package com.login.loginPortfolio.controller;

import com.login.loginPortfolio.modelo.credenciales;
import com.login.loginPortfolio.modelo.itemPortfolio;
import com.login.loginPortfolio.modelo.mensaje;
import com.login.loginPortfolio.modelo.persona;
import com.login.loginPortfolio.modelo.skillClass;

import com.login.loginPortfolio.service.ICredencialesService;
import com.login.loginPortfolio.service.IItemPortfolioService;
import com.login.loginPortfolio.service.IPersonaService;
import com.login.loginPortfolio.service.ISkillService;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.mail.javamail.JavaMailSender;

@RestController
public class controller {

        
        @Autowired
        private ICredencialesService credServ; 

        @PostMapping("/new/credenciales")
        public void agregarCredenciales(@RequestBody credenciales cred){
            
            //Genera token aleatorio
            String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            String cadena = "";
            for(int x = 0; x<20; x++){
                Random r = new Random();
                char c = alphabet.charAt(r.nextInt(alphabet.length()));
                cadena += c;
            }
            cred.setToken(cadena);
            credServ.crearCredenciales(cred);
        }
        
        @Autowired
        private IPersonaService persoServ;  
        @PostMapping("/new/persona")
        public void agregarPersona(@RequestBody persona pers){
            persoServ.crearPersona(pers);
        }
        
        @Autowired
        private IItemPortfolioService itemServ;  
        @PostMapping("/new/itemPortfolio")
        public void agregarItemPortfolio(@RequestBody itemPortfolio item){
            itemServ.crearItemPortfolio(item);
        }

        @Autowired
        private ISkillService skillServ;  
        @PostMapping("/new/skill")
        public void agregarSkill(@RequestBody skillClass sk){
            skillServ.crearSkills(sk);
        }
        
                       
        //@CrossOrigin(origins = "http://localhost:4200")
        @PostMapping("/login")
        public String login(@RequestBody credenciales cred){
            
            
            List<credenciales> credenDB = credServ.verCredenciales();
            
            String Token = "";
            String id_persona = "";
                     
            for (int i=0;i<credenDB.size();i++) {
                
                if (credenDB.get(i).getEmail().equals(cred.getEmail()) && credenDB.get(i).getPassword().equals(cred.getPassword())){
                    Token = credenDB.get(i).getToken();
                    id_persona = credenDB.get(i).getId_persona();
                }
            }


            JSONObject json = new JSONObject();
            try {
                json.put("Token", Token);
                json.put("id_persona", id_persona);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return json.toString();
        }
        
        
        //@CrossOrigin(origins = "http://localhost:4200")
        @GetMapping("/datos")
        @ResponseBody
        public String consDatos(@RequestHeader("token")String token,@RequestHeader("id_persona")String id_persona){
        
        System.out.println("Comprobando acceso...");   
        JSONObject data = new JSONObject();
        
        //Busca token en base de datos para comparar con la solicitud
        boolean acceso = false;
        List<credenciales> credenDB = credServ.verCredenciales();
        for (int i=0;i<credenDB.size();i++) {
                if (credenDB.get(i).getId_persona().equals(id_persona)){
                    acceso = true;
                }
            }
        
        //Hace lectura de datos desde DB
        
        if (acceso){
            System.out.println("Consultando datos a DB...");  
            JSONObject persona = new JSONObject();
            JSONObject itemsPortfolio = new JSONObject();
            JSONObject skills = new JSONObject();
            
            //obtiene persona en funcion de su id
            persona personaDB = persoServ.buscarPersona(Long.parseLong(id_persona));
            
            try {
                persona.put("nombre", personaDB.getNombre());
                persona.put("frase", personaDB.getFrase());
                persona.put("descripcion",personaDB.getDescripcion());
                persona.put("ciudad", personaDB.getCiudad());
                persona.put("pais", personaDB.getPais());
                persona.put("nacimiento", personaDB.getNacimiento());
                persona.put("direccion", personaDB.getDireccion());
                persona.put("ocupacion", personaDB.getOcupacion());
                persona.put("email", personaDB.getEmail());
                persona.put("numeroCel", personaDB.getNumeroCel());
                persona.put("pathLinkedin", personaDB.getPathLinkedin());
                persona.put("pathFacebook", personaDB.getPathFacebook());
                persona.put("pathCv", personaDB.getPathCv());
                persona.put("foto", personaDB.getFoto());

            } catch (JSONException e) {
                e.printStackTrace();
            }
            
            //Obtiene y separa los skills para este id_persona en particular
            List<skillClass> skillsDB = skillServ.verSkills();
            int x = 0;
            for (int i=0;i<skillsDB.size();i++) {
                if (skillsDB.get(i).getId_persona().equals(id_persona)){
                    x = x+1;
                    JSONObject skill = new JSONObject();
                    try {
                        skill.put("Name", skillsDB.get(i).getName());
                        skill.put("Cant", skillsDB.get(i).getCant());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    try {

                    skills.put("skill"+x, skill);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    }
            }
            
            //Obtiene y separa los itemsPortfolio para este id_persona en particular
            List<itemPortfolio> itemDB = itemServ.verItemPortfolio();
            int j = 0;
            for (int i=0;i<itemDB.size();i++) {
                if (itemDB.get(i).getId_persona().equals(id_persona)){
                    j = j+1;
                    JSONObject item = new JSONObject();
                    try {
                        item.put("nombre", itemDB.get(i).getNombre());
                        item.put("descripcion", itemDB.get(i).getDescripcion());
                        item.put("path", itemDB.get(i).getPath());
                        item.put("img", itemDB.get(i).getImg());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    try {

                    itemsPortfolio.put("item"+j, item);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    }
            }

            //Carga los datos de DB mas los estaticos para comunicar al Frontend
            try {
                data.put("skills", skills);
                data.put("itemsPortfolio", itemsPortfolio);
                data.put("persona", persona);
                data.put("pathPortada", "/assets/Imagenes/portada.png");
                data.put("contactoImage", "/assets/Imagenes/contact_bg.png");
                data.put("APLink", "https://argentinaprograma.inti.gob.ar/");
                data.put("APImage", "/assets/Imagenes/APLogo-20-20.png");
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        
        return data.toString();
        }
        

    @Autowired
    private JavaMailSender mail ;
   // @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/enviarCorreo")
    public ResponseEntity<?> enviar_correo(@RequestBody mensaje men){
        System.out.println("Estoy dentro de Enviar correo");

        System.out.println("Email:");
        System.out.println(men.getEmail());
        System.out.println("Nombre:");
        System.out.println(men.getNombre());
        System.out.println("Mensaje:");
        System.out.println(men.getMensaje());
        
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("portfolioTomasMartin@hotmail.com");
        email.setFrom("portfolioTomasMartin@hotmail.com");
        email.setSubject("Mensaje de portfolio");
        email.setText("Nombre: "+men.getNombre() + "\nMail: "+ men.getEmail() + "\nMensaje: " + men.getMensaje());
        
        
        mail.send(email);
        
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
        

}

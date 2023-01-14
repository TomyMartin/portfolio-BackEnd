package com.login.loginPortfolio.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String frase;
    private String descripcion;
    private String ciudad;
    private String pais;
    private String nacimiento;
    private String direccion;
    private String ocupacion;
    private String email;
    private String numeroCel;
    private String pathLinkedin;
    private String pathFacebook;
    private String pathCv;
    private String foto;
    

    public persona() {
    }

    public persona(String nombre, String frase, String descripcion, String ciudad, String pais, String nacimiento, String direccion, String ocupacion, String email, String numeroCel, String pathLinkedin, String pathFacebook, String pathCv, String foto) {
        this.nombre = nombre;
        this.frase = frase;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.ocupacion = ocupacion;
        this.email = email;
        this.numeroCel = numeroCel;
        this.pathLinkedin = pathLinkedin;
        this.pathFacebook = pathFacebook;
        this.pathCv = pathCv;
        this.foto = foto;

    }
    
    
    

}

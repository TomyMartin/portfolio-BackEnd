
package com.login.loginPortfolio.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class credenciales {
    private String email;
    private String password;
    private String id_persona;
    private String token;
            
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public credenciales() {
    }

    public credenciales(String email, String password, String id_persona,String token) {
        this.email = email;
        this.password = password;
        this.id_persona = id_persona;
        this.token = token;
    }
    
}

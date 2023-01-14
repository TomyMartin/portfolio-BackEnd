package com.login.loginPortfolio.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class skillClass {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cant;
    private String id_persona;

    public skillClass() {
    }

    public skillClass(Long id, String name, String cant, String id_persona) {
        this.id = id;
        this.name = name;
        this.cant = cant;
        this.id_persona = id_persona;
    }
        
}

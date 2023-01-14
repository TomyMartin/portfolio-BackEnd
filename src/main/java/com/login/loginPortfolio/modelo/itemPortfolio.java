package com.login.loginPortfolio.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class itemPortfolio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    private String path;
    private String img;
    private String id_persona;

    public itemPortfolio() {
    }

    public itemPortfolio(String nombre, String descripcion, String path, String img, String id_persona) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.path = path;
        this.img = img;
        this.id_persona = id_persona;
    }
    
    
}

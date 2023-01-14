/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login.loginPortfolio.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class mensaje {
    private String mensaje;
    private String nombre;
    private String email;

    public mensaje() {
    }

    public mensaje(String mensaje, String nombre, String email) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.email = email;
    }
    
}

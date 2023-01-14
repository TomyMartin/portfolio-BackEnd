package com.login.loginPortfolio.service;

import com.login.loginPortfolio.modelo.persona;
import java.util.List;


public interface IPersonaService {
    
    public List<persona> verPersonas();
    
    public void crearPersona(persona per);
    
    public void borrarPersona(Long id);
    
    public persona buscarPersona(Long id);
}

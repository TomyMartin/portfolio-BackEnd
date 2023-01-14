package com.login.loginPortfolio.service;

import com.login.loginPortfolio.modelo.credenciales;
import java.util.List;


public interface ICredencialesService {
        
    public List<credenciales> verCredenciales();
    
    public void crearCredenciales(credenciales cred);
    
    public void borrarCredenciales(Long id);
    
    public credenciales buscarCredenciales(Long id);
    
}

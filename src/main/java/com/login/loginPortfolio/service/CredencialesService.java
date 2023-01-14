package com.login.loginPortfolio.service;

import com.login.loginPortfolio.modelo.credenciales;
import com.login.loginPortfolio.repository.CredencialesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredencialesService implements ICredencialesService{
    
    @Autowired
    public CredencialesRepository credRepo;
    
    @Override
    public List<credenciales> verCredenciales() {
        return credRepo.findAll();
    }

    @Override
    public void crearCredenciales(credenciales cred) {
        credRepo.save(cred);
    }

    @Override
    public void borrarCredenciales(Long id) {
        credRepo.deleteById(id);
    }

    @Override
    public credenciales buscarCredenciales(Long id) {
        return credRepo.findById(id).orElse(null);
    }
    
}

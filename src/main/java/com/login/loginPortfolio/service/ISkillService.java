package com.login.loginPortfolio.service;

import com.login.loginPortfolio.modelo.skillClass;
import java.util.List;


public interface ISkillService {
    
    public List<skillClass> verSkills();
    
    public void crearSkills(skillClass sk);
    
    public void borrarSkills(Long id);
    
    public skillClass buscarSkills(Long id);
}
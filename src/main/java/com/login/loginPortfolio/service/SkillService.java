package com.login.loginPortfolio.service;

import com.login.loginPortfolio.modelo.skillClass;
import com.login.loginPortfolio.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{

    @Autowired
    public SkillRepository skillPort;
    
    @Override
    public List<skillClass> verSkills() {
        return skillPort.findAll();
    }

    @Override
    public void crearSkills(skillClass sk) {
        skillPort.save(sk);
    }

    @Override
    public void borrarSkills(Long id) {
        skillPort.deleteById(id);
    }

    @Override
    public skillClass buscarSkills(Long id) {
        return skillPort.findById(id).orElse(null);
    }
    
}

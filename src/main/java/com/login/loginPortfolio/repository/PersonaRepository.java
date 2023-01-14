package com.login.loginPortfolio.repository;

import com.login.loginPortfolio.modelo.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<persona,Long>{
    
}

package com.login.loginPortfolio.repository;
        
import com.login.loginPortfolio.modelo.skillClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository  extends JpaRepository<skillClass,Long>{
    
}


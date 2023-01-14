package com.login.loginPortfolio.repository;

import com.login.loginPortfolio.modelo.credenciales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredencialesRepository  extends JpaRepository<credenciales,Long> {
    
}

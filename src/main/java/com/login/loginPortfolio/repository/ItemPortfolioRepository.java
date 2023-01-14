package com.login.loginPortfolio.repository;

import com.login.loginPortfolio.modelo.itemPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPortfolioRepository  extends JpaRepository<itemPortfolio,Long>{
    
}

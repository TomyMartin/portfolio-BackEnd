package com.login.loginPortfolio.service;

import com.login.loginPortfolio.modelo.itemPortfolio;
import java.util.List;


public interface IItemPortfolioService {
        
    public List<itemPortfolio> verItemPortfolio();
    
    public void crearItemPortfolio(itemPortfolio item);
    
    public void borrarItemPortfolio(Long id);
    
    public itemPortfolio buscarItemPortfolio(Long id);
}

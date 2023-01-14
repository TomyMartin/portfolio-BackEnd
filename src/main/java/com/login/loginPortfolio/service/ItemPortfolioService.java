package com.login.loginPortfolio.service;

import com.login.loginPortfolio.modelo.itemPortfolio;
import com.login.loginPortfolio.repository.ItemPortfolioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPortfolioService implements IItemPortfolioService{
    
    @Autowired
    public ItemPortfolioRepository itemRepo;
    
    @Override
    public List<itemPortfolio> verItemPortfolio() {
        return itemRepo.findAll();
    }

    @Override
    public void crearItemPortfolio(itemPortfolio item) {
        itemRepo.save(item);
    }

    @Override
    public void borrarItemPortfolio(Long id) {
        itemRepo.deleteById(id);
    }

    @Override
    public itemPortfolio buscarItemPortfolio(Long id) {
        return itemRepo.findById(id).orElse(null);
    }
    
}

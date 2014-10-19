package com.gamersrepublic.services.impl;

import com.gamersrepublic.domain.Product;
import com.gamersrepublic.repository.ProductRepository;
import com.gamersrepublic.services.ProductCRUDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonathan
 */

@Service
public class ProductCRUDServiceImpl implements ProductCRUDService{
    @Autowired
    private ProductRepository repo;
    private Long id;

    @Override
    public Product find(Long id) {
       return repo.findOne(id);
    }

    @Override
    public Product persist(Product entity) {
        return repo.save(entity);
    }

    @Override
    public Product merge(Product entity) {
        if (entity.getId() != null) {
            return repo.save(entity);
        }
        return null;
        }
    
    @Override
    public void remove(Product entity) {
       repo.delete(entity);
    }

    @Override
    public List<Product> findAll() {
       return repo.findAll();
    }
}
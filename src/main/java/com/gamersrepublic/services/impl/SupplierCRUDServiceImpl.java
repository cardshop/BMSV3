package com.gamersrepublic.services.impl;

import com.gamersrepublic.domain.Supplier;
import com.gamersrepublic.repository.SupplierRepository;
import com.gamersrepublic.services.SupplierCRUDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonathan
 */

@Service
public class SupplierCRUDServiceImpl implements SupplierCRUDService{
    @Autowired
    private SupplierRepository repo;
    private Long id;

    @Override
    public Supplier find(Long id) {
       return repo.findOne(id);
    }

    @Override
    public Supplier persist(Supplier entity) {
        return repo.save(entity);
    }

    @Override
    public Supplier merge(Supplier entity) {
        if (entity.getId() != null) {
            return repo.save(entity);
        }
        return null;
        }
    
    @Override
    public void remove(Supplier entity) {
       repo.delete(entity);
    }

    @Override
    public List<Supplier> findAll() {
       return repo.findAll();
    }
}
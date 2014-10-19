package com.gamersrepublic.services.impl;

import com.gamersrepublic.domain.InkCardridge;
import com.gamersrepublic.repository.InkRepository;
import com.gamersrepublic.services.InkCardridgeCRUDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonathan
 */

@Service
public class InkCardridgeCRUDServiceImpl implements InkCardridgeCRUDService{
    @Autowired
    private InkRepository repo;
    private Long id;

    @Override
    public InkCardridge find(Long id) {
       return repo.findOne(id);
    }

    @Override
    public InkCardridge persist(InkCardridge entity) {
        return repo.save(entity);
    }

    @Override
    public InkCardridge merge(InkCardridge entity) {
        if (entity.getId() != null) {
            return repo.save(entity);
        }
        return null;
        }
    
    @Override
    public void remove(InkCardridge entity) {
       repo.delete(entity);
    }

    @Override
    public List<InkCardridge> findAll() {
       return repo.findAll();
    }
}
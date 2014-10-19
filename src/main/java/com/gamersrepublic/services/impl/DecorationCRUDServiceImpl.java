package com.gamersrepublic.services.impl;

import com.gamersrepublic.domain.Decoration;
import com.gamersrepublic.repository.DecorationRepository;
import com.gamersrepublic.services.DecorationCRUDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonathan
 */

@Service
public class DecorationCRUDServiceImpl implements DecorationCRUDService{
    @Autowired
    private DecorationRepository repo;
    private Long id;

    @Override
    public Decoration find(Long id) {
       return repo.findOne(id);
    }

    @Override
    public Decoration persist(Decoration entity) {
        return repo.save(entity);
    }

    @Override
    public Decoration merge(Decoration entity) {
        if (entity.getId() != null) {
            return repo.save(entity);
        }
        return null;
        }
    
    @Override
    public void remove(Decoration entity) {
       repo.delete(entity);
    }

    @Override
    public List<Decoration> findAll() {
       return repo.findAll();
    }
}
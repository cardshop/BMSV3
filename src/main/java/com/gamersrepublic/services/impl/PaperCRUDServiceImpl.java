package com.gamersrepublic.services.impl;

import com.gamersrepublic.domain.Paper;
import com.gamersrepublic.repository.PaperRepository;
import com.gamersrepublic.services.PaperCRUDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonathan
 */

@Service
public class PaperCRUDServiceImpl implements PaperCRUDService{
    @Autowired
    private PaperRepository repo;
    private Long id;

    @Override
    public Paper find(Long id) {
       return repo.findOne(id);
    }

    @Override
    public Paper persist(Paper entity) {
        return repo.save(entity);
    }

    @Override
    public Paper merge(Paper entity) {
        if (entity.getId() != null) {
            return repo.save(entity);
        }
        return null;
        }
    
    @Override
    public void remove(Paper entity) {
       repo.delete(entity);
    }

    @Override
    public List<Paper> findAll() {
       return repo.findAll();
    }
}
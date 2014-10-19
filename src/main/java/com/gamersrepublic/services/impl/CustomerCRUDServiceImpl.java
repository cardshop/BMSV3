package com.gamersrepublic.services.impl;

import com.gamersrepublic.domain.Customer;
import com.gamersrepublic.repository.CustomerRepository;
import com.gamersrepublic.services.CustomerCRUDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonathan
 */

@Service
public class CustomerCRUDServiceImpl implements CustomerCRUDService{
    @Autowired
    private CustomerRepository repo;
    private Long id;

    @Override
    public Customer find(Long id) {
       return repo.findOne(id);
    }

    @Override
    public Customer persist(Customer entity) {
        return repo.save(entity);
    }

    @Override
    public Customer merge(Customer entity) {
        if (entity.getId() != null) {
            return repo.save(entity);
        }
        return null;
        }
    
    @Override
    public void remove(Customer entity) {
       repo.delete(entity);
    }

    @Override
    public List<Customer> findAll() {
       return repo.findAll();
    }
}
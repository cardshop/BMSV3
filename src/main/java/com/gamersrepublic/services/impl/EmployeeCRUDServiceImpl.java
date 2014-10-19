package com.gamersrepublic.services.impl;

import com.gamersrepublic.domain.Employee;
import com.gamersrepublic.repository.EmployeeRepository;
import com.gamersrepublic.services.EmployeeCRUDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonathan
 */

@Service
public class EmployeeCRUDServiceImpl implements EmployeeCRUDService{
    @Autowired
    private EmployeeRepository repo;
    private Long id;

    @Override
    public Employee find(Long id) {
       return repo.findOne(id);
    }

    @Override
    public Employee persist(Employee entity) {
        return repo.save(entity);
    }

    @Override
    public Employee merge(Employee entity) {
        if (entity.getId() != null) {
            return repo.save(entity);
        }
        return null;
        }
    
    @Override
    public void remove(Employee entity) {
       repo.delete(entity);
    }

    @Override
    public List<Employee> findAll() {
       return repo.findAll();
    }
}
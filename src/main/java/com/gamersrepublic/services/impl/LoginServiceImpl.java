/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamersrepublic.services.impl;

import com.gamersrepublic.config.ConnectionConfig;
import com.gamersrepublic.domain.Employee;
import com.gamersrepublic.repository.EmployeeRepository;
import com.gamersrepublic.services.LoginService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Luke
 */
public class LoginServiceImpl implements LoginService{
    private EmployeeRepository repo;
    private ApplicationContext ctx;
    
    public LoginServiceImpl(){
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        repo = ctx.getBean(EmployeeRepository.class);
    }
    
    @Override
    public Employee validateCredentials(String username, String password){
        List<Employee> employees = repo.findAll();
        
        for(Employee employee : employees){
            if(employee.getUsername().equals(username) && employee.getPassword().equals(password))
                return employee;
        }
        
        return null;
    }
    
}

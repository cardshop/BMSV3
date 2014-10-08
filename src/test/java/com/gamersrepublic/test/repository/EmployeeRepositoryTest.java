package com.gamersrepublic.test.repository;

import com.gamersrepublic.domain.Employee;
import com.gamersrepublic.repository.EmployeeRepository;
import com.gamersrepublic.test.config.ConnectionConfigTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Gamers Republic
 */

public class EmployeeRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private EmployeeRepository empRepo;
    
    public EmployeeRepositoryTest() {
    }

    @Test
    public void createEmployee(){
        empRepo = ctx.getBean(EmployeeRepository.class);
        
        Employee emp = new Employee.Builder("Jonathan")
                .surname("Kok")
                .username("jonathan")
                .password("gamers")
                .build();
        
        empRepo.save(emp);      
        
        id = emp.getId();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createEmployee")
    public void readEmployee(){
        empRepo = ctx.getBean(EmployeeRepository.class);
        
        Employee emp = empRepo.findOne(id);
        Assert.assertEquals("Jonathan", emp.getName());
    }
    
    @Test(dependsOnMethods = "readEmployee")
    public void updateEmployee(){
        empRepo = ctx.getBean(EmployeeRepository.class);
        Employee emp = empRepo.findOne(id);
    
        Employee updatedEmployee = new Employee.Builder("Jonathan")
                .surname("Kok")
                .username("jonno")
                .clone(emp)
                .password("gamersRepublic")
                .build();
        
        empRepo.save(updatedEmployee);
        
        Employee newEmployee = empRepo.findOne(id);
        
        Assert.assertEquals(newEmployee.getPassword(), "gamersRepublic");
    }
    
    @Test(dependsOnMethods = "updateEmployee")
    public void deleteEmployee(){
        empRepo = ctx.getBean(EmployeeRepository.class);
        Employee emp = empRepo.findOne(id);
        
        empRepo.delete(emp);
        
        Employee deletedEmp = empRepo.findOne(id);
   
        Assert.assertNull(deletedEmp);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

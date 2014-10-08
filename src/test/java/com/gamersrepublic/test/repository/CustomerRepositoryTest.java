package com.gamersrepublic.test.repository;

import com.gamersrepublic.domain.Contact;
import com.gamersrepublic.domain.Customer;
import com.gamersrepublic.repository.CustomerRepository;
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
 * @author Jonathan Kok
 */

public class CustomerRepositoryTest {
    private static ApplicationContext ctx;
    private CustomerRepository repo;
    private Long id;
    
    public CustomerRepositoryTest() {
    }

    @Test
    public void createCustomer(){
        repo = ctx.getBean(CustomerRepository.class);
        
        Contact contact = new Contact.Builder("555-5555")
                .emailAddress("www.johnsmithwebsite.com")
                .cellphoneNumber("0897857478474")
                .build();
        
        Customer c = new Customer.Builder("John")
                .surname("Smith")
                .contact(contact)
                .address("10 Red Street")
                .build();
        
        repo.save(c);
        
        id = c.getId();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createCustomer")
    public void readCustomer(){
        repo = ctx.getBean(CustomerRepository.class);
        Customer c = repo.findOne(id);
        Assert.assertEquals(c.getName(), "John");
    }
    
    @Test(dependsOnMethods = "readCustomer")
    public void updateCustomer(){
        repo = ctx.getBean(CustomerRepository.class);
        Customer c = repo.findOne(id);
        
        Customer update = new Customer.Builder("John")
                .clone(c)
                .address("50 Red Street")
                .build();
        
        repo.save(update);
        
        Customer newCustomer = repo.findOne(id);
        
        Assert.assertEquals(newCustomer.getAddress(), "50 Red Street");
    }
    
    @Test(dependsOnMethods = "updateCustomer")
    public void deleteCustomer(){
        repo = ctx.getBean(CustomerRepository.class);
        Customer c = repo.findOne(id);
        repo.delete(c);
        
        Customer deleted = repo.findOne(id);
        Assert.assertNull(deleted);
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

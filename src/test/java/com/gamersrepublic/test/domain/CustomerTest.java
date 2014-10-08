package com.gamersrepublic.test.domain;

import com.gamersrepublic.domain.Customer;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Wesley
 */

public class CustomerTest {
     public static Customer service;
    
    public CustomerTest() {
    }

    @Test
    public void CustomerTest(){
        service = new Customer.Builder("John").address("12 Willow Place").build();
        Assert.assertEquals(service.getAddress(),"12 Willow Place");
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

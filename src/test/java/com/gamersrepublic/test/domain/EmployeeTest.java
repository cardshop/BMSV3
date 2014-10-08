package com.gamersrepublic.test.domain;

import com.gamersrepublic.domain.Employee;
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

public class EmployeeTest {
    
      public static Employee service;
    
    public EmployeeTest() {
    }

    @Test
    public void EmployeeTest(){
        service = new Employee.Builder("Wesley").surname("Martins").build();
        Assert.assertEquals(service.getSurname(),"Martins");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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

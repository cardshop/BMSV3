package com.gamersrepublic.test.domain;

import com.gamersrepublic.domain.Supplier;
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

public class SupplierTest {
    
    public static Supplier service;
    
    public SupplierTest() {
    }

    @Test
    public void SupplierTest(){
        service = new Supplier.Builder("Becky").build();
        Assert.assertEquals(service.getName(),"Becky");
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

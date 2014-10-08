package com.gamersrepublic.test.domain;

import com.gamersrepublic.domain.CustomerInvoice;
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

public class CustomerInvoiceTest {
    public static CustomerInvoice service;
    
    public CustomerInvoiceTest() {
    }

    @Test
    public void CustomerInvoiceTest(){
        service = new CustomerInvoice.Builder(0).depositPaid(true).build();
        Assert.assertEquals(service.isDepositPaid(),true);
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

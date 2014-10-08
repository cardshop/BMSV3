package com.gamersrepublic.test.domain;

import com.gamersrepublic.domain.InkPrinter;
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
public class InkPrinterTest {
    
     public static InkPrinter service;
    
    public InkPrinterTest() {
    }

    @Test
    public void InkPrinterTest(){
        service = new InkPrinter.Builder("Samsung Printer").numInkCardridges(4).build();
        Assert.assertEquals(service.getNumInkCardridges(),4);
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

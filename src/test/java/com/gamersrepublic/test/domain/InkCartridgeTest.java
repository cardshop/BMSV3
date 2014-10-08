package com.gamersrepublic.test.domain;

import com.gamersrepublic.domain.InkCardridge;
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

public class InkCartridgeTest {
    
    public static InkCardridge service;
    
    public InkCartridgeTest() {
    }

    @Test
    public void InkCardridgeTest(){
        service = new InkCardridge.Builder("Eon Ink").colour("Black").build();
        Assert.assertEquals(service.getColour(),"Black");
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

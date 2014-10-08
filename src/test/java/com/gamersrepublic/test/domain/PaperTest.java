package com.gamersrepublic.test.domain;

import com.gamersrepublic.domain.Paper;
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

public class PaperTest {
    
    public static Paper service;
    
    public PaperTest() {
    }

    @Test
    public void PaperTest(){
        service = new Paper.Builder("Standard").colour("White").build();
        Assert.assertEquals(service.getColour(),"White");
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

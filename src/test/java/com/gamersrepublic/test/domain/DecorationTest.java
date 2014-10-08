package com.gamersrepublic.test.domain;

import com.gamersrepublic.domain.Decoration;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jonathan
 */

public class DecorationTest {
    
    private static Decoration service;
    
    public DecorationTest() {
    }
    
    @Test
     public void decorationTest() {
         service = new Decoration.Builder("Ribbon")
                 .build();
         
         Assert.assertEquals(service.getDescrip(), "Ribbon");
     
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

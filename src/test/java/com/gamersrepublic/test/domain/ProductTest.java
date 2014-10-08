package com.gamersrepublic.test.domain;

import com.gamersrepublic.domain.Template;
import com.gamersrepublic.domain.Product;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Jonathan
 */

public class ProductTest {
    public static Product service;
    public static Template templateService;    
  
    public ProductTest() {
    }

    @Test
    public void WeddingInvitation(){
       service = new Product.Builder("Wedding Invitation")
               .build();
       Assert.assertEquals(service.getDescription(),"Wedding Invitation");
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

package com.gamersrepublic.test.domain;

import com.gamersrepublic.domain.Template;
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

public class TemplateTest {
    
    public static Template service;
    
    public TemplateTest() {
    }

    @Test
    public void TemplateTest(){
        service = new Template.Builder("Wedding Template").amountUsed(109).build();
        Assert.assertEquals(service.getAmountUsed(),109);
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

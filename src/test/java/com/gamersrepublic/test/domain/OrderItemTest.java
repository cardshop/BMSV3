package com.gamersrepublic.test.domain;

import com.gamersrepublic.domain.OrderItem;
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

public class OrderItemTest {
    
    public static OrderItem service;
    
    public OrderItemTest() {
    }

    @Test
    public void OrderItemTest(){
        service = new OrderItem.Builder(10).build();
        Assert.assertEquals(service.getQuantity(),10);
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

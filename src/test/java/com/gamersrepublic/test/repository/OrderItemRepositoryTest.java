package com.gamersrepublic.test.repository;

import com.gamersrepublic.domain.OrderItem;
import com.gamersrepublic.domain.Product;
import com.gamersrepublic.repository.OrderItemRepository;
import com.gamersrepublic.repository.ProductRepository;
import com.gamersrepublic.test.config.ConnectionConfigTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Luke
 */

public class OrderItemRepositoryTest {
    private static ApplicationContext ctx;
    private OrderItemRepository repo;
    private ProductRepository weddingRepo;
    private Product w;
    private long id;
    
    public OrderItemRepositoryTest() {
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
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
    
    @Test
    public void createOrderItem(){
        repo = ctx.getBean(OrderItemRepository.class);
        weddingRepo = ctx.getBean(ProductRepository.class);
        w = new Product.Builder("Wedding Invitation").build();
        weddingRepo.save(w);
        OrderItem orderItem = new OrderItem.Builder(1)
                .product(w)
                .build();
        
        repo.save(orderItem);      
        
        id = orderItem.getId();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createOrderItem")
    public void readOrderItem(){
        repo = ctx.getBean(OrderItemRepository.class);
        
        OrderItem orderItem = repo.findOne(id);
        Assert.assertEquals(1, orderItem.getQuantity());
    }
    
    @Test(dependsOnMethods = "readOrderItem")
    public void updateOrderItem(){
        repo = ctx.getBean(OrderItemRepository.class);
        OrderItem orderItem = repo.findOne(id);
    
        OrderItem updatedOrderItem = new OrderItem.Builder(1)
                .clone(orderItem)
                .build();
        
        repo.save(updatedOrderItem);
        
        OrderItem newOrderItem = repo.findOne(id);
        
        Assert.assertEquals(newOrderItem.getQuantity(), 1);
    }
    
    @Test(dependsOnMethods = "updateOrderItem")
    public void deleteOrderItem(){
        repo = ctx.getBean(OrderItemRepository.class);
        OrderItem orderItem = repo.findOne(id);
        
        repo.delete(orderItem);
        weddingRepo.delete(w);
        
        OrderItem deletedOrderItem = repo.findOne(id);
   
        Assert.assertNull(deletedOrderItem);
    }
}

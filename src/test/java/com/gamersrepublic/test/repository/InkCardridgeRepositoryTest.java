package com.gamersrepublic.test.repository;

import com.gamersrepublic.config.ConnectionConfig;
import com.gamersrepublic.domain.InkCardridge;
import com.gamersrepublic.repository.InkRepository;
import com.gamersrepublic.test.config.ConnectionConfigTest;
import java.util.Date;
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
 * @author Jonathan Kok
 */

public class InkCardridgeRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private InkRepository repo;
    
    public InkCardridgeRepositoryTest() {
    }

   @Test
    public void createInkCard(){
            repo = ctx.getBean(InkRepository.class);
            
            InkCardridge card = new InkCardridge.Builder("Ink Card")
                    .colour("Cyan")
                    .price(350.00)
                    .inkLevel(100)
                    .dateInstalled(new Date())
                    .inUse("Yes")
                    .inventory(1)
                    .build();
            
            repo.save(card);
            
            id = card.getId();
            
            Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createInkCard")
    public void readInkCard(){
         repo = ctx.getBean(InkRepository.class);
         InkCardridge card = repo.findOne(id);
         Assert.assertEquals(card.getColour(), "Cyan");
    }
    
    @Test(dependsOnMethods = "readInkCard")
    public void updateInkCard(){
         repo = ctx.getBean(InkRepository.class);
         InkCardridge card = repo.findOne(id);

         InkCardridge update = new InkCardridge.Builder("Ink Card")
                 .clone(card)
                 .inkLevel(50)
                 .build();
         
        repo.save(update);
        
        InkCardridge newCard = repo.findOne(id);
        
        Assert.assertEquals(newCard.getInkLevel(), 50);
    }
    
    @Test(dependsOnMethods = "updateInkCard")
    public void deleteCard(){
         repo = ctx.getBean(InkRepository.class);
         InkCardridge card = repo.findOne(id);
         
         repo.delete(card);
         
         InkCardridge deleted = repo.findOne(id);
    
         Assert.assertNull(deleted);
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
}

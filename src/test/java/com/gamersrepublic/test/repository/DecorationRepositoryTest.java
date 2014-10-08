
package com.gamersrepublic.test.repository;

import com.gamersrepublic.domain.Decoration;
import com.gamersrepublic.repository.DecorationRepository;
import com.gamersrepublic.test.config.ConnectionConfigTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jonathan
 */

public class DecorationRepositoryTest {
    private static ApplicationContext ctx;
    private DecorationRepository repo;
    private Long id;
    
    public DecorationRepositoryTest(){  
    }

     @Test
     public void createDecoration(){
         repo = ctx.getBean(DecorationRepository.class);
         
         Decoration ribbon = new Decoration.Builder("Silk Ribbon")
                 .colour("Red")
                 .build();
         
         repo.save(ribbon);
         
         id = ribbon.getId();
         
         Assert.assertNotNull(id);
     }
     
     @Test(dependsOnMethods = "createDecoration")
     public void readDecoration(){
         repo = ctx.getBean(DecorationRepository.class);
         Decoration ribbon = repo.findOne(id);
         Assert.assertEquals(ribbon.getColour(), "Red");
     }
     
     @Test(dependsOnMethods = "readDecoration")
     public void updateDecoration(){
         repo = ctx.getBean(DecorationRepository.class);
         Decoration ribbon = repo.findOne(id);
         
         Decoration update = new Decoration.Builder("Silk Ribbon")
                 .clone(ribbon)
                 .colour("Blue")
                 .build();
         
         repo.save(update);
         
        Decoration newDec = repo.findOne(id);
        Assert.assertEquals(newDec.getColour(), "Blue");
     }
     
     @Test(dependsOnMethods = "updateDecoration")
     public void deleteDecoration(){
         repo = ctx.getBean(DecorationRepository.class);
         Decoration ribbon = repo.findOne(id);
         repo.delete(ribbon);
         
         Decoration deletedDec = repo.findOne(id);
         Assert.assertNull(deletedDec);
     }
     
    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
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

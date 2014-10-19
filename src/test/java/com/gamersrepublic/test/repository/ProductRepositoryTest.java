package com.gamersrepublic.test.repository;

import com.gamersrepublic.domain.Decoration;
import com.gamersrepublic.domain.Paper;
import com.gamersrepublic.domain.Product;
import com.gamersrepublic.repository.DecorationRepository;
import com.gamersrepublic.repository.PaperRepository;
import com.gamersrepublic.repository.ProductRepository;
import com.gamersrepublic.test.config.ConnectionConfigTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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

public class ProductRepositoryTest {
    private static ApplicationContext ctx;
    private ProductRepository repo;
    private PaperRepository paperRepo;
    private DecorationRepository decRepo;
    private Long id;
    
    public ProductRepositoryTest() {
    }


     @Test
     public void createInvite(){
         repo = ctx.getBean(ProductRepository.class);
         paperRepo = ctx.getBean(PaperRepository.class);
         decRepo = ctx.getBean(DecorationRepository.class);
         
         Paper paperUsed = new Paper.Builder("Glossy")
                 .colour("Red")
                 .build();
         
         paperRepo.save(paperUsed);
         
         List<Paper> p = new ArrayList<>();
         p.add(paperUsed);
         
         Decoration ribbon = new Decoration.Builder("Silk Ribbon")
                 .colour("Red")
                 .decLength(25)
                 .inventory(4)
                 .price(20)
                 .build();
         
         decRepo.save(ribbon);
         
         List<Decoration> d = new ArrayList<>();
         d.add(ribbon);
         
         Product invite = new Product.Builder("Wedding Invitation")
                 .paperUsed(p)
                 .decorationsUsed(d)
                 .build();
     
         repo.save(invite);
          
         id = invite.getId();
         
         Assert.assertNotNull(id);
     }
  
     @Test(dependsOnMethods = "createInvite")
     public void readInvite(){
         repo = ctx.getBean(ProductRepository.class);
         Product invite = repo.findOne(id);
         Assert.assertEquals(invite.getDescription(), "Wedding Invitation");
     }
   
     @Test(dependsOnMethods = "readInvite")
     public void updateInvite(){
         repo = ctx.getBean(ProductRepository.class);
         Product invite = repo.findOne(id);
         Product inviteUpdate = new Product.Builder("Wedding Invitation")
                 .clone(invite)
                 .unitPrice(8.00)
                 .build();
         repo.save(inviteUpdate);
         
         id = inviteUpdate.getId();
         
         Product newInvite = repo.findOne(id);
         
         Assert.assertEquals(newInvite.getUnitPrice(),8.00);
     }
     
     @Test(dependsOnMethods = "updateInvite")
     public void deleteInvite(){
         repo = ctx.getBean(ProductRepository.class);
         Product invite = repo.findOne(id);
         repo.delete(invite);
         
         Product deleted = repo.findOne(id);
         
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

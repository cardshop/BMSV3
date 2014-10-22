package com.gamersrepublic.test.repository;

import com.gamersrepublic.domain.Paper;
import com.gamersrepublic.repository.PaperRepository;
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

public class PaperRepositoryTest {
    private static ApplicationContext ctx;
    public PaperRepository repo;
    public long id;
    
    public PaperRepositoryTest() {
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
    public void createPaper(){
        repo = ctx.getBean(PaperRepository.class);
        
        Paper paper = new Paper.Builder("Paper")
                .price(10)
                .colour("White")
                .build();
        
        repo.save(paper);      
        
        id = paper.getId();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createPaper")
    public void readPaper(){
        repo = ctx.getBean(PaperRepository.class);
        
        Paper paper = repo.findOne(id);
        Assert.assertEquals("White", paper.getColour());
    }
    
    @Test(dependsOnMethods = "readPaper")
    public void updatePaper(){
        repo = ctx.getBean(PaperRepository.class);
        Paper paper = repo.findOne(id);
    
        Paper updatedLace = new Paper.Builder("Paper")
                .clone(paper)
                .price(11)
                .build();
        
        repo.save(updatedLace);
        
        Paper newPaper = repo.findOne(id);
        
        Assert.assertEquals(newPaper.getPrice(), 11.0);
    }
    
    @Test(dependsOnMethods = "updatePaper")
    public void deletePaper(){
        repo = ctx.getBean(PaperRepository.class);
        Paper paper = repo.findOne(id);
        
        repo.delete(paper);
        
        Paper deletedPaper = repo.findOne(id);
   
        Assert.assertNull(deletedPaper);
    }
}

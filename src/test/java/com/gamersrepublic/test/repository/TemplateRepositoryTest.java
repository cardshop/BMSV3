package com.gamersrepublic.test.repository;

import com.gamersrepublic.domain.Template;
import com.gamersrepublic.repository.TemplateRepository;
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
public class TemplateRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private TemplateRepository tempRepo;
    
    public TemplateRepositoryTest() {
    }


    @Test
    public void createTemplate(){
        tempRepo = ctx.getBean(TemplateRepository.class);
        
        Template template = new Template.Builder("Wedding Invite Template")
                .dateAdded(new Date())
                .amountUsed(0)
                .imageSourcePath("local")
                .build();
        
        tempRepo.save(template);
                
        id = template.getId();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createTemplate")
    public void readTemplate(){
        tempRepo = ctx.getBean(TemplateRepository.class);
        Template template = tempRepo.findOne(id);
        
        Assert.assertEquals(template.getName(), "Wedding Invite Template");
    }
    
    @Test(dependsOnMethods = "readTemplate")
    public void updateTemplate(){
        tempRepo = ctx.getBean(TemplateRepository.class);
        Template template = tempRepo.findOne(id);
        
        Template updatedTemplate = new Template.Builder("Wedding Invite Template")
                .clone(template)
                .imageSourcePath("www.imageFileLocation.com")
                .build();
        
        tempRepo.save(updatedTemplate);
        
        id = updatedTemplate.getId();
        
        Template newTemplate = tempRepo.findOne(id);
        
        Assert.assertEquals(newTemplate.getImageSourcePath(), "www.imageFileLocation.com");
    }
    
    @Test(dependsOnMethods = "updateTemplate")
    public void deleteTemplate(){
        tempRepo = ctx.getBean(TemplateRepository.class);
        Template template = tempRepo.findOne(id);
        tempRepo.delete(template);
        
        Template deletedTemplate = tempRepo.findOne(id);
        
        Assert.assertNull(deletedTemplate);
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

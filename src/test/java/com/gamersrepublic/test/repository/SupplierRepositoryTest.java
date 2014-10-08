package com.gamersrepublic.test.repository;

import com.gamersrepublic.domain.Supplier;
import com.gamersrepublic.repository.SupplierRepository;
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
 * @author Gamers Republic 
 */

public class SupplierRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private SupplierRepository suppRepo;
    
    public SupplierRepositoryTest() {
    }

    @Test
    public void createSupplier(){
        suppRepo = ctx.getBean(SupplierRepository.class);
        
        Supplier supp = new Supplier.Builder("John")
                .address("100 Imaginay Land")
                .contactCellphone("082979789787")
                .contactLandline("021-4848584")
                .emailAddress("johnsmith@johnsmithpapercompany.co.za")
                .serviceDescrip("Paper Supplier")
                .websiteURL("www.thejohnsmithpapercompanyisnotreal.com")
                .build();
        
        suppRepo.save(supp);
        
        id = supp.getId();
        
        Assert.assertNotNull(id);  
    }
    
    @Test(dependsOnMethods = "createSupplier")
    public void readSupplier(){
        suppRepo = ctx.getBean(SupplierRepository.class);
        Supplier supp = suppRepo.findOne(id);
        
        Assert.assertEquals(supp.getName(), "John");
    }
    
    @Test(dependsOnMethods = "readSupplier")
    public void updateSupplier(){
        suppRepo = ctx.getBean(SupplierRepository.class);
        Supplier supp = suppRepo.findOne(id);
        
        Supplier updateSup = new Supplier.Builder("John")
                .clone(supp)
                .emailAddress("johns@johnsmithpapercompany.co.za")
                .build();
    
        suppRepo.save(updateSup);
        
        Supplier newSupp = suppRepo.findOne(id);
        
        Assert.assertEquals(newSupp.getEmailAddress(), "johns@johnsmithpapercompany.co.za");
    }
    
    @Test(dependsOnMethods = "updateSupplier")
    public void deleteSupplier(){
        suppRepo = ctx.getBean(SupplierRepository.class);
        Supplier supp = suppRepo.findOne(id);
        
        suppRepo.delete(supp);
        
        Supplier deletedSupp = suppRepo.findOne(id);
        
        Assert.assertNull(deletedSupp);
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

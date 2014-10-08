package com.gamersrepublic.test.repository;

import com.gamersrepublic.domain.CustomerInvoice;
import com.gamersrepublic.repository.CustomerInvoiceRepository;
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

public class CustomerInvoiceRepositoryTest {
    private static ApplicationContext ctx;
    private CustomerInvoiceRepository repo;
    private Long id;
    
    public CustomerInvoiceRepositoryTest() {
    }


    @Test
    public void createInvoice(){
        repo = ctx.getBean(CustomerInvoiceRepository.class);
        
        CustomerInvoice invoice = new CustomerInvoice.Builder(200.00)
                .depositPaid(true)
                .invoiceDate(new Date())
                .invoiceStatus(false)
                .build();
        
        repo.save(invoice);
        
        id = invoice.getId();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createInvoice")
    public void readInvoice(){
        repo = ctx.getBean(CustomerInvoiceRepository.class);
        CustomerInvoice invoice = repo.findOne(id);
        Assert.assertTrue(invoice.isDepositPaid());
    }
    
    @Test(dependsOnMethods = "readInvoice")
    public void updateInvoice(){
        repo = ctx.getBean(CustomerInvoiceRepository.class);
        CustomerInvoice invoice = repo.findOne(id);
        
        CustomerInvoice update = new CustomerInvoice.Builder(200.00)
                .clone(invoice)
                .invoiceStatus(true)
                .build();
        
        repo.save(update);
        
        CustomerInvoice newInvoice = repo.findOne(id);
        
        Assert.assertTrue(newInvoice.isInvoicePaid());
    }
    
    @Test(dependsOnMethods = "updateInvoice")
    public void deleteInvoice(){
        repo = ctx.getBean(CustomerInvoiceRepository.class);
        CustomerInvoice invoice = repo.findOne(id);
        repo.delete(invoice);
        
        CustomerInvoice deleted = repo.findOne(id);
        
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

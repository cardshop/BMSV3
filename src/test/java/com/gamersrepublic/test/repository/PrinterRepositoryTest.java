package com.gamersrepublic.test.repository;

import com.gamersrepublic.domain.InkCardridge;
import com.gamersrepublic.domain.InkPrinter;
import com.gamersrepublic.repository.InkRepository;
import com.gamersrepublic.repository.PrinterRepository;
import com.gamersrepublic.test.config.ConnectionConfigTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
public class PrinterRepositoryTest {
    private static ApplicationContext ctx;
    public PrinterRepository printRepo;
    public long id;
    
    public PrinterRepositoryTest() {
    }

    @Test
    public void createInkPrinter(){ 
        printRepo = ctx.getBean(PrinterRepository.class);       
        
        InkPrinter inkPrinter = new InkPrinter.Builder("Printer")
                .price(2000.00)
                .cardridges(null)
                .dateInstalled(new Date())
                .numInkCardridges(0)
                .build();
        
        printRepo.save(inkPrinter);      
        
        id = inkPrinter.getId();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createInkPrinter")
    public void readInkPrinter(){
        printRepo = ctx.getBean(PrinterRepository.class);
        
        InkPrinter inkPrinter = printRepo.findOne(id);
        Assert.assertEquals(inkPrinter.getName(), "Printer");
    }
    
    @Test(dependsOnMethods = "readInkPrinter")
    public void updateInkPrinter(){
        printRepo = ctx.getBean(PrinterRepository.class);
        InkPrinter inkPrinter = printRepo.findOne(id);
    
        InkPrinter updatedInkPrinter = new InkPrinter.Builder("Printer")
                .clone(inkPrinter)
                .numInkCardridges(1)
                .build();
        
        printRepo.save(updatedInkPrinter);
        
        InkPrinter newInkPrinter = printRepo.findOne(id);
        
        Assert.assertEquals(newInkPrinter.getNumInkCardridges(), 1);
    }
    
    @Test(dependsOnMethods = "updateInkPrinter")
    public void deleteInkPrinter(){
        printRepo = ctx.getBean(PrinterRepository.class);
        InkPrinter inkPrinter = printRepo.findOne(id);
        
        printRepo.delete(inkPrinter);
        
        InkPrinter deletedInkPrinter = printRepo.findOne(id);
   
        Assert.assertNull(deletedInkPrinter);
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

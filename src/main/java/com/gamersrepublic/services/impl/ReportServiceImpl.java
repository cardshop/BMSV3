/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamersrepublic.services.impl;

import com.gamersrepublic.config.ConnectionConfig;
import com.gamersrepublic.domain.CustomerInvoice;
import com.gamersrepublic.domain.Decoration;
import com.gamersrepublic.domain.InkCardridge;
import com.gamersrepublic.domain.OrderItem;
import com.gamersrepublic.domain.Paper;
import com.gamersrepublic.repository.CustomerInvoiceRepository;
import com.gamersrepublic.repository.DecorationRepository;
import com.gamersrepublic.repository.InkRepository;
import com.gamersrepublic.repository.OrderItemRepository;
import com.gamersrepublic.repository.PaperRepository;
import com.gamersrepublic.services.ReportService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Luke
 */
public class ReportServiceImpl implements ReportService{

    private final ApplicationContext ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    private CustomerInvoiceRepository invoiceReppo = ctx.getBean(CustomerInvoiceRepository.class);
    private DecorationRepository decorationRepo = ctx.getBean(DecorationRepository.class);
    private InkRepository inkCardridgeRepo = ctx.getBean(InkRepository.class);
    private PaperRepository paperRepo =  ctx.getBean(PaperRepository.class);
    
    @Override
    public List<CustomerInvoice> MonthlyOrdersProcessed() {
        List<CustomerInvoice> model = new ArrayList<CustomerInvoice>();
        List<CustomerInvoice> orders = invoiceReppo.findAll();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int currentMonth = cal.get(Calendar.MONTH);
        int invoiceMonth = 0;
        
        for (CustomerInvoice order : orders){
            cal.setTime(order.getInvoiceDate());
            invoiceMonth = cal.get(Calendar.MONTH);
            
            if(invoiceMonth == currentMonth)
                model.add(order);
        }
        
        return model;
    }

    @Override
    public Map StockReport() {
        Map model = new HashMap();
        int counter = 0;
        
        try{
            List<InkCardridge> inkCardridges = inkCardridgeRepo.findAll();
            for(InkCardridge inkCardridge : inkCardridges){
                counter += inkCardridge.getInventory();
            }

            model.put("inkCardridges", counter);
            counter = 0;
        } catch(Exception e){
            model.put("inkCardridges", 0);
        }
        
        try{
            List<Decoration> decorations = decorationRepo.findAll();
            for(Decoration decoration : decorations){
                counter += decoration.getInventory();
            }
        
            model.put("decorations", counter);
            counter = 0;
        } catch(Exception e){
            model.put("decorations", 0);
        }
        
        try{
            List<Paper> paper = paperRepo.findAll(); 
            for (Paper page : paper){
               counter += page.getInventory();
            }
        
            model.put("paper", counter);
        } catch(Exception e){
            model.put("paper", 0);
        }
        
        return model;
    }
    
}

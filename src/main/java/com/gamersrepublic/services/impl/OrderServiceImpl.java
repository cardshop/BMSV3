/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamersrepublic.services.impl;

import com.gamersrepublic.config.ConnectionConfig;
import com.gamersrepublic.domain.CustomerInvoice;
import com.gamersrepublic.domain.OrderItem;
import com.gamersrepublic.domain.Orders;
import com.gamersrepublic.domain.Paper;
import com.gamersrepublic.domain.Product;
import com.gamersrepublic.repository.CustomerInvoiceRepository;
import com.gamersrepublic.repository.OrderItemRepository;
import com.gamersrepublic.repository.ProductRepository;
import com.gamersrepublic.services.OrderService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Luke
 */
public class OrderServiceImpl implements OrderService{
    private final ApplicationContext ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    ProductRepository productRepo;
    OrderItemRepository orderItemRepo;
    CustomerInvoiceRepository invoiceRepo;
    
    @Override
    public OrderItem addOrder(Map model, List<Paper> pages) {
        if(!pages.isEmpty()){
            productRepo = ctx.getBean(ProductRepository.class);
            orderItemRepo = ctx.getBean(OrderItemRepository.class);

            Product product = new Product.Builder(model.get("type").toString())
                    .paperUsed(pages)
                    .unitPrice(Double.parseDouble(model.get("price").toString()))
                    .build();
            productRepo.save(product);

            OrderItem orderItem = new OrderItem.Builder(Integer.parseInt(model.get("quantity").toString()))
                    .product(product)
                    .build();
            orderItemRepo.save(orderItem);

            return orderItemRepo.findOne(orderItem.getId());
        }else{
            return null;
        }
    }
    
    @Override
    public CustomerInvoice generateInvoice(){
        invoiceRepo = ctx.getBean(CustomerInvoiceRepository.class);
        
        CustomerInvoice customerInvoice = new CustomerInvoice.Builder(3)
                .depositPaid(true)
                .invoiceDate(new Date())
                .build();
        invoiceRepo.save(customerInvoice);
        
        return invoiceRepo.findOne(customerInvoice.getId());
    }
}

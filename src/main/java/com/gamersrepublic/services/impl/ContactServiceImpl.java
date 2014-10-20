/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamersrepublic.services.impl;

import com.gamersrepublic.config.ConnectionConfig;
import com.gamersrepublic.domain.Supplier;
import com.gamersrepublic.repository.SupplierRepository;
import com.gamersrepublic.services.ContactService;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Luke
 */
public class ContactServiceImpl implements ContactService{
    private final ApplicationContext ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    private SupplierRepository supplierRepo;
    
    @Override
    public void addContact(Map model) {
        supplierRepo = ctx.getBean(SupplierRepository.class);
        
        Supplier supplier = new Supplier.Builder(model.get("name").toString())
                .address(model.get("address").toString())
                .contactCellphone(model.get("cel").toString())
                .emailAddress(model.get("email").toString())
                .contactLandline(model.get("tel").toString())
                .websiteURL(model.get("website").toString())
                .serviceDescrip(model.get("description").toString())
                .build();
        
        supplierRepo.save(supplier);
    }
    
}

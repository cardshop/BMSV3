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
import java.util.ArrayList;
import java.util.List;
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
    public Supplier addContact(Map model) {
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
        
        return supplierRepo.findOne(supplier.getId());
    }
    
    @Override
    public Supplier updateContact(Map model){
        supplierRepo = ctx.getBean(SupplierRepository.class);
        
        Supplier supplierOld = supplierRepo.findOne((Long)model.get("id"));
        
        Supplier supplierNew = new Supplier.Builder(model.get("name").toString())
                .clone(supplierOld)
                .address(model.get("address").toString())
                .contactCellphone(model.get("cel").toString())
                .emailAddress(model.get("email").toString())
                .contactLandline(model.get("tel").toString())
                .websiteURL(model.get("website").toString())
                .serviceDescrip(model.get("description").toString())
                .build();
        
        supplierRepo.save(supplierNew);
        
        return supplierRepo.findOne(supplierNew.getId());
    }
    
    @Override
    public List<Supplier> populateContactList(){
        supplierRepo = ctx.getBean(SupplierRepository.class);
        return supplierRepo.findAll();
    }
    
    @Override
    public boolean deleteContact(Long id){
        supplierRepo = ctx.getBean(SupplierRepository.class);
        Supplier supplier = supplierRepo.findOne(id);
        supplierRepo.delete(supplier);
        
        Supplier deleted = supplierRepo.findOne(id);
        
        if (deleted != null)
            return true;
        else
            return false;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamersrepublic.services;

import com.gamersrepublic.domain.Supplier;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luke
 */
public interface ContactService { 
    public Supplier addContact(Map model);
    public Supplier updateContact(Map model);
    public List<Supplier> populateContactList();
    public boolean deleteContact(Long id);
}

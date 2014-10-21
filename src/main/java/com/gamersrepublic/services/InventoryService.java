/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamersrepublic.services;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Luke
 */
public interface InventoryService {
    public Object addInventory(Map model);
    public Object updateInventory(Map model);
    public List<Object> populateInventoryList();
    public boolean deleteInventory(Map model);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamersrepublic.services;

import com.gamersrepublic.domain.CustomerInvoice;
import com.gamersrepublic.domain.OrderItem;
import com.gamersrepublic.domain.Orders;
import com.gamersrepublic.domain.Paper;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luke
 */
public interface OrderService {
    public OrderItem addOrder(Map model, List<Paper> pages);
    public CustomerInvoice generateInvoice();
}

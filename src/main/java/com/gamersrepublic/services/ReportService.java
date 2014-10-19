/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamersrepublic.services;

import com.gamersrepublic.domain.CustomerInvoice;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luke
 */
public interface ReportService {
    public List<CustomerInvoice> MonthlyOrdersProcessed();
    public Map StockReport();
}

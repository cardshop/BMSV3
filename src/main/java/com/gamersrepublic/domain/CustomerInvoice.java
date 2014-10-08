package com.gamersrepublic.domain;
import java.io.*;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author Jonathan Kok
 */

/* Notes
    Invoice generated for customer based on Order/s placed. 
    Invoice Status is either Paid or Unpaid, a deposit of 40% is usually required up front before any work is done.
*/

@Entity
public class CustomerInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
 
    @Temporal(javax.persistence.TemporalType.DATE) 
    private Date invoiceDate;   
    
    private double orderAmount;
    private boolean invoiceStatus;
    private boolean depositPaid;
    
    private CustomerInvoice(){
    }

    private CustomerInvoice(Builder build) {
        id = build.id;
        invoiceDate = build.invoiceDate;
        invoiceStatus = build.invoiceStatus;
        orderAmount = build.orderAmount; 
        depositPaid = build.depositPaid;   
    }
    public static class Builder {
        private Long id;
        private Date invoiceDate;
        private double orderAmount;
        private boolean invoiceStatus; 
        private boolean depositPaid;;

        public Builder(double orderAmount){
            this.orderAmount = orderAmount;
        }
        
        public Builder invoiceDate(Date invoiceDate){
            this.invoiceDate = invoiceDate;
            return this;
        }
        
        public Builder invoiceStatus(boolean invoiceStatus){
            this.invoiceStatus = invoiceStatus;
            return this;
        }
        
        public Builder depositPaid(boolean depositPaid){
               this.depositPaid = depositPaid;
               return this;
        }
        
        public Builder id(Long id) {
            this.id = id;
            return this;
        } 
        
        public Builder clone(CustomerInvoice custInvoice){
            id = custInvoice.getId();
            invoiceDate = custInvoice.getInvoiceDate();
            invoiceStatus = custInvoice.isInvoicePaid();
            depositPaid = custInvoice.isDepositPaid();
            orderAmount = custInvoice.getOrderAmount(); 
            
            return this;
        }
        
        public CustomerInvoice build(){
            return new CustomerInvoice(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public boolean isInvoicePaid() {
        return invoiceStatus;
    }

    public boolean isDepositPaid() {
        return depositPaid;
    }

    @Override
    public String toString() {
        return "CustomerInvoice{" + "id=" + id + ", invoiceDate=" + invoiceDate + ", orderAmount=" + orderAmount + ", invoiceStatus=" + invoiceStatus + ", depositPaid=" + depositPaid + '}';
    }
}


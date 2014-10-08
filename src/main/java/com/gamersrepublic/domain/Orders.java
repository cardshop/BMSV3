package com.gamersrepublic.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Jonathan
 */

@Entity
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int orderNumber;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date orderDate;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dueDate;
    
    @OneToMany//(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
    @JoinColumn(name = "ITEMS")
    private List<OrderItem> items;  
    
    private boolean collected;

    @OneToOne 
    private CustomerInvoice invoice;
    
    private int amountPaperUsed;
    private int amountCrystalsUsed;
    private int amountBeadsUsed;
    private int amountRibbonsUsed;
    private int amountGlueUsed;
    private int amountSprayUsed;
    private int amountPodgeUsed;
    private int amountLaminatingPocketsUsed;
    
    private Orders(){
    }
    
    private Orders(Builder build){
        id = build.id;
        orderNumber = build.orderNumber;
        orderDate = build.orderDate;
        dueDate = build.dueDate;
        items = build.items;
        collected = build.collected;
        invoice = build.invoice;
        amountPaperUsed = build.amountPaperUsed;
        amountCrystalsUsed = build.amountCrystalsUsed;
         amountBeadsUsed = build.amountBeadsUsed;
        amountRibbonsUsed = build.amountRibbonsUsed;
         amountGlueUsed = build.amountGlueUsed;
        amountSprayUsed = build.amountPodgeUsed;
        amountPodgeUsed = build.amountPodgeUsed;
        amountLaminatingPocketsUsed = build.amountLaminatingPocketsUsed; 
    }
    
    public static class Builder{
            private Long id;
            private int orderNumber;
            private CustomerInvoice invoice;
            @Temporal(javax.persistence.TemporalType.DATE)
            private Date orderDate;
            @Temporal(javax.persistence.TemporalType.DATE)
            private Date dueDate;
            private List<OrderItem> items = new ArrayList<>();  
            private boolean collected;
            
            private int amountPaperUsed;
            private int amountCrystalsUsed;
            private int amountBeadsUsed;
            private int amountRibbonsUsed;
            private int amountGlueUsed;
            private int amountSprayUsed;
            private int amountPodgeUsed;
            private int amountLaminatingPocketsUsed;
            
            public Builder(int orderNumber){
                this.orderNumber = orderNumber;
            }
            
            public Builder id(Long id){
                this.id = id;
                return this;
            }
        
           public Builder orderDate(Date orderDate){
                this.orderDate = orderDate;
                return this;
           }
           
           public Builder dueDate(Date dueDate){
                this.dueDate = dueDate;
                return this;
           }
         
           public Builder invoice(CustomerInvoice inv){
                this.invoice = inv;
                return this;
           }
        
           public Builder orderItem(List<OrderItem> items){
                this.items = items;
                return this;
           }

           public Builder collected(boolean collected){
               this.collected = collected;
               return this;
           }
           
           public Builder amountPaperUsed(int amountPaperUsed){
               this.amountPaperUsed = amountPaperUsed;
               return this;
           }
           
           public Builder amountCrystalsUsed(int amountCrystalsUsed){
               this.amountCrystalsUsed = amountCrystalsUsed;
               return this;
           }
           
           public Builder amountBeadsUsed(int amountBeadsUsed){
              this.amountBeadsUsed = amountBeadsUsed;
              return this;
           }
           
           public Builder amountRibbonsUsed(int amountRibbonsUsed){
               this.amountRibbonsUsed = amountRibbonsUsed;
               return this;
           }
           
           public Builder amountGlueUsed(int amountGlueUsed){
               this.amountGlueUsed = amountGlueUsed;
               return this;
           }
           
           public Builder amountSprayUsed(int amountSprayUsed){
               this.amountSprayUsed = amountSprayUsed;
               return this;
           }
           
           public Builder amountPodgeUsed(int amountPodgeUsed){
               this.amountPodgeUsed = amountPodgeUsed;
               return this;
           }
                      
           public Builder amountLaminatingPocketsUsed(int amountLaminatingPocketsUsed){
               this.amountLaminatingPocketsUsed = amountLaminatingPocketsUsed;
               return this;
           }
           
           public Builder clone(Orders order){
                id = order.getId();
                orderDate = order.getOrderDate();
                dueDate = order.getDueDate();
                orderNumber = order.getOrderNumber(); 
                invoice = order.getInvoice();
                collected = order.isCollected();
                items = order.getItems();
                amountPaperUsed = order.getAmountPaperUsed();
                amountCrystalsUsed = order.getAmountCrystalsUsed();
                amountBeadsUsed = order.amountBeadsUsed;
                amountRibbonsUsed = order.getAmountRibbonsUsed();
                amountGlueUsed = order.getAmountGlueUsed();
                amountSprayUsed = order.getAmountSprayUsed();
                amountPodgeUsed = order.getAmountPodgeUsed();
                amountLaminatingPocketsUsed = order.getAmountLaminatingPocketsUsed();
                return this;
          }

          public Orders build(){
            return new Orders(this);
          }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orders other = (Orders) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.dueDate, other.dueDate)) {
            return false;
        }
        if (!Objects.equals(this.items, other.items)) {
            return false;
        }
        if (this.collected != other.collected) {
            return false;
        }
        if (!Objects.equals(this.invoice, other.invoice)) {
            return false;
        }
        if (this.amountPaperUsed != other.amountPaperUsed) {
            return false;
        }
        if (this.amountCrystalsUsed != other.amountCrystalsUsed) {
            return false;
        }
        if (this.amountBeadsUsed != other.amountBeadsUsed) {
            return false;
        }
        if (this.amountRibbonsUsed != other.amountRibbonsUsed) {
            return false;
        }
        if (this.amountGlueUsed != other.amountGlueUsed) {
            return false;
        }
        if (this.amountSprayUsed != other.amountSprayUsed) {
            return false;
        }
        if (this.amountPodgeUsed != other.amountPodgeUsed) {
            return false;
        }
        if (this.amountLaminatingPocketsUsed != other.amountLaminatingPocketsUsed) {
            return false;
        }
        return true;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public CustomerInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(CustomerInvoice invoice) {
        this.invoice = invoice;
    }

    public int getAmountPaperUsed() {
        return amountPaperUsed;
    }

    public void setAmountPaperUsed(int amountPaperUsed) {
        this.amountPaperUsed = amountPaperUsed;
    }

    public int getAmountCrystalsUsed() {
        return amountCrystalsUsed;
    }

    public void setAmountCrystalsUsed(int amountCrystalsUsed) {
        this.amountCrystalsUsed = amountCrystalsUsed;
    }

    public int getAmountBeadsUsed() {
        return amountBeadsUsed;
    }

    public void setAmountBeadsUsed(int amountBeadsUsed) {
        this.amountBeadsUsed = amountBeadsUsed;
    }

    public int getAmountRibbonsUsed() {
        return amountRibbonsUsed;
    }

    public void setAmountRibbonsUsed(int amountRibbonsUsed) {
        this.amountRibbonsUsed = amountRibbonsUsed;
    }

    public int getAmountGlueUsed() {
        return amountGlueUsed;
    }

    public void setAmountGlueUsed(int amountGlueUsed) {
        this.amountGlueUsed = amountGlueUsed;
    }

    public int getAmountSprayUsed() {
        return amountSprayUsed;
    }

    public void setAmountSprayUsed(int amountSprayUsed) {
        this.amountSprayUsed = amountSprayUsed;
    }

    public int getAmountPodgeUsed() {
        return amountPodgeUsed;
    }

    public void setAmountPodgeUsed(int amountPodgeUsed) {
        this.amountPodgeUsed = amountPodgeUsed;
    }

    public int getAmountLaminatingPocketsUsed() {
        return amountLaminatingPocketsUsed;
    }

    public void setAmountLaminatingPocketsUsed(int amountLaminatingPocketsUsed) {
        this.amountLaminatingPocketsUsed = amountLaminatingPocketsUsed;
    }


}

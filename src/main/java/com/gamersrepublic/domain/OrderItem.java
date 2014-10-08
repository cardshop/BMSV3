package com.gamersrepublic.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Jonathan Kok
 */

/*Notes
    Can be a Wedding Invite, Brochure, Business Card or Birthday Card.
*/

@Entity
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;

    @OneToOne
    private Product product;
            
    private OrderItem(){
    }
    
    private OrderItem(Builder build){
        id = build.id;
        quantity = build.quantity;
        product = build.product;
    }
    
    public static class Builder{
            private Long id;
            private int quantity;
            private Product product;
            
            public Builder(int quantity){
                this.quantity = quantity;
            }
            
            public Builder id(Long id){
                this.id = id;
                return this;
            }
            
            public Builder product(Product product){
                this.product = product;
                return this;
            }
            
            public Builder clone(OrderItem orderItem){
                id = orderItem.getId();
                quantity = orderItem.getQuantity();
                product = orderItem.getProduct();
                return this;
            }
            
            public OrderItem build(){
                return new OrderItem(this);
            }
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final OrderItem other = (OrderItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "id=" + id + ", quantity=" + quantity + ", product=" + product + '}';
    }    
}


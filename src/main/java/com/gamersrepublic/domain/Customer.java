package com.gamersrepublic.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


/**
 *
 * @author Jonathan Kok
 */

@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String address;
    
    @Embedded
    private Contact contact;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL) 
    @JoinColumn(name = "CUSTOMER_ORDERS")
    private List<Orders> order;
    
    private Customer(){
    }
    
     private Customer(Builder build){
        id = build.id;
        name = build.name;
        surname = build.surname;
        address = build.address;
        contact = build.contact;
        order = build.order;
    }

     public static class Builder{
        private Long id;
        private String name;
        private String surname;
        private String address;
        private Contact contact;
        private List<Orders> order = new ArrayList<>();
        
        public Builder(String name){
            this.name = name;
        }
        
         public Builder id(Long n){            
            id = n ;
            return this;
        }
        
        public Builder name(String name){            
            this.name = name ;
            return this;
        }
        
        public Builder surname(String surname){            
            this.surname = surname ;
            return this;
        }
             
        public Builder address(String add){
            address = add;
            return this;
        }
           
        public Builder contact(Contact contact){
            this.contact = contact;
            return this;
        }
        
        public Builder order(List<Orders> order){
            this.order = order;
            return this;
        }
        
        public Builder clone(Customer c){
                id = c.getId();
                name = c.getName();
                surname = c.getSurname();
                address = c.getAddress();
                contact = c.getContact();
                order = c.getOrder();
                return this;
        }
        
        public Customer build(){
            return new Customer(this);
        }
     } 

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public Contact getContact() {
        return contact;
    }

    public List<Orders> getOrder() {
        return order;
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
            return false;
        }
        if (!Objects.equals(this.order, other.order)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address + ", contact=" + contact + ", order=" + order + '}';
    }
}

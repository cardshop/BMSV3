package com.gamersrepublic.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String contactLandline;
    private String contactCellphone;
    private String emailAddress;
    private String address;
    private String websiteURL;
    private String serviceDescrip;

    private Supplier(){
    }
    
     private Supplier(Builder build){
        id = build.id;
        name = build.name;
        contactCellphone = build.contactCellphone; 
        contactLandline = build.contactLandline;
        address = build.address;
        emailAddress = build.emailAddress;
        websiteURL = build.websiteURL;
        serviceDescrip = build.serviceDescrip; 
    }
     
     public static class Builder{
        private Long id;
        private String name;
        private String contactCellphone;
        private String contactLandline;
        private String address;
        private String emailAddress;
        private String websiteURL;
        private String serviceDescrip;
        
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
          
         public Builder contactLandline(String contactLandline){            
            this.contactLandline = contactLandline;
            return this;
        }        
         
        public Builder contactCellphone(String contactCellphone){            
            this.contactCellphone = contactCellphone;
            return this;
        }   
        
        public Builder address(String add){
            address = add;
            return this;
        }
        
        public Builder websiteURL(String url){
            websiteURL = url;
            return this;
        }
        
        public Builder serviceDescrip(String service){
            serviceDescrip = service;
            return this;
        }
        
        public Builder emailAddress(String emailAddress){
            this.emailAddress = emailAddress;
            return this;
        }
        
        public Builder clone(Supplier s){
                id = s.getId();
                name = s.getName();
                contactCellphone = s.getContactCellphone();
                address = s.getAddress();
                websiteURL = s.getWebsiteURL();
                serviceDescrip = s.getServiceDescrip();
                emailAddress = s.getEmailAddress();
                return this;
        }
        
        public Supplier build(){
            return new Supplier(this);
        }
     }   

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getContactLandline() {
        return contactLandline;
    }

    public String getContactCellphone() {
        return contactCellphone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public String getServiceDescrip() {
        return serviceDescrip;
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
        final Supplier other = (Supplier) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.contactLandline, other.contactLandline)) {
            return false;
        }
        if (!Objects.equals(this.contactCellphone, other.contactCellphone)) {
            return false;
        }
        if (!Objects.equals(this.emailAddress, other.emailAddress)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.websiteURL, other.websiteURL)) {
            return false;
        }
        if (!Objects.equals(this.serviceDescrip, other.serviceDescrip)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Supplier{" + "id=" + id + ", name=" + name + ", contactLandline=" + contactLandline + ", contactCellphone=" + contactCellphone + ", emailAddress=" + emailAddress + ", address=" + address + ", websiteURL=" + websiteURL + ", serviceDescrip=" + serviceDescrip + '}';
    }
}

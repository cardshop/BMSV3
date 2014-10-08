package com.gamersrepublic.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jonathan Kok
 */

@Embeddable
public class Contact implements Serializable{
    private String landlineNumber;
    private String cellphoneNumber;
    private String emailAddress;

    private Contact(){
    }
    
    private Contact(Builder build){
        landlineNumber = build.landlineNumber;
        cellphoneNumber = build.cellphoneNumber;
        emailAddress = build.emailAddress;
    }
    
    public static class Builder{
        private String landlineNumber;
        private String cellphoneNumber;
        private String emailAddress;
        
        public Builder(String landlineNumber){
            this.landlineNumber = landlineNumber;
        }
        
        public Builder cellphoneNumber(String cellphoneNumber){
            this.cellphoneNumber = cellphoneNumber;
            return this;
        }
        
        public Builder emailAddress(String emailAddress){
            this.emailAddress = emailAddress;
            return this;
        }
        
        public Builder clone(Contact contact){
            landlineNumber = contact.getLandlineNumber();
            cellphoneNumber = contact.getCellphoneNumber();
            emailAddress = contact.getEmailAddress();
            return this;
        }
    
        public Contact build(){
            return new Contact(this); 
        }
    }

    public String getLandlineNumber() {
        return landlineNumber;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Contact other = (Contact) obj;
        if (!Objects.equals(this.landlineNumber, other.landlineNumber)) {
            return false;
        }
        if (!Objects.equals(this.cellphoneNumber, other.cellphoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.emailAddress, other.emailAddress)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contact{" + "landlineNumber=" + landlineNumber + ", cellphoneNumber=" + cellphoneNumber + ", emailAddress=" + emailAddress + '}';
    }
}
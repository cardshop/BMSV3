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
public class Decoration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descrip;
    private double price;
    private double inventory;
    private String colour;
    private String decWidth;
    private double decLength;
    private String decSize;
    
    private Decoration(){
    }
    
    private Decoration(Builder build){
        id = build.id;
        descrip = build.descrip;
        price = build.price;
        inventory = build.inventory;
        colour = build.colour;
        decWidth = build.decWidth;
        decLength = build.decLength;
        decSize = build.decSize;
    }
    
    public static class Builder{
        private Long id;
        private String descrip;
        private double price;
        private double inventory;
        private String colour;
        private String decWidth;
        private double decLength;
        private String decSize;
        
        public Builder(String descrip){
            this.descrip = descrip;
        }
        
        public Builder id(Long id){
            this.id = id;
            return this;
        }
        
        public Builder price(double price){
            this.price = price;
            return this;
        }
        
        public Builder inventory(double inventory){
            this.inventory = inventory;
            return this;
        }
        
        public Builder colour(String colour){
            this.colour = colour;
            return this;
        }
        
        public Builder decWidth(String decWidth){
            this.decWidth = decWidth;
            return this;
        }
        
        public Builder decLength(double decLength){
            this.decLength = decLength;
            return this;
        }
        
        
        public Builder decSize(String decSize){
            this.decSize = decSize;
            return this;
        }
        
        public Builder clone(Decoration d){
            id = d.getId();
            descrip = d.getDescrip();
            price = d.getPrice();
            inventory = d.getInventory();
            colour = d.getColour();
            decWidth = d.getDecWidth();
            decLength = d.getDecLength();
            decSize = d.getDecSize();
            return this;
        }
        
        public Decoration build(){
            return new Decoration(this);
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
        final Decoration other = (Decoration) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.descrip, other.descrip)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (this.inventory != other.inventory) {
            return false;
        }
        if (!Objects.equals(this.colour, other.colour)) {
            return false;
        }
        if (!Objects.equals(this.decWidth, other.decWidth)) {
            return false;
        }
        if (!Objects.equals(this.decLength, other.decLength)) {
            return false;
        }
        if (!Objects.equals(this.decSize, other.decSize)) {
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

    public String getDescrip() {
        return descrip;
    }

    public double getPrice() {
        return price;
    }

    public double  getInventory() {
        return inventory;
    }

    public String getColour() {
        return colour;
    }

    public String getDecWidth() {
        return decWidth;
    }

    public double getDecLength() {
        return decLength;
    }

    public String getDecSize() {
        return decSize;
    }
}

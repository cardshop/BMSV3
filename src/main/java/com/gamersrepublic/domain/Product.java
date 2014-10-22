package com.gamersrepublic.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Jonathan Kok
 */

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany
    //@JoinColumn(name = "Paper")
    private List<Paper> paperUsed;
   
    private double unitPrice;
    
    private String description;
    
    @OneToMany
    //@JoinColumn(name = "Art_Decor")
    private List<Decoration> decorationsUsed;

    private Product(){
    }
    
    private Product(Builder build){
        this.id = build.id;
        this.paperUsed = build.paperUsed;
        this.unitPrice = build.unitPrice;
        this.description = build.description;
        this.decorationsUsed = build.decorationsUsed; 
    }
    
    public static class Builder{
               private Long id;
               private List<Paper> paperUsed;
               private double unitPrice; 
               private String description;
               private List<Decoration> decorationsUsed;
               
           public Builder(String description){
                this.description = description;
            }
            
            public Builder id(Long id){
                this.id = id;
                return this;
            }
                       
            public Builder paperUsed(List<Paper> paperUsed){
                this.paperUsed = paperUsed;
                return this;
            }
            
            public Builder decorationsUsed(List<Decoration> decorationsUsed){
                this.decorationsUsed = decorationsUsed;
                return this;
            }
            
            public Builder unitPrice(double unitPrice){
                this.unitPrice = unitPrice;
                return this;
            }


            public Builder clone(Product prod){
                this.id = prod.getId();
                this.decorationsUsed = prod.getDecorationsUsed();
                this.paperUsed = prod.getPaperUsed();
                this.unitPrice = prod.getUnitPrice();
                this.description = prod.description;               
                return this;
            }
            
            public Product build(){
                return new Product(this);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.paperUsed, other.paperUsed)) {
            return false;
        }
        if (!Objects.equals(this.unitPrice, other.unitPrice)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.decorationsUsed, other.decorationsUsed)) {
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

    public List<Paper> getPaperUsed() {
        return paperUsed;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public List<Decoration> getDecorationsUsed() {
        return decorationsUsed;
    }

 }

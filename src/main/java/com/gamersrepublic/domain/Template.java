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
 * @author Jonathan Kok
 */

@Entity
public class Template implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String imageSourcePath;  //Path to jpg/png image file on system 
    private int amountUsed; // the amount of times this template has been used.
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAdded;
                
    private Template(){
    }

    private Template(Builder build){
        name = build.name;
        imageSourcePath = build.imageSourcePath;
        amountUsed = build.amountUsed;
        dateAdded = build.dateAdded;
    }

    public static class Builder{
            private Long id;
            private String name;
            private String imageSourcePath;   
            private int amountUsed;
            
            @Temporal(javax.persistence.TemporalType.DATE)
            private Date dateAdded;
            
            public Builder(String name){
                this.name = name;
            }
            
            public Builder id(Long id){
                this.id = id;
                return this;
            }
            
            public Builder name(String name){
                this.name = name;
                return this;
            }
            
            public Builder imageSourcePath(String imageSourcePath){
                this.imageSourcePath = imageSourcePath;
                return this;                
            }
            
            public Builder amountUsed(int amountUsed){
                this.amountUsed = amountUsed;
                return this;
            }
            
            public Builder dateAdded(Date dateAdded){
                this.dateAdded = dateAdded;
                return this;
            }
            
            public Builder clone(Template temp){
                id = temp.getId();
                name = temp.getName();
                imageSourcePath = temp.getImageSourcePath();
                amountUsed = temp.getAmountUsed();
                return this;
            }
 
            public Template build(){
                return new Template(this);
            }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageSourcePath() {
        return imageSourcePath;
    }

    public int getAmountUsed() {
        return amountUsed;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    @Override
    public String toString() {
        return "Template{" + "id=" + id + ", name=" + name + ", imageSourcePath=" + imageSourcePath + ", amountUsed=" + amountUsed + ", dateAdded=" + dateAdded + '}';
    }
}

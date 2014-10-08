package com.gamersrepublic.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Jonathan Kok
 */

/*Notes
    This entity allows for the tracking of Ink Cardridges, seeing as they can be quite expensive, they needed to be tracked as well.
    Designed in way that will allow the user to add a new card from the front end.
*/

@Entity
public class InkCardridge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private int inventory;
    private int inkLevel;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInstalled;
    private String colour;
    private String inUse;
    private double price;
    

    private InkCardridge(){
    }
    
    private InkCardridge(Builder build){
        id = build.id;
        name = build.name;
        inventory = build.inventory;
        inkLevel = build.inkLevel;
        dateInstalled = build.dateInstalled;
        colour = build.colour;
        inUse = build.inUse;
        price = build.price;
    }
  
    public static class Builder{
            private Long id;
            private String name;
            private int inventory;
            private int inkLevel;
            @Temporal(javax.persistence.TemporalType.DATE)
            private Date dateInstalled;
            private String colour;
            private String inUse;
            private double price;
            
            public Builder(String name){
                this.name = name;
            }
            
            public Builder id(Long id){
                this.id = id;
                return  this;
            }
            
            public Builder inventory(int inventory){
                this.inventory = inventory;
                return this;
            }
            
            public Builder inkLevel(int inkLevel){
                this.inkLevel = inkLevel;
                return this;  
            }
            
            public Builder dateInstalled(Date dateInstalled){
                this.dateInstalled = dateInstalled;
                return this;
            }
            
            public Builder colour(String colour){
                this.colour = colour;
                return this;
            }
            
            public Builder inUse(String inUse){
                this.inUse = inUse;
                return this;
            }
            
            public Builder price(double price){
                this.price = price;
                return this;
            }
            
            public Builder clone(InkCardridge card){
                id = card.getId();
                name = card.getName();
                inventory = card.getInventory();
                inkLevel = card.getInkLevel();
                dateInstalled = card.getDateInstalled();
                colour = card.getColour();
                inUse = card.getInUse();
                price = card.getPrice();
                return this;
            }     
            
            public InkCardridge build(){
                return new InkCardridge(this);
            }
    }
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getInventory() {
        return inventory;
    }

    public int getInkLevel() {
        return inkLevel;
    }

    public Date getDateInstalled() {
        return dateInstalled;
    }

    public String getColour() {
        return colour;
    }

    public String getInUse() {
        return inUse;
    }

    public double getPrice() {
        return price;
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
        final InkCardridge other = (InkCardridge) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.inventory != other.inventory) {
            return false;
        }
        if (this.inkLevel != other.inkLevel) {
            return false;
        }
        if (!Objects.equals(this.dateInstalled, other.dateInstalled)) {
            return false;
        }
        if (!Objects.equals(this.colour, other.colour)) {
            return false;
        }
        if (!Objects.equals(this.inUse, other.inUse)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InkCardridge{" + "id=" + id + ", name=" + name + ", inventory=" + inventory + ", inkLevel=" + inkLevel + ", dateInstalled=" + dateInstalled + ", colour=" + colour + ", inUse=" + inUse + ", price=" + price + '}';
    }
}

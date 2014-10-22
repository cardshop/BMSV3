package com.gamersrepublic.domain;
import java.io.Serializable;
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
/*Notes
    Client buys paper in boxes or reams but will input the amount of sheets for quantity.
*/

@Entity
public class Paper implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private double price;
    private int inventory;
    private String grammage; // 100, 200, 270, 300
    private String size; //A4
    private String colour;
     
    private Paper(){
    }
    
    private Paper(Builder build){
        id = build.id;
        type = build.type;
        price = build.price;
        inventory = build.inventory;
        colour = build.colour;
        size = build.size;
        grammage = build.grammage;
    }
    
    public static class Builder{
        private Long id;
        private String type;
        private double price;
        private int inventory;
        private String colour;
        private String size;
        private String grammage;
        
        public Builder(String type){
            this.type = type;
        }
        
        public Builder id(Long id){
            this.id = id;
            return this;
        }
        
        public Builder price(double price){
            this.price = price;
            return this;
        }
        
        public Builder inventory(int inventory){
            this.inventory = inventory;
            return this;
        }
        
        public Builder colour(String colour){
            this.colour = colour;
            return this;
        }
        
        public Builder grammage(String grammage){
            this.grammage = grammage;
            return this;
        }
        
        public Builder size(String size){
            this.size = size;
            return this;
        }
        
        public Builder clone(Paper p){
            id = p.getId();
            type = p.getType();
            price = p.getPrice();
            inventory = p.getInventory();
            colour = p.getColour();
            size = p.getSize();
            grammage = p.getGrammage();
            return this;
        }
        
        public Paper build(){
            return new Paper(this);
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }


    public int getInventory() {
        return inventory;
    }

    public String getGrammage() {
        return grammage;
    }

    public String getSize() {
        return size;
    }

    public String getColour() {
        return colour;
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
        final Paper other = (Paper) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.inventory != other.inventory) {
            return false;
        }
        if (!Objects.equals(this.grammage, other.grammage)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Objects.equals(this.colour, other.colour)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return "Paper";
    }
}

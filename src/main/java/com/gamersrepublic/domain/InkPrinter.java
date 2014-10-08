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
 * 
 * 
 */

/*Notes
*  Used InkPrinter because Printer is the name of another java class. Ran into some non sense.
*  This entity keeps track and provides info of the Printer that was used to print the item.
*  It is design in a way that will allow for the user to (from the front end) "Add a new Printer" to track if/when a new Printer is purchased.
*  Keeps track of Ink Levels of the cardridges for a specific printer 
*/

@Entity
public class InkPrinter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String type; //Ink Jet, Laser
    private String name;
    private int numInkCardridges;
    private double price;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInstalled;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
    @JoinColumn(name = "Ink_Cardridges")
    private List<InkCardridge> cardridges;
    
    
    private InkPrinter(){
    }
    
    private InkPrinter(Builder build){
        id = build.id;
        name = build.name;
        type = build.type;
        numInkCardridges = build.numInkCardridges;
        price = build.numInkCardridges;
        dateInstalled = build.dateInstalled;
        cardridges = build.cardridges;
    }

    public static class Builder{
            private Long id;
            private String type; //Ink Jet, Laser
            private String name;
            private int numInkCardridges;
            private double price;
            @Temporal(javax.persistence.TemporalType.DATE)
            private Date dateInstalled;
            private List<InkCardridge> cardridges = new ArrayList<>();
            
            public Builder(String name){
                this.name = name;                         
            }
            
            public Builder id(Long id){
                this.id = id;
                return this;
            }
    
            public Builder type(String type){
                this.type = type;
                return this;
            }
            
            public Builder numInkCardridges(int numInkCardridges){
                this.numInkCardridges = numInkCardridges;
                return this;
            }
            
            public Builder price(double price){
                this.price = price;
                return this;
            }
            
            public Builder dateInstalled(Date dateInstalled){
                this.dateInstalled = dateInstalled;
                return this;
            }
            
            public Builder cardridges(List<InkCardridge> cardridges){
                this.cardridges = cardridges;
                return this;
            }
            
            public Builder clone(InkPrinter printer){
                id = printer.getId();
                name = printer.getName();
                type = printer.getType();
                numInkCardridges = printer.getNumInkCardridges();
                cardridges = printer.getCardridges();
                price = printer.getPrice();
                dateInstalled = printer.dateInstalled;
                return this;
            }
            
            public InkPrinter build(){
                return new InkPrinter(this);
            }   
    }
    
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getNumInkCardridges() {
        return numInkCardridges;
    }

    public double getPrice() {
        return price;
    }

    public Date getDateInstalled() {
        return dateInstalled;
    }

    public List<InkCardridge> getCardridges() {
        return cardridges;
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
        final InkPrinter other = (InkPrinter) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.numInkCardridges != other.numInkCardridges) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.dateInstalled, other.dateInstalled)) {
            return false;
        }
        if (!Objects.equals(this.cardridges, other.cardridges)) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return "Printer{" + "id=" + id + ", type=" + type + ", name=" + name + ", numInkCardridges=" + numInkCardridges + ", price=" + price + ", dateInstalled=" + dateInstalled + ", cardridges=" + cardridges + '}';
    }
}

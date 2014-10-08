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
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private String name;
    private String surname;
    private String username;
    private String password;
    
    private Employee(){
    }
    
     private Employee(Builder build){
        id = build.id;
        name = build.name;
        surname = build.surname;
        username = build.username;
        password = build.password; 
    }
     
     public static class Builder{
        private Long id;
        private String name;
        private String surname;
        private String username;
        private String password;
        
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
        
        public Builder surname(String surname){            
            this.surname = surname;
            return this;
        }
          
        public Builder username(String username){
            this.username = username;
            return this;
        }
        
        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder clone(Employee emp){
                id = emp.getId();
                name = emp.getName();
                surname = emp.getSurname();
                password = emp.getPassword();
                username = emp.getUsername();
                return this;
        }
        
        public Employee build(){
            return new Employee(this);
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password + '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.DoublyLinkedList;
import adt.ListInterface;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ivanmjq
 */
public class Company implements Serializable {
    
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private double latitude;
    private double longitude;
    private int foundedYear;

    public Company(String id, String name, String phone, String email, String address, double latitude, double longitude, int foundedYear) {
        this.id             = id;
        this.name           = name;
        this.phone          = phone;
        this.email          = email;
        this.address        = address;
        this.latitude       = latitude;
        this.longitude      = longitude;
        this.foundedYear    = foundedYear;
    }

    public String getId() {
        return id;
    }
        
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    
    public double getLatitude() {
        return latitude;
    }


    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }   
    
    public double getLongitude() {
        return longitude;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }
    
    @Override
    public int hashCode() {
        int hash = 1;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        return Objects.equals(this.id, other.id); 
        // Check if the id are same
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + name + ", phone=" + phone 
                + ", email=" + email + ", address=" + address 
                + ", foundedYear=" + foundedYear + '}';
    }  

}

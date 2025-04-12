/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalTime;
import utility.IdGeneration;

/**
 *
 * @author ivanmjq
 */
public class Company implements Serializable, IdGeneration.Identifiable {

    private String id;
    private String name;
    private String phone;
    private String email;
    private String streetAddress;
    private String area;
    private String state;
    private double latitude;
    private double longitude;
    private int foundedYear;

    private LocalTime interviewStartTime;
    private LocalTime interviewEndTime;

    public Company(String id, String name, String phone, String email, String streetAddress, String area, String state, double latitude, double longitude, int foundedYear, LocalTime interviewStartTime, LocalTime interviewEndTime) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.streetAddress = streetAddress;
        this.area = area;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
        this.foundedYear = foundedYear;
        this.interviewStartTime = interviewStartTime;
        this.interviewEndTime = interviewEndTime;
    }

    @Override
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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public LocalTime getAvailableStartTime() {
        return interviewStartTime;
    }

    public void setInterviewStartTime(LocalTime interviewStartTime) {
        this.interviewStartTime = interviewStartTime;
    }

    public LocalTime getInterviewEndTime() {
        return interviewEndTime;
    }

    public void setInterviewEndTime(LocalTime interviewEndTime) {
        this.interviewEndTime = interviewEndTime;
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
        return "\n------------------------------"
                + "\nCompany ID         : " + id
                + "\nName               : " + name
                + "\nPhone              : " + phone
                + "\nEmail              : " + email
                + "\nStreet Address     : " + streetAddress
                + "\nArea               : " + area
                + "\nState              : " + state
                + "\nLatitude           : " + latitude
                + "\nLongitude          : " + longitude
                + "\nFounded Year       : " + foundedYear
                + "\nInterview Start    : " + interviewStartTime.toString()
                + "\nInterview End      : " + interviewEndTime.toString()
                + "\n------------------------------";
    }

}

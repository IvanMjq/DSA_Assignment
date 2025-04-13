/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ivanmjq
 */
public class Student implements Serializable {
    
    private String id;
    private String name;
    private String password;
    private int age;
    private String streetAddress;
    private String area;
    private String state;
    private double latitude;
    private double longitude;
    private String email;
    private String achievement;
    private String education;
    private int yearsOfExperience;
    private String[] desiredJobTypes;
    
    
    public Student(String id, String name, String password, int age, String streetAddress, String area, String state, double latitude, double longitude, String email, String achievement, String education, int yearsOfExperience, String... desiredJobTypes) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.streetAddress = streetAddress;
        this.area = area;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
        this.email = email;
        this.achievement = achievement;
        this.education = education;
        this.yearsOfExperience = yearsOfExperience;
        this.desiredJobTypes = desiredJobTypes;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getArea() {
        return area;
    }

    public String getState() {
        return state;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getEmail() {
        return email;
    }

    public String getAchievement() {
        return achievement;
    }

    public String getEducation() {
        return education;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String[] getDesiredJobTypes() {
        return desiredJobTypes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setDesiredJobTypes(String[] desiredJobTypes) {
        this.desiredJobTypes = desiredJobTypes;
    }    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return Objects.equals(this.id, other.id); 
    }

    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", age=" + age + ", address='" + streetAddress + ", " + area + ", " + state + '\'' +
           ", email='" + email + '\'' + ", education='" + education + '\'' + ", yearsOfExperience=" + yearsOfExperience + ", desiredJobTypes=" +  String.join(", ", desiredJobTypes) +
           '}';
    }

    public void setDesiredJobType(String[] jobTypes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

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
public class Student implements Serializable {
    
    private String id;
    private String name;
    private String password;
    private int age;
    private String address;
    private double latitude;
    private double longitude;
    private String email;
    private String achievement;
    private String education;
    private int yearsOfExperience;
    private String[] desiredJobTypes;

    public Student(String id, String name, String password, int age, String address, double latitude, double longitude, String email, String achievement, String education, int yearsOfExperience, String... desireJobTypes) {
        this.id                 = id;
        this.name               = name;
        this.password           = password;
        this.age                = age;
        this.address            = address;
        this.latitude           = latitude;
        this.longitude          = longitude;
        this.email              = email;
        this.achievement        = achievement;
        this.education          = education;
        this.yearsOfExperience  = yearsOfExperience;
        this.desiredJobTypes = desireJobTypes;
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

    public String getAddress() {
        return address;
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

    public void setAddress(String address) {
        this.address = address;
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
        final Student other = (Student) obj;
        return Objects.equals(this.id, other.id); 
    }

    @Override
    public String toString() {
        StringBuilder jobsTypeStr = new StringBuilder();
        if (desiredJobTypes != null) {
            for (String job : desiredJobTypes) {
                jobsTypeStr.append(job).append(", ");
            }
            if (jobsTypeStr.length() > 0) {
                jobsTypeStr.setLength(jobsTypeStr.length() - 2); // remove last comma
            }
        }
        
        return "Student{" +
            "id=" + id + ", name=" + name + ", password=" + password + ", age=" + age +
            ", address=" + address + ", latitude=" + latitude + ", longitude=" + longitude +
            ", email=" + email + ", achievement=" + achievement + ", education=" + education +
            ", yearsOfExperience=" + yearsOfExperience + ", desiredJobTypes=[" + jobsTypeStr + "]" + '}';
    }
}

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
    private int age;
    private String address;
    private String email;
    private String[] achievement = null;
    private String education;
    private String[] skills = null;
    // Store all JobApplication
    private ListInterface<JobPosting> jobPostingList = new DoublyLinkedList<>();
    
    public Student(String id, String name, int age, String address, String email, String[] achievement, String education, String[] skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.achievement = achievement;
        this.education = education;
        this.skills = skills;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getAchievement() {
        return achievement;
    }

    public void setAchievement(String[] achievement) {
        this.achievement = achievement;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public ListInterface<JobPosting> getJobPostingList() {
        return jobPostingList;
    }

    public void setJobPostingList(ListInterface<JobPosting> jobPostingList) {
        this.jobPostingList = jobPostingList;
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
        // Check if the id are same
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name +
                ", age=" + age + ", address=" + address +
                ", email=" + email + ", achievement=" +
                achievement + ", education=" + education +
                ", skills=" + "" + ", jobPostingList=" +
                jobPostingList + '}';
    }      
    
    
     // Method to display student details
    public void displayStudent() {
        System.out.println("\nStudent ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.print("Achievements: ");
        if (achievement.length > 0) {
            System.out.println(String.join(", ", achievement));
        } else {
            System.out.println("None");
        }
        System.out.print("Skills: ");
        if (skills.length > 0) {
            System.out.println(String.join(", ", skills));
        } else {
            System.out.println("None");
        }
        System.out.println("-----------------------------");
    }
    
}

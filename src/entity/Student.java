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
    private String skills;

    public Student(String studentId, String name, String skills) {
        this.id = studentId;
        this.name = name;
        this.skills = skills;
    }

    public String getStudentId() {
        return id;
    }

    public void setStudentId(String studentId) {
        this.id = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
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
        //check if the id are same
    }
    
    @Override
    public String toString() {
        return "Student{" + "studentId=" + id + ", name=" + name + ", skills=" + skills + '}';
    }
    
    
    
}

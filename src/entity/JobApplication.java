/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import java.time.*;

/**
 *
 * @author ivanmjq
 */
public class JobApplication implements Serializable {
    private String id; 
    private Student student;
    private LocalDateTime appliedDateTime;

    public JobApplication(String id, Student student, LocalDateTime appliedDateTime) {
        this.id = id;
        this.student = student;
        this.appliedDateTime = appliedDateTime;
    }

    public String getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDateTime getAppliedDateTime() {
        return appliedDateTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setAppliedDateTime(LocalDateTime appliedDateTime) {
        this.appliedDateTime = appliedDateTime;
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
        final JobApplication other = (JobApplication) obj;
        return Objects.equals(this.id, other.id); 
        // Check if the id are same
    }

    @Override
    public String toString() {
        return "JobApplication{" + "id='" + id + '\'' + ", jobPost=" + jobPost +
           ", student=" + student + ", appliedDateTime=" + appliedDateTime + '}';
    }

}

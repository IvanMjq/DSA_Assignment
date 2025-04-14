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
    private Student student;
    private JobPosting jobPosting;
    private Interview interviewList;
    private LocalDateTime appliedDateTime;

    public JobApplication(Student student, JobPosting jobPosting, Interview interviewList, LocalDateTime appliedDateTime) {
        this.student = student;
        this.jobPosting = jobPosting;
        this.interviewList = interviewList;
        this.appliedDateTime = appliedDateTime;
    }

    public Student getStudent() {
        return student;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public Interview getInterviewList() {
        return interviewList;
    }

    public LocalDateTime getAppliedDateTime() {
        return appliedDateTime;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public void setInterviewList(Interview interviewList) {
        this.interviewList = interviewList;
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
        return Objects.equals(this.student, other.student); 
        // Check if the id are same
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "studentId='" + student.getId() + '\'' +
                ", applicationDate=" + appliedDateTime +
                '}';
    }

}

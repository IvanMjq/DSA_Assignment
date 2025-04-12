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
public class JobApplication implements Serializable {
    
    private String id; 
    private JobPosting jobPost;
    private Student student;
    
    private Interview interview = new Interview();

    public JobApplication(String id, JobPosting jobPost, Student student) {
        this.id = id;
        this.jobPost = jobPost;
        this.student = student;
    }

    public JobApplication(String id, JobPosting jobPost, Student student, Interview interview) {
        this.id = id;
        this.jobPost = jobPost;
        this.student = student;
        this.interview = interview;
    }

    public String getId() {
        return id;
    }

    public JobPosting getJobPost() {
        return jobPost;
    }

    public Student getStudent() {
        return student;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setJobPost(JobPosting jobPost) {
        this.jobPost = jobPost;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
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
        return "JobApplication{" + "id=" + id + ", jobPost=" + jobPost + ", student=" + student + ", interview=" + interview + '}';
    }   

}

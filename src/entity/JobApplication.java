/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.DoublyLinkedList;
import adt.ListInterface;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author ivanmjq
 */
public class JobApplication implements Serializable {
    public enum InterviewStatus {
        APPLIED,
        INTERVIEW_SCHEDULED,
        INTERVIEWED,
        OFFERED,
        REJECTED,
        ACCEPTED,
        DECLINED
    }
    
    private String id; 
    private JobPosting jobPost;
    private Student student;
    private LocalDate dateOfInterview;
    private InterviewStatus interviewStatus;

    public JobApplication(String id, JobPosting jobPost, Student student, LocalDate dateOfInterview, InterviewStatus interviewStatus) {
        this.id = id;
        this.jobPost = jobPost;
        this.student = student;
        this.dateOfInterview = dateOfInterview;
        this.interviewStatus = interviewStatus;
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

    public LocalDate getDateOfInterview() {
        return dateOfInterview;
    }

    public InterviewStatus getInterviewStatus() {
        return interviewStatus;
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

    public void setDateOfInterview(LocalDate dateOfInterview) {
        this.dateOfInterview = dateOfInterview;
    }

    public void setInterviewStatus(InterviewStatus interviewStatus) {
        this.interviewStatus = interviewStatus;
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
        return "JobApplication{" +"id='" + id + '\'' + ", jobPostingID='" + jobPost + '\'' +
            ", studentID='" + student + '\'' +
            ", dateOfInterview=" + dateOfInterview + ", interviewStatus=" + interviewStatus +'}';
    }
}

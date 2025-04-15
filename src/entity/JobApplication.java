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
public class JobApplication implements Serializable, Comparable<JobApplication> {

    private Student student;
    private JobPosting jobPosting;
    private Interview interview;
    private LocalDateTime appliedDateTime;

    public JobApplication(Student student, JobPosting jobPosting, Interview interview, LocalDateTime appliedDateTime) {
        this.student = student;
        this.jobPosting = jobPosting;
        this.interview = interview;
        this.appliedDateTime = appliedDateTime;
    }

    public Student getStudent() {
        return student;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public Interview getInterview() {
        return interview;
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

    public void setInterview(Interview interview) {
        this.interview = interview;
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
        return Objects.equals(this.student.getId(), other.student.getId())
                && Objects.equals(this.jobPosting, other.jobPosting)
                && Objects.equals(this.interview.getId(), other.interview.getId());
        // Check if the id are same
    }

    @Override
    public String toString() {
        return "JobApplication{"
                + "studentId='" + student.getId() + '\''
                + ", applicationDate=" + appliedDateTime
                + '}';
    }

    @Override
    public int compareTo(JobApplication other) {
        return 0;
    }

}

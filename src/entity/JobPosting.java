/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;

/**
 *
 * @author ivanmjq
 */
public class JobPosting implements Serializable {
    
    private String id;
    private Company company;
    private Job job;
    private String description;
    private String salaryRange;
    private int requiredExperience; // Year (testing purpose)
    private LocalDate  datePosted;

    public JobPosting(String id, Company company, Job job, String description, String salaryRange, int requiredExperience, LocalDate datePosted) {
        this.id = id;
        this.company = company;
        this.job = job;
        this.description = description;
        this.salaryRange = salaryRange;
        this.requiredExperience = requiredExperience;
        this.datePosted = datePosted;
    }

    public String getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Job getJob() {
        return job;
    }

    public String getDescription() {
        return description;
    }

    public String getSalaryRange() {
        return salaryRange;
    }
    public int getRequiredExperience() {
        return requiredExperience;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }
    
    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public void setRequiredExperience(int requiredExperience) {
        this.requiredExperience = requiredExperience;
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
        final JobPosting other = (JobPosting) obj;
        return Objects.equals(this.id, other.id); 
        // Check if the id are same
    }

    @Override
    public String toString() {
        return "JobPosting{" + "id=" + id + ", company=" + company + ", job=" + job + ", description=" + description + ", salaryRange=" + salaryRange + ", requiredExperience=" + requiredExperience + ", datePosted=" + datePosted + '}';
    }       
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.DoublyLinkedList;
import adt.ListInterface;
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
    private double minimumSalary;
    private double maximumSalary;
    private int requiredExperience;
    private LocalDate  datePosted;
    
    ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
    ListInterface<JobRequiredSkill> jobRequiredSkillList = new DoublyLinkedList<>();

    public JobPosting(String id, Company company, Job job, String description, double minimumSalary, double maximumSalary, int requiredExperience, LocalDate datePosted,ListInterface<JobRequiredSkill> jobRequiredSkillList) {
        this.id = id;
        this.company = company;
        this.job = job;
        this.description = description;
        this.minimumSalary = minimumSalary;
        this.maximumSalary = maximumSalary;
        this.requiredExperience = requiredExperience;
        this.datePosted = datePosted;
        this.jobRequiredSkillList = jobRequiredSkillList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMinimumSalary() {
        return minimumSalary;
    }

    public void setMinimumSalary(int minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    public double getMaximumSalary() {
        return maximumSalary;
    }

    public void setMaximumSalary(int maximumSalary) {
        this.maximumSalary = maximumSalary;
    }

    public int getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(int requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public ListInterface<JobApplication> getJobApplicationList() {
        return jobApplicationList;
    }

    public void setJobApplicationList(ListInterface<JobApplication> jobApplicationList) {
        this.jobApplicationList = jobApplicationList;
    }

    public ListInterface<JobRequiredSkill> getJobRequiredSkills() {
        return jobRequiredSkillList;
    }

    public void setJobRequiredSkills(ListInterface<JobRequiredSkill> jobRequiredSkillList) {
        this.jobRequiredSkillList = jobRequiredSkillList;
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
        return "JobPosting{" + "id=" + id + ", company=" + company + ", job=" + job + ", description=" + description + ", salaryRange=" + minimumSalary + " - " + maximumSalary + ", requiredExperience=" + requiredExperience + ", datePosted=" + datePosted + '}';
    }       
    
}

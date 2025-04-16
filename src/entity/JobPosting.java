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
import utility.TrimToLength;

/**
 *
 * @author ivanmjq
 */
public class JobPosting implements Serializable, Comparable<JobPosting> {

    private Company company;
    private Job job;
    private String description;
    private double minimumSalary;
    private double maximumSalary;
    private int requiredExperience;
    private LocalDate datePosted;

    ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
    ListInterface<JobRequiredSkill> jobRequiredSkillList = new DoublyLinkedList<>();

    public JobPosting(Company company, Job job, String description, double minimumSalary, double maximumSalary, int requiredExperience, LocalDate datePosted) {
        this.company = company;
        this.job = job;
        this.description = description;
        this.minimumSalary = minimumSalary;
        this.maximumSalary = maximumSalary;
        this.requiredExperience = requiredExperience;
        this.datePosted = datePosted;
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

    public void setMinimumSalary(double minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    public double getMaximumSalary() {
        return maximumSalary;
    }

    public void setMaximumSalary(double maximumSalary) {
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

    public ListInterface<JobRequiredSkill> getJobRequiredSkillList() {
        return jobRequiredSkillList;
    }

    public void setJobRequiredSkillList(ListInterface<JobRequiredSkill> jobRequiredSkillList) {
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
        return Objects.equals(this.company.getId(), other.company.getId())
                && Objects.equals(this.job.getId(), other.job.getId());
        // Check if the id are same
    }

    @Override
    public String toString() {
        String line = "+-------------------------------------------------------------------------------------+\n";

        // Adjusting the format for the header and content
        return "\n" + line
                + String.format("| %-83s |\n", "Job Posting Details")
                + line
                + String.format("| %-20s : %-60s |\n", "Company Name", TrimToLength.trimToLength(company.getName(), 60))
                + String.format("| %-20s : %-60s |\n", "Job Title", TrimToLength.trimToLength(job.getTitle(), 60))
                + String.format("| %-20s : %-60s |\n", "Description", TrimToLength.trimToLength(description, 60))
                + String.format("| %-20s : RM %-57.2f |\n", "Minimum Salary", minimumSalary)
                + String.format("| %-20s : RM %-57.2f |\n", "Maximum Salary", maximumSalary)
                + String.format("| %-20s : %-60d |\n", "Required Experience", requiredExperience)
                + String.format("| %-20s : %-60s |\n", "Date Posted", datePosted)
                + line;
    }

    @Override
    public int compareTo(JobPosting other) {
        return 0;
    }

}

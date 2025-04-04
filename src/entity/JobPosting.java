/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.DoublyLinkedList;
import adt.ListInterface;
import java.io.Serializable;
import java.util.Objects;
import java.util.Date;
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
    private int requiredExperience;//year (testing purpose)
    private LocalDate  datePosted;
    private ListInterface<JobSkillRequirement> skillRequired = new DoublyLinkedList<>();

    // Store all JobApplication

    public JobPosting(String id, Company company, Job job, String description, String salaryRange, int requiredExperience,LocalDate datePosted, JobSkillRequirement... skillRequired) {
        this.id = id;
        this.company = company;
        this.job = job;
        this.description = description;
        this.salaryRange = salaryRange;
        this.requiredExperience = requiredExperience;
        this.datePosted = datePosted;
        addSkill(skillRequired);
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

    public ListInterface<JobSkillRequirement> getSkillRequired() {
        return skillRequired;
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

    public void setRequiredExperience(int RequiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public void setSkillRequired(ListInterface<JobSkillRequirement> skillRequired) {
        this.skillRequired = skillRequired;
    }


    
    public void addSkill(JobSkillRequirement... JobSkillRequirementList) {
        for (JobSkillRequirement skillRequirement : JobSkillRequirementList) {
            if (skillRequirement != null) {
                this.skillRequired.add(skillRequirement);
            }
        }
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
        StringBuilder skillsStr = new StringBuilder();
        for (int i = 1; i <= skillRequired.size(); i++) {
            skillsStr.append(skillRequired.getData(i)).append(", ");
        }
        if (skillsStr.length() > 0) {
            skillsStr.setLength(skillsStr.length() - 2); // Remove last comma
        }

        return "JobPosting{" + "id='" + id + '\'' + ", companyID='" + company + '\'' + ", jobID='" + job + '\'' + ", description='" + description + '\'' +
               ", salaryRange='" + salaryRange + '\'' + ", requiredExperience="+ requiredExperience + '\'' + ", datePosted=" + datePosted + ", requiredSkills=[" + skillsStr + "]" +'}';
    }
    
}

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
    private LocalDate  datePosted;
    private ListInterface<Skill> skillRequired = new DoublyLinkedList<>();

    // Store all JobApplication

    public JobPosting(String id, Company company, Job job, String description, String salaryRange, LocalDate datePosted, Skill... skillRequired) {
        this.id = id;
        this.company = company;
        this.job = job;
        this.description = description;
        this.salaryRange = salaryRange;
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

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public ListInterface<Skill> getSkillRequired() {
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

    public void setSkillRequired(ListInterface<Skill> skillRequired) {
        this.skillRequired = skillRequired;
    }


    
    public void addSkill(Skill... skillList) {
        for (Skill skill : skillList) {
            if (skill != null) {
                this.skillRequired.add(skill);
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
               ", salaryRange='" + salaryRange + '\'' + ", datePosted=" + datePosted + ", requiredSkills=[" + skillsStr + "]" +'}';
    }
    
}

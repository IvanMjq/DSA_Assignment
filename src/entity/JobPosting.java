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

/**
 *
 * @author ivanmjq
 */
public class JobPosting implements Serializable {
    
    private String id;
    private String description;
    private String requiredSkill;
    private Date datePosted;
    // store all JobApplication
    private ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();

    public JobPosting(String id, String description, String requiredSkill, Date datePosted) {
        this.id = id;
        this.description = description;
        this.requiredSkill = requiredSkill;
        this.datePosted = datePosted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }
    
    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }
    
    public ListInterface<JobApplication> getJobApplicationList() {
        return jobApplicationList;
    }

    public void setJobApplicationList(ListInterface<JobApplication> jobApplicationList) {
        this.jobApplicationList = jobApplicationList;
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
        //check if the id are same
    }

    
       
}

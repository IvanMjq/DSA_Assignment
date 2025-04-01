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
    private String title;
    private String description;
    private String[] requiredSkills = null;
    private Date datePosted;
    // Store all JobApplication
    private ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
    // store all RequiredSkills
    //private ListInterface<String> requiredSkiils = new DoublyLinkedList<>();

    public JobPosting(String id, String title, String description, String[] requiredSkills, Date datePosted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.datePosted = datePosted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String[] getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String[] requiredSkills) {
        this.requiredSkills = requiredSkills;
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
        // Check if the id are same
    }
    
    public void displayJobPostings() {
         System.out.println("Job ID: " + id);
         System.out.println("Title: " + title);
         System.out.println("Description: " + description);
         System.out.print("Required Skills: ");
         for (String skill : requiredSkills) {
             System.out.print(skill + ", ");
         }
         System.out.print("\n");
         System.out.println("Date Posted: " + datePosted);
     }

    public void add(JobPosting jobPost) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}

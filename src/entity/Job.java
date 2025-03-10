/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import adt.ListInterface;
import adt.DoublyLinkedList;

/**
 *
 * @author ivanmjq
 */
public class Job implements Serializable {
    
    private String id;
    private String desc;
    //store all CompanyJob
    private ListInterface<CompanyJob> companyJobList;
    // store all JobPosting
    private ListInterface<JobPosting> jobPostingList;
    

    public Job(String id, String desc) {
        this.id = id;
        this.desc = desc;
        this.companyJobList = new DoublyLinkedList<>();
        this.jobPostingList = new DoublyLinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public ListInterface<CompanyJob> getCompanyJobList() {
        return companyJobList;
    }

    public void setCompanyJobList(ListInterface<CompanyJob> companyJobList) {
        this.companyJobList = companyJobList;
    }

    public ListInterface<JobPosting> getJobPostingList() {
        return jobPostingList;
    }

    public void setJobPostingList(ListInterface<JobPosting> jobPostingList) {
        this.jobPostingList = jobPostingList;
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
        final Job other = (Job) obj;
        return Objects.equals(this.id, other.id); 
        //check if the id are same
    }

    @Override
    public String toString() {
        return "entity.Company[ id=" + id + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ivanmjq
 */
public class CompanyJob implements Serializable {

    private Company company;
    private Job job;

    public CompanyJob(Company company, Job job) {
        this.company = company;
        this.job = job;
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
        final CompanyJob other = (CompanyJob) obj;
        return Objects.equals(this.company.getId(), other.company.getId()) &&
                Objects.equals(this.job.getId(), other.job.getId()); 
        // Check if the id are same
    }

    @Override
    public String toString() {
        return "CompanyJob{" + "company=" + company + ", job=" + job + '}';
    }
     
}

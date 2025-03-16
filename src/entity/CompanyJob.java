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

    private String companyId;
    private String jobId;

    public CompanyJob(String companyId, String jobId) {
        this.companyId = companyId;
        this.jobId = jobId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
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
        return Objects.equals(this.companyId, other.companyId) &&
                Objects.equals(this.jobId, other.jobId); 
        // Check if the id are same
    }

    @Override
    public String toString() {
        return "CompanyJob{" + "companyId=" + companyId + ", jobId=" + jobId + '}';
    }
     
}

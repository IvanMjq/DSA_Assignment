/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author WEI ZHENG
 */

public class JobPosting<T> {
    private static final long serialVersionUID = 1L;
    private String jobId;
    private String jobTitle;
    private String description;
    private String requiredSkill;

    public JobPosting(String jobId, String jobTitle, String description, String requiredSkill) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.description = description;
        this.requiredSkill = requiredSkill;
    }

    public String getJobId() {
        return jobId;
    }

    public String getJobTitle() {   // ✅ Make sure this method exists
        return jobTitle;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    @Override
    public String toString() {
        return "Job[ID=" + jobId + ", Title=" + jobTitle + ", Skill=" + requiredSkill + "]";
    }
}

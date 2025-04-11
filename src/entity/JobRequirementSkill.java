/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author WEI ZHENG
 */
public class JobRequirementSkill{
    private JobPosting jobPost;
    private Skill skill;
    private int importance; // 1 to 5, how critical the skill is

    public JobRequirementSkill(JobPosting jobPost, Skill skill, int importance) {
        this.jobPost = jobPost;
        this.skill = skill;
        this.importance = importance;
    }

    public JobPosting getJobPost() {
        return jobPost;
    }

    public Skill getSkill() {
        return skill;
    }
    
// Getter and Setter for importance
    public int getImportance() {
        return importance;
    }

    public void setJobPost(JobPosting jobPost) {
        this.jobPost = jobPost;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "RequiredSkill{skill=" + "Job Post=" + jobPost + "Skill=" + skill + ", importance=" + importance + "}";
    }

}

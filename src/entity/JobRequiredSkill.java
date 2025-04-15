/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author WEI ZHENG
 */
public class JobRequiredSkill implements Serializable, Comparable<JobRequiredSkill> {

    private Skill skill;
    private int importance; // 1 to 5, how critical the skill is

    public JobRequiredSkill(Skill skill, int importance) {
        this.skill = skill;
        this.importance = importance;
    }

    public Skill getSkill() {
        return skill;
    }

    public int getImportance() {
        return importance;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setImportance(int importance) {
        this.importance = importance;
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
        final JobRequiredSkill other = (JobRequiredSkill) obj;
        return Objects.equals(this.getSkill().getId(), other.getSkill().getId());
        // Check if the id are same
    }

    @Override
    public String toString() {
        return "JobRequiredSkill{" + "skill=" + skill + ", importance=" + importance + '}';
    }

    @Override
    public int compareTo(JobRequiredSkill other) {
        return 0;
    }

}

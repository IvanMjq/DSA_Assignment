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
public class JobRequiredSkill implements Serializable {
    
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
    public String toString() {
        return "JobRequiredSkill{" + "skill=" + skill + ", importance=" + importance + '}';
    }

    

}

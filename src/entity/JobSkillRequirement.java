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
public class JobSkillRequirement extends Skill{
    private int importance; // 1 to 5, how critical the skill is

    public JobSkillRequirement(String id,  String name, int importance) {
        super(id, name);
        this.importance = importance;
    }
    
// Getter and Setter for importance
    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "RequiredSkill{skill=" + super.toString() + ", importance=" + importance + "}";
    }

}

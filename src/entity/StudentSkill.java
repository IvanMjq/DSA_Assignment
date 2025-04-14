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
public class StudentSkill implements Serializable {
    private Skill skill;
    private int proficiencyLevel; // Proficiency level of the student in the skill (1-5)

    public StudentSkill( Skill skill, int proficiencyLevel) {
        this.skill              = skill;
        this.proficiencyLevel   = proficiencyLevel;
    }

    public Skill getSkill() {
        return skill;
    }

    public int getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setProficiencyLevel(int proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }   
    @Override
    public String toString() {
        return "StudentSkill{" +
            "skill=" + skill.getName() +
            ", proficiency=" + proficiencyLevel +
            '}';
    }

}

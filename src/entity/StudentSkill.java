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
    private String id;
    private Student student;
    private Skill skill;
    private int proficiencyLevel; // Proficiency level of the student in the skill (1-5)

    public StudentSkill(String id, Student student, Skill skill, int proficiencyLevel) {
        this.id = id;
        this.student = student;
        this.skill = skill;
        this.proficiencyLevel = proficiencyLevel;
    }

    public String getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Skill getSkill() {
        return skill;
    }

    public int getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setProficiencyLevel(int proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    @Override
    public String toString() {
        return "StudentSkill{" + "student=" + student + ", skill=" + skill + ", proficiencyLevel=" + proficiencyLevel + '}';
    }

}

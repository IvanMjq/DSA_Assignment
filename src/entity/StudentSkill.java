/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author WEI ZHENG
 */
public class StudentSkill {
    private Student student;
    private Skill skill;
    private int proficiencyLevel; // Proficiency level of the student in the skill (1-5)

    // Constructor
    public StudentSkill(Student student, Skill skill, int proficiencyLevel) {
       this.student = student;
       this.skill = skill;
       this.proficiencyLevel = proficiencyLevel;
    }

    // Getter and Setter for proficiencyLevel
    public int getProficiencyLevel() {
        return proficiencyLevel;
    }

    public Student getStudent() {
        return student;
    }

    public Skill getSkill() {
        return skill;
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
        return "StudentSkill{skill=" + super.toString() + ", proficiencyLevel=" + proficiencyLevel + "}";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author WEI ZHENG
 */
public class StudentSkill extends Skill{
    private int proficiencyLevel; // Proficiency level of the student in the skill (1-5)

    // Constructor
    public StudentSkill(String id, String name, int proficiencyLevel) {
        super(id, name); // Call the parent constructor to initialize id and name
        this.proficiencyLevel = proficiencyLevel;
    }

    // Getter and Setter for proficiencyLevel
    public int getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(int proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    @Override
    public String toString() {
        return "StudentSkill{skill=" + super.toString() + ", proficiencyLevel=" + proficiencyLevel + "}";
    }
}

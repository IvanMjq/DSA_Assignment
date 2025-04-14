/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.*;
import java.io.Serializable;

/**
 *
 * @author Teh Yi Shan
 */
public class Skill implements Serializable {
    private String id;
    private String name;
    private ListInterface<JobRequiredSkill> jobRequiredSkill    = new DoublyLinkedList<>();
    private ListInterface<StudentSkill> studentSkillList        = new DoublyLinkedList<>();
        
    public Skill(String id, String name, ListInterface<StudentSkill> studentSkillList) {
        this.id                 = id;
        this.name               = name;
        this.studentSkillList   = studentSkillList;
    }
    
    public Skill(String id, String name, ListInterface<StudentSkill> studentSkillList, ListInterface<JobRequiredSkill> jobRequiredSkill) {
        this.id                 = id;
        this.name               = name;
        this.studentSkillList   = studentSkillList;
        this.jobRequiredSkill   = jobRequiredSkill;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ListInterface<JobRequiredSkill> getJobRequiredSkill() {
        return jobRequiredSkill;
    }

    public ListInterface<StudentSkill> getStudentSkillList() {
        return studentSkillList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJobRequiredSkill(ListInterface<JobRequiredSkill> jobRequiredSkill) {
        this.jobRequiredSkill = jobRequiredSkill;
    }

    public void setStudentSkillList(ListInterface<StudentSkill> studentSkillList) {
        this.studentSkillList = studentSkillList;
    }

   

    @Override
    public String toString() {
        return "Skill{" + "id=" + id + ", name=" + name + '}';
    }
 
}

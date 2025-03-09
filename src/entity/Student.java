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

public class Student implements Serializable {

    private String studentId;
    private String name;
    private String skills;

    public Student(String studentId, String name, String skills) {
        this.studentId = studentId;
        this.name = name;
        this.skills = skills;
    }

    public String getStudentId() { 
        return studentId;
    }
    public String getName() { 
        return name;
    }
    public String getSkills() { 
        return skills;
    }

    @Override
    public String toString() {
        return "Student{" + "id='" + studentId + '\'' + ", name='" + name + '\'' + '}';
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.DoublyLinkedList;
import adt.ListInterface;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ivanmjq
 */
public class Student implements Serializable {
    
    private String id;
    private String name;
    private int age;
    private String address;
    private String email;
    private String achievement;
    private String education;
    private ListInterface<Skill> skillList = new DoublyLinkedList<>();
    
    public Student(String id, String name, int age, String address, String email, String achievement, String education, Skill... skills) {
        this.id             = id;
        this.name           = name;
        this.age            = age;
        this.address        = address;
        this.email          = email;
        this.achievement    = achievement;
        this.education      = education;
        addSkill(skills);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getAchievement() {
        return achievement;
    }

    public String getEducation() {
        return education;
    }

    public ListInterface<Skill> getSkillList() {
        return skillList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setSkillList(ListInterface<Skill> skillList) {
        this.skillList = skillList;
    }
    
    public void addSkill(Skill... skillList) {
        for (Skill skill : skillList) {
            if (skill != null) {
                this.skillList.add(skill);
            }
        }
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
        final Student other = (Student) obj;
        return Objects.equals(this.id, other.id); 
    }

    @Override
    public String toString() {
        StringBuilder skillsStr = new StringBuilder();
        for (int i = 1; i <= skillList.size(); i++) {
            skillsStr.append(skillList.getData(i)).append(", ");
        }
        if (skillsStr.length() > 0) {
            skillsStr.setLength(skillsStr.length() - 2); // Remove last comma
        }
        
        return "Student{" + "id = " + id + ", name = " + name + ", age = " + age + ", address = " + address +
                ", email = " + email + ", achievement = " + achievement + ", education = " + education +
                ", skills = [" + skillsStr + "]}";
    }      
}

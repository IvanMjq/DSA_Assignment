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
    private double latitude;
    private double longitude;
    private String email;
    private String achievement;
    private String education;
    private int yearsOfExperience;
    private ListInterface<StudentSkill> skillList = new DoublyLinkedList<>();
    private ListInterface<MatchingResult> matchResult = new DoublyLinkedList<>();
    public Student(String id, String name, int age, String address, double latitude, double longitude, String email, String achievement, String education, int yearsOfExperience, StudentSkill... studentSkill) {
        this.id             = id;
        this.name           = name;
        this.age            = age;
        this.address        = address;
        this.latitude       = latitude;
        this.longitude     = longitude;
        this.email          = email;
        this.achievement    = achievement;
        this.education      = education;
        this.yearsOfExperience = yearsOfExperience;
        addSkill(studentSkill);

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
    
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
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
    
    public int getYearsOfExperience(){
        return yearsOfExperience;
    }

    public ListInterface<StudentSkill> getSkillList() {
        return skillList;
    }
    public ListInterface<MatchingResult> getMatchResult() { 
        return matchResult;
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
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
    
    public void setYearsOfExperience(int yearsOfExperience){
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setSkillList(ListInterface<StudentSkill> skillList) {
        this.skillList = skillList;
    }
    public void setMatchResult(ListInterface<MatchingResult> matchResult) { 
        this.matchResult = matchResult;
    }

    
    public void addSkill(StudentSkill... skillList) {
        for (StudentSkill skill : skillList) {
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
                ", email = " + email + ", achievement = " + achievement + ", education = " + education + ", yearsOfExperience = " + yearsOfExperience +
                ", skills = [" + skillsStr + "]}";
    }      

}

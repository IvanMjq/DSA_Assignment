/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ivanmjq
 */
public class Student implements Serializable, Comparable<Student> {

    private String id;
    private String name;
    private String password;
    private int age;
    private String streetAddress;
    private String area;
    private String state;
    private double latitude;
    private double longitude;
    private String email;
    private String achievement;
    private String education;
    private int yearsOfExperience;
    private ListInterface<StudentSkill> studentSkillList = new DoublyLinkedList<>();
    private ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
    private String[] desiredJobTypes;
    
    private ListInterface<MatchingResult> matchingResultList = new DoublyLinkedList<>();

    public Student(String id, String name, String password, int age, String streetAddress, String area, String state, double latitude, double longitude, String email, String achievement, String education, int yearsOfExperience, String... desiredJobTypes) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.streetAddress = streetAddress;
        this.area = area;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
        this.email = email;
        this.achievement = achievement;
        this.education = education;
        this.yearsOfExperience = yearsOfExperience;
        this.desiredJobTypes = desiredJobTypes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String[] getDesiredJobTypes() {
        return desiredJobTypes;
    }

    public void setDesiredJobTypes(String[] desiredJobTypes) {
        this.desiredJobTypes = desiredJobTypes;
    }

    public ListInterface<StudentSkill> getStudentSkillList() {
        return studentSkillList;
    }

    public void setStudentSkillList(ListInterface<StudentSkill> studentSkillList) {
        this.studentSkillList = studentSkillList;
    }

    public ListInterface<JobApplication> getJobApplicationList() {
        return jobApplicationList;
    }

    public void setJobApplicationList(ListInterface<JobApplication> jobApplicationList) {
        this.jobApplicationList = jobApplicationList;
    }

    public ListInterface<MatchingResult> getMatchingResultList() {
        return matchingResultList;
    }

    public void setMatchingResultList(ListInterface<MatchingResult> matchingResultList) {
        this.matchingResultList = matchingResultList;
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
        StringBuilder skillListStr = new StringBuilder();
        for (int i = 1; i <= studentSkillList.size(); i++) {
            skillListStr.append("\n    - ").append(studentSkillList.getData(i));
        }

        StringBuilder jobAppListStr = new StringBuilder();
        for (int i = 1; i <= jobApplicationList.size(); i++) {
            jobAppListStr.append("\n    - ").append(jobApplicationList.getData(i));
        }

        return "Student{"
                + "\n  ID='" + id + '\''
                + ",\n  Name='" + name + '\''
                + ",\n  Age=" + age
                + ",\n  Address='" + streetAddress + ", " + area + ", " + state + '\''
                + ",\n  Email='" + email + '\''
                + ",\n  Education='" + education + '\''
                + ",\n  Years of Experience=" + yearsOfExperience
                + ",\n  Desired Job Types=" + (desiredJobTypes != null ? String.join(", ", desiredJobTypes) : "None")
                + ",\n  Student Skills=" + (studentSkillList.size() > 0 ? skillListStr : " None")
                + ",\n  Job Applications=" + (jobApplicationList.size() > 0 ? jobAppListStr : " None")
                + "\n}";
    }

    @Override
    public int compareTo(Student other) {
        return 0;
    }
}

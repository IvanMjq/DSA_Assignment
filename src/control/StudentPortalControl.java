/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.*;
import entity.*;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class StudentPortalControl {
    Scanner scanner = new Scanner(System.in);
    
    private ListInterface<Student> studentList;
    private ListInterface<StudentSkill> studentSkillList;
    private ListInterface<Skill> skillList;
    private ListInterface<Job> jobList;
    private ListInterface<JobPosting> jobPostList;
    private ListInterface<JobRequiredSkill> requiredSkill;
    private StudentPortalUI studentPortalUI;
    private StudentControl studentControl;
    private MatchingEngineControl matchControl;
    
    
    
    protected Student loginStudent;
    
    
    public StudentPortalControl() { 
    }
    
    public StudentPortalControl(ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<StudentSkill> studentSkillList, ListInterface<Job> jobList, ListInterface<JobPosting> jobPostList, ListInterface<JobRequiredSkill> requiredSkill){
        this.studentList        = studentList;
        this.studentSkillList   = studentSkillList;
        this.skillList          = skillList;
        this.jobList            = jobList;
        this.jobPostList        = jobPostList;
        this.requiredSkill      = requiredSkill;
        this.studentPortalUI    = new StudentPortalUI(this);
        this.studentControl     = new StudentControl(studentList, skillList, studentSkillList, jobList, jobPostList, requiredSkill ,this);
        this.matchControl       = new MatchingEngineControl(studentSkillList, requiredSkill, studentList, jobPostList);
        runStudentPortalManagement();
    }
    
    public void runStudentPortalManagement() {
        int option = 0;

        do {
            option = studentPortalUI.homePage();
            switch (option) {
                case 0:
                    System.out.println("Exiting Student Portal...");
                    break;
                case 1:
                    registerStudent();
                    break;
                case 2:
                    studentLogin();
                    break;
                case 3:
                    studentLogout();
                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }
    
    public void studentStudentManagement() {
        int option = 0;

        do {

            option = studentPortalUI.studentStudentMenu();
            switch (option) {
                case 0:
                    System.out.println("Exiting Student Menu...");
                    break;
                case 1:
                    studentControl.studentOwnListing();
                    break;
                case 2:
                    studentControl.updateOwnStudent();
                    break;
                case 3:
                    matchControl.MatchingRunner(loginStudent);
                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }
    
    public void registerStudent() {
        studentControl.addStudent();
    }

    
    public void studentLogin() {
        studentPortalUI.loginUI();
        if(this.loginStudent != null) {
            studentStudentManagement();
        }
    }
    
    public void studentLogout() {
        studentPortalUI.logoutUI();
        this.loginStudent = null;
    }
    
    public boolean loginValidation(String inputID, String inputPassword) {
        boolean isValid = false;
        Student found = null;
        for (int i = 1; i <= studentList.size(); i++) {
            if (studentList.getData(i).getId().equals(inputID)) {
                found = studentList.getData(i);
                break;
            }
        }
        
        if(found != null && found.getPassword().equals(inputPassword)) {
            this.loginStudent = found;
            isValid = true;
        }
        
        return isValid;
    }
    
    public boolean isLogin() {
        if(loginStudent != null) {
            return true;
        }
        return false;
    }
    
    public Student getLoginStudent() {
        return loginStudent;
    }
}

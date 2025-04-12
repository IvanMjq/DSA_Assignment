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
    private Student loginStudent;
    private StudentPortalUI studentPortalUI;
    private StudentControl studentControl;
    
    
    public StudentPortalControl() { 
    }
    
    public StudentPortalControl(ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<StudentSkill> studentSkillList, ListInterface<Job> jobList) {
        this.studentList        = studentList;
        this.studentSkillList   = studentSkillList;
        this.skillList          = skillList;
        this.jobList            = jobList;
        this.studentPortalUI    = new StudentPortalUI(this);
        this.studentControl     = new StudentControl(studentList, skillList, studentSkillList, jobList);
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
    
    public void registerStudent() {
        studentControl.addStudent();
    }

    
    public void studentLogin() {
        studentPortalUI.loginUI();
    }
    
    public void studentLogout() {
        studentPortalUI.logoutUI();
        loginStudent = null;
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
            loginStudent = found;
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

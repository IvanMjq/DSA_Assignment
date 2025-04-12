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
    private Student loginStudent;
    private StudentPortalUI studentPortalUI;
    
    public StudentPortalControl() { 
    }
    
    public StudentPortalControl(ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<StudentSkill> studentSkillList) {
        this.studentList = studentList;
        this.studentSkillList = studentSkillList;
        this.skillList = skillList;
        this.studentPortalUI    = new StudentPortalUI(this);
        runJobPostingManagement();
    }
    
    public void runJobPostingManagement() {
        int option = 0;

        do {
            option = studentPortalUI.homePage();
            switch (option) {
                case 0:
                    System.out.println("Exiting Student Portal...");
                    break;
                case 1:
                    addStudent();
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
    
    public void addStudent() {
        studentPortalUI.addStudentUI();
        Student newStudent = studentPortalUI.newStudentDetails();
        
        
    }
    
    public void studentLogin() {
        studentPortalUI.loginUI();
        System.out.println("Welcome" + loginStudent.getName() + ".");
    }
    
    public void studentLogout() {
        studentPortalUI.logoutUI();
        System.out.println("See you" + loginStudent.getName() + ".");
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
    
    public String generateStudentID() {
        String id;
        if(studentList.getLastData() != null){
            id = studentList.getLastData().getId();
            int num = Integer.parseInt(id.substring(3)); 
             return "STU-" + (num + 1);
        }else{
            return "STU-" + 1;
        }
        
    }
}

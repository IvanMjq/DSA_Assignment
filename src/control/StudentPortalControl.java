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
    
    private ListInterface<Company> companyList = new DoublyLinkedList<>();;
    private ListInterface<Student> studentList = new DoublyLinkedList<>();;
    private ListInterface<Skill> skillList = new DoublyLinkedList<>();;
    private ListInterface<Job> jobList = new DoublyLinkedList<>();;
    private ListInterface<Interview> interviewList = new DoublyLinkedList<>();;
    private StudentPortalUI studentPortalUI;
    private StudentControl studentControl;
    private MatchingEngineControl matchControl;
    
    
    
    private Student loginStudent;
    
    
    public StudentPortalControl() { 
    }
    
    public StudentPortalControl(ListInterface<Company> companyList, ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<Job> jobList,ListInterface<Interview> interviewList){
        this.companyList        = companyList;
        this.studentList        = studentList;
        this.skillList          = skillList;
        this.jobList            = jobList;
        this.interviewList      = interviewList;
        this.studentPortalUI    = new StudentPortalUI(this);
        this.studentControl     = new StudentControl(companyList, studentList, skillList, jobList, interviewList,this);
        this.matchControl       = new MatchingEngineControl(companyList, studentList);
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
                    if(this.loginStudent != null) {
                        studentLogout();
                    }
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.*;
import entity.*;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class AdminPortalControl {
    Scanner scanner = new Scanner(System.in);
    
    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    private ListInterface<Student> studentList = new DoublyLinkedList<>();
    private ListInterface<Skill> skillList = new DoublyLinkedList<>();
    private ListInterface<Job> jobList = new DoublyLinkedList<>();
    private ListInterface<Interview> interviewList = new DoublyLinkedList<>();
    private Student loginStudent;
    private AdminPortalUI adminPortalUI;
    private StudentControl studentControl;
    private JobApplicationControl jobApplicationControl;
    private MatchingEngineControl matchControl;
    
    
    public AdminPortalControl() { 
    }
    
public AdminPortalControl(ListInterface<Company> companyList,
                          ListInterface<Student> studentList,
                          ListInterface<Skill> skillList,
                          ListInterface<Job> jobList,
                          ListInterface<Interview> interviewList) {
    this.companyList = companyList;
    this.studentList = studentList;
    this.skillList = skillList;
    this.jobList = jobList;
    this.interviewList = interviewList;

    this.adminPortalUI = new AdminPortalUI(this); // ✅ initialize this!
    this.jobApplicationControl = new JobApplicationControl(companyList, studentList, skillList, jobList, interviewList, this); 
    this.studentControl = new StudentControl(companyList, studentList, skillList, jobList, interviewList, this);

    runAdminPortalManagement(); // ✅ safe to call now
}
    
    public void runAdminPortalManagement() {
        int option = 0;

        do {
            option = adminPortalUI.homePage();
            switch (option) {
                case 0:
                    System.out.println("Exiting Admin Portal...");
                    break;
                case 1:
//                    registerStudent();
                    break;
                case 2:
                    studentControl.adminStudentManagement();
                    break;
                case 3:
                    jobApplicationControl.adminJobApplicationManagement();
                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }
}

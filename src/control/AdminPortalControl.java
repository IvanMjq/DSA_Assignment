/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

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
    
    private ListInterface<Student> studentList;
    private ListInterface<StudentSkill> studentSkillList;
    private ListInterface<Skill> skillList;
    private ListInterface<Job> jobList;
    private ListInterface<JobPosting> jobPostList;
    private ListInterface<JobRequiredSkill> requiredSkill;
    private Student loginStudent;
    private AdminPortalUI adminPortalUI;
    private StudentControl studentControl;
    private MatchingEngineControl matchControl;
    
    
    public AdminPortalControl() { 
    }
    
    public AdminPortalControl(ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<StudentSkill> studentSkillList, ListInterface<Job> jobList, ListInterface<JobPosting> jobPostList, ListInterface<JobRequiredSkill> requiredSkill) {
        this.studentList        = studentList;
        this.studentSkillList   = studentSkillList;
        this.skillList          = skillList;
        this.jobList            = jobList;
        this.jobPostList        = jobPostList;
        this.requiredSkill      = requiredSkill;
        this.adminPortalUI      = new AdminPortalUI(this);
        this.studentControl     = new StudentControl(studentList, skillList, studentSkillList, jobList, jobPostList, requiredSkill);
        this.matchControl       = new MatchingEngineControl(studentSkillList, requiredSkill, studentList, jobPostList);
        runAdminPortalManagement();
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
//                    studentLogout();
                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }
}

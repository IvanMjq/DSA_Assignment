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
    private AdminPortalUI adminPortalUI;
    private StudentControl studentControl;
    private CompanyControl companyControl;
    private JobControl jobControl;
    private JobPostingControl jobPostingControl;
    private JobApplicationControl jobApplicationControl;
    private MatchingEngineControl matchControl;

    public AdminPortalControl() {
    }

    public AdminPortalControl(ListInterface<Company> companyList, ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<Job> jobList, ListInterface<Interview> interviewList) {
        this.companyList = companyList;
        this.studentList = studentList;
        this.skillList = skillList;
        this.jobList = jobList;
        this.interviewList = interviewList;
        this.studentControl = new StudentControl(companyList, studentList, skillList, jobList, interviewList);
        this.studentControl.setAdminPortalControl(this);
        this.jobApplicationControl = new JobApplicationControl(companyList, studentList, skillList, jobList, interviewList);
        this.jobApplicationControl.setAdminPortalControl(this);
        this.jobApplicationControl.setStudentControl(this.studentControl);
        this.companyControl = new CompanyControl(companyList);
        this.jobControl = new JobControl(jobList);
        this.jobPostingControl = new JobPostingControl(companyList, jobList, skillList);
        this.adminPortalUI = new AdminPortalUI(this);

        if (login()) {
            runAdminPortalManagement();
        } else {
            System.out.println("Exiting system due to failed login.");
        }
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
                    companyControl.startCompanyManagement(); 
                    break;
                case 2:
                    jobControl.startJobManagement();
                    break;
                case 3:
                    studentControl.adminStudentManagement();
                    break;
                case 4:
                    jobPostingControl.startJobPostingManagement();
                    break;
                case 5:
                    jobApplicationControl.adminJobApplicationManagement();
                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }

    private boolean login() {
        String adminUsername = "admin";
        String adminPassword = "12345";
        final int MAX_ATTEMPTS = 3;
        int attempt = 0;

        while (attempt < MAX_ATTEMPTS) {
            System.out.println("\n===== Admin Login =====");
            System.out.println("Enter '0' at any time to go back.\n");

            System.out.print("Username : ");
            String username = scanner.nextLine();
            if (username.equals("0")) {
                System.out.println("Returning to previous menu...\n");
                return false;
            }

            System.out.print("Password : ");
            String password = scanner.nextLine();
            if (password.equals("0")) {
                System.out.println("Returning to previous menu...\n");
                return false;
            }

            if (adminUsername.equals(username) && adminPassword.equals(password)) {
                System.out.println("Login successful!\n");
                return true;
            } else {
                attempt++;
                System.out.println("Invalid credentials. Attempts left: " + (MAX_ATTEMPTS - attempt) + "\n");
            }
        }

        System.out.println("Maximum login attempts reached. Returning to previous menu...\n");
        return false;
    }

}

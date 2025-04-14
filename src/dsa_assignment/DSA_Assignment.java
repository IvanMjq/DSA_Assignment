/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa_assignment;

import adt.ListInterface;
import control.*;
import dao.*;
import entity.*;
import java.util.Scanner;
import boundary.*;

/**
 *
 * @author ivanmjq
 */
public class DSA_Assignment {

    /**
     * @param args the command line arguments
     */
    private AllDataInitialize dataInitialized = new AllDataInitialize();
    private ListInterface<Student> studentList = dataInitialized.getStudentList();

//    private MatchingEngineControl matchControl = new MatchingEngineControl(studentSkill, requiredSkill, studentList, jobPost);
//    private StudentUI studentUI = new StudentUI();
    
//
    public void StudentLogin() {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        while (!loggedIn) {

            System.out.println("============== Login ============");
            System.out.print("Enter Student Id: ");
            String input1 = scanner.nextLine();
            System.out.print("Password:");
            String input2 = scanner.nextLine();

            for (int i = 1; i <= studentList.size(); i++) {
                Student student = studentList.getData(i);
                if (student.getId().equals(input1)) {
                    if (input2.equals("1234")) {  // Example password
                        System.out.println("Welcome " + student.getName());
                        StudentMainMenu(student);
                        loggedIn = true;
                        break;
                    } else {
                        System.out.println("Incorrect password");
                        break;
                    }
                }
            }

            if (!loggedIn) {
                System.out.println("Student ID not found. Please try again.");
            }
        }
    }

    public void StudentMainMenu(Student student) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {

            System.out.println("============== Main Menu ============");
            System.out.println("1. Company Management");
            System.out.println("2. Job Posting Management");
            System.out.println("3. Student Login");
            System.out.println("4. Matching Engine");
            System.out.println("0. Exit");
            System.out.println("=====================================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    exit = true;
                    break;
                case 1:
                case 2:
//                    jobPostingControl.runJobPostingManagement();
                    break;
                case 3:
                    //testing purpose, will be replaced with UI
//                    studentUI.getAllStudents();
                    break;
                case 4:
//                    System.out.println(student);
//                    matchControl.MatchingRunner(student);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    
    
    public void portalMenu() {
        
        Scanner scanner = new Scanner(System.in);
        
        boolean exit = false;
        while (!exit) {

            System.out.println("============== Main Menu ============");
            System.out.println("1. Admin Portal");
            System.out.println("2. Student Portal");
//            System.out.println("4. Matching Engine");
            System.out.println("0. Exit");
            System.out.println("=====================================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    exit = true;
                    break;
                case 1:
                    new AdminPortalControl(dataInitialized.getCompanyList(), dataInitialized.getStudentList(), dataInitialized.getSkillList(), dataInitialized.getJobList(), dataInitialized.getInterviewList());
                    break;
                case 2:
                    new StudentPortalControl(dataInitialized.getCompanyList(), dataInitialized.getStudentList(), dataInitialized.getSkillList(), dataInitialized.getJobList(), dataInitialized.getInterviewList());
                    break;
                case 3:

//                    new StudentPortalControl(dataInitialized.getStudentList(), dataInitialized.getSkillList(), dataInitialized.getStudentSkillList());
                    break;
                case 4:
//                    System.out.println(student);
//                    matchControl.MatchingRunner();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
//         TODO code application logic here
//        JobRelatedDataInitialize jobRelatedData = new JobRelatedDataInitialize();
//        ListInterface<JobPosting> students = jobRelatedData.getjobPostingListList();
//        if (students instanceof DoublyLinkedList) {
//            for (JobPosting student : (DoublyLinkedList<JobPosting>) students) {
//                System.out.println(student);
//            }
//        }

        DSA_Assignment internshipSystem = new DSA_Assignment();
        internshipSystem.portalMenu();
    }
}

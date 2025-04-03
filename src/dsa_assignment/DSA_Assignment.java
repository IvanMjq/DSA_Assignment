/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa_assignment;

import adt.DoublyLinkedList;
import adt.ListInterface;
import control.*;
import dao.*;
import entity.*;
import java.util.Scanner;
//import boundary.*;

/**
 *
 * @author ivanmjq
 */
public class DSA_Assignment {

    /**
     * @param args the command line arguments
     */
    private JobRelatedDataInitialize dataInitialize = new JobRelatedDataInitialize();
    private JobPostingControl jobPostingControl     = new JobPostingControl(dataInitialize.getJobList(), dataInitialize.getCompanyList(), dataInitialize.getJobApplicationList(), dataInitialize.getjobPostingListList(), dataInitialize.getSkillList());
    
    public void MainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("============== Main Menu ============");
            System.out.println("1. Job Posting Management");
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
                    jobPostingControl.runJobPostingManagement();
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
        internshipSystem.MainMenu();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;


import control.*;
import entity.*;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class JobApplicationUI {
    Scanner scanner = new Scanner(System.in);
    private JobApplicationControl jobApplicationControl;
     
    public JobApplicationUI(JobApplicationControl jobApplicationControl) {
        this.jobApplicationControl = jobApplicationControl;
    }
     
    public int adminStudentMenu() {
        System.out.println("\nJob Application Menu");
        System.out.println("=====================================");
        System.out.println("1. Listing");
        System.out.println("2. Register");
        System.out.println("3. Remove");
        System.out.println("0. Exit");
        System.out.print("Enter option: ");

        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }
    
    public int studentStudentMenu() {
        System.out.println("\nJob Application Menu");
        System.out.println("=====================================");
        System.out.println("1. Listing");
        System.out.println("2. Register");
        System.out.println("3. Remove");
        System.out.println("0. Exit");
        System.out.print("Enter option: ");

        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }
    
    public void jobApplicationListingUI() {
        System.out.println("--------------------------------------");
        System.out.println("Job Appication Listing");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-30s | %-15s | %-30s | %-15s | %-30s | %-30s | %-30s | %-30s |\n",
                    "Student ID",
                    "Student Name",
                    "Company ID",
                    "Company Name",
                    "Job ID",
                    "Job Title",
                    "Applied Date Time",
                    "Interview Status",
                    "Interview Scheduled Date Time"
                );
        
    }
    
    public void addJobAppicationUI(){
        System.out.println("--------------------------------------");
        System.out.println("Add Job Appication");
        System.out.println("--------------------------------------");
        System.out.println("Enter Job Appication Infomation:");
        System.out.println("======================================");  
    }
    
    public void removeJobAppicationUI() {
        System.out.println("--------------------------------------");
        System.out.println("Remove Job Application");
    }
      
    public boolean confirmation(String message) {
        System.out.print(message + " (Y/N): ");
        char confirmation = scanner.nextLine().toUpperCase().charAt(0);
        return confirmation == 'Y';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;


import control.*;
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
        System.out.println("4. Update");
        System.out.println("5. Filter");
        System.out.println("0. Exit");
        System.out.print("Enter option: ");

        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }
    
    public void jobApplicationListingUI() {
        System.out.println("--------------------------------------");
        System.out.println("Student Listing");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-7s | %-30s | %-30s | %-30s | %-30s | %-30s | %-30s |\n",
                    "ID",
                    "Company Name",
                    "Job Title",
                    "Student Name",
                    "Applied Date Time",
                    "Status",
                    "State",
                    "Schedule Date Time"
                );
        
    }
    
    public void addStudentUI(){
        System.out.println("--------------------------------------");
        System.out.println("Add New Student");
        System.out.println("--------------------------------------");
        System.out.println("Enter Student Infomation:");
        System.out.println("======================================");
    }
}

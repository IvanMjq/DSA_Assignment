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
        System.out.println("Job Appication Listing");
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
    
    public void addJobAppicationUI(){
        System.out.println("--------------------------------------");
        System.out.println("Add Job Appication");
        System.out.println("--------------------------------------");
        System.out.println("Enter Job Appication Infomation:");
        System.out.println("======================================");
    }
    
//    public Student newJobAppicationDetails() {
//        Company companySelected = null;
//        while(companySelected == null) {
//            System.out.print("Company ID/Name, (X=Show list): ");
//            String input = scanner.nextLine().trim();
//            
//            if(Character.toUpperCase(input.charAt(0)) == 'X') {
//                compannyList();
//            }
//            
//            companySelected = jobApplicationControl.isCompanyExist(input);
//            
//            if( (companySelected == null) && (Character.toUpperCase(input.charAt(0)) != 'X'))
//                System.out.println("Company Not Found");
//         
//        }
//    }
    
//    public void compannyList() {
//        System.out.println("==========================================================================================================================================================================");
//        System.out.printf("| %-5s | %-40s | %-20s | %-35s | %-40s | %-10s |\n",
//                        "ID", "Name", "Contact", "Phone", "Email", "Address", "Founded Year");
//        jobApplicationControl.companyList();
//        System.out.println("==========================================================================================================================================================================");
//    }
//    
//    public boolean confirmation(String message) {
//        System.out.print(message + " (Y/N): ");
//        char confirmation = scanner.nextLine().toUpperCase().charAt(0);
//        return confirmation == 'Y';
//    }
}

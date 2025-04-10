/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.Scanner;

/**
 *
 * @author ivanmjq
 */
public class CompanyManagementUI {
    
    Scanner sc = new Scanner(System.in);

    public CompanyManagementUI() {
    }
    
    
    
    public int companyManagementMainMenu() {
        int option = -1; 
        boolean validInput = false; 
        boolean isFirstInput = true;
        
        while (validInput != true) {   
            System.out.println("\n\n");
            System.out.println("*--------------------------------*");
            System.out.printf("|  %-30s|\n", "Company Management Menu");
            System.out.println("+--------------------------------+");
            System.out.printf("|  %-30s|\n", "1. AddCompany ");
            System.out.printf("|  %-30s|\n", "2. View Company");
            System.out.printf("|  %-30s|\n", "3. Edit Company");
            System.out.printf("|  %-30s|\n", "4. Delete Company");
            System.out.printf("|  %-30s|\n", "0. Exit to Main Menu");
            System.out.println("*--------------------------------*\n");
            
            // Check if the user input was invalid before
            if (!isFirstInput) {
                System.out.println("Invalid option. Please choose a number between 0 - 4.");
            }
            
            // Prompt user input message
            System.out.print("Please enter your option : ");
            
            // Validate user input
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                sc.nextLine(); // Clear newline character
                if (option >= 0 && option <= 4) {
                    validInput = true;
                }
            } else {
                sc.nextLine(); // Clear the invalid input
            }
            isFirstInput = false;
            
        }
        
        return option;
    }
    
    public String getName() {
        System.out.print("Enter Company Name : ");
        return sc.nextLine();
    } 
    
    public void inValidName() {
        System.err.println("Invalid Company Name. It must be 3-50 characters long and contain only alphabets, integers and spaces.");
    }
    
    
    
    
    
    // Just for testing purpose
    public static void main(String[] args) {
        CompanyManagementUI cm = new CompanyManagementUI();
        System.out.println(cm.companyManagementMainMenu());
    }
    
}

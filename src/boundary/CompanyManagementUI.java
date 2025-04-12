/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.time.LocalTime;
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

    public String getNamePrompt() {
        System.out.print("Enter Company Name : ");
        return sc.nextLine().trim();
    }

    public String getPhonePrompt() {
        System.out.print("Enter Phone Number (e.g. 03-12345678): ");
        return sc.nextLine().trim();
    }

    public String getEmailPrompt() {
        System.out.print("Enter Email Address: ");
        return sc.nextLine().trim();
    }

    public String getStreetAddressPrompt() {
        System.out.print("Enter Street Address: ");
        return sc.nextLine().trim();
    }

    public String getAreaPrompt() {
        System.out.print("Enter Area: ");
        return sc.nextLine().trim();
    }

    public String getStatePrompt() {
        System.out.print("Enter State: ");
        return sc.nextLine().trim();
    }

    public int getFoundedYearPrompt() {
        System.out.print("Enter Founded Year: ");
        while (!sc.hasNextInt()) {
            System.err.println("Invalid input. Please enter a integer.");
            sc.nextLine(); // Clear the invalid input
            System.out.print("Enter Founded Year: ");
        }
        int year = sc.nextInt();
        sc.nextLine(); // Clear the newline character
        return year;
    }

    public LocalTime getInterviewTimePrompt(String message) {
        while (true) {
            System.out.print(message + " (HH:mm): ");
            String input = sc.nextLine().trim();
            
            if (input == null || input.isEmpty()) {
                System.err.println("Input cannot be null or empty.");
                continue;
            }
            
            try {
                return LocalTime.parse(input); // Accepts format HH:mm
            } catch (Exception e) {
                System.err.println("Invalid time format. Please enter time in HH:mm format.");
            }
        }
    }

    public String getConfirmationPrompt(String message) {
        System.out.print(message + " (Y/N): ");
        return sc.nextLine().toUpperCase().trim();
    }

    // Just for testing purpose
    public static void main(String[] args) {
        CompanyManagementUI cm = new CompanyManagementUI();
        System.out.println(cm.companyManagementMainMenu());
    }

}

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

    public int companyManagementMenu() {
        int option = -1;
        boolean validInput = false;
        boolean isFirstInput = true;
        
        String line = "+--------------------------------+";

        while (validInput != true) {
            System.out.println("\n\n");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "Company Management Menu");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "1. Add Company");
            System.out.printf("|  %-30s|\n", "2. View Company");
            System.out.printf("|  %-30s|\n", "3. Edit Company");
            System.out.printf("|  %-30s|\n", "4. Delete Company");
            System.out.printf("|  %-30s|\n", "5. Report");
            System.out.printf("|  %-30s|\n", "0. Exit to Main Menu");
            System.out.println(line);

            // Check if the user input was invalid before
            if (!isFirstInput) {
                System.err.println("Invalid option. Please choose a number between 0 - 5.");
                System.err.flush();
            }

            // Prompt user input message
            System.out.print("Please enter your option (0-5) : ");

            // Validate user input
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                sc.nextLine(); // Clear newline character
                if (option >= 0 && option <= 5) {
                    validInput = true;
                }
            } else {
                sc.nextLine(); // Clear the invalid input
            }
            isFirstInput = false;

        }

        return option;
    }

    public int companyEditMenu() {
        int option = -1;
        boolean validInput = false;
        boolean isFirstInput = true;
        
        String line = "+--------------------------------------+";

        while (validInput != true) {
            System.out.println("\n\n");
            System.out.println(line);
            System.out.printf("|  %-36s|\n", "Company Fields to Edit");
            System.out.println(line);
            System.out.printf("|  %-36s|\n", "1. Company Name ");
            System.out.printf("|  %-36s|\n", "2. Phone Number");
            System.out.printf("|  %-36s|\n", "3. Email Address");
            System.out.printf("|  %-36s|\n", "4. Street Address");
            System.out.printf("|  %-36s|\n", "5. Area");
            System.out.printf("|  %-36s|\n", "6. State");
            System.out.printf("|  %-36s|\n", "7. Founded Year");
            System.out.printf("|  %-36s|\n", "8. Interview Start and End Time");
            System.out.printf("|  %-36s|\n", "0. Exit to Company Management Menu");
            System.out.println(line);

            // Check if the user input was invalid before
            if (!isFirstInput) {
                System.out.println("Invalid option. Please choose a number between 0 - 4.");
            }

            // Prompt user input message
            System.out.print("Please enter your option (0-8) : ");

            // Validate user input
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                sc.nextLine(); // Clear newline character
                if (option >= 0 && option <= 8) {
                    validInput = true;
                }
            } else {
                sc.nextLine(); // Clear the invalid input
            }
            isFirstInput = false;

        }

        return option;

    }

    public String getStringInput(String promptMsg) {
        System.out.print(promptMsg);
        return sc.nextLine().trim();
    }

    public int getIntegerInput(String promptMsg) {
        System.out.print(promptMsg);
        while (!sc.hasNextInt()) {
            System.err.println("Invalid input. Please enter a integer.");
            sc.nextLine(); // Clear the invalid input
            System.out.print(promptMsg);
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
                System.err.flush();
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
        System.out.println(cm.companyManagementMenu());
    }

}

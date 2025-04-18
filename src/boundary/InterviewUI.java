/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.*;
import control.*;
import entity.*;
import java.util.Scanner;
/**
 *
 * @author Secret
 */
public class InterviewUI {
    
    Scanner scanner = new Scanner(System.in);

    public InterviewUI() {
    }

    public int interviewManagementMenu() {
        int choose = -1;
        boolean validInput = false;
        boolean isFirstInput = true;

        String line = "+--------------------------------+";

        while (validInput != true) {
            System.out.println("\n\n");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "Interview Management Menu");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "1. Add Interview");
            System.out.printf("|  %-30s|\n", "2. View Interiew");
            System.out.printf("|  %-30s|\n", "3. Edit Interview");
            System.out.printf("|  %-30s|\n", "4. Delete Interview");
            System.out.printf("|  %-30s|\n", "5. Report");
            System.out.printf("|  %-30s|\n", "0. Returnin to Main Menu...");
            System.out.println(line);

            // Check if the user input was invalid before
            if (!isFirstInput) {
                System.out.println("Invalid option. Please choose a number between 0 - 5.");
            }

            // Prompt user input message
            System.out.print("Please enter your option (0-5) : ");

            // Validate user input
            if (scanner.hasNextInt()) {
                choose = scanner.nextInt();
                scanner.nextLine(); // Clear newline character
                if (choose >= 0 && choose <= 5) {
                    validInput = true;
                }
            } else {
                scanner.nextLine(); // Clear the invalid input
            }
            isFirstInput = false;

        }

        return choose;
    }
    
    public int interviewEditMenu() {
        int choose = -1;
        boolean validInput = false;
        boolean isFirstInput = true;

        String line = "+--------------------------------+";

        while (validInput != true) {
            System.out.println("\n\n");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "Interview Edit Menu");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "1. Edit Interiew Date");
            System.out.printf("|  %-30s|\n", "2. Edit Interview Time");
            System.out.printf("|  %-30s|\n", "0. Returnin to Main Menu...");
            System.out.println(line);

            // Check if the user input was invalid before
            if (!isFirstInput) {
                System.out.println("Invalid option. Please choose a number between 0 - 2.");
            }

            // Prompt user input message
            System.out.print("Please enter your option (0-2) : ");

            // Validate user input
            if (scanner.hasNextInt()) {
                choose = scanner.nextInt();
                scanner.nextLine(); // Clear newline character
                if (choose >= 0 && choose <= 2) {
                    validInput = true;
                }
            } else {
                scanner.nextLine(); // Clear the invalid input
            }
            isFirstInput = false;

        }

        return choose;
    }
    
    public int reportMenu() {
        int choose = -1;
        boolean validInput = false;
        boolean isFirstInput = true;

        String line = "+--------------------------------+";

        while (validInput != true) {
            System.out.println("\n");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "Interview Report Menu");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "1. Summary Report");
            System.out.printf("|  %-30s|\n", "2. Report Ascending Rank");
            System.out.printf("|  %-30s|\n", "3. Report Descending Rank");
            System.out.printf("|  %-30s|\n", "0. Exit");
            System.out.println(line);

            // Check if the user input was invalid before
            if (!isFirstInput) {
                System.out.println("Invalid option. Please choose a number between 0 - 3.");
            }

            // Prompt user input message
            System.out.print("Please enter your option (0-3) : ");

            // Validate user input
            if (scanner.hasNextInt()) {
                choose = scanner.nextInt();
                scanner.nextLine(); // Clear newline character
                if (choose >= 0 && choose <= 3) {
                    validInput = true;
                }
            } else {
                scanner.nextLine(); // Clear the invalid input
            }
            isFirstInput = false;

        }

        return choose;
    }
    
}

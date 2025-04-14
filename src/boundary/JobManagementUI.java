/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.*;
import control.*;
import entity.*;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Ivanmjq
 */
public class JobManagementUI {

    Scanner sc = new Scanner(System.in);

    public JobManagementUI() {
    }

    public int jobManagementMenu() {
        int option = -1;
        boolean validInput = false;
        boolean isFirstInput = true;

        String line = "+--------------------------------+";

        while (validInput != true) {
            System.out.println("\n\n");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "Job Management Menu");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "1. Add Job");
            System.out.printf("|  %-30s|\n", "2. View Job");
            System.out.printf("|  %-30s|\n", "3. Edit Job");
            System.out.printf("|  %-30s|\n", "4. Delete Job");
            System.out.printf("|  %-30s|\n", "4. Report");
            System.out.printf("|  %-30s|\n", "0. Exit to Main Menu");
            System.out.println(line);

            // Check if the user input was invalid before
            if (!isFirstInput) {
                System.out.println("Invalid option. Please choose a number between 0 - 5.");
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
    
    public String getStringInput(String promptMsg) {
        System.out.println(promptMsg);
        return sc.nextLine().trim();
    }

    // Just for testing purpose
    public static void main(String[] args) {
        JobManagementUI jm = new JobManagementUI();
        System.out.println(jm.jobManagementMenu());
    }

}

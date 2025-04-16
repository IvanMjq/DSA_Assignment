/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

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
            System.out.printf("|  %-30s|\n", "0. Exit to Main Menu");
            System.out.println(line);

            // Check if the user input was invalid before
            if (!isFirstInput) {
                System.out.println("Invalid option. Please choose a number between 0 - 4.");
            }

            // Prompt user input message
            System.out.print("Please enter your option (0-4) : ");

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

    public String getJobType() {
        int option = -1;
        boolean validInput = false;
        boolean isFirstInput = true;

        String line = "+--------------------------------+";

        while (validInput != true) {
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "Job Type");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "1. Computer & Technology");
            System.out.printf("|  %-30s|\n", "2. Finance & Banking");
            System.out.printf("|  %-30s|\n", "3. Healthcare");
            System.out.printf("|  %-30s|\n", "4. Education");
            System.out.printf("|  %-30s|\n", "5. Engineering");
            System.out.println(line);

            // Check if the user input was invalid before
            if (!isFirstInput) {
                System.out.println("Invalid option. Please choose a number between 1 - 5.");
            }

            // Prompt user input message
            System.out.print("Please enter your option (1-5) : ");

            // Validate user input
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                sc.nextLine(); // Clear newline character
                if (option >= 1 && option <= 5) {
                    validInput = true;
                }
            } else {
                sc.nextLine(); // Clear the invalid input
            }
            isFirstInput = false;

        }

        switch (option) {
            case 1:
                return "Computer & Technology";
            case 2:
                return "Finance & Banking";
            case 3:
                return "Healthcare";
            case 4:
                return "Education";
            case 5:
                return "Engineering";
            default:
                return null;
        }
    }

    public int jobEditMenu() {
        int option = -1;
        boolean validInput = false;
        boolean isFirstInput = true;

        String line = "+--------------------------------------+";

        while (validInput != true) {
            System.out.println("\n\n");
            System.out.println(line);
            System.out.printf("|  %-36s|\n", "Job Fields to Edit");
            System.out.println(line);
            System.out.printf("|  %-36s|\n", "1. Job Title");
            System.out.printf("|  %-36s|\n", "2. Job Type");
            System.out.printf("|  %-36s|\n", "3. Job Description");
            System.out.printf("|  %-36s|\n", "0. Exit to Job Management Menu");
            System.out.println(line);

            // Check if the user input was invalid before
            if (!isFirstInput) {
                System.out.println("Invalid option. Please choose a number between 0 - 3.");
            }

            // Prompt user input message
            System.out.print("Please enter your option (0-3) : ");

            // Validate user input
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                sc.nextLine(); // Clear newline character
                if (option >= 0 && option <= 3) {
                    validInput = true;
                }
            } else {
                sc.nextLine(); // Clear the invalid input
            }
            isFirstInput = false;

        }

        return option;

    }

    public String trimToLength(String str, int length) {
        if (str.length() > length) {
            return str.substring(0, length - 3) + "...";
        }
        return String.format("%-" + length + "s", str);
    }

    public String getStringInput(String promptMsg) {
        System.out.print(promptMsg);
        return sc.nextLine().trim();
    }

    public String getConfirmationPrompt(String message) {
        System.out.print(message + " (Y/N): ");
        return sc.nextLine().toUpperCase().trim();
    }

    // Just for testing purpose
    public static void main(String[] args) {
        JobManagementUI jm = new JobManagementUI();
        System.out.println(jm.getJobType());
    }

}

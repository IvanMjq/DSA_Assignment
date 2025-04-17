/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedList;
import adt.ListInterface;
import dao.AllDataInitialize;
import entity.Skill;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author ivanmjq
 */
public class JobPostingManagementUI {

    private ListInterface<Skill> skillList = new DoublyLinkedList<>();

    Scanner sc = new Scanner(System.in);

    public JobPostingManagementUI(ListInterface<Skill> skillList) {
        this.skillList = skillList;
    }

    public int jobPostingManagementMenu() {
        int option = -1;
        boolean validInput = false;
        boolean isFirstInput = true;

        String line = "+--------------------------------+";

        while (validInput != true) {
            System.out.println("\n\n");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "Job Posting Management Menu");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "1. Add Job Posting");
            System.out.printf("|  %-30s|\n", "2. View Job Posting");
            System.out.printf("|  %-30s|\n", "3. Edit Job Posting");
            System.out.printf("|  %-30s|\n", "4. Delete Job Posting");
            System.out.printf("|  %-30s|\n", "5. Report");
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

    public int displaySkillMenu() {
        int option = -1;
        boolean validInput = false;
        boolean isFirstInput = true;
        int skillListSize = skillList.size();

        String line = "+--------------------------------+";

        while (validInput != true) {
            System.out.println("");
            System.out.println(line);
            System.out.printf("|  %-30s|\n", "Job Required Skill List");
            for (int i = 1; i <= skillListSize; i++) {
                Skill sk = skillList.getData(i);
                System.out.printf("|  %-30s|\n", i + ". " + sk.getName());
            }
            System.out.println(line);

            // Check if the user input was invalid before
            if (!isFirstInput) {
                System.out.println("Invalid option. Please choose a number between 1 - " + skillListSize + ".");
            }

            // Prompt user input message
            System.out.print("Please enter your option (1-" + skillListSize + ") : ");

            // Validate user input
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                sc.nextLine(); // Clear newline character
                if (option >= 1 && option <= skillListSize) {
                    validInput = true;
                }
            } else {
                sc.nextLine(); // Clear the invalid input
            }
            isFirstInput = false;

        }

        return option;
    }

    public int getJobPostingViewOptions() {
        int option = -1;
        boolean validInput = false;
        boolean isFirstInput = true;

        String line = "+----------------------------------------------------+";

        while (validInput != true) {
            System.out.println("\n\n");
            System.out.println(line);
            System.out.printf("|  %-50s|\n", "View Options");
            System.out.println(line);
            System.out.printf("|  %-50s|\n", "1. Filtering by Minimum Salary (Range)");
            System.out.printf("|  %-50s|\n", "2. Filtering by Maximum Salary (Range)");
            System.out.printf("|  %-50s|\n", "3. Filtering by Required Experience (Range)");
            System.out.printf("|  %-50s|\n", "4. Filtering by Date Posted Range (Range)");
            System.out.printf("|  %-50s|\n", "5. Display all Job Posting");
            System.out.printf("|  %-50s|\n", "0. Exit View.");
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

    public int jobPostingEditMenu() {
        int option = -1;
        boolean validInput = false;
        boolean isFirstInput = true;

        String line = "+--------------------------------------+";

        while (validInput != true) {
            System.out.println("\n\n");
            System.out.println(line);
            System.out.printf("|  %-36s|\n", "Job Posting Fields to Edit");
            System.out.println(line);
            System.out.printf("|  %-36s|\n", "1. Job Posting Descripttion");
            System.out.printf("|  %-36s|\n", "2. Job Minimum Salary");
            System.out.printf("|  %-36s|\n", "3. Job Maximum Salary");
            System.out.printf("|  %-36s|\n", "4. Job Required Experience (Year)");
            System.out.printf("|  %-36s|\n", "4. Job Required Skills");
            System.out.printf("|  %-36s|\n", "0. Exit to Job Management Menu");
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
        System.out.print(promptMsg);
        return sc.nextLine().trim();
    }

    public String getConfirmationPrompt(String message) {
        System.out.print(message + " (Y/N): ");
        return sc.nextLine().toUpperCase().trim();
    }

    public int getIntegerInput(String promptMsg) {
        int value;
        while (true) {
            System.out.print(promptMsg);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine(); // Clear newline
                break;
            } else {
                System.err.println("Invalid input. Please enter an integer.");
                sc.nextLine(); // Clear invalid input
            }
        }
        return value;
    }

    public double getDoubleInput(String promptMsg) {
        while (true) {
            try {
                System.out.print(promptMsg);
                String input = sc.nextLine().trim();
                return Double.parseDouble(input);

            } catch (NumberFormatException e) {
                System.err.flush();
                System.err.println("Invalid number format. Please enter a valid double value.");
                System.err.flush();

            }
        }
    }

    public LocalDate getDatePrompt(String message) {
        while (true) {
            System.out.print(message + " (yyyy-MM-dd): ");
            String input = sc.nextLine().trim();

            if (input == null || input.isEmpty()) {
                System.out.println("Input cannot be null or empty.");
                System.err.flush();
                continue;
            }

            try {
                return LocalDate.parse(input); // Accepts format yyyy-MM-dd
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
                System.err.flush();
            }
        }
    }

    // Just for testing purpose
    public static void main(String[] args) {
        AllDataInitialize dataInitialize = new AllDataInitialize();
        ListInterface<Skill> skillList = dataInitialize.getSkillList();

        JobPostingManagementUI jp = new JobPostingManagementUI(skillList);
        jp.getJobPostingViewOptions();
    }

}

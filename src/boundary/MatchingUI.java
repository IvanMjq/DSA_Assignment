
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.ListInterface;
import control.MatchingEngineControl;
import control.StudentPortalControl;
import entity.Student;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author WEI ZHENG
 */
public class MatchingUI {

    private MatchingEngineControl matchControl;
    Scanner scanner = new Scanner(System.in);

    public MatchingUI(MatchingEngineControl matchControl) {
        this.matchControl = matchControl;
    }

    public int MatchingMenu(Student student) {
        int choice = -1;
        System.out.println("Please select the table to be shown");

        System.out.println("| 1 - No Sort");
        System.out.println("| 2 - Ascending Sort by Score");
        System.out.println("| 3 - Descending Sort by Score");
        System.out.println("| 0 - Exit");
        while (true) {
            System.out.print("Enter your choice (0, 1, 2, or 3): ");
            try {
                choice = Integer.parseInt(scanner.nextLine()); // Read input as String, then parse
                if (choice >= 0 && choice <= 3) {
                    break; // valid input
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return choice;

    }

    public int AdminReport() {
        int choice = -1;

        System.out.println("Welcome to Summary Report of MatchingEngine");
        System.out.println("| 1 - Check Matching Results");
        System.out.println("| 2 - Distribution Graph for Job Post vs Number of Student");
        System.out.println("| 3 - Searching");
        System.out.println("| 0 - Exit");
           while (true) {
            System.out.print("Enter your choice (0, 1, 2, 3): ");
            try {
                choice = Integer.parseInt(scanner.nextLine()); 
                if (choice >= 0 && choice <= 3) {
                    break; // valid input
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return choice;

    }
    
    public String SearchUI(){
        System.out.println("***Find Your Desired Information***");
        System.out.print("Search Info(Enter QUIT to quit): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input;

    }
}

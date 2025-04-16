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

        System.out.println("Please select the table to be shown");
        matchControl.matchStudentsToJobs(student);
        System.out.println("| 1 - No Sort");
        System.out.println("| 2 - Ascending Sort by Score");
        System.out.println("| 3 - Descending Sort by Score");
        System.out.println("| 0 - Exit");
        System.out.print("Enter your choice (0, 1, or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;

    }

    public int AdminReport() {

        System.out.println("Welcome to Summary Report of MatchingEngine");
        matchControl.SummaryMatching();
        System.out.println("| 1 - All Matching Results");
        System.out.println("| 2 - Distribution Graph for Job Post vs Number of Student");
        System.out.println("| 0 - Exit");
        System.out.print("Enter your choice (0, 1, or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;

    }
}

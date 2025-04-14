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

        System.out.println("These are the job that match with you");
        matchControl.matchStudentsToJobs(student);
        System.out.println("| 1 - Search");
        System.out.println("| 2 - Sort");
        System.out.println("| 0 - Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;

    }

    public int AdminReport() {

        System.out.println("Welcome to Summary Report of MatchingEngine");
        matchControl.SummaryMatching();
        System.out.println("| 1 - Distribution Graph for Job Post vs Number of Student");
        System.out.println("| 2 - Sort");
        System.out.println("| 0 - Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;

    }
}

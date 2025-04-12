/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.ListInterface;
import control.MatchingEngineControl;
import entity.Student;
import java.util.Scanner;

/**
 *
 * @author WEI ZHENG
 */
public class MatchingUI {
       
        private MatchingEngineControl matchControl;
        private ListInterface<Student> studentList;
        

        
        public MatchingUI(MatchingEngineControl matchControl){
            this.matchControl = matchControl;
        }
        
        public int MatchingMenu(Student student){
            Scanner scanner = new Scanner(System.in);
            System.out.println("These are the job that match with you");
            matchControl.matchStudentsToJobs(student);
            matchControl.listScoresForStudent(student);
            System.out.println("============================================================================================================");
            System.out.println("| 1 - Search");
            System.out.println("| 2 - Sort");
            System.out.println("Press 0 to exit....");
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;

        }
        
        public int AdminReport(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Summary Report of MatchingEngine");
            matchControl.SummaryMatching();
            matchControl.displayAllMatchingResults();
            System.out.println("Press 0 to exit....");
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;

        }

}

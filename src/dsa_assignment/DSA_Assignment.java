/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa_assignment;
import control.MatchingEngine;
import adt.ListInterface;
import entity.Student;
import entity.JobPosting;
import java.util.Date;

/**
 *
 * @author ivanmjq
 */
public class DSA_Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date currentDate = new Date();
        MatchingEngine matchingEngine = new MatchingEngine();

        // Create Students with skills mock Data
        Student student1 = new Student("S001", "Alice Johnson", 22, "123 Main St", "alice@example.com",
                new String[]{"Hackathon Winner"}, "Computer Science", new String[]{"Java", "Python", "SQL"});

        Student student2 = new Student("S002", "Bob Smith", 23, "456 Park Ave", "bob@example.com",
                new String[]{"Dean's List"}, "Software Engineering", new String[]{"Python", "JavaScript", "HTML", "CSS"});

        Student student3 = new Student("S003", "Charlie Brown", 21, "789 Elm St", "charlie@example.com",
                new String[]{"Internship at Google"}, "Data Science", new String[]{"Python", "R", "SQL", "Machine Learning"});
        
        
        JobPosting jobPost1 = new JobPosting("J001", "Java Developer", "Tech Corp", 
                 new String[]{"Java", "SQL"}, currentDate);
        JobPosting jobPost2 = new JobPosting("J002", "Frontend Developer", "Web Solutions", 
                 new String[]{"JavaScript", "HTML", "CSS"}, currentDate);
        // Add sample jobs
       
        // Add students to matching engine
        matchingEngine.addStudent(student1);
        matchingEngine.addStudent(student2);
        matchingEngine.addStudent(student3);
        
        matchingEngine.addJobPosting(jobPost1);
        matchingEngine.addJobPosting(jobPost2);

        // Display all students
        System.out.println("=== All Students ===");
        ListInterface<Student> students = matchingEngine.getAllStudents();
        for (int i = 1; i <= students.getNumberOfEntries(); i++) {
            students.getEntry(i).displayStudent();
        }

        // Display all jobs
        System.out.println("\n=== All Jobs ===");
        ListInterface<JobPosting> jobs = matchingEngine.getAllJobPostings();
        for (int i = 1; i <= jobs.getNumberOfEntries(); i++) {
            jobs.getEntry(i).displayJobPostings();
        }
      
    }
    
}

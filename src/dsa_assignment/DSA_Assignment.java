/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa_assignment;
import adt.DoublyLinkedList;
import entity.Student;
import entity.JobPosting;
import matching_client.MatchingEngine;


/**
 *
 * @author ivanmjq
 */
public class DSA_Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DoublyLinkedList<Student> students = new DoublyLinkedList<>();
        DoublyLinkedList<JobPosting> jobs = new DoublyLinkedList<>();

        students.add(new Student("S101", "Alice", "Java"));
        students.add(new Student("S102", "Bob", "Python"));
        students.add(new Student("S103", "Carley", "C++"));
        students.add(new Student("S104", "Dickson", "Html"));
        students.add(new Student("S105", "Emily", "C"));

        jobs.add(new JobPosting("J201", "Software Engineer", "Develop software", "Java"));
        jobs.add(new JobPosting("J202", "Data Analyst", "Analyze data", "Python"));
        jobs.add(new JobPosting("J203", "Game Developer", "Analyze data", "C++"));
        jobs.add(new JobPosting("J204", "Web Developer", "Analyze data", "Html"));
        jobs.add(new JobPosting("J205", "Programmer", "Analyze data", "C"));


        MatchingEngine.matchStudentsWithJobs(students, jobs);
    }
}

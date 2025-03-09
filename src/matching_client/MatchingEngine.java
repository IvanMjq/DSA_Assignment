/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matching_client;

import adt.MatchingNode;
import adt.DoublyLinkedList;
import entity.JobPosting;
import entity.Student;

/**
 *
 * @author WEI ZHENG
 */
public class MatchingEngine {
 public static void matchStudentsWithJobs(DoublyLinkedList<Student> students, 
                                             DoublyLinkedList<JobPosting> jobs) {
        MatchingNode<Student> studentNode = students.getHead(); // ✅ Use getter method
        while (studentNode != null) {
            Student student = studentNode.getData(); // ✅ Access data correctly
            MatchingNode<JobPosting> jobNode = jobs.getHead(); // ✅ Use getter method
            while (jobNode != null) {
                JobPosting job = jobNode.getData(); // ✅ Access data correctly
                if (student.getSkills().equalsIgnoreCase(job.getRequiredSkill())) {  
                    System.out.println("✅ Match Found: " + student.getName() + " -> " + job.getJobTitle());
                }
                jobNode = jobNode.getNext(); // ✅ Move to the next job node
            }
            studentNode = studentNode.getNext(); // ✅ Move to the next student node
        }
    }
}
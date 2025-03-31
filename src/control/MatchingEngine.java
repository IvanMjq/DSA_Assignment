/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entity.Student;
import entity.JobPosting;
import adt.ListInterface;
import adt.DoublyLinkedList;
import dao.JobPostingDao;
import dao.StudentDao;

/**
 *
 * @author WEI ZHENG
 */
public class MatchingEngine {
    private StudentDao studentDao;
    private JobPostingDao jobPostingDao;

    public MatchingEngine() {
        this.studentDao = new StudentDao();
        this.jobPostingDao = new JobPostingDao(); 
    }
    
   // Student operations
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public Student getStudent(String id) {
        return studentDao.getStudent(id);
    }

    public ListInterface<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    // Job operations
    public void addJobPosting(JobPosting job) {
        jobPostingDao.addJobPosting(job);
    }

    public JobPosting getJobPosting(String id) {
        return jobPostingDao.getJobPosting(id);
    }

    public ListInterface<JobPosting> getAllJobPostings() {
        return jobPostingDao.getAllJobPostings();
    }
    

}

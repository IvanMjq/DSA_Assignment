/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ListInterface;
import boundary.*;
import entity.*;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class JobApplicationControl {
    Scanner scanner = new Scanner(System.in);
    
    private ListInterface<Student> studentList;
    private ListInterface<JobPosting> jobPostingList;
    private ListInterface<JobApplication> jobApplicationList;
    private JobApplicationUI jobApplicationUI;
    private StudentPortalControl studentPortalControl;
    
    public JobApplicationControl(ListInterface<Student> studentList, ListInterface<JobPosting> jobPostingList , StudentPortalControl studentPortalControl) { 
        this.studentList            = studentList;
        this.jobPostingList         = jobPostingList;
        this.studentPortalControl   = studentPortalControl;
    }

    public JobApplicationControl(ListInterface<Student> studentList, ListInterface<JobPosting> jobPostingList, JobApplicationUI jobApplicationUI) {
        this.studentList            = studentList;
        this.jobPostingList         = jobPostingList;
        this.jobApplicationUI       = jobApplicationUI;
        this.jobApplicationUI       = new JobApplicationUI(this);
        
    }

     public void adminJobApplicationManagement() {
        int option = 0;

        do {
            option = jobApplicationUI.adminStudentMenu();
            switch (option) {
                case 0:
                    System.out.println("Exiting Student Menu...");
                    break;
                case 1:
                    jobApplicationListing();
                    break;
                case 2:
//                    addStudent();
                    break;
                case 3:
//                    removeStudent();
                    break;
                case 4:
//                    updateStudent();
                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }
     
     public void jobApplicationListing() {
        jobApplicationUI.jobApplicationListingUI();
        if(studentList.size() > 0){
            
            for (JobApplication jobApplication : jobApplicationList) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-7s | %-30s | %-30s | %-30s | %-30s | %-30s | %-30s |\n",
                    jobApplication.getId(),
                    jobApplication.getJobPost().getCompany().getName(),
                    jobApplication.getJobPost().getJob().getTitle(),
                    jobApplication.getStudent().getName(),
                    jobApplication.getAppliedDateTime(),
                    jobApplication.getInterview().getInterviewStatus(),
                    jobApplication.getInterview().getScheduledDateTime()
                );
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    
    
}

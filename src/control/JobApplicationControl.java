/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ListInterface;
import boundary.*;
import entity.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class JobApplicationControl {
    Scanner scanner = new Scanner(System.in);
    
    private ListInterface<Company> companyList;
    private ListInterface<Student> studentList;
    private ListInterface<Skill> skillList;
    private ListInterface<Job> jobList;
    private ListInterface<Interview> interviewList;
    private JobApplicationUI jobApplicationUI;
    private StudentPortalControl studentPortalControl;
    private StudentControl studentControl;
    
    
    public JobApplicationControl(ListInterface<Company> companyList, ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<Job> jobList, ListInterface<Interview> interviewList ) {
        this.companyList                = companyList;
        this.studentList                = studentList;
        this.skillList                  = skillList;
        this.jobList                    = jobList;
        this.interviewList              = interviewList;
    }
    
    public JobApplicationControl(ListInterface<Company> companyList, ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<Job> jobList, ListInterface<Interview> interviewList , StudentPortalControl studentPortalControl, StudentControl studentControl) { 
        this.companyList                = companyList;
        this.studentList                = studentList;
        this.skillList                  = skillList;
        this.jobList                    = jobList;
        this.interviewList              = interviewList;
        this.studentPortalControl       = studentPortalControl;
        this.studentControl             = studentControl;
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
                    addJobApplication();
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

        if (studentList != null && studentList.size() > 0) {
            for (int i = 1; i <= studentList.size(); i++) {
                Student student = studentList.getData(i);
                if (student == null || student.getJobApplicationList() == null) continue;

                for (int j = 1; j <= student.getJobApplicationList().size(); j++) {
                    JobApplication ja = student.getJobApplicationList().getData(j);
                    if (ja == null) continue;

                    Student stu = ja.getStudent();
                    JobPosting jp = ja.getJobPosting();
                    Interview interview = ja.getInterview();

                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("| %-10s | %-30s | %-30s | %-30s | %-30s | %-30s | %-30s |\n",
                            stu != null ? stu.getId() : "NULL",
                            stu != null ? stu.getName() : "NULL",
                            jp != null ? jp.getCompany().getName() : "NULL",
                            (jp != null && jp.getJob() != null) ? jp.getJob().getTitle() : "NULL",
                            ja.getAppliedDateTime() != null ? ja.getAppliedDateTime() : "NULL",
                            interview != null ? interview.getInterviewStatus() : "NULL",
                            interview != null ? interview.getScheduledDateTime() : "NULL"
                    );
                }
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("No student data available.");
        }
    }

    public void addJobApplication() {
        jobApplicationUI.addJobAppicationUI();
        
        Student selectedStudent  = null;
        while(selectedStudent == null){
            System.out.print("Enter Student ID, (X=Show list): ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("X")) {
                studentControl.studentListing();
            } 
            
            if(studentControl.findStudent(input) != 0) {
                selectedStudent = studentList.getData(studentControl.findStudent(input));
            } else {
                System.out.println("Invalid Student.");
            }
        }
        
        JobPosting selectedJobPosting  = null;
        while(selectedJobPosting == null){
            System.out.print("Enter of Company ID, (X=Show list): ");
            String companyInput = scanner.nextLine().trim();
            
            if (companyInput.equalsIgnoreCase("X")) {
                jobPostingList();
            } 
            
            System.out.print("Enter of Job ID: ");
            String jobInput = scanner.nextLine().trim();
            
            System.out.print("Enter of Date Posted (yyy-mm-dd): ");
            String dateInput = scanner.nextLine().trim();
            
            JobPosting tempJobPost = findJobPost(companyInput, jobInput, dateInput);
            if(tempJobPost != null) {
                selectedJobPosting = tempJobPost;
            } else {
                System.out.println("Invalid Job Post.");
            }
        }
        
        JobApplication newApplication = new JobApplication(selectedStudent, selectedJobPosting, null, LocalDateTime.now());
        Interview newInterview = new Interview("id", null, Interview.InterviewStatus.APPLIED, 0);

        boolean isConfirm = jobApplicationUI.confirmation("Confirm Apply " + newApplication.getJobPosting().getJob().getTitle()+ "?");
        
        if (isConfirm) {
            studentList.getData(studentList.indexOf(selectedStudent)).getJobApplicationList().add(newApplication);
            interviewList.add(newInterview);
            studentList.getData(studentList.indexOf(selectedStudent)).getJobApplicationList().getLastData().setInterview(newInterview);
            interviewList.getLastData().getJobApplicationList().add(studentList.getData(studentList.indexOf(selectedStudent)).getJobApplicationList().getLastData());
            addToCompanySide(newApplication, selectedJobPosting);
            System.out.println("Job Apply successfully!");
        } else {
            System.out.println("Failed to Apply Job .");
        }
    }
    
    public void addToCompanySide(JobApplication newApplicationn, JobPosting jobPost) {
        for(int i = 1; i <= companyList.size(); i++) {
            int index = companyList.getData(i).getJobPostingList().indexOf(jobPost);
            if(index != -1){
                companyList.getData(i).getJobPostingList().getData(index).getJobApplicationList().add(newApplicationn);
                break;
            }
                
        }
    }
    
    public void jobPostingList() {
        for (int i = 1; i <= companyList.size(); i++) {
            Company company = companyList.getData(i);
            if (company.getJobPostingList() == null || company.getJobPostingList().size() == 0) 
                continue;

            for (int j = 1; j <= company.getJobPostingList().size(); j++) {
                JobPosting jp = company.getJobPostingList().getData(j);

                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-15s | %-30s | %-15s | %-30s | %-50s | %-15.2f | %-15.2f | %-15d | %-15s |\n",
                        jp.getCompany().getId(),
                        jp.getCompany().getName(),
                        jp.getJob().getId(),
                        jp.getJob().getTitle(),
                        jp.getDescription(),
                        jp.getMaximumSalary(),
                        jp.getMaximumSalary(),
                        jp.getRequiredExperience(),
                        jp.getDatePosted()
                    
                );
            }
        }
    }
    
    public JobPosting findJobPost(String companyInput, String jobInput, String dateInput) {
        JobPosting foundJobPost = null;
        LocalDate datePosted = null;

        try {
            datePosted = LocalDate.parse(dateInput); 
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return null;
        }

        for (int i = 1; i <= companyList.size(); i++) {
            Company company = companyList.getData(i);
            if (company.getJobPostingList() == null || company.getJobPostingList().size() == 0) continue;

            for (int j = 1; j <= company.getJobPostingList().size(); j++) {
                JobPosting jp = company.getJobPostingList().getData(j);
                if (jp.getCompany().getId().equalsIgnoreCase(companyInput) &&
                    jp.getJob().getId().equalsIgnoreCase(jobInput) &&
                    jp.getDatePosted().equals(datePosted)) {

                    return jp; 
                }
            }
        }

        return null; 
    }
}

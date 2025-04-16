/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
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
    
    private ListInterface<Company> companyList      = new DoublyLinkedList<>();;
    private ListInterface<Student> studentList      = new DoublyLinkedList<>();;
    private ListInterface<Skill> skillList          = new DoublyLinkedList<>();;
    private ListInterface<Job> jobList              = new DoublyLinkedList<>();;
    private ListInterface<Interview> interviewList  = new DoublyLinkedList<>();;
    private JobApplicationUI jobApplicationUI;
    private StudentPortalControl studentPortalControl;
    private StudentControl studentControl;
    private AdminPortalControl adminPortalControl;
     private MatchingEngineControl matchControl;
   

    public JobApplicationControl(ListInterface<Company> companyList,ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<Job> jobList,ListInterface<Interview> interviewList) {
        this.companyList                    = companyList;
        this.studentList                    = studentList;
        this.skillList                      = skillList;
        this.jobList                        = jobList;
        this.interviewList                  = interviewList;
        this.jobApplicationUI               = new JobApplicationUI(this);
        this.matchControl                   = new MatchingEngineControl(companyList, studentList);
    }

    public void setAdminPortalControl(AdminPortalControl adminPortalControl) {
        this.adminPortalControl = adminPortalControl;
    }
    
    public void setStudentPortalControl(StudentPortalControl studentPortalControl) {
        this.studentPortalControl = studentPortalControl;
    }
    
    public void setStudentControl(StudentControl studentControl) {
        this.studentControl = studentControl;
    }

     public void adminJobApplicationManagement() {
        int option = 0;

        do {
            option = jobApplicationUI.adminStudentMenu();
            switch (option) {
                case 0:
                    System.out.println("Exiting Job Application Menu...");
                    break;
                case 1:
                    jobApplicationListing();
                    break;
                case 2:
                    addJobApplication();
                    break;
                case 3:
                    removeJobApplication();
                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }
     
    public void studentJobApplicationManagement() {
        int option = 0;

        do {
            option = jobApplicationUI.studentStudentMenu();
            switch (option) {
                case 0:
                    System.out.println("Exiting Job Application Menu...");
                    break;
                case 1:
                    personalJobApplicationListing(studentPortalControl.getLoginStudent());
                    break;
                case 2:
                    studentAddJobApplication();
                    break;
                case 3:
                    removeOwnJobApplication();
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
                    System.out.printf("| %-15s | %-30s | %-15s | %-30s | %-15s | %-30s | %-30s | %-30s | %-30s |\n",
                            stu != null ? stu.getId() : "NULL",
                            stu != null ? stu.getName() : "NULL",
                            jp != null ? jp.getCompany().getId(): "NULL",
                            jp != null ? jp.getCompany().getName() : "NULL",
                            (jp != null && jp.getJob() != null) ? jp.getJob().getId(): "NULL",
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
            } else if (!input.equalsIgnoreCase("X")){
                System.out.println("Invalid Student.");
            }
        }
        
        JobPosting selectedJobPosting  = null;
        while(selectedJobPosting == null){
            System.out.print("Enter of Company ID, (X=Show list), , (F=Filter By Desire Job): ");
            String companyInput = scanner.nextLine().trim();
            
            if (companyInput.equalsIgnoreCase("X")) {
                jobPostingListing();
            } 
            
            if (companyInput.equalsIgnoreCase("F")) {
                filterByJobDesired(selectedStudent);
            } 
            
            if(!companyInput.equalsIgnoreCase("X") && !companyInput.equalsIgnoreCase("F") ) {
                System.out.print("Enter of Job ID: ");
                String jobInput = scanner.nextLine().trim();
            
                System.out.print("Enter of Date Posted (yyyy-mm-dd): ");
                String dateInput = scanner.nextLine().trim();
            
                JobPosting tempJobPost = findJobPost(companyInput, jobInput, dateInput);
                if(tempJobPost != null) {
                    selectedJobPosting = tempJobPost;
                } else {
                    System.out.println("Invalid Job Post.");
                }   
            }            
        }
        
        JobApplication newApplication = new JobApplication(selectedStudent, selectedJobPosting, null, LocalDate.now());
        Interview newInterview = new Interview(generateInterviewID(), null, Interview.InterviewStatus.APPLIED, 0);

        boolean isConfirm = jobApplicationUI.confirmation("Confirm Apply " + newApplication.getJobPosting().getJob().getTitle()+ " of " + newApplication.getJobPosting().getCompany().getName() + " company ?");
        
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
    
    public void jobPostingListing() {
        for (int i = 1; i <= companyList.size(); i++) {
            Company company = companyList.getData(i);
            if (company.getJobPostingList() == null || company.getJobPostingList().size() == 0) 
                continue;

            for (int j = 1; j <= company.getJobPostingList().size(); j++) {
                JobPosting jp = company.getJobPostingList().getData(j);

                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-15s | %-30s | %-15s | %-30s | %-100s | %-15.2f | %-15.2f | %-15d | %-15s |\n",
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
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
    
    public void studentAddJobApplication() {
        jobApplicationUI.addJobAppicationUI();
        
        JobPosting selectedJobPosting  = null;
        while(selectedJobPosting == null){
            System.out.print("Enter of Company ID, (X=Show list), , (F=Filter): ");
            String companyInput = scanner.nextLine().trim();
            
            if (companyInput.equalsIgnoreCase("X")) {
                jobPostingListing();
            } 
            
            if (companyInput.equalsIgnoreCase("F")) {
                filterByJobDesired(studentPortalControl.getLoginStudent());
            } 
            
            if(!companyInput.equalsIgnoreCase("X") && !companyInput.equalsIgnoreCase("F") ) {
                System.out.print("Enter of Job ID: ");
                String jobInput = scanner.nextLine().trim();
            
                System.out.print("Enter of Date Posted (yyyy-mm-dd): ");
                String dateInput = scanner.nextLine().trim();
            
                JobPosting tempJobPost = findJobPost(companyInput, jobInput, dateInput);
                if(tempJobPost != null) {
                    selectedJobPosting = tempJobPost;
                } else {
                    System.out.println("Invalid Job Post.");
                }   
            }            
        }
        
        
        JobApplication newApplication = new JobApplication(studentPortalControl.getLoginStudent(), selectedJobPosting, null, LocalDate.now());
        Interview newInterview = new Interview(generateInterviewID(), null, Interview.InterviewStatus.APPLIED, 0);

        boolean isConfirm = jobApplicationUI.confirmation("Confirm Apply " + newApplication.getJobPosting().getJob().getTitle()+ " of " + newApplication.getJobPosting().getCompany().getName() + " company ?");
        
        if (isConfirm) {
            studentList.getData(studentList.indexOf(studentPortalControl.getLoginStudent())).getJobApplicationList().add(newApplication);
            interviewList.add(newInterview);
            studentList.getData(studentList.indexOf(studentPortalControl.getLoginStudent())).getJobApplicationList().getLastData().setInterview(newInterview);
            interviewList.getLastData().getJobApplicationList().add(studentList.getData(studentList.indexOf(studentPortalControl.getLoginStudent())).getJobApplicationList().getLastData());
            addToCompanySide(newApplication, selectedJobPosting);
            System.out.println("Job Apply successfully!");
        } else {
            System.out.println("Failed to Apply Job .");
        }
    }
    
    
    public void removeJobApplication() {
        jobApplicationUI.removeJobAppicationUI();
        jobApplicationListing();

        int studentIndex = 0;
        int jobApplicationIndex = 0;
        while(studentIndex == 0 && jobApplicationIndex == 0){
            System.out.print("Enter Student ID, (Q=Quit): ");
            String studentInput = scanner.nextLine().trim();
            
            if (Character.toUpperCase(studentInput.charAt(0)) == 'Q') {
                jobApplicationIndex = -1;
                break;
            }
            
            System.out.print("Enter of Company ID: ");
            String companyInput = scanner.nextLine().trim();

            System.out.print("Enter of Job ID: ");
            String jobInput = scanner.nextLine().trim();
            
            System.out.print("Enter of Date Applied (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine().trim();
            
            jobApplicationIndex = findJobApplicationIndex(studentInput, companyInput, jobInput, dateInput);
            studentIndex = studentControl.findStudent(studentInput);
        }
        
        if(jobApplicationIndex != -1) {
            JobApplication oriData = studentList.getData(studentIndex).getJobApplicationList().getData(jobApplicationIndex);
       
            boolean isConfirm = jobApplicationUI.confirmation("Confirm " + oriData.getJobPosting().getJob().getTitle() + " from " + oriData.getStudent().getName());
              
            if (isConfirm) {
                removeCompanySide(studentList.getData(studentIndex));
                removeInterviewSide(studentList.getData(studentIndex));
                studentList.getData(studentIndex).getJobApplicationList().remove(jobApplicationIndex);
                System.out.println("Job Application remove successfully!");
                
            } else {
                System.out.println("Failed to Remove Job Application .");
            }
        }   
    }
    
     public void removeOwnJobApplication() {
        jobApplicationUI.removeJobAppicationUI();
        personalJobApplicationListing(studentPortalControl.getLoginStudent());
        
        int studentIndex = 0;
        int jobApplicationIndex = 0;
        if(studentPortalControl.getLoginStudent().getJobApplicationList().isEmpty()){
            jobApplicationIndex = -1;
        }
        
        while( jobApplicationIndex == 0){

            System.out.print("Enter of Company ID, (Q=Quit): ");
            String companyInput = scanner.nextLine().trim();

            if (Character.toUpperCase(companyInput.charAt(0)) == 'Q') {
                jobApplicationIndex = -1;
                break;
            }
                        
            System.out.print("Enter of Job ID: ");
            String jobInput = scanner.nextLine().trim();
            
            System.out.print("Enter of Date Applied (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine().trim();
            
            jobApplicationIndex = findJobApplicationIndex(studentPortalControl.getLoginStudent().getId(), companyInput, jobInput, dateInput);
            
            
            if(jobApplicationIndex == 0){
                System.out.println("Invalid input.");
            }
        }
        
        if(jobApplicationIndex != -1) {
            studentIndex = studentList.indexOf(studentPortalControl.getLoginStudent());
            JobApplication oriData = studentList.getData(studentIndex).getJobApplicationList().getData(jobApplicationIndex);
            boolean isConfirm = jobApplicationUI.confirmation("Confirm Remove " + oriData.getJobPosting().getJob().getTitle() + " from " + oriData.getStudent().getName());
              
            if (isConfirm) {
                removeCompanySide(studentPortalControl.getLoginStudent());
                removeInterviewSide(studentList.getData(studentIndex));
                studentList.getData(studentIndex).getJobApplicationList().remove(jobApplicationIndex);
                System.out.println("Job Application remove successfully!");
                
            } else {
                System.out.println("Failed to Remove Job Application .");
            }
        }   
    }
        
    public int findJobApplicationIndex(String studentInput, String companyInput, String jobInput, String dateInput) {
        LocalDate appliedDate = validateDateInput(dateInput); 
        if (appliedDate == null) return 0;

        for (int i = 1; i <= studentList.size(); i++) {
            Student s = studentList.getData(i);
            if (s.getId().equalsIgnoreCase(studentInput)) {
                int count = 1;
                for (int j = 1; j <= s.getJobApplicationList().size(); j++) {
                    JobApplication ja = s.getJobApplicationList().getData(j);
                    if (ja != null &&
                        ja.getJobPosting().getCompany().getId().equalsIgnoreCase(companyInput) &&
                        ja.getJobPosting().getJob().getId().equalsIgnoreCase(jobInput) &&
                        ja.getAppliedDateTime().equals(appliedDate)) {

                        return count;
                    }
                    count++;
                }
            }
        }

        return 0;
    }

    
    public LocalDate validateDateInput(String input) {
        String pattern = "^\\d{4}-\\d{2}-\\d{2}$";

        if (!input.matches(pattern)) {
            System.out.println("Format must be yyyy-MM-dd (e.g. 2024-04-16)");
            return null;
        }

        String[] parts = input.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        if (month < 1 || month > 12 || day < 1 || day > 31) {
            System.out.println("❌ Invalid date values.");
            return null;
        }

        try {
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            System.out.println("Invalid date: " + e.getMessage());
            return null;
        }
    }


    
    public void personalJobApplicationListing(Student oriData) {
        if (oriData.getJobApplicationList().isEmpty()) {
            System.out.println("No job applications found for this student.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-30s | %-15s | %-30s | %-15s | %-30s | %-30s | %-30s |\n",
                 "Student ID", "Student Name", "Company ID", "Company Name", "Job ID",
                "Job Title", "Applied Date Time", "Interview Info");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 1; i <= oriData.getJobApplicationList().size(); i++) {
            JobApplication ja = oriData.getJobApplicationList().getData(i);
            if (ja == null)
                continue;

            Student stu = ja.getStudent();
            JobPosting jp = ja.getJobPosting();
            Interview interview = ja.getInterview();

            System.out.printf("| %-15s | %-30s | %-15s | %-30s | %-15s | %-30s | %-30s | %-30s |\n",
                    stu != null ? stu.getId() : "NULL",
                    stu != null ? stu.getName() : "NULL",
                    jp != null ? jp.getCompany().getId() : "NULL",
                    jp != null ? jp.getCompany().getName() : "NULL",
                    (jp != null && jp.getJob() != null) ? jp.getJob().getId() : "NULL",
                    (jp != null && jp.getJob() != null) ? jp.getJob().getTitle() : "NULL",
                    ja.getAppliedDateTime() != null ? ja.getAppliedDateTime() : "NULL",
                    interview != null ? interview.getInterviewStatus() : "NULL"
            );
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    
    
    public void jobListing(){
        for(int i = 1; i <= jobList.size(); i++) {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-15s | %-30s | %-50s | %-300s |\n",
                        jobList.getData(i).getId(),
                        jobList.getData(i).getTitle(),
                        jobList.getData(i).getType(),
                        jobList.getData(i).getDesc()
                );
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public boolean digitValidation(String input) { 
        if (!input.matches("\\d+")) {
            System.out.println("Invalid input. Must be digits only.");
            return false;
        }
        return true;
    }
    
    public String generateInterviewID() {
        String id;
        if (interviewList.getLastData() != null) {
            id = interviewList.getLastData().getId();
            int num = Integer.parseInt(id.substring(4));
            return "itv-" + (num + 1);
        } else {
            return "itv-" + 1;
        }
    }
    
    public void removeCompanySide(Student input) {
        if (input == null || input.getJobApplicationList() == null) {
            System.out.println("Input student or their job application list is null.");
            return;
        }

        for (int i = 1; i <= companyList.size(); i++) {
            Company c = companyList.getData(i);
            if (c == null || c.getJobPostingList() == null) continue;

            for (int k = 1; k <= c.getJobPostingList().size(); k++) {
                JobPosting jp = c.getJobPostingList().getData(k);
                if (jp == null || jp.getJobApplicationList() == null) continue;

                for (int h = jp.getJobApplicationList().size(); h >= 1; h--) {
                    JobApplication ja = jp.getJobApplicationList().getData(h);
                    if (ja != null && input.getJobApplicationList().indexOf(ja) != -1) {
                        jp.getJobApplicationList().remove(h);
                    }
                }
            }
        }
    }

    public void removeInterviewSide(Student input) {
        for (int i = 1; i <= interviewList.size(); i++) {
            Interview interview = interviewList.getData(i);
            ListInterface<JobApplication> jobApps = interview.getJobApplicationList();

           
            for (int k = jobApps.size(); k >= 1; k--) {
                JobApplication ja = jobApps.getData(k);
                if (ja != null && input.getJobApplicationList().indexOf(ja) != -1) {
                    jobApps.remove(k);
                }
            }
        }
    }
    
    public void filterByJobDesired(Student selectedStudent) {
        String[] desiredJob = selectedStudent.getDesiredJobTypes();
        System.out.println(desiredJob[0]);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-30s | %-15s | %-30s | %-30s | %-100s | %-15s | %-15s | %-15s | %-15s |\n","Company ID", "Company Name", "Job ID", "Job Title", "Job Type","Description", "Max Salary", "Min Salary", "Experience", "Date Posted");
        for(int i = 0; i < desiredJob.length; i++) {
            for(int j = 1; j <= companyList.size(); j++) {
                Company c = companyList.getData(j);
                for(int k = 1; k <= c.getJobPostingList().size(); k++) {
                    JobPosting jp = c.getJobPostingList().getData(k);
//                    System.out.println(jp);
                    if (jp == null || jp.getJob() == null) continue;
                    
                    String jobType = jp.getJob().getType();
                    if (jobType != null && desiredJob[i] != null && jobType.trim().equalsIgnoreCase(desiredJob[i].trim())) {
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("| %-15s | %-30s | %-15s | %-30s | %-30s | %-100s | %-15.2f | %-15.2f | %-15d | %-15s |\n",
                            jp.getCompany().getId(),
                            jp.getCompany().getName(),
                            jp.getJob().getId(),
                            jp.getJob().getTitle(),
                            jp.getJob().getType(),
                            jp.getDescription(),
                            jp.getMaximumSalary(),
                            jp.getMaximumSalary(),
                            jp.getRequiredExperience(),
                            jp.getDatePosted()
                            );
                    }
                }
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}

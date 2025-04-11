/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.*;
import entity.*;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class JobPostingControl {
    Scanner scanner = new Scanner(System.in);
    private ListInterface<Job> jobList;
    private ListInterface<Company> companyList;
    private ListInterface<JobApplication> jobApplicationList;
    private ListInterface<JobPosting> jobPostingList;
    private ListInterface<JobRequirementSkill> skillList;
            
    private JobManagementUI jobManagementUI;

    public JobPostingControl() {
        
    }

    public JobPostingControl(ListInterface<Job> jobList, ListInterface<Company> companyList, ListInterface<JobApplication> jobApplicationList, ListInterface<JobPosting> jobPostingList, ListInterface<JobRequirementSkill> skillList) {
        this.jobList            = jobList;
        this.companyList        = companyList;
        this.jobApplicationList = jobApplicationList;
        this.jobPostingList     = jobPostingList;
        this.skillList          = skillList;
        this.jobManagementUI    = new JobManagementUI(this); 
    }
    
    public void runJobPostingManagement() {
        int option = 0;

        do {
            option = jobManagementUI.jobPostingManagementMenu();
            System.out.println(option);
            switch (option) {
                case 0:
                    System.out.println("Exiting Donee Management...");
                    break;
                case 1:
                    addJobPost();
                    break;
                case 2:
                    updateJobPost();
                    break;
                case 3:
                    removeJobPost();
                    break;
//                case 4:
//                    filterJobListing();
//                    break;
                case 5:
                    jobPostListing();
                    break;
//                case 6:
//                    
//                    break;
//                case 7:
//                    
//                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }
    
    public void jobPostListing() {
        jobManagementUI.jobPostListingUI();
        if(jobPostingList.size() > 0){
            
            for (JobPosting jobPost : jobPostingList) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-5s | ID:%-5s Name:%-30s | ID:%-5s Name:%-30s | %-100s | %-15s | %-10s | %-90s |\n",
                    jobPost.getId(),
                    jobPost.getCompany().getId(),
                    jobPost.getCompany().getName(),
                    jobPost.getJob().getId(),
                    jobPost.getJob().getTitle(),
                    jobPost.getDescription(),
                    jobPost.getSalaryRange(),
                    jobPost.getDatePosted(),
                    displaySkill(jobPost.getSkillRequired())
                );
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    
    public void addJobPost() {
        jobManagementUI.addJobPostUI();
        JobPosting newJobPost = jobManagementUI.newJobPostDetails();
        boolean isConfirm = jobManagementUI.confirmation("Confirm add " + newJobPost.getId() + " as new Job Post?");
        
        if (isConfirm) {
            jobPostingList.add(newJobPost);
            jobPostListing();
            System.out.println("Job posting added successfully!");
        } else {
            System.out.println("Failed to add job posting.");
        }
    } 
    
    public void updateJobPost() {
        jobManagementUI.updateJobPostUI();
        jobPostListing();
        int jobPostingPosition = 0;
        do{
            System.out.print("Enter ID, (Q=Quit): ");
            String selectedPost = scanner.nextLine().trim();
            jobPostingPosition = findJobPosting(selectedPost);
            
            if(Character.toUpperCase(selectedPost.charAt(0)) == 'Q'){
                jobPostingPosition = -1;
            }
            
            if(jobPostingPosition == 0){
                System.out.println("ID Not Found");
            }
        }while(jobPostingPosition == 0);
        
        if(jobPostingPosition != -1){
            JobPosting oriData = jobPostingList.getData(jobPostingPosition);
            System.out.println(oriData);
            boolean isConfirm = jobManagementUI.confirmation("Confirm " + oriData.getId() +  " as Edit Job Post?");
            
            if(isConfirm){
                JobPosting updateJobPost = jobManagementUI.newJobPostDetails();
                updateJobPost.setId(oriData.getId());
                jobPostingList.replace(jobPostingPosition, updateJobPost);
                jobPostListing();
                System.out.println("Job posting update successfully!");
            }else {
                System.out.println("Failed to update job posting.");
            }
        }
    } 
    
    public void removeJobPost() {
        jobManagementUI.removeJobPostUI();
        jobPostListing();
        
        int jobPostingPosition = 0;
        do{
            System.out.print("Enter ID, (Q=Quit): ");
            String selectedPost = scanner.nextLine().trim();
            jobPostingPosition = findJobPosting(selectedPost);
            
            if(Character.toUpperCase(selectedPost.charAt(0)) == 'Q'){
                jobPostingPosition = -1;
            }
            
            if(jobPostingPosition == 0){
                System.out.println("ID Not Found");
            }
        }while(jobPostingPosition == 0);
        
         if(jobPostingPosition != -1){
            JobPosting oriData = jobPostingList.getData(jobPostingPosition);
            System.out.println(oriData);
            boolean isConfirm = jobManagementUI.confirmation("Confirm " + oriData.getId() + " as remove Job Post?");
            
            if(isConfirm){
                jobPostingList.remove(jobPostingPosition);
                jobPostListing();
                System.out.println("Job posting remove successfully!");
            }else {
                System.out.println("Failed to remove job posting.");
            }
        }
    }
    
    public void filterJobListing(){
        
    }
    
    public int findJobPosting(String input) {
        int count   = 1;
        int noFound = 0;
        for (int i = 1; i <= jobPostingList.size(); i++) {
            if (jobPostingList.getData(i).getId().equalsIgnoreCase(input)) {
                return count;
            }
            count++;
        }
        return noFound;
    }
    
    public String displaySkill(ListInterface<JobRequirementSkill> skillList) {
        StringBuilder skillsStr = new StringBuilder();
    
        for (int i = 1; i <= skillList.size(); i++) {
            skillsStr.append(skillList.getData(i)).append(", ");
        }
    
        if (skillsStr.length() > 0) {
            skillsStr.setLength(skillsStr.length() - 2); 
        }
    
        return skillsStr.toString();
    }
    
    public void companyList() {
        for (Company company : companyList) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-5s | %-40s | %-20s | %-35s | %-40s | %-10s |\n",
                 company.getId(),
                 company.getName(),
                 company.getPhone(),
                 company.getEmail(),
                 company.getAddress(),
                 company.getFoundedYear()); 
        }
    }
        
    public void jobList() {
        for (Job job : (DoublyLinkedList<Job>) jobList) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-5s | %-40s | %-60s |\n",
                job.getId(),
                job.getTitle(),
                job.getDesc());
        }
    }
    
    public void skillList() {
        for (Skill skill : (DoublyLinkedList<JobRequirementSkill>) skillList) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-5s | %-40s |\n",
                    skill.getId(),
                    skill.getName());
        }
    }
    
    public Company isCompanyExist(String info) {
        Company company = null;
        
        for(int i = 1; i <= companyList.size(); i++) {
            if (info.equalsIgnoreCase(companyList.getData(i).getId())){
                company = companyList.getData(i);
                break;
            }
            
            if (info.equalsIgnoreCase(companyList.getData(i).getName())){
                company = companyList.getData(i);
                break;
            }
        }
        return company;
    }
    
    public Job isJobExist(String info) {
        Job job = null;
        
        for(int i = 1; i <= jobList.size(); i++) {
            if (info.equalsIgnoreCase(jobList.getData(i).getId())){
                job = jobList.getData(i);
                break;
            }
            
            if (info.equalsIgnoreCase(jobList.getData(i).getTitle())){
                job = jobList.getData(i);
                break;
            }
        }
        return job;
    }
    
    public JobRequirementSkill isSkillExist(String info) {
        JobRequirementSkill skill = null;
        
        for(int i = 1; i <= skillList.size(); i++) {
            if (info.equalsIgnoreCase(skillList.getData(i).getId())){
                skill = skillList.getData(i);
                break;
            }
            
            if (info.equalsIgnoreCase(skillList.getData(i).getName())){
                skill = skillList.getData(i);
                break;
            }
        }
        return skill;
    }
        
    public String generateJobPostID() {
        if(jobPostingList.size() != 0){
            return "JP-" + (getMax() + 1);
        }else{
            return "JP-" + 1;
        }
        
    }
    
    public int getMax() {
        int max = 0;
        
        for (int i = 1; i <= jobPostingList.size(); i++) {
            JobPosting jp = jobPostingList.getData(i);
            String id = jp.getId(); 

            int num = Integer.parseInt(id.substring(3)); 
                if (num > max) {
                    max = num;
                 }
        }
        return max;
    }
      
}

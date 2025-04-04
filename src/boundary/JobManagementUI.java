/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.*;
import control.*;
import entity.*;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class JobManagementUI {
    Scanner scanner = new Scanner(System.in);
    private JobPostingControl jobPostingControl;
    
    public JobManagementUI(JobPostingControl control) {
        this.jobPostingControl = control;
    }

    public int jobPostingManagementMenu() {
        System.out.println("\nJob Posting Management MAIN MENU");
        System.out.println("=====================================");
        System.out.println("1. Add New Job");
        System.out.println("2. Update Job Details");
        System.out.println("3. Remove Job");
//        System.out.println("4. Search Job Details");
        System.out.println("5. List All Job Post List");
//        System.out.println("6. Filter Job Type");
//        System.out.println("7. Generate Job Reports");
        System.out.println("0. Exit");
        System.out.print("Enter option: ");

        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }
    
    public void jobPostListingUI() {
        System.out.println("--------------------------------------");
        System.out.println("Job Post Listing");
    }
    
    public void addJobPostUI(){
        System.out.println("--------------------------------------");
        System.out.println("Add New Job Post");
        System.out.println("--------------------------------------");
        System.out.println("Enter Job Infomation:");
        System.out.println("======================================");
    }
    
    public JobPosting newJobPostDetails() {
        Company companySelected = null;
        while(companySelected == null) {
            System.out.print("Company ID/Name, (X=Show list): ");
            String input = scanner.nextLine().trim();
            
            if(Character.toUpperCase(input.charAt(0)) == 'X') {
                compannyList();
            }
            
            companySelected = jobPostingControl.isCompanyExist(input);
            
            if( (companySelected == null) && (Character.toUpperCase(input.charAt(0)) != 'X'))
                System.out.println("Company Not Found");
         
        }
      
        Job jobSelected = null;
        while(jobSelected == null) {
            System.out.print("Job ID/Name, (X=Show list): ");
            String input = scanner.nextLine().trim();
            
            if(Character.toUpperCase(input.charAt(0)) == 'X') {
                jobList();
            }
            
            jobSelected = jobPostingControl.isJobExist(input);
            
            if((jobSelected == null) && (Character.toUpperCase(input.charAt(0)) != 'X')){
                 System.out.println("Job Not Found");
            } 
        }

        System.out.print("description: ");
        String description = scanner.nextLine();
        
        String salaryRange = null;
        while (salaryRange == null) {
            System.out.print("Enter salary range (format: xxxx.xx-yyyy.yy): ");
            String input = scanner.nextLine().trim();
    
            if (salaryValidation(input)) {
                salaryRange = input; 
            } else {
                System.out.println("Invalid salary range format. Please use: xxxx.xx-yyyy.yy (e.g. 3500.00-5000.00)");
            }
        }
        

        //testing
        int requiredExperience = 0;
        while (requiredExperience <= 0) {
            System.out.print("Enter required experience (years): ");
            int input = scanner.nextInt();
    
            if (input >= 1) {
                requiredExperience = input; 
            } else {
                System.out.println("Invalid required experience. Please use digit (e.g. 1)");
            }
        }
        
        LocalDate datePosted = null;
        while (datePosted == null) {
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            try {
                datePosted = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            }
        }
        
        JobSkillRequirement[] skillArray = new JobSkillRequirement[5];
        
        boolean loop = true;
        
        int i = 0;
        while(loop) {
            boolean duplicateInput = false;
            System.out.print("Require Skill(ID/Name), (X=Show List, (Q/q)=Quit): ");
            String input = scanner.nextLine().trim();
            
            if ((i > 0) && (Character.toUpperCase(input.charAt(0)) == 'Q'))  {
                loop = false;
            }
            
            if((Character.toUpperCase(input.charAt(0)) == 'X')) {
                skillList();
                
            } 
            
            JobSkillRequirement skillInput = jobPostingControl.isSkillExist(input);
            
            if (skillInput != null) {
                for (int j = 0; j < i; j++) {
                    if (skillArray[j].equals(skillInput)) {
                        duplicateInput = true;
                        break;
                    }
                }
                
                if(!duplicateInput){
                    if(i == skillArray.length - 1)
                        skillArray = doubleArray(skillArray);
                    
                    skillArray [i] = skillInput;
                    System.out.println("Skill Selected: " + displaySkillSelected(skillArray));
                    i++;
                        
                }else{
                    System.out.println("Skill Have Selected");
                }

            } else if((Character.toUpperCase(input.charAt(0)) != 'X') && (Character.toUpperCase(input.charAt(0)) != 'Q')){
                System.out.println("Skill Not Found");
            }
        }
       
        JobPosting jobPosting = new JobPosting(jobPostingControl.generateJobPostID(),companySelected, jobSelected, description, salaryRange, requiredExperience,datePosted,skillArray);
        
        return jobPosting;
    }
    
    public void updateJobPostUI() {
        System.out.println("--------------------------------------");
        System.out.println("Update Job Post");
    }
    
    public void removeJobPostUI() {
        System.out.println("--------------------------------------");
        System.out.println("Remove Job Post");
    }
    
    public boolean salaryValidation(String salaryRange) {
        return salaryRange.matches("^\\d+\\.\\d{2}-\\d+\\.\\d{2}$");
    }
    
    public String displaySkillSelected(Skill[] skillArray) {
        StringBuilder sb = new StringBuilder();
        for (Skill skill : skillArray) {
            if (skill != null) {
                sb.append(skill.getName()).append(", ");
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2); // Remove last ", "
        }
        return sb.toString();
    }
    
    public JobSkillRequirement[] doubleArray(JobSkillRequirement[] oldArray) {
        JobSkillRequirement[] newArray = new JobSkillRequirement[oldArray.length * 2];
        for (int j = 0; j < oldArray.length; j++) {
            newArray[j] = oldArray[j];
        }
        return newArray;
    }
    
    public void compannyList() {
        System.out.println("==========================================================================================================================================================================");
        System.out.printf("| %-5s | %-40s | %-20s | %-35s | %-40s | %-10s |\n",
                        "ID", "Name", "Contact", "Phone", "Email", "Address", "Founded Year");
        jobPostingControl.companyList();
        System.out.println("==========================================================================================================================================================================");
    }
    
    public void jobList() {
        System.out.println("==========================================================================================================================================================================");
        System.out.printf("| %-5s | %-40s | %-60s |\n",
                        "ID", "Title", "Description");
        jobPostingControl.jobList();
        System.out.println("==========================================================================================================================================================================");
    }
        
    public void skillList() {
        System.out.println("==========================================================================================================================================================================");
        System.out.printf("| %-5s | %-40s |\n",
                        "ID", "Name");
        jobPostingControl.skillList();
        System.out.println("==========================================================================================================================================================================");
    }
    
    public boolean confirmation(String message) {
        System.out.print(message + " (Y/N): ");
        char confirmation = scanner.nextLine().toUpperCase().charAt(0);
        return confirmation == 'Y';
    }
}

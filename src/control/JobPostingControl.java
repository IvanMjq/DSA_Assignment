/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.JobPostingManagementUI;
import dao.AllDataInitialize;
import entity.*;
import java.time.LocalDate;
import utility.JobPostingValidateFunction;

/**
 *
 * @author Ivanmjq
 */
public class JobPostingControl {

    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    private ListInterface<Job> jobList = new DoublyLinkedList<>();
    private ListInterface<Student> studentList = new DoublyLinkedList<>();
    private ListInterface<Interview> interviewList = new DoublyLinkedList<>();

    private ListInterface<Skill> skillList = new DoublyLinkedList<>();
    JobPostingManagementUI jobPostingManagementUI = new JobPostingManagementUI(skillList);
    JobControl jobControl;
    CompanyControl companyControl;

    public JobPostingControl(ListInterface<Company> companyList, ListInterface<Job> jobList, ListInterface<Student> studentList, ListInterface<Interview> interviewList, ListInterface<Skill> skillList) {
        this.companyList = companyList;
        this.jobList = jobList;
        this.studentList = studentList;
        this.interviewList = interviewList;
        this.skillList = skillList;
        
        jobControl = new JobControl(companyList, jobList, studentList, interviewList);
        companyControl = new CompanyControl(companyList, jobList, studentList, interviewList);
    }

    public void startJobPostingManagement() {
        int option;

        do {
            option = jobPostingManagementUI.jobPostingManagementMenu();

            switch (option) {
                case 1:
                    addJobPosting();
                    break;
                case 2:
                    viewJobPostingList();
                    break;
                case 3:
                    editJobPosting();
                    break;
                case 4:
                    deleteJobPosting();
                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("Returing to Main Menu ...");
                    break;
            }

        } while (option != 0);
    }

    public void addJobPosting() {
        Company company;
        Job job;
        String description;
        double mininumSalary;
        double maxinumSalary;
        int requiredExperience;
        LocalDate datePosted = LocalDate.now();
        
        String addConfirmation;
        
        System.out.println("\n--------------------");
        System.out.println(" Add Job Posting");
        System.out.println("--------------------");

        String exitString = "Type 0 or X to return to the previous menu.\n";

        do {
            companyControl.viewCompanyList();
            System.out.println(exitString);
            String id = jobPostingManagementUI.getStringInput("Enter Company ID : ");
            id = id.toUpperCase();

            if (id.equals("0") || id.equals("X")) {
                return;
            }

            company = JobPostingValidateFunction.isValidCompanyId(id, companyList);
        } while (company == null);

        do {
            jobControl.viewJobList();
            System.out.println(exitString);
            String id = jobPostingManagementUI.getStringInput("Enter Job ID : ");
            id = id.toUpperCase();

            if (id.equals("0") || id.equals("X")) {
                return;
            }

            job = JobPostingValidateFunction.isValidJobId(id, jobList);
        } while (job == null);

        do {
            description = jobPostingManagementUI.getStringInput("Enter Job Posting Description : ");
        } while (!JobPostingValidateFunction.isValidDescription(description));

        do {
            mininumSalary = jobPostingManagementUI.getDoubleInput("Enter Minimum Salary : ");
            maxinumSalary = jobPostingManagementUI.getDoubleInput("Enter Maximum Salary : ");
        } while (!JobPostingValidateFunction.isValidSalaryRange(mininumSalary, maxinumSalary));
        
        do {
            requiredExperience = jobPostingManagementUI.getIntegerInput("Enter Required Experience (Years) : ");
        } while (!JobPostingValidateFunction.isValidRequiredExperience(requiredExperience));
        
        do {
            addConfirmation = jobPostingManagementUI.getConfirmationPrompt("Do you want to add this Job Posting?");
        } while (!JobPostingValidateFunction.isValidConfirmation(addConfirmation));

        JobPosting newJobPosting = new JobPosting(company,
                job, description, 
                mininumSalary, 
                maxinumSalary, 
                requiredExperience,
                datePosted);
        
        company.getJobPostingList().add(newJobPosting);
        job.getJobPostingList().add(newJobPosting);
        
    }

    public void viewJobPostingList() {

    }

    public void editJobPosting() {

    }

    public void deleteJobPosting() {

    }

    public static void main(String[] args) {
        AllDataInitialize dataInitialize = new AllDataInitialize();

        ListInterface<Company> companyList = dataInitialize.getCompanyList();
        ListInterface<Job> jobList = dataInitialize.getJobList();
        ListInterface<Student> studentList = dataInitialize.getStudentList();
        ListInterface<Interview> interviewList = dataInitialize.getInterviewList();
        ListInterface<Skill> skillList = dataInitialize.getSkillList();

        JobPostingControl jobPostingControl = new JobPostingControl(companyList, jobList, studentList, interviewList, skillList);

        jobPostingControl.startJobPostingManagement();
    }

}

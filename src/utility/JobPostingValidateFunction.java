/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import adt.ListInterface;
import entity.Company;
import entity.Job;
import entity.JobPosting;

/**
 *
 * @author Ivanmjq
 */
public class JobPostingValidateFunction {

    public static Company isValidCompanyId(String id, ListInterface<Company> companyList) {
        String prefixPattern = "C-\\d+";

        if (id == null || id.trim().isEmpty()) {
            System.err.flush();
            System.err.println("ID cannot be null or empty.");
            System.err.flush();
            return null;
        }

        if (!id.matches(prefixPattern)) {
            System.err.flush();
            System.err.println("Invalid ID format. ID should follow the format 'C-<number>' (e.g. C-1, C-2).");
            System.err.flush();
            return null;
        }

        for (Company c : companyList) {
            if (c.getId().equals(id.trim())) {
                return c;
            }
        }

        System.err.flush();
        System.err.println("No company found with ID: " + id);
        System.err.flush();
        return null;
    }

    public static Job isValidJobId(String id, ListInterface<Job> jobList) {
        String prefixPattern = "J-\\d+";

        if (id == null || id.isEmpty()) {
            System.err.flush();
            System.err.println("ID cannot be null or empty.");
            System.err.flush();
            return null;
        }

        if (!id.matches(prefixPattern)) {
            System.err.flush();
            System.err.println("Invalid ID format. ID should follow the format 'J-<number>' (e.g. J-1, J-2).");
            System.err.flush();
            return null;
        }

        for (Job j : jobList) {
            if (j.getId().equals(id)) {
                return j;
            }
        }

        System.err.flush();
        System.err.println("No Job found with ID: " + id);
        System.err.flush();
        return null;
    }

    public static boolean isJobPostingExist(Company company, Job job) {
        ListInterface<JobPosting> jpList = company.getJobPostingList();
        
        for (JobPosting jp : jpList) {
            if (jp.getJob().equals(job)) {
                System.out.println("A job posting for this company and job already exists.");
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean isValidDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.out.println("Description cannot be null or empty.");
            return false;
        }

        int length = description.length();
        if (length < 10) {
            System.out.println("Invalid Job Posting Description. Descirption is too short. Minimum 10 characters long.");
            return false;
        }

        if (length > 500) {
            System.out.println("Invalid Job Posting Descirption. Description is too long. Maximum 500 characters allowed.");
            return false;
        }

        return true;
    }

    public static boolean isValidSalaryRange(double min, double max) {
        if (min < 0 || max < 0) {
            System.out.println("Salary values cannot be negative.");
            return false;

        }

        if (min >= max) {
            System.out.println("Minimum must be less than maximum.");
            return false;

        }

        return true;
    }

    public static boolean isValidRequiredExperience(int years) {
        if (years < 0) {
            System.out.println("Invaid Required Experience. Required experience cannot be negative.");
            return false;
        }

        if (years > 25) {
            System.out.println("That's an unusually high experience requirement. Please enter a value between 0 and 25.");
            return false;
        }

        return true;
    }

    public static boolean isValidConfirmation(String confirmation) {
        if (confirmation == null || confirmation.isEmpty()) {
            System.out.println("Confirmation Input cannot be null or empty.");
            return false;
        }

        if (confirmation.length() != 1) {
            System.out.println("Invalid input. Please enter a single character: 'Y' or 'N'.");
            return false;
        }

        if (!(confirmation.equals("Y")) && !confirmation.equals("N")) {
            System.out.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            return false;
        }

        return true;
    }

    public static JobPosting isValidJobPosting(Company companyFound, Job jobFound, ListInterface<Company> companyList) {
        for (Company c : companyList) {
            if (c.equals(companyFound)) {
                for (JobPosting jp : c.getJobPostingList()) {
                    if (jp.getJob().equals(jobFound)) {
                        return jp;
                    }
                }
            }
        }
        return null;
    }

}

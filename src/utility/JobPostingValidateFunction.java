/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import adt.ListInterface;
import entity.Company;
import entity.Job;

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

    public static boolean isValidDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.flush();
            System.err.println("Description cannot be null or empty.");
            System.err.flush();
            return false;
        }

        int length = description.length();
        if (length < 10) {
            System.err.flush();
            System.err.println("Invalid Job Posting Description. Descirption is too short. Minimum 10 characters long.");
            System.err.flush();
            return false;
        }

        if (length > 500) {
            System.err.flush();
            System.err.println("Invalid Job Posting Descirption. Description is too long. Maximum 500 characters allowed.");
            System.err.flush();
            return false;
        }

        return true;
    }

    public static boolean isValidSalaryRange(double min, double max) {
        if (min < 0 || max < 0) {
            System.err.flush();
            System.err.println("Salary values cannot be negative.");
            System.err.flush();
            return false;

        }

        if (min >= max) {
            System.err.flush();
            System.err.println("Minimum salary must be less than maximum salary.");
            System.err.flush();
            return false;

        }

        return true;
    }

    public static boolean isValidRequiredExperience(int years) {
        if (years < 0) {
            System.err.flush();
            System.err.println("Invaid Required Experience. Required experience cannot be negative.");
            System.err.flush();
            return false;
        }

        if (years > 25) {
            System.err.flush();
            System.err.println("That's an unusually high experience requirement. Please enter a value between 0 and 25.");
            System.err.flush();
            return false;
        }

        return true;
    }

    public static boolean isValidConfirmation(String confirmation) {
        if (confirmation == null || confirmation.isEmpty()) {
            System.err.flush();
            System.err.println("Confirmation Input cannot be null or empty.");
            System.err.flush();
            return false;
        }

        if (confirmation.length() != 1) {
            System.err.flush();
            System.err.println("Invalid input. Please enter a single character: 'Y' or 'N'.");
            System.err.flush();
            return false;
        }

        if (!(confirmation.equals("Y")) && !confirmation.equals("N")) {
            System.err.flush();
            System.err.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            System.err.flush();
            return false;
        }

        return true;
    }

}

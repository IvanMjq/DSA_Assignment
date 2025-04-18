/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import adt.ListInterface;
import entity.Job;

/**
 *
 * @author User
 */
public class JobValidateFunction {

    public static boolean isValidTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Job title cannot be null or empty.");
            return false;
        }

        if (!title.matches("^[A-Za-z\\s]{3,60}$")) {
            System.out.println("Invalid Job Title. Must be 3–60 characters and contain only letters and spaces.");
            return false;
        }

        return true;
    }

    public static boolean isValidDescription(String desc) {
        if (desc == null || desc.trim().isEmpty()) {
            System.out.println("Description cannot be null or empty.");
            return false;
        }

        int length = desc.length();
        if (length < 10) {
            System.out.println("Invalid Job Description. Descirption is too short. Minimum 10 characters long.");
            return false;
        }

        if (length > 500) {
            System.out.println("Invalid Job Descirption. Description is too long. Maximum 500 characters allowed.");
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

    public static Job isValidJobId(String id, ListInterface<Job> jobList) {
        String prefixPattern = "J-\\d+";

        if (id == null || id.isEmpty()) {
            System.out.println("ID cannot be null or empty.");
            return null;
        }

        if (!id.matches(prefixPattern)) {
            System.out.println("Invalid ID format. ID should follow the format 'J-<number>' (e.g. J-1, J-2).");
            return null;
        }

        for (Job j : jobList) {
            if (j.getId().equals(id)) {
                return j;
            }
        }

        System.out.println("No Job found with ID: " + id);
        return null;
    }

}

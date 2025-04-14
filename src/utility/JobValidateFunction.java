/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author User
 */
public class JobValidateFunction {

    public static boolean isValidTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Job title cannot be empty.");
            return false;
        }

        title = title.trim();

        if (title.length() > 60) {
            System.out.println("Job title must not exceed 60 characters.");
            return false;
        }

        // Check for only letters and spaces
        if (!title.matches("^[A-Za-z\\s]+$")) {
            System.out.println("Job title must contain only letters and spaces.");
            return false;
        }

        // Check word count
        String[] words = title.trim().split("\\s+");
        if (words.length < 3) {
            System.out.println("Job title must contain at least 3 words.");
            return false;
        }

        return true;
    }

}

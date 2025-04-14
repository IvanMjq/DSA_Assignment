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
            System.err.println("Job title cannot be empty.");
            System.err.flush();
            return false;
        }

        title = title.trim();

        if (title.length() > 60) {
            System.err.println("Invalid Job Title. Must not exceed 60 characters.");
            System.err.flush();
            return false;
        }

        // Check for only letters and spaces
        if (!title.matches("^[A-Za-z\\s]+$")) {
            System.err.println("Invalid Job Title. Must contain only letters and spaces.");
            System.err.flush();
            return false;
        }

        // Check word count
        String[] words = title.trim().split("\\s+");
        if (words.length < 3) {
            System.err.println("Invalid Job Title. Must contain at least 3 words.");
            System.err.flush();
            return false;
        }

        return true;
    }
    
    public static boolean isValidType(String type) {
        
        
        return true;
    }

}

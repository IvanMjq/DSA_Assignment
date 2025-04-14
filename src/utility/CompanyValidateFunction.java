/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import adt.ListInterface;
import entity.Company;
import java.time.LocalTime;
/**
 *
 * @author Ivanmjq
 */
public class CompanyValidateFunction {

    public static boolean isValidName(String name) {
        if (name == null || name.isEmpty()) {
            System.err.println("Company Name cannot be null or empty.");
            System.err.flush();
            return false;
        }
        if (!name.matches("^[a-zA-Z0-9\\s'.-]{3,50}$")) {
            System.err.println("Invalid Company Name. Must be 3–50 characters and contain only letters, numbers, spaces, ', ., or -.");
            System.err.flush();
            return false;
        }
        return true;
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            System.err.println("Phone Number cannot be null or empty.");
            System.err.flush();
            return false;
        }
        if (!phone.matches("^0\\d{1,2}-\\d{7,8}$")) {
            System.err.println("Invalid Phone Number. Format must be 0X-XXXXXXX or 0XX-XXXXXXXX.");
            System.err.flush();
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            System.err.println("Email Address cannot be null or empty.");
            System.err.flush();
            return false;
        }
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            System.err.println("Invalid Email Address. Please enter a valid format (e.g. example@mail.com).");
            System.err.flush();
            return false;
        }
        return true;
    }

    public static boolean isValidStreetAddress(String streetAddress) {
        if (streetAddress == null || streetAddress.isEmpty()) {
            System.err.println("Street Address cannot be null or empty.");
            System.err.flush();
            return false;
        }
        if (!streetAddress.matches("^[a-zA-Z0-9\\s,.-]{5,100}$")) {
            System.err.println("Invalid Street Address. Must be 5–100 characters with letters, numbers, spaces, commas, periods, or hyphens.");
            System.err.flush();
            return false;
        }
        return true;
    }

    public static boolean isValidArea(String area) {
        if (area == null || area.isEmpty()) {
            System.err.println("Area cannot be null or empty.");
            System.err.flush();
            return false;
        }
        if (!area.matches("^[a-zA-Z\\s]{2,50}$")) {
            System.err.println("Invalid Area. Only letters and spaces allowed, 2–50 characters.");
            System.err.flush();
            return false;
        }
        return true;
    }

    public static boolean isValidState(String state) {
        if (!state.matches("^[a-zA-Z\\s]{2,50}$")) {
            System.err.println("Invalid State. Only letters and spaces allowed, 2–50 characters.");
            System.err.flush();
            return false;
        }
        return true;
    }

    public static boolean isValidFoundedYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        if (year < 1800 || year > currentYear) {
            System.err.println("Invalid Founded Year. Must be between 1800 and " + currentYear + ".");
            System.err.flush();
            return false;
        }
        return true;
    }

    public static boolean isValidTimeRange(LocalTime startTime, LocalTime endTime) {
        if (!endTime.isAfter(startTime)) {
            System.err.println("End time must be later than start time.");
            System.err.flush();
            return false;
        }

        return true;
    }

    public static boolean isValidConfirmation(String confirmation) {
        if (confirmation == null || confirmation.isEmpty()) {
            System.err.println("Confirmation Input cannot be null or empty.");
            System.err.flush();
            return false;
        }

        if (confirmation.length() != 1) {
            System.err.println("Invalid input. Please enter a single character: 'Y' or 'N'.");
            System.err.flush();
            return false;
        }

        if (!(confirmation.equals("Y")) && !confirmation.equals("N")) {
            System.err.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            System.err.flush();
            return false;
        }

        return true;
    }
    
    public static Company isValidCompanyId(String id, ListInterface<Company> companyList) {
        String prefixPattern = "C-\\d+";

        if (id == null || id.trim().isEmpty()) {
            System.err.println("ID cannot be null or empty.");
            System.err.flush();
            return null;
        }

        if (!id.matches(prefixPattern)) {
            System.err.println("Invalid ID format. ID should follow the format 'C-<number>' (e.g. C-1, C-2).");
            System.err.flush();
            return null;
        }

        for (Company c : companyList) {
            if (c.getId().equals(id.trim())) {
                return c;
            }
        }

        System.err.println("No company found with ID: " + id);
        System.err.flush();
        return null;
    }

}

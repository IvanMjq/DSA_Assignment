/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author Ivanmjq
 */
public class ValidationFunction {
    
    public static boolean isValidName(String name) {
        return name != null && name.trim().matches("^[a-zA-Z0-9\\s'.-]{3,50}$"); // ' and - is accepted
    }
    
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.trim().matches("^0\\d{1,2}-\\d{7,8}$");
    }
    
    public static boolean isValidEmail(String email) {
        return email != null && email.trim().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    }
    
    public static boolean isValidStreetAddress(String streetAddress) {
        return streetAddress != null && streetAddress.trim().matches("^[a-zA-Z0-9\\s,.-]{5,100}$");
    }
    
    public static boolean isValidArea(String area) {
        return area != null && area.trim().matches("^[a-zA-Z\\s]{2,50}$");
    }
    
    public static boolean isValidState(String state) {
        return state != null && state.trim().matches("^[a-zA-Z\\s]{2,50}$");
    }
    
    public static boolean isValidFoundedYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        return year >= 1800 && year <= currentYear;
    }
    
}

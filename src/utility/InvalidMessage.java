/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author Ivanmjq
 */
public class InvalidMessage {

    public static void invalidName() {
        System.err.println("Invalid Company Name. It must be 3-50 characters long and contain only letters, numbers, spaces, apostrophes, periods, or hyphens.");
    }

    public static void invalidPhone() {
        System.err.println("Invalid Phone Number. It must follow the format: 0X-XXXXXXX or 0XX-XXXXXXXX.");
    }

    public static void invalidEmail() {
        System.err.println("Invalid Email Address. It must be in a valid email format like: name@example.com.");
    }

    public static void invalidStreetAddress() {
        System.err.println("Invalid Street Address. It must be 5-100 characters long and contain only letters, numbers, commas, periods, hyphens, and spaces.");
    }

    public static void invalidArea() {
        System.err.println("Invalid Area. It must be 2-50 characters long and contain only letters and spaces.");
    }

    public static void invalidState() {
        System.err.println("Invalid State. It must be 2-50 characters long and contain only letters and spaces.");
    }

    public static void invalidFoundedYear() {
        System.err.println("Invalid Founded Year. It must be between 1800 and the current year.");
    }

}

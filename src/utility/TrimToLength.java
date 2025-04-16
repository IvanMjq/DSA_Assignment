/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author User
 */
public class TrimToLength {
    
    public static String trimToLength(String str, int length) {
        if (str.length() > length) {
            return str.substring(0, length - 3) + "...";
        }
        return String.format("%-" + length + "s", str);
    }
    
}

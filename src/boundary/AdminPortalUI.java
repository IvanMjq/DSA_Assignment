/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import control.*;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class AdminPortalUI {
    Scanner scanner = new Scanner(System.in);
    
    private AdminPortalControl adminPortalControl;
     
    public AdminPortalUI(AdminPortalControl adminPortalControl) {
        this.adminPortalControl = adminPortalControl;
    }
    
    public int homePage() {
        System.out.println("\nAdmin Portal");
        System.out.println("=====================================");
        System.out.println("1. Company");
        System.out.println("2. Student");
        System.out.println("3. Job Appication");
        System.out.println("0. Exit");
        System.out.print("Enter option: ");

        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }
}

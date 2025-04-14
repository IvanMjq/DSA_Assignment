/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import control.*;
import entity.*;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class StudentPortalUI {
    Scanner scanner = new Scanner(System.in);
    private StudentPortalControl studentPortalControl;
     
    public StudentPortalUI(StudentPortalControl studentPortalControl) {
        this.studentPortalControl = studentPortalControl;
    }
     
    public int homePage() {
        System.out.println("\nStudent Portal");
        System.out.println("=====================================");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.print("Enter option: ");

        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }
    
    public int studentStudentMenu() {
        System.out.println("\nStudent Portal " + "{User Login: " + studentPortalControl.getLoginStudent().getId() + "}");
        System.out.println("=====================================");
        System.out.println("1. Listing");
        System.out.println("2. Update");
        System.out.println("3. Matching");
        System.out.println("0. Exit");
        System.out.print("Enter option: ");

        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }
     
    public void loginUI() {
        boolean loop = true;
        while(loop){
            System.out.print("Enter Student ID, (Q/q)=Quit): ");
            String inputID = scanner.nextLine().trim();
            
            if((Character.toUpperCase(inputID.charAt(0)) == 'Q')){
                System.out.println("Quitting login...");
                break;
            }
            
            System.out.print("Enter Password: ");
            String inputPassword = scanner.nextLine().trim();
            
            if(studentPortalControl.loginValidation(inputID, inputPassword)) {
                System.out.println("Login Successful, Welcome " + studentPortalControl.getLoginStudent().getName() + ".");
                loop = false;
            } else {
                System.out.println("Invalid Student ID / Password. Please try again");
            }
        } 
    }
    
    
    
    public void logoutUI() {
        if(studentPortalControl.isLogin()) {
            System.out.println("Logout Successful, See you " + studentPortalControl.getLoginStudent().getName() + ".");
        }else {
            System.out.println("Invalid Logout Request.");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.CompanyManagementUI;
import entity.Company;

/**
 *
 * @author ivanmjq
 */
public class CompanyControl {
    
    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    
    CompanyManagementUI companyManagementUI = new CompanyManagementUI();
    
    public CompanyControl() {
    }

    public CompanyControl(ListInterface<Company> companyList) {
        companyList = this.companyList;
    }
    
    public void startComanyManagement() {
        int option;
        
        do {            
            option = companyManagementUI.companyManagementMainMenu();
            
            switch (option) {
                case 1:
                    addCompany();
                    break;
                case 2:
                    viewCompany();
                    break;
                case 3:
                    editCompany();
                    break;
                case 4:
                    deleteCompany();
                    break;
                case 0:
                    System.out.println("Returing to Company Management Menu ...");
                    break;
            }
            
        } while (option != 0);
    }
    
    public void addCompany() {
        String id;
        String name;
        String phone;
        String email;
        String streetAddress;
        String area;
        String state;
        int foundedYear;
        
        System.out.println("\n--------------------");
        System.out.println("Add Company ");
        System.out.println("--------------------");
        
        do {            
            name = companyManagementUI.getName();
            if (!isValidName(name)) {
                companyManagementUI.inValidName();
            }
        } while (!isValidName(name));
        
    }
    
    public void viewCompany() {
    
    }
    
    public void editCompany() {
    
    }

    public void deleteCompany() {
    
    } 
    
    // Just for testing purpose
    public static void main(String[] args) {
        CompanyControl companyControl = new CompanyControl();
        companyControl.startComanyManagement();
    }
    
    public boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z0-9\\s]{3,50}$");
    }
    
    public boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^\\d{3}-\\d{7}$");
    }
    
    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
    
    public boolean isValidStreetAddress(String streetAddress) {
        return streetAddress != null && streetAddress.matches("^[a-zA-Z0-9\\s,.-]{5,100}$");
    }
    
    public boolean isValidArea(String area) {
        return area != null && area.matches("^[a-zA-Z\\s]{2,50}$");
    }
    
    public boolean isValidState(String state) {
        return state != null && state.matches("^[a-zA-Z\\s]{2,50}$");
    }
    
    public boolean isValidFoundedYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        return year >= 1800 && year <= currentYear;
    }
    
}

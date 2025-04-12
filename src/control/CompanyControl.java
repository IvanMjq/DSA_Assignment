/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.CompanyManagementUI;
import dao.AllDataInitialize;
import entity.Company;
import utility.*;

/**
 *
 * @author ivanmjq
 */
public class CompanyControl {
    
    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    
    CompanyManagementUI companyManagementUI = new CompanyManagementUI();
    
    public CompanyControl(ListInterface<Company> companyList) {
        this.companyList = companyList;
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
            if (!ValidationFunction.isValidName(name)) {
                InvalidMessage.invalidName();
            }
        } while (!ValidationFunction.isValidName(name));

        do {
            phone = companyManagementUI.getPhone();
            if (!ValidationFunction.isValidPhone(phone)) {
                InvalidMessage.invalidPhone();
            }
        } while (!ValidationFunction.isValidPhone(phone));

        do {
            email = companyManagementUI.getEmail();
            if (!ValidationFunction.isValidEmail(email)) {
                InvalidMessage.invalidEmail();
            }
        } while (!ValidationFunction.isValidEmail(email));

        do {
            streetAddress = companyManagementUI.getStreetAddress();
            if (!ValidationFunction.isValidStreetAddress(streetAddress)) {
                InvalidMessage.invalidStreetAddress();
            }
        } while (!ValidationFunction.isValidStreetAddress(streetAddress));

        do {
            area = companyManagementUI.getArea();
            if (!ValidationFunction.isValidArea(area)) {
                InvalidMessage.invalidArea();
            }
        } while (!ValidationFunction.isValidArea(area));

        do {
            state = companyManagementUI.getState();
            if (!ValidationFunction.isValidState(state)) {
                InvalidMessage.invalidState();
            }
        } while (!ValidationFunction.isValidState(state));

        do {
            foundedYear = companyManagementUI.getFoundedYear();
            if (!ValidationFunction.isValidFoundedYear(foundedYear)) {
                InvalidMessage.invalidFoundedYear();
            }
        } while (!ValidationFunction.isValidFoundedYear(foundedYear));

        id = IdGeneration.generateID(companyList, "C");
    }
    
    public void viewCompany() {
    
    }
    
    public void editCompany() {
    
    }

    public void deleteCompany() {
    
    } 
    
    // Just for testing purpose
    public static void main(String[] args) {
        AllDataInitialize dataInitialize = new AllDataInitialize();
        
        CompanyControl companyControl = new CompanyControl(dataInitialize.getCompanyList());
        companyControl.startComanyManagement();
    }
    
}

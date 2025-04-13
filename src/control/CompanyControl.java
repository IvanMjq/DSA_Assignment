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
import java.time.LocalTime;
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
            option = companyManagementUI.companyManagementMenu();

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
        double latitude = 0.0;
        double longitude = 0.0;
        int foundedYear;
        LocalTime interviewStartTime;
        LocalTime interviewEndTime;

        String addConfirmation;

        id = IdGeneration.generateID(companyList, "C");

        System.out.println("\n--------------------");
        System.out.println(" Add Company ");
        System.out.println("--------------------");

        do {
            name = companyManagementUI.getStringInput("Enter Company Name : ");
        } while (!ValidationFunction.isValidName(name));

        do {
            phone = companyManagementUI.getStringInput("Enter Phone Number (e.g. 03-12345678): ");
        } while (!ValidationFunction.isValidPhone(phone));

        do {
            email = companyManagementUI.getStringInput("Enter Email Address : ");
        } while (!ValidationFunction.isValidEmail(email));

        do {
            streetAddress = companyManagementUI.getStringInput("Enter Street Address : ");
        } while (!ValidationFunction.isValidStreetAddress(streetAddress));

        do {
            area = companyManagementUI.getStringInput("Enter Area : ");
        } while (!ValidationFunction.isValidArea(area));

        do {
            state = companyManagementUI.getStringInput("Enter State : ");
        } while (!ValidationFunction.isValidState(state));

        do {
            foundedYear = companyManagementUI.getIntegerInput("Enter Founded Year : ");
        } while (!ValidationFunction.isValidFoundedYear(foundedYear));

        do {
            interviewStartTime = companyManagementUI.getInterviewTimePrompt("Enter interview start time : ");
            interviewEndTime = companyManagementUI.getInterviewTimePrompt("Enter interview end time : ");
        } while (!ValidationFunction.isValidTimeRange(interviewStartTime, interviewEndTime));

        do {
            addConfirmation = companyManagementUI.getConfirmationPrompt("Do you want to add this company?");
        } while (!ValidationFunction.isValidConfirmation(addConfirmation));

        if (addConfirmation.equals("Y")) {

            Company newCompany = new Company(
                    id,
                    name,
                    phone,
                    email,
                    streetAddress,
                    area,
                    state,
                    latitude,
                    longitude,
                    foundedYear,
                    interviewStartTime,
                    interviewEndTime
            );
            companyList.add(newCompany);
            System.out.println("Company added successfully!");
            System.out.println("");
        } else {
            // Cancel the addition
            System.out.println("Company addition canceled.");
        }

    }

    public void viewCompany() {
        System.out.println("\n--------------------");
        System.out.println(" View Company List ");
        System.out.println("--------------------");

        System.out.println("*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
        System.out.printf("| %-5s | %-30s | %-14s | %-30s | %-50s | %-25s | %-17s | %-9s | %-9s | %-6s | %-6s | %-6s |\n",
                "ID", "Name", "Phone", "Email", "Street", "Area", "State",
                "Latitude", "Longitude", "Year", "Start", "End");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

        if (companyList.isEmpty()) {
            System.out.println("No companies found.");
        } else {
            for (Company c : companyList) {
                System.out.printf("| %-5s | %-30s | %-14s | %-30s | %-50s | %-25s | %-17s | %-9.4f | %-9.4f | %-6d | %-6s | %-6s |\n",
                        c.getId(),
                        c.getName(),
                        c.getPhone(),
                        c.getEmail(),
                        c.getStreetAddress(),
                        c.getArea(),
                        c.getState(),
                        c.getLatitude(),
                        c.getLongitude(),
                        c.getFoundedYear(),
                        c.getInterviewStartTime(),
                        c.getInterviewEndTime());
            }
        }
        System.out.println("*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*\n");

    }

    public void editCompany() {
        if (companyList.isEmpty()) {
            System.out.println("No companies available to edit.");
            return;
        }

        String id;
        Company companyFound = null;
        String confirmationToEdit1;
        boolean confirmationToEdit2;

        do {
            
            do {
                viewCompany();
                System.out.println("Type 0 or X to return to the previous menu.\n");
                id = companyManagementUI.getStringInput("Enter Company ID : ");
                id = id.toUpperCase();
                
                if (id.equals("0") || id.equals("X")) {
                    return;
                }
                
                companyFound = ValidationFunction.isValidCompanyId(id, companyList);
            } while (companyFound == null);

            System.out.println(companyFound);
            
            do {
                confirmationToEdit1 = companyManagementUI.getConfirmationPrompt("Do you want to edit this company?");
            } while (!ValidationFunction.isValidConfirmation(confirmationToEdit1));

        } while (confirmationToEdit1.equals("N"));
        
        int option;
        
        do {            
            option = companyManagementUI.companyEditMenu();
            
            
        } while (option != 0);

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

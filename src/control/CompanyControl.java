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
            name = companyManagementUI.getNamePrompt();
        } while (!ValidationFunction.isValidName(name));

        do {
            phone = companyManagementUI.getPhonePrompt();
        } while (!ValidationFunction.isValidPhone(phone));

        do {
            email = companyManagementUI.getEmailPrompt();
        } while (!ValidationFunction.isValidEmail(email));

        do {
            streetAddress = companyManagementUI.getStreetAddressPrompt();
        } while (!ValidationFunction.isValidStreetAddress(streetAddress));

        do {
            area = companyManagementUI.getAreaPrompt();
        } while (!ValidationFunction.isValidArea(area));

        do {
            state = companyManagementUI.getStatePrompt();
        } while (!ValidationFunction.isValidState(state));

        do {
            foundedYear = companyManagementUI.getFoundedYearPrompt();
        } while (!ValidationFunction.isValidFoundedYear(foundedYear));

        do {
            interviewStartTime = companyManagementUI.getInterviewTimePrompt("Enter interview start time");
            interviewEndTime = companyManagementUI.getInterviewTimePrompt("Enter interview end time");
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
        System.out.println(" Company List ");
        System.out.println("--------------------");
        
        if (companyList.isEmpty()) {
            System.out.println("No companies found.");
        } else {
            for (Company company : companyList) {
                System.out.println(company);
            }
        }
        System.out.println("\n");
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

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
import entity.Interview;
import entity.Job;
import entity.JobPosting;
import entity.Student;
import java.time.LocalTime;
import utility.*;

/**
 *
 * @author ivanmjq
 */
public class CompanyControl {

    private ListInterface<Company> companyList = new DoublyLinkedList<>();

    CompanyManagementUI companyManagementUI = new CompanyManagementUI();
    
    //JobPostingControl jobPostingControl = new JobPostingControl(companyList, jobList, studentList, interviewList, skillList);

    public CompanyControl(ListInterface<Company> companyList) {
        this.companyList = companyList;
    }

    public void startCompanyManagement() {
        int option;

        do {
            option = companyManagementUI.companyManagementMenu();

            switch (option) {
                case 1:
                    addCompany();
                    break;
                case 2:
                    viewAllCompanyList();
                    break;
                case 3:
                    editCompany();
                    break;
                case 4:
                    deleteCompany();
                    break;
                case 0:
                    System.out.println("Returing to Main Menu ...");
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
        } while (!CompanyValidateFunction.isValidName(name));

        do {
            phone = companyManagementUI.getStringInput("Enter Phone Number (e.g. 03-12345678): ");
        } while (!CompanyValidateFunction.isValidPhone(phone));

        do {
            email = companyManagementUI.getStringInput("Enter Email Address : ");
        } while (!CompanyValidateFunction.isValidEmail(email));

        do {
            streetAddress = companyManagementUI.getStringInput("Enter Street Address : ");
        } while (!CompanyValidateFunction.isValidStreetAddress(streetAddress));

        do {
            area = companyManagementUI.getStringInput("Enter Area : ");
        } while (!CompanyValidateFunction.isValidArea(area));

        do {
            state = companyManagementUI.getStringInput("Enter State : ");
        } while (!CompanyValidateFunction.isValidState(state));

        do {
            foundedYear = companyManagementUI.getIntegerInput("Enter Founded Year : ");
        } while (!CompanyValidateFunction.isValidFoundedYear(foundedYear));

        do {
            interviewStartTime = companyManagementUI.getInterviewTimePrompt("Enter Interview Start Time : ");
            interviewEndTime = companyManagementUI.getInterviewTimePrompt("Enter Interview End Time : ");
        } while (!CompanyValidateFunction.isValidTimeRange(interviewStartTime, interviewEndTime));

        do {
            addConfirmation = companyManagementUI.getConfirmationPrompt("Do you want to add this company?");
        } while (!CompanyValidateFunction.isValidConfirmation(addConfirmation));

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
            boolean isAdded = companyList.add(newCompany);
            if (isAdded) {
                System.out.println("Company added successfully!");
            } else {
                System.err.println("Failed to add company. Please try agian.");
                System.err.flush();
            }
        } else {
            // Cancel the addition
            System.out.println("Company addition canceled.");
        }

    }

    public void viewAllCompanyList() {
        String line = "+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+";
        System.out.println("\n--------------------");
        System.out.println(" View Companies List ");
        System.out.println("--------------------");

        System.out.println(line);
        System.out.printf("| %-5s | %-30s | %-14s | %-30s | %-50s | %-25s | %-17s | %-9s | %-9s | %-6s | %-6s | %-6s |\n",
                "ID", "Name", "Phone", "Email", "Street", "Area", "State",
                "Latitude", "Longitude", "Year", "Start", "End");
        System.out.println(line);

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
        System.out.println(line);

    }

    public void editCompany() {
        if (companyList.isEmpty()) {
            System.out.println("No Companies available to edit.");
            return;
        }

        String id;
        Company companyFound = null;
        String confirmationToEdit;

        do {
            do {
                viewAllCompanyList();
                System.out.println("Type 0 or X to return to the previous menu.\n");
                id = companyManagementUI.getStringInput("Enter Company ID : ");
                id = id.toUpperCase();

                if (id.equals("0") || id.equals("X")) {
                    return;
                }

                companyFound = CompanyValidateFunction.isValidCompanyId(id, companyList);
            } while (companyFound == null);

            System.out.println(companyFound);

            do {
                confirmationToEdit = companyManagementUI.getConfirmationPrompt("Do you want to edit this company?");
            } while (!CompanyValidateFunction.isValidConfirmation(confirmationToEdit));

        } while (confirmationToEdit.equals("N"));

        int option;

        do {
            option = companyManagementUI.companyEditMenu();

            switch (option) {
                case 1: // Name
                    String newName;
                    do {
                        newName = companyManagementUI.getStringInput("Enter New Company Name : ");
                    } while (!CompanyValidateFunction.isValidName(newName));
                    companyFound.setName(newName);
                    break;
                case 2: // Phone number
                    String newPhone;
                    do {
                        newPhone = companyManagementUI.getStringInput("Enter New Phone Number (e.g. 03-12345678): ");
                    } while (!CompanyValidateFunction.isValidPhone(newPhone));
                    companyFound.setPhone(newPhone);
                    break;
                case 3: // Email address
                    String newEmail;
                    do {
                        newEmail = companyManagementUI.getStringInput("Enter New Email Address : ");
                    } while (!CompanyValidateFunction.isValidEmail(newEmail));
                    companyFound.setEmail(newEmail);
                    break;
                case 4: // Street Address
                    String newStreet;
                    do {
                        newStreet = companyManagementUI.getStringInput("Enter New Street Address : ");
                    } while (!CompanyValidateFunction.isValidStreetAddress(newStreet));
                    companyFound.setStreetAddress(newStreet);
                    break;
                case 5: // Area
                    String newArea;
                    do {
                        newArea = companyManagementUI.getStringInput("Enter New Area : ");
                    } while (!CompanyValidateFunction.isValidArea(newArea));
                    companyFound.setArea(newArea);
                    break;
                case 6: // State
                    String newState;
                    do {
                        newState = companyManagementUI.getStringInput("Enter New State : ");
                    } while (!CompanyValidateFunction.isValidState(newState));
                    companyFound.setState(newState);
                    break;
                case 7: // Founded Year
                    int newFoundedYear;
                    do {
                        newFoundedYear = companyManagementUI.getIntegerInput("Enter New Founded Year : ");
                    } while (!CompanyValidateFunction.isValidFoundedYear(newFoundedYear));
                    companyFound.setFoundedYear(newFoundedYear);
                    break;
                case 8: // Interview Start and End Time
                    LocalTime newInterviewStartTime,
                     newInterviewEndTime;
                    do {
                        newInterviewStartTime = companyManagementUI.getInterviewTimePrompt("Enter New Interview Start Time : ");
                        newInterviewEndTime = companyManagementUI.getInterviewTimePrompt("Enter New Interview End Time : ");
                    } while (!CompanyValidateFunction.isValidTimeRange(newInterviewStartTime, newInterviewEndTime));
                    companyFound.setInterviewStartTime(newInterviewStartTime);
                    companyFound.setInterviewEndTime(newInterviewEndTime);
                    break;
                case 0:
                    System.out.println("Returning to Company Management Menu..");
            }

            // Display the updated company
            System.out.println("\n\nUpdated Company : ");
            System.out.println(companyFound);

        } while (option != 0);

    }

    public void deleteCompany() {
        if (companyList.isEmpty()) {
            System.out.println("No companies available to edit.");
            return;
        }

        String id;
        Company companyFound = null;
        String confirmationToDelete;

        do {
            do {
                viewAllCompanyList();
                System.out.println("Type 0 or X to return to the previous menu.\n");
                id = companyManagementUI.getStringInput("Enter Company ID : ");
                id = id.toUpperCase();

                if (id.equals("0") || id.equals("X")) {
                    return;
                }

                companyFound = CompanyValidateFunction.isValidCompanyId(id, companyList);
            } while (companyFound == null);

            System.out.println(companyFound);

            do {
                confirmationToDelete = companyManagementUI.getConfirmationPrompt("Do you want to delete this company?");
            } while (!CompanyValidateFunction.isValidConfirmation(confirmationToDelete));

        } while (confirmationToDelete.equals("N"));

        removeCompanyFromList(companyFound);

    }
    
    public void removeCompanyFromList(Company companyFound) {
        ListInterface<JobPosting> jpList = companyFound.getJobPostingList();
        
        for (JobPosting jp : jpList) {
            JobPostingControl.removeJobApplicationFromStudent(jp);
            JobPostingControl.removeJobApplicationFromInterview(jp);
            JobPostingControl.removeJobPostingFromJob(jp);
        }
        
        companyFound.getJobPostingList().clear();
        
        int companyIndex = companyList.indexOf(companyFound);
        Company removedCompany = companyList.remove(companyIndex);
        if (removedCompany != null) {
            System.out.println("Successfully removed Company with ID : " + 
                    removedCompany.getId()
            );
        } else {
            System.err.println("Failed to remove Company wih ID : " + 
                    companyFound.getId()
            );
        } 
    }
    
    // Just for testing purpose
    public static void main(String[] args) {
        AllDataInitialize dataInitialize = new AllDataInitialize();

        ListInterface<Company> companyList = dataInitialize.getCompanyList();

        CompanyControl companyControl = new CompanyControl(companyList);

        companyControl.startCompanyManagement();
    }

}

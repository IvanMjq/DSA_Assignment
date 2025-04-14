/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.JobManagementUI;
import dao.AllDataInitialize;
import entity.Company;
import entity.Job;
import entity.Student;
import utility.IdGeneration;
import utility.JobValidateFunction;

/**
 *
 * @author Ivanmjq
 */
public class JobControl {

    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    private ListInterface<Job> jobList = new DoublyLinkedList<>();
    private ListInterface<Student> studentList = new DoublyLinkedList<>();

    JobManagementUI jobManagementUI = new JobManagementUI();

    public JobControl(ListInterface<Company> companyList, ListInterface<Job> jobList, ListInterface<Student> studentList) {
        this.companyList = companyList;
        this.jobList = jobList;
        this.studentList = studentList;
    }

    public void startJobManagement() {
        int option;

        do {
            option = jobManagementUI.jobManagementMenu();

            switch (option) {
                case 1:
                    addJob();
                    break;
                case 2:
                    viewJob();
                    break;
                case 3:
                    editJob();
                    break;
                case 4:
                    deleteJob();
                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("Returing to Main Menu ...");
                    break;
            }

        } while (option != 0);
    }

    public void addJob() {
        String id;
        String title;
        String type;
        String desc;
        
        String addConfirmation;
        
        id = IdGeneration.generateID(jobList, "J");

        System.out.println("\n--------------------");
        System.out.println(" Add Job ");
        System.out.println("--------------------");

        do {
            title = jobManagementUI.getStringInput("Enter Job Title : ");
        } while (!JobValidateFunction.isValidTitle(title));
        
        do {
            type = jobManagementUI.getStringInput("Enter Job Type : ");
        } while (!JobValidateFunction.isValidType(type));
        
    }

    public void viewJob() {

    }

    public void editJob() {

    }

    public void deleteJob() {

    }

    // Just for testing purpose 
    public static void main(String[] args) {
        AllDataInitialize dataInitialize = new AllDataInitialize();

        ListInterface<Company> companyList = dataInitialize.getCompanyList();
        ListInterface<Job> jobList = dataInitialize.getJobList();
        ListInterface<Student> studentList = dataInitialize.getStudentList();

        JobControl jobControl = new JobControl(companyList, jobList, studentList);

        jobControl.startJobManagement();
    }

}

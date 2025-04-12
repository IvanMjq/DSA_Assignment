/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.*;
import entity.*;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class StudentPortalControl {
    Scanner scanner = new Scanner(System.in);
    
    private ListInterface<Student> studentList;
    private ListInterface<StudentSkill> studentSkillList;
    private ListInterface<Skill> skillList;
    private ListInterface<Job> jobList;
    private Student loginStudent;
    private StudentPortalUI studentPortalUI;
    
    public StudentPortalControl() { 
    }
    
    public StudentPortalControl(ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<StudentSkill> studentSkillList, ListInterface<Job> jobList) {
        this.studentList        = studentList;
        this.studentSkillList   = studentSkillList;
        this.skillList          = skillList;
        this.jobList            = jobList;
        this.studentPortalUI    = new StudentPortalUI(this);
        runJobPostingManagement();
    }
    
    public void runJobPostingManagement() {
        int option = 0;

        do {
            option = studentPortalUI.homePage();
            switch (option) {
                case 0:
                    System.out.println("Exiting Student Portal...");
                    break;
                case 1:
                    addStudent();
                    break;
                case 2:
                    studentLogin();
                    break;
                case 3:
                    studentLogout();
                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }
    
    public void addStudent() {
        studentPortalUI.addStudentUI();
        Student newStudent = studentPortalUI.newStudentDetails();
        
        boolean isConfirm = studentPortalUI.confirmation("Confirm add " + newStudent.getId() + " as new Job Post?");
        
        if (isConfirm) {
            studentList.add(newStudent);
//            jobPostListing();
            System.out.println("Student Register successfully!");
        } else {
            System.out.println("Failed to add job posting.");
        }
    }
    
    public void studentLogin() {
        studentPortalUI.loginUI();
    }
    
    public void studentLogout() {
        studentPortalUI.logoutUI();
        loginStudent = null;
    }
    
    public boolean loginValidation(String inputID, String inputPassword) {
        boolean isValid = false;
        Student found = null;
        for (int i = 1; i <= studentList.size(); i++) {
            if (studentList.getData(i).getId().equals(inputID)) {
                found = studentList.getData(i);
                break;
            }
        }
        
        if(found != null && found.getPassword().equals(inputPassword)) {
            loginStudent = found;
            isValid = true;
        }
        
        return isValid;
    }
    
    public boolean isLogin() {
        if(loginStudent != null) {
            return true;
        }
        return false;
    }
    
    public Job isJobExist(String info) {
        Job job = null;
        
        for(int i = 1; i <= jobList.size(); i++) {
            if (info.equalsIgnoreCase(jobList.getData(i).getId())){
                job = jobList.getData(i);
                break;
            }
            
            if (info.equalsIgnoreCase(jobList.getData(i).getTitle())){
                job = jobList.getData(i);
                break;
            }
        }
        return job;
    }
    
    public int[] jobTypeList() {
        int count = 0;
        String[] typeListed = new String[10];
        int[] option = new int[10];
      
        System.out.println("====================================================================================================");
        System.out.printf("| %-10s | %-40s  |\n", "Option","Type");
        for (int i = 1; i <= jobList.size(); i++) {
            String currentType = jobList.getData(i).getType();
            boolean isExists = false;
            
            for (int j = 0; j < count; j++) {
                if (typeListed[j].equals(currentType)) {
                    isExists = true;
                    break;
                }
            }
            
            if (!isExists) {
                if (count == typeListed.length) {
                    typeListed = doubleStringArray(typeListed);
                    option = doubleIntArray(option);
                }

                typeListed[count] = currentType;
                option[count] = i;
                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.printf("| %-10d | %-40s  |\n", count + 1, currentType);
                count++;
            }
        }
        
        System.out.println("====================================================================================================");
        
        return option;
    }
    
    public String getJobType(int input){
        return jobList.getData(input).getType();
    }
    
    public String[] doubleStringArray(String[] oldArray) {
        String[] newArray = new String[oldArray.length * 2];
        for (int j = 0; j < oldArray.length; j++) {
            newArray[j] = oldArray[j];
        }
        return newArray;
    }
    
    public int[] doubleIntArray(int[] oldArray) {
        int[] newArray = new int[oldArray.length * 2];
        for (int j = 0; j < oldArray.length; j++) {
            newArray[j] = oldArray[j];
        }
        return newArray;
    }
    
    public boolean isJobTypeDuplicateEnter(int input, String[] jobType) {
        int i = 0;
        while(jobType[i] != null){
            if(jobList.getData(input).getType().equals(jobType[i])) {
                return false;
            }
            i++;
        }
        
        return true;
    }
    
    public String generateStudentID() {
        String id;
        if(studentList.getLastData() != null){
            id = studentList.getLastData().getId();
            int num = Integer.parseInt(id.substring(4)); 
             return "STU-" + (num + 1);
        }else{
            return "STU-" + 1;
        }
    }
    
    public Student getLoginStudent() {
        return loginStudent;
    }
}

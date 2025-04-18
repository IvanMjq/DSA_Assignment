/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedList;
import adt.ListInterface;
import control.*;
import entity.*;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class StudentUI {
    Scanner scanner = new Scanner(System.in);
    private StudentControl studentControl;
     
     public StudentUI(StudentControl studentControl) {
        this.studentControl = studentControl;
    }
     
    public int adminStudentMenu() {
        System.out.println("\nStudent Menu");
        System.out.println("=====================================");
        System.out.println("1. Listing");
        System.out.println("2. Register");
        System.out.println("3. Remove");
        System.out.println("4. Update");
        System.out.println("5. Report");
        System.out.println("6. Matching Report");
        System.out.println("0. Exit");
        System.out.print("Enter option: ");
        

        int option = scanner.nextInt();
        System.out.println("You selected option: " + option);
        scanner.nextLine();
        System.out.println();
        return option;
    }
    
    public int studentListingOption() {
        System.out.println("\nStudent Listing");
        System.out.println("=====================================");
        System.out.println("1. Listing");
        System.out.println("2. Listing Sort By Name");
        System.out.println("0. Exit");
        System.out.print("Enter option: ");
        

        int option = scanner.nextInt();
        System.out.println("You selected option: " + option);
        scanner.nextLine();
        System.out.println();
        return option;
    }
    

    
    public void studentListingUI() {
        System.out.println("--------------------------------------");
        System.out.println("Student Listing");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-7s | %-30s | %-30s | %-5s | %-30s | %-30s | %-30s | %-15s | %-15s | %-30s | %-30s | %-40s | %-20s | %-200s | %-70s |\n",
                    "ID",
                    "Name",
                    "Password",
                    "Age",
                    "Street Address",
                    "Area",
                    "State",
                    "Latitute",
                    "Longitute",
                    "Email",
                    "Achievement",
                    "Education",
                    "Year Of Experience",
                    "Skill",
                    "Desired Job Types"
                );
        
    }
    
    public void addStudentUI(){
        System.out.println("--------------------------------------");
        System.out.println("Add New Student");
        System.out.println("--------------------------------------");
        System.out.println("Enter Student Infomation:");
        System.out.println("======================================");
    }
    
    public Student newStudentDetails() {
        String name = null;
        while(name == null) {
            System.out.print("Enter Name: ");
            String input = scanner.nextLine().trim();
            
            if(nameValidation(input)){
               name = input;
            }
        }
        
        String password = null;
        while(password == null) {
            System.out.print("Enter Password: ");
            String input = scanner.nextLine().trim();
            
            if(passwordValidation(input)){
               password = input;
            }
        }
      
        int age = -1;
        while(age == -1) {
            System.out.print("Enter Age: ");
            String input = scanner.nextLine().trim();
            
            if(ageValidation(input)){
                age = Integer.parseInt(input);
            } 
        }

        System.out.print("Enter Street Address: ");
        String address = scanner.nextLine().trim();
                
        String area = null;
        while(area == null){
            System.out.print("Enter area: ");
            String input = scanner.nextLine().trim();
            
            if(alphabetValidation(input)){
                area = input;
            }
        }

        String state = null;
        while(state == null) {
            System.out.print("Enter state: ");
            String input = scanner.nextLine().trim();
            
            if(alphabetValidation(input)){
                state = input;
            }
        }
       
        
        String email = null;
        while (email == null) {
            System.out.print("Enter Email: ");
            String input = scanner.nextLine().trim();
    
            if (emailValidation(input)) {
                email = input; 
            }
        }
        
        String achievement = null;
        while (achievement == null) {
            System.out.print("Enter Achievement: ");
            String input = scanner.nextLine().trim();
    
            if (achievementValidation(input)) {
                achievement = input; 
            }
        }
        
        String education = null;
        while (education == null) {
            System.out.print("Enter Education: ");
            String input = scanner.nextLine().trim();
    
            if (educationValidation(input)) {
                education = input; 
            }
        }
        
        int yearsOfExperience = -1;
        while(yearsOfExperience == -1) {
            System.out.print("Enter Years Of Experience: ");
            String input = scanner.nextLine().trim();
            
            if(digitValidation(input)){
                yearsOfExperience = Integer.parseInt(input);
            } 
        }
        
        boolean loop = true;
        int i = 0;
        ListInterface<StudentSkill> studentSkillList = new DoublyLinkedList<>();
        while(loop) {
            if(i == 3)
                break;
            
            studentControl.skillList();
            System.out.println("Choose min 1 to 3 Skill.");
            System.out.print("Enter Skill ID, Q=Done: ");
            String skillInput = scanner.nextLine().trim();
            
            if (skillInput.equalsIgnoreCase("Q")) {
                if (i == 0) 
                    System.out.println("You must select at least one Skill.");
                else
                    break;
            } 
            
            if(!skillInput.equalsIgnoreCase("Q")) {
                int intProficiencyLevelInput = 0;
                while(intProficiencyLevelInput == 0){
                    System.out.print("Enter Proficiency Level (1-5): ");
                    String proficiencyLevelInput = scanner.nextLine().trim();
                    
                    if(digitValidation(proficiencyLevelInput)){
                        int intInput = Integer.parseInt(proficiencyLevelInput);
                        if((intInput >= 1) && (intInput <= 5)) {
                            intProficiencyLevelInput = intInput;
                        }else {
                            System.out.println("Invalid input, Enter Proficiency within 1-5 ");
                        }
                    } 
                }
               
                
                Skill tempSkill = studentControl.selectedSkill(skillInput);
                if(tempSkill != null){
                    if(studentControl.duplicateSkillSelection(studentSkillList, tempSkill)) {
                        studentSkillList.add(new StudentSkill(tempSkill, intProficiencyLevelInput));
                        i++;
                    }else{
                        System.out.println("Duplicate Selection.");
                    }
                }else {
                    System.out.println("You must select existed ID only.");
                } 

            }
        }
        
        loop = true;
        i = 0;
        String[] jobTypes = new String[3];
        while(loop) {
            if(i == 3)
                break;
            
            int[] option = studentControl.jobTypeList();
            System.out.print("Choose min 1 to 3 Job Type.");
            System.out.print("Chooese Desire Job Type, Q=Done: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("Q")) {
                if (i == 0) 
                    System.out.println("You must select at least one job type.");
                else
                    break;
            } 
            
            if(digitValidation(input)){
                int intInput = Integer.parseInt(input);
   
                if( (intInput <= studentControl.checkItemLength(option))) {
                    if (studentControl.noJobTypeDuplicateEnter(option[intInput - 1], jobTypes)) {
                        jobTypes[i] = studentControl.getJobType(option[intInput - 1]);
                         i++;
                    }
                } else {
                    System.out.println("You must select existed number only.");
                }
            }
           
        }
        
        double[] tude = GeoUtilControl.getLatLong(area, state);
        double latitude = tude[0];
        double longitude = tude[1];
        
        Student newStudent = new Student(studentControl.generateStudentID(), name, password, age, address, area, state,latitude, longitude, email, achievement, education, yearsOfExperience, jobTypes);
        
        for(int z = 1; z <= studentSkillList.size(); z++) {
            Skill skill = studentSkillList.getData(z).getSkill();
            int level = studentSkillList.getData(z).getProficiencyLevel();
            newStudent.getStudentSkillList().add(new StudentSkill(skill, level));
        }
        
        return newStudent;
    }
    
    
    public boolean nameValidation(String input) {
        boolean isValid = true;
        
        if(input.isEmpty()) {
            System.out.println("Name cannot be empty or spaces only. Please try again.");
            isValid = false;
        }  
        
        if (!input.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid name. Only alphabets and spaces are allowed.");
            isValid = false;
        }  
        
        if (input.length() > 30) {
            System.out.println("Max 30 characters.");
            isValid = false;
        } 
        
        return isValid;
    }
    
    public boolean passwordValidation(String input) { 
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Password cannot be empty.");
            return false;
        }

        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$";

        if (!input.matches(passwordRegex)) {
            System.out.println("Password must be at least 8 characters, include uppercase, lowercase, number, and special character.");
            return false;
        } 
        
        return true;
    }
    
    
    public boolean ageValidation(String input) { 
        if(!digitValidation(input)) {
            return false;
        }
        
        int age = Integer.parseInt(input);
        if (age < 12 || age > 120) {
            System.out.println("Invalid age.  Please try again");
            return false;
        } 

        return true;
    }
    
    public boolean alphabetValidation(String input) {
        boolean isValid = true;
        
        if(input.isEmpty()) {
            System.out.println("Cannot be empty or spaces only. Please try again.");
            isValid = false;
        }  
        
        if(!input.matches("^[A-Za-z]+$")) {
            System.out.println("Input must only contain alphabets only. Please try again.");
            isValid = false;
        }  
        
        return isValid;
    }
    
     public boolean emailValidation(String input) { 
         boolean isValid = true;
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
         
        if(input.isEmpty()) {
            isValid = false;
        }  
        
        if (!input.matches(emailRegex)) {
            System.out.println("Invalid email. Please try again");
            isValid = false;
        } 
        
        return isValid;
    }
     
    public boolean achievementValidation(String input) { 
        if(!input.isEmpty()) {
            return true;
        }  
        System.out.println("Invalid achievement. Please try again");
        return false;
    }
    
    public boolean educationValidation(String input) { 
        if(!input.isEmpty()) {
            return true;
        }  
        System.out.println("Invalid education. Please try again");
        return false;
    }
    
    public boolean digitValidation(String input) { 
        if (!input.matches("\\d+")) {
            System.out.println("Invalid input. Must be digits only.");
            return false;
        }
        return true;
    }
    
    public void updateStudentUI() {
        System.out.println("--------------------------------------");
        System.out.println("Update Student Details");
    } 
    
    public int updateStudentMenu() {
        System.out.println("\nStudent Update Menu");
        System.out.println("=====================================");
        System.out.println("1. Name");
        System.out.println("2. Password");
        System.out.println("3. Age");
        System.out.println("4. Street Address");
        System.out.println("5. Area");
        System.out.println("6. State");
        System.out.println("7. Email");
        System.out.println("8. Achievement");
        System.out.println("9. Education");
        System.out.println("10.Year Of Experience");
        System.out.println("11.Skill");
        System.out.println("12.Desire Job Type");
        System.out.println("0. Exit");
        System.out.print("Enter option: ");

        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }
    
    public void removeStudentUI() {
        System.out.println("--------------------------------------");
        System.out.println("Remove Student");
    }
    
    public boolean confirmation(String message) {
        System.out.print(message + " (Y/N): ");
        char confirmation = scanner.nextLine().toUpperCase().charAt(0);
        return confirmation == 'Y';
    }
}

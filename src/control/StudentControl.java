/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.*;
import entity.*;
import java.util.Scanner;

/**
 *
 * @author Teh Yi Shan
 */
public class StudentControl {

    Scanner scanner = new Scanner(System.in);

    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    private ListInterface<Student> studentList = new DoublyLinkedList<>();
    private ListInterface<Skill> skillList = new DoublyLinkedList<>();
    private ListInterface<Job> jobList = new DoublyLinkedList<>();
    private ListInterface<Interview> interviewList = new DoublyLinkedList<>();
    private StudentUI studentUI;
    private MatchingEngineControl matchControl;
    private StudentPortalControl studentPortalControl;
    private JobApplicationControl jobApplicationControl;
    private AdminPortalControl adminPortalControl;
    
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";

//    public StudentControl() {
//    }

    public StudentControl(ListInterface<Company> companyList, ListInterface<Student> studentList,ListInterface<Skill> skillList,ListInterface<Job> jobList, ListInterface<Interview> interviewList) {
        this.companyList            = companyList;
        this.studentList            = studentList;
        this.skillList              = skillList;
        this.jobList                = jobList;
        this.interviewList          = interviewList;
        this.studentUI              = new StudentUI(this);
        this.jobApplicationControl  = new JobApplicationControl(companyList, studentList, skillList, jobList, interviewList); 
        this.matchControl           = new MatchingEngineControl(companyList, studentList);
        this.jobApplicationControl.setStudentControl(this);
    }
 
    public void setAdminPortalControl(AdminPortalControl adminPortalControl) {
        this.adminPortalControl = adminPortalControl;
    }
    
    public void setStudentPortalControl(StudentPortalControl studentPortalControl) {
        this.studentPortalControl = studentPortalControl;
    }
    
    public void adminStudentManagement() {
        int option = 0;

        do {
            option = studentUI.adminStudentMenu();
            switch (option) {
                case 0:
                    System.out.println("Exiting Student Menu...");
                    break;
                case 1:
                    studentListing();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    generateReport();
                    break;
                case 6:
                    matchControl.AdminMatchingRunner();
                    break;

                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }

    public void studentOwnListing() {

        studentUI.studentListingUI();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-7s | %-30s | %-30s | %-5s | %-30s | %-30s | %-30s | %-15f | %-15f | %-30s | %-30s | %-40s | %-20s | %-200s | %-70s |\n",
                studentPortalControl.getLoginStudent().getId(),
                studentPortalControl.getLoginStudent().getName(),
                studentPortalControl.getLoginStudent().getPassword(),
                studentPortalControl.getLoginStudent().getAge(),
                studentPortalControl.getLoginStudent().getStreetAddress(),
                studentPortalControl.getLoginStudent().getArea(),
                studentPortalControl.getLoginStudent().getState(),
                studentPortalControl.getLoginStudent().getLatitude(),
                studentPortalControl.getLoginStudent().getLongitude(),
                studentPortalControl.getLoginStudent().getEmail(),
                studentPortalControl.getLoginStudent().getAchievement(),
                studentPortalControl.getLoginStudent().getEducation(),
                studentPortalControl.getLoginStudent().getYearsOfExperience(),
                convertSkillListToString(studentPortalControl.getLoginStudent().getStudentSkillList()),
                convertArrayToString(studentPortalControl.getLoginStudent().getDesiredJobTypes())
        );
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void studentListing() {
        int option = 0;

        do {
            option = studentUI.studentListingOption();
            switch (option) {
                case 0:
                    System.out.println("Exiting Student Menu...");
                    break;
                case 1:
                    normalStudentListing();
                    break;
                case 2:
                    sortedByNameStudentListing();
                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
        
    }
    
    public void normalStudentListing() {
        studentUI.studentListingUI();
        if (studentList.size() > 0) {
            bubbleSortById(studentList);
            
            for (Student student : studentList) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-7s | %-30s | %-30s | %-5s | %-30s | %-30s | %-30s | %-15f | %-15f | %-30s | %-30s | %-40s | %-20s | %-200s | %-70s |\n",
                        student.getId(),
                        student.getName(),
                        student.getPassword(),
                        student.getAge(),
                        student.getStreetAddress(),
                        student.getArea(),
                        student.getState(),
                        student.getLatitude(),
                        student.getLongitude(),
                        student.getEmail(),
                        student.getAchievement(),
                        student.getEducation(),
                        student.getYearsOfExperience(),
                        convertSkillListToString(student.getStudentSkillList()),
                        convertArrayToString(student.getDesiredJobTypes())
                );
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    
    public void sortedByNameStudentListing() {
        studentUI.studentListingUI();

        if (studentList.size() > 0) {
            bubbleSortStudentListByName(studentList);  // Call sorting method

            for (int i = 1; i <= studentList.size(); i++) {
                Student student = studentList.getData(i);
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-7s | %-30s | %-30s | %-5s | %-30s | %-30s | %-30s | %-15f | %-15f | %-30s | %-30s | %-40s | %-20s | %-200s | %-70s |\n",
                        student.getId(),
                        student.getName(),
                        student.getPassword(),
                        student.getAge(),
                        student.getStreetAddress(),
                        student.getArea(),
                        student.getState(),
                        student.getLatitude(),
                        student.getLongitude(),
                        student.getEmail(),
                        student.getAchievement(),
                        student.getEducation(),
                        student.getYearsOfExperience(),
                        convertSkillListToString(student.getStudentSkillList()),
                        convertArrayToString(student.getDesiredJobTypes())
                );
            }

            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    
    public void bubbleSortById(ListInterface<Student> list) {
        for (int i = 1; i <= list.size(); i++) {
            for (int j = 1; j <= list.size() - i; j++) {
                Student s1 = list.getData(j);
                Student s2 = list.getData(j + 1);

                int id1 = extractIdNumber(s1.getId());
                int id2 = extractIdNumber(s2.getId());

                if (id1 > id2) {
                    list.replace(j, s2);
                    list.replace(j + 1, s1);
                }
            }
        }
    }
    
    private int extractIdNumber(String id) {
        try {
            return Integer.parseInt(id.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE; 
        }
    }
    
    public void bubbleSortStudentListByName(ListInterface<Student> list) {
        for (int i = 1; i <= list.size(); i++) {
            for (int j = 1; j <= list.size() - i; j++) {
                Student s1 = list.getData(j);
                Student s2 = list.getData(j + 1);
                if (s1.getName().compareToIgnoreCase(s2.getName()) > 0) {
                    // Swap
                    list.replace(j, s2);
                    list.replace(j + 1, s1);
                }
            }
        }
    }
    
    public String convertSkillListToString(ListInterface<StudentSkill> skills) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= skills.size(); i++) {
            StudentSkill ss = skills.getData(i);
            sb.append("Name: ").append(ss.getSkill().getName()).append(",")
            .append(" Proficiency Level: ").append(ss.getProficiencyLevel());
            if (i < skills.size()) {
                sb.append("| ");
            }
        }
        return sb.toString();
    }
    
    public String convertArrayToString(String[] array) {
        String result = "";
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    result += array[i];
                    if (i < array.length - 1) {
                        result += ", ";
                    }
                }
            }
        }

        return result;
    }

    public void addStudent() {
        studentUI.addStudentUI();
        Student newStudent = studentUI.newStudentDetails();

        boolean isConfirm = studentUI.confirmation("Confirm Register " + newStudent.getId() + " as new Student?");

        if (isConfirm) {
            studentList.add(newStudent);
            System.out.println("Student Register successfully!");
        } else {
            System.out.println("Failed to add job posting.");
        }
    }
    
    public void skillList() {
        System.out.println("====================================================================================================");
        System.out.printf("| %-10s | %-40s  |\n", "ID", "Name");
        for (Skill skill : skillList) {
            System.out.printf("| %-10s | %-40s  |\n", skill.getId(), skill.getName());
        }

        System.out.println("====================================================================================================");
    }
    
    public Skill selectedSkill(String input) {
         for (Skill skill : skillList) {
            if(input.equals(skill.getId())){
                return skill;
            }
        }
        return null;
    }
    
    public boolean duplicateSkillSelection(ListInterface<StudentSkill> selectedSkillList, Skill input) {
        for(int i = 1; i <= selectedSkillList.size(); i++) {
            Skill existing = selectedSkillList.getData(i).getSkill();
            if (existing.getId().equals(input.getId())) {
                return false;
            }
        }
        return true;
    }
    
    public int[] jobTypeList() {
        int count = 0;
        String[] typeListed = new String[5];
        int[] option = new int[5];

        System.out.println("====================================================================================================");
        System.out.printf("| %-10s | %-40s  |\n", "Option", "Type");
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
    
    public String getJobType(int input) {
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

    public boolean noJobTypeDuplicateEnter(int input, String[] jobType) {
        int i = 0;
        while (jobType[i] != null) {
            if (jobList.getData(input).getType().equals(jobType[i])) {
                System.out.println("Current Job Type had selected.");
                return false;
            }
            i++;
        }

        return true;
    }

    public void updateOwnStudent() {
        studentUI.updateStudentUI();

        int studentPosition = studentList.indexOf(studentPortalControl.getLoginStudent());
        if (studentPosition != -1) {
            Student oriData = studentList.getData(studentPosition);
            updateStudentDetails(oriData);
            System.out.println(oriData);
            double[] tude = GeoUtilControl.getLatLong(oriData.getArea(), oriData.getState());
            double latitude = tude[0];
            double longitude = tude[1];
            oriData.setLatitude(latitude);
            oriData.setLongitude(longitude);
            Student updatedData = studentList.getData(studentPosition);
            System.out.println(updatedData);
        }
    }

    public void updateStudent() {
        studentUI.updateStudentUI();
        studentListing();

        int studentPosition = 0;
        do {
            System.out.print("Enter ID, (Q=Quit): ");
            String selectedStudent = scanner.nextLine().trim();
            studentPosition = findStudent(selectedStudent);

            if (Character.toUpperCase(selectedStudent.charAt(0)) == 'Q') {
                studentPosition = -1;
            }

            if (studentPosition == 0) {
                System.out.println("ID Not Found");
            }
        } while (studentPosition == 0);

        if (studentPosition != -1) {
            Student oriData = studentList.getData(studentPosition);
            updateStudentDetails(oriData);
            System.out.println(oriData);
            double[] tude = GeoUtilControl.getLatLong(oriData.getArea(), oriData.getState());
            double latitude = tude[0];
            double longitude = tude[1];
            oriData.setLatitude(latitude);
            oriData.setLongitude(longitude);
            Student updatedData = studentList.getData(studentPosition);
            System.out.println(updatedData);
        }
    }

    public void updateStudentDetails(Student ori) {
        int option = 0;

        do {
            option = studentUI.updateStudentMenu();
            switch (option) {
                case 0:
                    System.out.println("Exiting Update Menu...");
                    break;
                case 1:
                    updateName(ori);
                    break;
                case 2:
                    updatePassword(ori);
                    break;
                case 3:
                    updateAge(ori);
                    break;
                case 4:
                    updateStreetAddress(ori);
                    break;
                case 5:
                    updateArea(ori);
                    break;
                case 6:
                    updateState(ori);
                    break;
                case 7:
                    updateEmail(ori);
                    break;
                case 8:
                    updateAchievement(ori);
                    break;
                case 9:
                    updateEducation(ori);
                    break;
                case 10:
                    updateYearOfExp(ori);
                    break;
                case 11:
                    updateSkill(ori);
                    break;
                case 12:
                    updateDesireJobType(ori);
                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }

    public void updateName(Student ori) {
        boolean loop = true;
        while (loop) {
            System.out.print("Enter Name: ");
            String input = scanner.nextLine().trim();

            if (studentUI.nameValidation(input)) {
                boolean isConfirm = studentUI.confirmation("Confirm update " + ori.getName() + " as " + input + "?");
                if (isConfirm) {
                    ori.setName(input);
                    System.out.println("Student Name update successfully!");
                }else {

                    System.out.println("Failed to update.");
                }
                loop = false;
            }
        }
    }

    public void updatePassword(Student ori) {
        boolean loop = true;
        while (loop) {
            System.out.print("Enter Password: ");
            String input = scanner.nextLine().trim();

            if (studentUI.passwordValidation(input)) {
                boolean isConfirm = studentUI.confirmation("Confirm update " + ori.getPassword() + " as " + input + "?");
                if (isConfirm) {
                    ori.setPassword(input);
                    System.out.println("Student Password update successfully!");
                }else {

                    System.out.println("Failed to update.");
                }
                loop = false;
            }
        }
    }

    public void updateAge(Student ori) {
        boolean loop = true;

        while(loop) {
            System.out.print("Enter Age: ");
            String input = scanner.nextLine().trim();

            if (studentUI.ageValidation(input)) {
                boolean isConfirm = studentUI.confirmation("Confirm update " + ori.getAge() + " as " + input + "?");
                if (isConfirm) {
                    ori.setAge(Integer.parseInt(input));
                    System.out.println("Student Age update successfully!");
                }else {

                    System.out.println("Failed to update.");
                }
                loop = false;
            }
        }
    }

    public void updateStreetAddress(Student ori) {
        System.out.print("Enter Street Address: ");
        String input = scanner.nextLine().trim();

        boolean isConfirm = studentUI.confirmation("Confirm update " + ori.getStreetAddress() + " as " + input + "?");
        if (isConfirm) {
            ori.setStreetAddress(input);
            System.out.println("Student Street Address update successfully!");
        }else {

            System.out.println("Failed to update.");
        }
    }

    public void updateArea(Student ori) {
        boolean loop = true;
        while (loop) {
            System.out.print("Enter Area: ");
            String input = scanner.nextLine().trim();

            if (studentUI.alphabetValidation(input)) {
                boolean isConfirm = studentUI.confirmation("Confirm update " + ori.getArea() + " as " + input + "?");

                if (isConfirm) {
                    ori.setArea(input);
                    System.out.println("Student Area update successfully!");
                }else {
                    System.out.println("Failed to update.");
                }
                loop = false;
            }
        }
    }

    public void updateState(Student ori) {
        boolean loop = true;
        while (loop) {
            System.out.print("Enter State: ");
            String input = scanner.nextLine().trim();

            if (studentUI.alphabetValidation(input)) {
                boolean isConfirm = studentUI.confirmation("Confirm update " + ori.getState() + " as " + input + "?");

                if (isConfirm) {
                    ori.setState(input);
                    System.out.println("Student State update successfully!");
                }else {
                    System.out.println("Failed to update.");
                }
                loop = false;
            }
        }
    }

    public void updateEmail(Student ori) {
        boolean loop = true;
        while (loop) {
            System.out.print("Enter Email: ");
            String input = scanner.nextLine().trim();

            if (studentUI.emailValidation(input)) {
                boolean isConfirm = studentUI.confirmation("Confirm update " + ori.getEmail() + " as " + input + "?");
                if (isConfirm) {
                    ori.setEmail(input);
                    System.out.println("Student Email update successfully!");
                }else {
                    System.out.println("Failed to update.");
                }
                loop = false;
            }
        }
    }

    public void updateAchievement(Student ori) {
        boolean loop = true;
        while (loop) {
            System.out.print("Enter Achievement: ");
            String input = scanner.nextLine().trim();

            if (studentUI.achievementValidation(input)) {
                boolean isConfirm = studentUI.confirmation("Confirm update " + ori.getAchievement() + " as " + input + "?");

                if (isConfirm) {
                    ori.setAchievement(input);
                    System.out.println("Student Achievement update successfully!");
                }else {
                    System.out.println("Failed to update.");
                }
                loop = false;
            }
        }
    }

    public void updateEducation(Student ori) {
        boolean loop = true;
        while (loop) {
            System.out.print("Enter Education: ");
            String input = scanner.nextLine().trim();

            if (studentUI.educationValidation(input)) {
                boolean isConfirm = studentUI.confirmation("Confirm update " + ori.getEducation() + " as " + input + "?");

                if (isConfirm) {
                    ori.setEducation(input);
                    System.out.println("Student Education update successfully!");
                }else {
                    System.out.println("Failed to update.");
                }
                loop = false;
            }
        }
    }

    public void updateYearOfExp(Student ori) {
        boolean loop = true;
        while (loop) {
            System.out.print("Enter Years Of Experience: ");
            String input = scanner.nextLine().trim();

            if (studentUI.digitValidation(input)) {
                boolean isConfirm = studentUI.confirmation("Confirm update " + ori.getYearsOfExperience() + " as " + input + "?");

                if (isConfirm) {
                    ori.setYearsOfExperience(Integer.parseInt(input));
                    System.out.println("Student Experience update successfully!");
                }else {
                    System.out.println("Failed to update.");
                }
                loop = false;

            }
        }
    }
    
    public void updateSkill (Student ori) {
        boolean loop = true;
        int i = 0;
        ListInterface<StudentSkill> studentSkillList = new DoublyLinkedList<>();
        while(loop) {
            if(i == 3)
                break;
            
            skillList();
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
                    
                    if(studentUI.digitValidation(proficiencyLevelInput)){
                        int intInput = Integer.parseInt(proficiencyLevelInput);
                        if((intInput >= 1) && (intInput <= 5)) {
                            intProficiencyLevelInput = intInput;
                        }else {
                            System.out.println("Invalid input, Enter Proficiency within 1-5 ");
                        }
                    } 
                }
               
                
                Skill tempSkill = selectedSkill(skillInput);
                if(tempSkill != null){
                    if(duplicateSkillSelection(studentSkillList, tempSkill)) {
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
        
        if (!studentSkillList.isEmpty()) {
                boolean isConfirm = studentUI.confirmation("Confirm update Skill?");

                if (isConfirm) {
                    ori.getStudentSkillList().clear();
                    for(int z = 1; z <= studentSkillList.size(); z++) {
                        Skill skill = studentSkillList.getData(z).getSkill();
                        int level = studentSkillList.getData(z).getProficiencyLevel();
                        ori.getStudentSkillList().add(new StudentSkill(skill, level));
                    }
                    System.out.println("Student Desire Job Type update successfully!");
                }else {
                    System.out.println("Failed to update.");
                }
            }
    }

    public void updateDesireJobType(Student ori) {
        boolean loop = true;
        int i = 0;
        String[] jobTypes = new String[3];
        while (loop) {
            if (i == 3) {
                break;
            }

            int[] option = jobTypeList();
            System.out.print("Choose min 1 to 3 Job Type.");
            System.out.print("Chooese Desire Job Type, Q=Done: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("Q")) {
                if (i == 0) {
                    System.out.println("You must select at least one job type.");
                }
                break;
            }

            if (studentUI.digitValidation(input)) {
                int intInput = Integer.parseInt(input);
                if ((intInput <= checkItemLength(option))) {
                    if (noJobTypeDuplicateEnter(option[intInput - 1], jobTypes)) {
                        jobTypes[i] = getJobType(option[intInput - 1]);
                        i++;
                    }
                } else {
                    System.out.println("You must select existed number only.");
                }
            }

        }

        if (jobTypes != null) {
            boolean isConfirm = studentUI.confirmation("Confirm update " + convertArrayToString(ori.getDesiredJobTypes()) + " as " + convertArrayToString(jobTypes) + "?");

            if (isConfirm) {
                ori.setDesiredJobTypes(jobTypes);
                System.out.println("Student Desire Job Type update successfully!");
            }else {
                System.out.println("Failed to update.");
            }
        }
    }

    public int checkItemLength(int[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                return i;
            }
        }
        return input.length;
    }
    
    public Job isJobExist(String info) {
        Job job = null;

        for (int i = 1; i <= jobList.size(); i++) {
            if (info.equalsIgnoreCase(jobList.getData(i).getId())) {
                job = jobList.getData(i);
                break;
            }

            if (info.equalsIgnoreCase(jobList.getData(i).getTitle())) {
                job = jobList.getData(i);
                break;
            }
        }
        return job;
    }

    public void removeStudent() {
        studentUI.removeStudentUI();
        studentListing();

        int studentPosition = 0;
        do {
            System.out.print("Enter ID, (Q=Quit): ");
            String selectedPost = scanner.nextLine().trim();
            studentPosition = findStudent(selectedPost);

            if (Character.toUpperCase(selectedPost.charAt(0)) == 'Q') {
                studentPosition = -1;
            }

            if (studentPosition == 0) {
                System.out.println("ID Not Found");
            }
        } while (studentPosition == 0);

        if (studentPosition != -1) {
            Student oriData = studentList.getData(studentPosition);
            System.out.println(oriData);
            boolean isConfirm = studentUI.confirmation("Confirm " + oriData.getId() + " as remove Student?");

            if (isConfirm) {
                removeCompanySide(oriData);
                removeInterviewSide(oriData);
                studentList.remove(studentPosition);
                studentListing();
                System.out.println("Student remove successfully!");
            } else {
                System.out.println("Failed to remove Student.");
            }
        }
    }
    
    public void removeCompanySide(Student input) {
        if (input == null || input.getJobApplicationList() == null) {
            System.out.println("Input student or their job application list is null.");
            return;
        }

        for (int i = 1; i <= companyList.size(); i++) {
            Company c = companyList.getData(i);
            if (c == null || c.getJobPostingList() == null) continue;

            for (int k = 1; k <= c.getJobPostingList().size(); k++) {
                JobPosting jp = c.getJobPostingList().getData(k);
                if (jp == null || jp.getJobApplicationList() == null) continue;

                for (int h = jp.getJobApplicationList().size(); h >= 1; h--) {
                    JobApplication ja = jp.getJobApplicationList().getData(h);
                    if (ja != null && input.getJobApplicationList().indexOf(ja) != -1) {
                        jp.getJobApplicationList().remove(h);
                    }
                }
            }
        }
    }


    
    public void removeInterviewSide(Student input) {
        for (int i = 1; i <= interviewList.size(); i++) {
            Interview interview = interviewList.getData(i);
            ListInterface<JobApplication> jobApps = interview.getJobApplicationList();

           
            for (int k = jobApps.size(); k >= 1; k--) {
                JobApplication ja = jobApps.getData(k);
                if (ja != null && input.getJobApplicationList().indexOf(ja) != -1) {
                    jobApps.remove(k);
                }
            }
        }
    }


    public int findStudent(String input) {
        int count = 1;
        int noFound = 0;
        for (int i = 1; i <= studentList.size(); i++) {
            if (studentList.getData(i).getId().equalsIgnoreCase(input)) {
                return count;
            }
            count++;
        }
        return noFound;
    }

    public String generateStudentID() {
        String id;
        if (studentList.getLastData() != null) {
            id = studentList.getLastData().getId();
            int num = Integer.parseInt(id.substring(4));
            return "STU-" + (num + 1);
        } else {
            return "STU-" + 1;
        }
    }
    
    
    public void generateReport() {
        String[] jobTypeExisted = jobTypeExist();
        int[] numberOfJobTypeExisted = new int[jobTypeExisted.length];
        String[] studentInEachType = new String[jobTypeExisted.length];
        int[] numberSuccessInterview = new int[jobTypeExisted.length];
        
        for (int i = 0; i < numberOfJobTypeExisted.length; i++) {
            studentInEachType[i] = "";
            numberOfJobTypeExisted[i] = 0;
            numberSuccessInterview[i] = 0;
        }
        
        for (int i = 1; i <= studentList.size(); i++) {
            Student s = studentList.getData(i);
            for (int j = 1; j <= s.getJobApplicationList().size(); j++) {
                JobApplication ja = s.getJobApplicationList().getData(j);
                if (ja == null) continue;

                String appJobType = ja.getJobPosting().getJob().getType();

                // find index of job type in jobTypeExisted[]
                for (int t = 0; t < jobTypeExisted.length; t++) {
                    if (jobTypeExisted[t] != null && appJobType.equalsIgnoreCase(jobTypeExisted[t])) {
                        numberOfJobTypeExisted[t]++;

                        // append student name if not already in
                        if (!studentInEachType[t].contains(s.getName())) {
                            if (!studentInEachType[t].isEmpty()) studentInEachType[t] += ", ";
                            studentInEachType[t] += s.getName();
                        }

                        if (ja.getInterview() != null && ja.getInterview().getInterviewStatus() == Interview.InterviewStatus.OFFERED) {
                            numberSuccessInterview[t]++;
                        }
                    }
                }
            }
        }
        

    // Display Report
        System.out.println("Student Job Appication Report");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-30s | %-200s | %-10s | %-25s |\n", "Job Type", "Student Applied", "Total", "Total Applied Success");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < jobTypeExisted.length; i++) {
            System.out.printf("| %-30s | %-200s | %-10d | %-25d |\n", 
                jobTypeExisted[i], 
                studentInEachType[i], 
                numberOfJobTypeExisted[i], 
                numberSuccessInterview[i]
            );
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        generateAsciiChart(jobTypeExisted, numberOfJobTypeExisted, numberSuccessInterview);
        
        // Highest / Lowest Applied (Manual) ===
        int maxApplied = numberOfJobTypeExisted[0];
        int minApplied = numberOfJobTypeExisted[0];

        // First, find max and min
        for (int i = 1; i < numberOfJobTypeExisted.length; i++) {
            if (numberOfJobTypeExisted[i] > maxApplied) {
                maxApplied = numberOfJobTypeExisted[i];
            }
            if (numberOfJobTypeExisted[i] < minApplied) {
                minApplied = numberOfJobTypeExisted[i];
            }
        }

        // Now, collect job types that match max/min
        String maxAppliedTypes = "";
        String minAppliedTypes = "";

        for (int i = 0; i < numberOfJobTypeExisted.length; i++) {
            if (numberOfJobTypeExisted[i] == maxApplied) {
                if (!maxAppliedTypes.isEmpty()) maxAppliedTypes += ", ";
                maxAppliedTypes += jobTypeExisted[i];
            }
            if (numberOfJobTypeExisted[i] == minApplied) {
                if (!minAppliedTypes.isEmpty()) minAppliedTypes += ", ";
                minAppliedTypes += jobTypeExisted[i];
            }
        }

        //Highest / Lowest Success Rate (Manual) ===
        double maxRate = -1;
        double minRate = Double.MAX_VALUE;

        // Find max and min rate
        for (int i = 0; i < jobTypeExisted.length; i++) {
            if (numberOfJobTypeExisted[i] == 0) continue; // skip to avoid division by zero
            double rate = (double) numberSuccessInterview[i] / numberOfJobTypeExisted[i];
            if (rate > maxRate) {
                maxRate = rate;
            }
            if (rate < minRate) {
                minRate = rate;
            }
        }

        // Collect job types that match those rates
        String maxRateTypes = "";
        String minRateTypes = "";

        for (int i = 0; i < jobTypeExisted.length; i++) {
            if (numberOfJobTypeExisted[i] == 0) continue;
            double rate = (double) numberSuccessInterview[i] / numberOfJobTypeExisted[i];

            if (Math.abs(rate - maxRate) < 0.0001) {
                if (!maxRateTypes.isEmpty()) maxRateTypes += ", ";
                maxRateTypes += jobTypeExisted[i];
            }
            if (Math.abs(rate - minRate) < 0.0001) {
                if (!minRateTypes.isEmpty()) minRateTypes += ", ";
                minRateTypes += jobTypeExisted[i];
            }
        }

        // === Summary ===
        System.out.println("Summary:");
        System.out.printf("Highest Applied (%d applications): %s\n", maxApplied, maxAppliedTypes);
        System.out.printf("Lowest Applied (%d applications): %s\n", minApplied, minAppliedTypes);
        System.out.printf("Highest Success Rate (%.2f%%): %s\n", maxRate * 100, maxRateTypes);
        System.out.printf("Lowest Success Rate (%.2f%%): %s\n", minRate * 100, minRateTypes);
    }
    
    private void generateAsciiChart(String[] jobTypes, int[] totalApps, int[] successApps) {
        int maxHeight = Math.max(getMax(totalApps), getMax(successApps));
        int colWidth = 5;

        for (int level = maxHeight; level >= 1; level--) {
            System.out.printf("%2d |", level);
            for (int i = 0; i < jobTypes.length; i++) {
                boolean isTotal = totalApps[i] >= level;
                boolean isSuccess = successApps[i] >= level;

                String symbol = repeatChar(' ', colWidth); // manually repeat spaces
                if (isSuccess) {
                    symbol = center(ANSI_RED + "*" + ANSI_RESET, colWidth);
                } else if (isTotal) {
                    symbol = center(ANSI_BLACK + "*" + ANSI_RESET, colWidth);
                }
                System.out.print(symbol);
            }
            System.out.println();
        }

        System.out.print("   +");
        for (int i = 0; i < jobTypes.length; i++) {
            System.out.print(repeatChar('-', colWidth)); // manually repeat '-'
        }
        System.out.println("+");

        System.out.print("    ");
        for (int i = 0; i < jobTypes.length; i++) {
            char label = (char) ('A' + i);
            System.out.print(center("(" + label + ")", colWidth));
        }
        System.out.println();

        System.out.println("\nDescription:");
        for (int i = 0; i < jobTypes.length; i++) {
            char label = (char) ('A' + i);
            System.out.println("(" + label + ") = " + jobTypes[i]);
        }
        System.out.println("\n" + ANSI_BLACK + "*" + ANSI_RESET + " = Total Applications");
        System.out.println(ANSI_RED + "*" + ANSI_RESET + " = Successful Interviews");
        System.out.println("X-axis: Job Type");
        System.out.println("Y-axis: Number of Applications");
    }

    private String center(String text, int width) {
        int textLen = text.replaceAll("\\u001B\\[[;\\d]*m", "").length();
        int padSize = (width - textLen) / 2;
        int extra = (width - textLen) % 2;
        if (padSize < 0) padSize = 0;
        return repeatChar(' ', padSize) + text + repeatChar(' ', padSize + extra);
    }

    private String repeatChar(char c, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private int getMax(int[] arr) {
        int max = 0;
        for (int val : arr) {
            if (val > max) max = val;
        }
        return max;
    }


    
    public String[] jobTypeExist() {
        String[] jobTypeList = new String[5]; 
        int typeCount = 0;

        for (int i = 1; i <= jobList.size(); i++) {
            String jobType = jobList.getData(i).getType();
            boolean exists = false;

            for (int j = 0; j < typeCount; j++) {
                if (jobTypeList[j] != null && jobTypeList[j].equalsIgnoreCase(jobType)) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                if (typeCount >= jobTypeList.length) {
                    jobTypeList = doubleStringArray(jobTypeList);
                }

                jobTypeList[typeCount++] = jobType;
            }
        }

        String[] trimmed = new String[typeCount];
        for (int i = 0; i < typeCount; i++) {
            trimmed[i] = jobTypeList[i];
        }
        return trimmed;
    }

    
}

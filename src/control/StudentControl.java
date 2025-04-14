/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

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

    private ListInterface<Company> companyList;
    private ListInterface<Student> studentList;
    private ListInterface<Skill> skillList;
    private ListInterface<Job> jobList;
    private ListInterface<Interview> interviewList;
    private StudentUI studentUI;
    private MatchingEngineControl matchControl;
    private StudentPortalControl studentPortalControl;

    public StudentControl() {
    }

    public StudentControl(ListInterface<Company> companyList, ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<Job> jobList,ListInterface<Interview> interviewList) {
        this.companyList = companyList;
        this.studentList = studentList;
        this.skillList = skillList;
        this.jobList = jobList;
        this.interviewList = interviewList;
        this.studentUI = new StudentUI(this);
//        this.matchControl = new MatchingEngineControl(studentList, jobPostList);
        
    }

    public StudentControl(ListInterface<Company> companyList, ListInterface<Student> studentList, ListInterface<Skill> skillList, ListInterface<Job> jobList,ListInterface<Interview> interviewList, StudentPortalControl studentPortalControl) {
        this.companyList = companyList;
        this.studentList = studentList;
        this.skillList = skillList;
        this.jobList = jobList;
        this.interviewList = interviewList;
        this.studentUI = new StudentUI(this);
//        this.matchControl = new MatchingEngineControl(studentList, jobPostList);
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
                case 6:
//                    matchControl.AdminMatchingRunner();

                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }

    public void studentOwnListing() {

        studentUI.studentListingUI();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-7s | %-30s | %-30s | %-5s | %-30s | %-30s | %-30s | %-15f | %-15f | %-30s | %-30s | %-40s | %-20s | %-70s |\n",
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
                convertArrayToString(studentPortalControl.getLoginStudent().getDesiredJobTypes())
        );
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void studentListing() {
        studentUI.studentListingUI();
        if (studentList.size() > 0) {

            for (Student student : studentList) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-7s | %-30s | %-30s | %-5s | %-30s | %-30s | %-30s | %-15f | %-15f | %-30s | %-30s | %-40s | %-20s | %-70s |\n",
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
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    
    private String convertSkillListToString(ListInterface<StudentSkill> skills) {
       StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= skills.size(); i++) {
            StudentSkill ss = skills.getData(i);
            sb.append("[").append("Name: ").append(ss.getSkill().getName())
            .append(" Proficiency Level: (").append(ss.getProficiencyLevel()).append(")]");
            if (i < skills.size()) {
                sb.append("\n");
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
                studentList.remove(studentPosition);
                studentListing();
                System.out.println("Student remove successfully!");
            } else {
                System.out.println("Failed to remove Student.");
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

}

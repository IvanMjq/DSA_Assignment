/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.*;
import adt.*;
import dao.*;
import entity.*;
import entity.Interview.InterviewStatus;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import utility.*;

/**
 *
 * @author Lim Zi Qi
 */
public class InterviewControl {
    
    private ListInterface<Interview> interviewList = new DoublyLinkedList<>();
    private ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
    private ListInterface<Company> companyList = new DoublyLinkedList();
    Scanner scanner = new Scanner(System.in);
    
    InterviewUI interviewUI = new InterviewUI();
    
    public InterviewControl(ListInterface<Interview> interviewList, ListInterface<Company> companyList) {
        this.interviewList = interviewList;
        this.companyList = companyList;
    }
    
    public void interviewMenu() {
        int choose;

        do {
            choose = interviewUI.interviewManagementMenu();

            switch (choose) {
                case 1:
                    interviewScheduling();
                    break;
                case 2:
                    viewInterview();
                    System.out.println("\nEnter any key to continue...");
                    scanner.nextLine();
                    break;
                case 3:
                    editInterview();
                    break;
                case 4:
                    removeInterview();
                    break;
                case 5:
                    interviewReportMenu();
                    break;
                case 6:
                    interviewRanking();
                    break;
                case 0:
                    System.out.println("\nExiting Interview Menu...");
                    break;
            }

        } while (choose != 0);
    }

    public void interviewScheduling() 
    {
        System.out.println("\t============================");
        System.out.println("\t   Interview Scheduling");
        System.out.println("\t============================");
        
        String id;
        
        if(interviewList.isEmpty())
        {
            System.out.println("No interview can remove");
            System.out.println("Enter any key to continue...");
            scanner.nextLine();
            return;
        }
        else
        {
            viewInterview();
            System.out.print("\nEnter the interview id you want schedule interview time: ");
            id = scanner.nextLine();
            
            if (id.equalsIgnoreCase("X")) 
            {
                System.out.println("\n\nExiting the Interview Scheduling...");
                scanner.nextLine();
                return; 
            }
            
            boolean interviewFound = false;
            
            for (int i = 1; i <= interviewList.size(); i++) 
            {
                Interview currentInterview = interviewList.getData(i);
                if (currentInterview.getId().equals(id)) 
                {
                    interviewFound = true;
                    System.out.println("Please select the interview date");
                    
                    int interviewDay = -1;
                    
                    while (true) 
                    {
                        try {
                            System.out.print("Select a day for the interview (1 = Monday, 2 = Tuesday, ..., 5 = Friday) or 0 to exit: ");
                            interviewDay = scanner.nextInt();
                            
                           if (interviewDay == 0) 
                           {
                                System.out.println("Interview scheduling cancelled.");
                                return;
                            }

                            if (interviewDay < 1 || interviewDay > 5) {
                                System.out.println("Invalid day. Please select a number between 1 (Monday) and 5 (Friday).");
                            } 
                            else 
                            {
                                Calendar calendar = Calendar.getInstance();
                                int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                                int difference = interviewDay - currentDayOfWeek;
                                if (difference < 0) {
                                    difference += 8;
                                }

                                calendar.add(Calendar.DAY_OF_YEAR, difference);
                                int year = calendar.get(Calendar.YEAR);
                                int month = calendar.get(Calendar.MONTH) + 1;
                                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                                Company currentCompany = currentInterview.getJobApplicationList().getData(1).getJobPosting().getCompany();

                                boolean validTime = false;
                                int hour = -1;
                                int minute = -1;
                                LocalDateTime localDateTime = null;

                                while (!validTime) 
                                {
                                    System.out.println("The interview time is between " + currentCompany.getInterviewStartTime() + " and " 
                                        + currentCompany.getInterviewEndTime() + ".");

                                    hour = timeValidation("Enter the time for the interview (hour): ", 0, 23);
                                    if (hour == 0) 
                                    {
                                        System.out.println("Exiting the interview scheduling...");
                                        interviewMenu();
                                        break;
                                    }

                                    minute = timeValidation("Enter the time for the interview (minute): ", 0, 59);
                                    if (minute == 0) {
                                        System.out.println("Exiting the interview scheduling...");
                                        interviewMenu();
                                        break;  // Exit the scheduling process if user enters 0
                                    }

                                    // Create the LocalTime for the interview
                                    LocalTime interviewTime = LocalTime.of(hour, minute);

                                    // Check if the interview time is within the company's interview hours
                                    if (isTimeSlotWithinInterviewHours(interviewTime, currentCompany)) {
                                        validTime = true; // Time is valid, break the loop
                                        System.out.println("Interview time is scheduled successful.");
                                        localDateTime = LocalDateTime.of(year, month, dayOfMonth, interviewTime.getHour(), interviewTime.getMinute(), interviewTime.getSecond());
                                        // Continue with the interview scheduling process here
                                    } else {
                                        System.out.println("Invalid time! The interview time must be between " 
                                            + currentCompany.getInterviewStartTime() + " and " 
                                            + currentCompany.getInterviewEndTime() + ". Please try again.");
                                    }
                                }
                                currentInterview.setScheduledDateTime(localDateTime);
                                interviewList.replace(i, currentInterview);
                                ListInterface<JobApplication> currentJobApplicationList = currentInterview.getJobApplicationList();

                                for(int p = 1; currentJobApplicationList.size() >= p; p++){
                                    currentJobApplicationList.getData(p).setInterview(currentInterview);
                                }

                                System.out.println("Interview successfully scheduled for Interview ID: " + currentInterview.getId());
                                System.out.println("\nPress any key to continue...");
                                scanner.nextLine();
                                interviewMenu();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number between 1 and 5.");
                            scanner.nextLine();
                        }
                    }
                } 
            }
            if (!interviewFound) 
            {
                System.out.println("\n\nInterview ID does not exist");
                scanner.nextLine();
                return;
            }
        }
    }
    
    // Remove an interview by ID
    public void removeInterview() {
        
        String id;
        
        if(interviewList.isEmpty())
        {
            System.out.println("No interview can remove");
            System.out.println("Enter any key to continue...");
            scanner.nextLine();
            return;
        }
        else
        {
            viewInterview();
            System.out.println("Enter the interview id that you want remove: ");
            id = scanner.nextLine();

            for (int i = 1; i <= interviewList.size(); i++) 
            {
                Interview currentInterview = interviewList.getData(i);
                if (currentInterview.getId().equals(id)) {
                    interviewList.remove(i);
                    System.out.print("Interview with ID " + id + " removed successfully.");
                    System.out.println("\nEnter any key to continue...");
                    scanner.nextLine();
                    return;
                }
                
            }
            
            System.out.println("Interview with ID " + id + " not found.");
            System.out.println("\nEnter any key to continue...");
            scanner.nextLine();
            return;
        }
    }

    // View an interview by ID
    public void viewInterview() 
    {
        if (interviewList.isEmpty()) 
        {
            System.out.println("No companies found.");
            return;
        } else 
        {
            interviewUI.displayInterviewHeader();

            for (Interview interview : interviewList) 
            {
                String scheduledDateTime = "";
                if (interview.getScheduledDateTime() != null) {
                    scheduledDateTime = interview.getScheduledDateTime().toLocalDate() + " " + interview.getScheduledDateTime().toLocalTime();
                } else {
                    scheduledDateTime = "Not scheduled";
                }

                System.out.printf("%-10s%-15s%-10s%-12s%-15s\n",
                        interview.getId(),
                        interview.getInterviewStatus(),
                        interview.getInterviewMark(),
                        scheduledDateTime.split(" ")[0],
                        scheduledDateTime.split(" ")[1]); 
            }
            return;
        }
    }
    
    public void editInterview()
    {
        String id;
        int interviewDay = -1;
        boolean interviewFound = false;
        
        if(interviewList.isEmpty())
        {
            System.out.println("No interview can edit");  
        }
        else
        {
            viewInterview();
            System.out.print("\n\nEnter the interview id that you want edit: ");
            id = scanner.nextLine();

            for (int i = 1; i <= interviewList.size(); i++) 
            {
                Interview currentInterview = interviewList.getData(i);

                if (currentInterview.getId().equals(id)) 
                {
                    interviewFound = true;
                    int choose;

                    do {
                        choose = interviewUI.interviewEditMenu();

                        switch (choose) {
                            case 1:
                                while (true) 
                                {
                                    try {
                                        System.out.print("Select a day for the interview (1 = Monday, 2 = Tuesday, ..., 5 = Friday) or enter 0 to cancel: ");
                                        interviewDay = scanner.nextInt();
                                        
                                        // Check if the input is valid
                                        if (interviewDay == 0) {
                                            System.out.println("Interview edit is cancelled.");
                                            return; 
                                        }
                                        
                                        if (interviewDay < 1 || interviewDay > 5) 
                                        {
                                            System.out.println("Invalid day. Please select a number between 1 (Monday) and 5 (Friday).");
                                        }
                                        else
                                        {
                                            Calendar calendar = Calendar.getInstance();
                                            int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                                            int difference = interviewDay - currentDayOfWeek;

                                            if (difference < 0) {
                                                difference += 8;
                                            }

                                            calendar.add(Calendar.DAY_OF_YEAR, difference);
                                            int year = calendar.get(Calendar.YEAR);
                                            int month = calendar.get(Calendar.MONTH) + 1;
                                            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                                            LocalDateTime currentDateTime = currentInterview.getScheduledDateTime();
                                            LocalDateTime newScheduledDateTime = LocalDateTime.of(year, month, dayOfMonth, currentDateTime.getHour(), currentDateTime.getMinute(), currentDateTime.getSecond());

                                            if (checkTimeSlotAvailability(newScheduledDateTime)) 
                                            {
                                                currentInterview.setScheduledDateTime(newScheduledDateTime);
                                                ListInterface<JobApplication> currentJobApplicationList = currentInterview.getJobApplicationList();

                                                for(int p = 1; currentJobApplicationList.size() >= p; p++){
                                                    currentJobApplicationList.getData(p).setInterview(currentInterview);
                                                }
                                                
                                                interviewList.replace(i, currentInterview);
                                                System.out.println("Interview date edit successfully.");
                                                return;
                                            } else {
                                                System.out.println("The time slot is not available. Please choose a different time.");
                                            }
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a number between 1 and 5 or 0 to cancel.");
                                        scanner.nextLine();
                                    }
                                }
                                
                                
                            case 2:
                                
                                int hour = -1, minute = -1;
                                
                                LocalDateTime currentDateTime = currentInterview.getScheduledDateTime();
                                
                                 while (true) {
                                    // Ask for hour input
                                    while (hour == -1) {
                                        System.out.print("Enter the new interview hour (0 to cancel): ");
                                        try {
                                            hour = scanner.nextInt();
                                            scanner.nextLine();  // Consume newline
                                            if (hour == 0) {
                                                System.out.println("Edit canceled. Returning to the previous menu.");
                                                return;  // Exit if user chooses to cancel
                                            } else if (hour < 0 || hour > 23) {
                                                System.out.println("Invalid hour. Please enter a valid hour (0-23).");
                                                hour = -1;  // Reset hour if invalid
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("Invalid input. Please enter an integer for the hour.");
                                            scanner.nextLine(); // Consume invalid input
                                        }
                                    }

                                    // Ask for minute input
                                    while (minute == -1) {
                                        System.out.print("Enter the new interview minute (0 to cancel): ");
                                        try {
                                            minute = scanner.nextInt();
                                            scanner.nextLine();  // Consume newline
                                            if (minute == 0) {
                                                System.out.println("Edit canceled. Returning to the previous menu.");
                                                return;  // Exit if user chooses to cancel
                                            } else if (minute < 0 || minute > 59) {
                                                System.out.println("Invalid minute. Please enter a valid minute (0-59).");
                                                minute = -1;  // Reset minute if invalid
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("Invalid input. Please enter an integer for the minute.");
                                            scanner.nextLine(); // Consume invalid input
                                        }
                                    }

                                    LocalDateTime newScheduledDateTime = LocalDateTime.of(currentDateTime.toLocalDate(), LocalTime.of(hour, minute));

                                    if (checkTimeSlotAvailability(newScheduledDateTime)) {
                                        
                                        currentInterview.setScheduledDateTime(newScheduledDateTime);
                                        ListInterface<JobApplication> currentJobApplicationList = currentInterview.getJobApplicationList();

                                        for(int p = 1; currentJobApplicationList.size() >= p; p++){
                                            currentJobApplicationList.getData(p).setInterview(currentInterview);
                                        }

                                        interviewList.replace(i, currentInterview);
                                        System.out.println("Interview time edited successfully.");      
                                        break;
                                    } else {
                                        System.out.println("The time slot is not available. Please choose a different time.");
                                        hour = -1;
                                        minute = -1;
                                    }
                                }  
                                break;
                            case 0:
                                System.out.println("Returning to Interview Menu...");
                                scanner.nextLine();
                                interviewMenu();
                                break;
                        }

                    } while (choose != 0);
                }
            }
            if (!interviewFound) 
            {
                System.out.println("\n\nInterview ID does not exist");
                System.out.println("\nPress any key to continue...");
                scanner.nextLine();
                return;
            }
        }
    }

    // Generate an interview report
    
    public void generateInterviewReport() 
    {
        if (interviewList.isEmpty()) {
            System.out.println("No interviews available.");
            return;
        }

        System.out.println("\n===== Successful Candidates =====");
        boolean foundSuccessful = false;
        for (int i = 1; i <= interviewList.size(); i++) {
            Interview currentInterview = interviewList.getData(i);
            if (currentInterview.getInterviewStatus() == Interview.InterviewStatus.OFFERED) {
                foundSuccessful = true;
                System.out.println("Interview ID: " + currentInterview.getId());
                System.out.println("Scheduled Time: " + currentInterview.getScheduledDateTime());
                System.out.println("Status: " + currentInterview.getInterviewStatus());
                System.out.println("Interview Mark: " + currentInterview.getInterviewMark());
                
                System.out.println("Applicant(s):");

                for (JobApplication jobApplication : currentInterview.getJobApplicationList()) {
                    Student student = jobApplication.getStudent();
                    Company company = jobApplication.getJobPosting().getCompany();
                    String jobType = jobApplication.getJobPosting().getJob().getType();

                    System.out.println("\t- Student Name: " + student.getName());
                    System.out.println("\t- Company Name: " + company.getName());
                    System.out.println("\t- Job Type: " + jobType + "\n");
                }

                System.out.println("---------------------------");
            }
        }

        if (!foundSuccessful) {
            System.out.println("No successful candidates found.");
        }
    }

    
    public void generateDescendingInterviewReport() {
        
        if (interviewList.isEmpty()) {
            System.out.println("No interviews available.");
            return;
        }else
        {
            ListInterface<Interview> interviewCopy = new DoublyLinkedList<>();
            for (int i = 1; i <= interviewList.size(); i++) 
            {
                interviewCopy.add(interviewList.getData(i));
            }
            Comparator<Interview> interviewMarkComparator = new Comparator<Interview>() 
            {
                public int compare(Interview interview1, Interview interview2) 
                {
                    return Integer.compare(interview2.getInterviewMark(), interview1.getInterviewMark());
                }
            };

            // Sort the interview list by interview mark (descending order)
            interviewCopy.bubbleSort(interviewMarkComparator);

            System.out.println("\n===== Sorted Interview Report (Ranked by Interview Marks) =====");
            for (int i = 1; i <= interviewCopy.size(); i++) {
                Interview currentInterview = interviewCopy.getData(i);
                System.out.println("Rank " + (i) + ":");
                System.out.println("Interview ID: " + currentInterview.getId());
                System.out.println("Scheduled Time: " + currentInterview.getScheduledDateTime());
                System.out.println("Status: " + currentInterview.getInterviewStatus());
                System.out.println("Interview Mark: " + currentInterview.getInterviewMark());
                
                System.out.println("Applicant(s):");

                for (JobApplication jobApplication : currentInterview.getJobApplicationList()) {
                    Student student = jobApplication.getStudent();
                    Company company = jobApplication.getJobPosting().getCompany();
                    String jobType = jobApplication.getJobPosting().getJob().getType();

                    System.out.println("\t- Student Name: " + student.getName());
                    System.out.println("\t- Company Name: " + company.getName());
                    System.out.println("\t- Job Type: " + jobType + "\n");
                }

                System.out.println("---------------------------");
            }
        }
    }
    
    public void generateAscendingSortedInterviewReport() 
    {
        if (interviewList.isEmpty()) {
            System.out.println("No interviews available.");
            return;
        }else
        {
            ListInterface<Interview> interviewCopy = new DoublyLinkedList<>();
            for (int i = 1; i <= interviewList.size(); i++) 
            {
                interviewCopy.add(interviewList.getData(i));
            }
            Comparator<Interview> interviewMarkComparator = new Comparator<Interview>() {
            @Override
            public int compare(Interview interview1, Interview interview2) {
                return Integer.compare(interview1.getInterviewMark(), interview2.getInterviewMark());
                }
            };

            interviewCopy.bubbleSort(interviewMarkComparator);

            System.out.println("===== Sorted Interview Report (Ranked by Interview Marks - Ascending) =====");
            for (int i = 1; i <= interviewCopy.size(); i++)
            {
                Interview currentInterview = interviewCopy.getData(i);

                System.out.println("Rank " + (i) + ":");
                System.out.println("Interview ID: " + currentInterview.getId());
                System.out.println("Scheduled Time: " + currentInterview.getScheduledDateTime());
                System.out.println("Status: " + currentInterview.getInterviewStatus());
                System.out.println("Interview Mark: " + currentInterview.getInterviewMark());

                System.out.println("Applicant(s):");

                for (JobApplication jobApplication : currentInterview.getJobApplicationList()) {
                    Student student = jobApplication.getStudent();
                    Company company = jobApplication.getJobPosting().getCompany();
                    String jobType = jobApplication.getJobPosting().getJob().getType();

                    System.out.println("\t- Student Name: " + student.getName());
                    System.out.println("\t- Company Name: " + company.getName());
                    System.out.println("\t- Job Type: " + jobType + "\n");
                }

                System.out.println("---------------------------");
            }
        }
    }
    
    public void interviewStatusDistributionGraph() 
    {
        ListInterface<String> interviewStatuses = new DoublyLinkedList<>();
        ListInterface<Integer> statusCounts = new DoublyLinkedList<>();

        // Count the applicants based on interview status
        for (int i = 1; i <= interviewList.size(); i++) {
            Interview currentInterview = interviewList.getData(i);
            String status = currentInterview.getInterviewStatus().toString();

            int foundIndex = -1;

            // Check if the status already exists in the list
            for (int j = 1; j <= interviewStatuses.size(); j++) {
                if (interviewStatuses.getData(j).equals(status)) {
                    foundIndex = j;
                    break;
                }
            }

            if (foundIndex == -1) {
                interviewStatuses.add(status);
                statusCounts.add(1);  // Initialize with 1 applicant for this status
            } else {
                int current = statusCounts.getData(foundIndex);
                statusCounts.replace(foundIndex, current + 1);  // Increment the count
            }
        }

        // Find max count to scale the graph
        int max = 0;
        for (int i = 1; i <= statusCounts.size(); i++) {
            if (statusCounts.getData(i) > max) {
                max = statusCounts.getData(i);
            }
        }

        System.out.println("======================================================================");
        System.out.println("Vertical Distribution of Applicants by Interview Status");
        System.out.println("======================================================================");

        System.out.printf("%4s\n", "^");

        // Print vertical bars using assigned characters
        for (int level = max; level >= 1; level--) {
            System.out.printf("%2d |", level);
            for (int i = 1; i <= statusCounts.size(); i++) {
                if (statusCounts.getData(i) >= level) {
                    System.out.print("   *   ");
                } else {
                    System.out.print("       ");
                }
            }
            System.out.println();
        }

        // X-axis
        System.out.print("   +");
        for (int i = 1; i <= interviewStatuses.size(); i++) {
            System.out.print("-------");
        }
        System.out.println();

        // Print character labels (status names)
        System.out.print("     ");
        for (int i = 1; i <= interviewStatuses.size(); i++) {
            System.out.printf("   %d   ", i);
        }
        System.out.println();

        // Print legend
        System.out.println("\nLegend:");
        for (int i = 1; i <= interviewStatuses.size(); i++) {
            System.out.printf("  %d = %s\n", i, interviewStatuses.getData(i));
        }

        System.out.println("======================================================================");
    }
    
    public void interviewReportMenu() {
        int choose;

        do {
            choose = interviewUI.reportMenu();

            switch (choose) {
                case 1:
                    interviewStatusDistributionGraph();
                    generateInterviewReport();
                    break;
                case 2:
                    interviewStatusDistributionGraph();
                    generateAscendingSortedInterviewReport();
                    break;
                case 3:
                    interviewStatusDistributionGraph();
                    generateDescendingInterviewReport();
                    break;
                case 0:
                    System.out.println("\nReturning to Interview Edit Menu...");
                    break;
                default:
                    System.out.println("Invalid option selected! Please try again.");
            }
        } while (choose != 0);
    }
    
    public void interviewRanking() 
    {
        System.out.println("\t==============================");
        System.out.println("\t   Interview Ranking");
        System.out.println("\t==============================");

        viewInterview();
        System.out.println("Enter the interview ID you want to rank: ");
        String id = scanner.nextLine();

        if (interviewList.isEmpty()) {
            System.out.println("No interviews available.");
            return;
        } else {
            boolean interviewFound = false;

            for (int i = 1; i <= interviewList.size(); i++) {
                Interview currentInterview = interviewList.getData(i);

                if (currentInterview.getId().equals(id)) {
                    interviewFound = true;

                    int result = -1;

                    while (true) {
                        try {
                            System.out.print("Enter the result for the interview (0-100): ");
                            result = scanner.nextInt();

                            if (result < 0 || result > 100) {
                                System.out.print("Invalid input. Please enter a number between 0 and 100.");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("Invalid input. Please enter a valid number between 0 and 100.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                    }

                    // Set the interview mark
                    currentInterview.setInterviewMark(result);

                    // If the result is below 50, set the status to REJECTED, otherwise, set to OFFERED
                    if (result < 50) {
                        currentInterview.setInterviewStatus(Interview.InterviewStatus.REJECTED);
                        System.out.println("Interview ranking updated to: " + result + ". The candidate is REJECTED.");
                    } else {
                        currentInterview.setInterviewStatus(Interview.InterviewStatus.OFFERED);
                        System.out.println("Interview ranking updated to: " + result + ". The candidate is OFFERED.");
                    }

                    // Replace the updated interview in the list
                    interviewList.replace(i, currentInterview);

                    // Now, update the interview in the job application list
                    ListInterface<JobApplication> jobApplicationList = currentInterview.getJobApplicationList();
                    for (int p = 1; p <= jobApplicationList.size(); p++) {
                        JobApplication jobApplication = jobApplicationList.getData(p);
                        jobApplication.setInterview(currentInterview);  // Set the interview for each job application
                    }

                    System.out.println("Interview ranking and status updated successfully.");
                    scanner.nextLine();
                    return;
                }
            }

            if (!interviewFound) {
                System.out.println("Interview with ID " + id + " not found.");
                scanner.nextLine();
                return;
            }
        }
    }

    
    public boolean checkTimeSlotAvailability(LocalDateTime localDateTime) 
    {
        int numberOfInterviewer = 0;

        for (Interview interviewer : interviewList) {
            if (interviewer.getScheduledDateTime().equals(localDateTime)) {
                numberOfInterviewer++;
            }
        }

        if (numberOfInterviewer >= 3) {
            return false;
        }else{
            return true;
        }
    }
    
    public boolean isTimeSlotWithinInterviewHours(LocalTime interviewTime, Company company) {
    
        LocalTime interviewStart = company.getInterviewStartTime();
        LocalTime interviewEnd = company.getInterviewEndTime();
        
        
        if (interviewTime.isAfter(interviewStart) && interviewTime.isBefore(interviewEnd)) {
        return true;
        } else 
        {
            System.out.println("Interview time is outside the company's allowed range.");
            return false;
        }
    }
    
    private int timeValidation(String prompt, int minValue, int maxValue) 
    {
        int value = -1;
        
        while (value < minValue || value > maxValue) 
        {
            System.out.print(prompt);

            // Check if the input is an integer
            try {
                value = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (value == 0) {
                    return 0;  // Exit condition if user enters 0
                }

                // Validate input range
                if (value < minValue || value > maxValue) {
                    System.out.println("Invalid input. Please enter a number between " + minValue + " and " + maxValue + ".");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume invalid input
            }
        }

        return value;
    }

}

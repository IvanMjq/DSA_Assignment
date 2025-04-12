/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.JobApplication;
import entity.Interview;
import entity.Interview.InterviewStatus;
import java.util.Scanner;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.time.LocalTime;
import java.time.LocalDateTime;

/**
 *
 * @author Lim Zi Qi
 */

public class InterviewSchedulingControl {
    
    private ListInterface<Interview> interviewList = new DoublyLinkedList<>();
    private ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
    static int count = 1;
    Scanner scanner = new Scanner(System.in);
    Interview interview = new Interview();

    //Get the student need to schedule the interview and also the all of the studentlist
    public void interviewScheduling(ListInterface<JobApplication> jobApplicationList, JobApplication jobApplicant, LocalTime timeSlot){
    
        System.out.println("============================");
        System.out.println("   Interview Scheduling");
        System.out.println("============================/n");

//Get the interview day
        for (int i = 0; jobApplicationList.size() > i; i++) {
            
            JobApplication currentJobApplication = jobApplicationList.getData(i);
            
            if(jobApplicant.getId().equals(currentJobApplication.getId()))
            {
                
                System.out.println("Please select the interview date");

                int interviewDay = -1;

                while (true) 
                {
                    try 
                    {
                        System.out.println("Select a day for the interview (1 = Monday, 2 = Tuesday, ..., 5 = Friday): ");
                        interviewDay = scanner.nextInt();
                        if (interviewDay < 1 || interviewDay > 5) 
                        {
                            System.out.println("Invalid day. Please select a number between 1 (Monday) and 5 (Friday).");
                        } else 
                        {
                            break;
                        }
                    } catch (InputMismatchException e) 
                    {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                        scanner.nextLine();
                    }
                }
            
                Calendar calendar = Calendar.getInstance();
                int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                int difference = interviewDay - currentDayOfWeek;
                
                if (difference < 0) 
                {
                    difference += 7;
                }
            
                //add the date to the booking date by adding diffrence
                calendar.add(Calendar.DAY_OF_YEAR, difference);

                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                
                LocalDateTime localDateTime = LocalDateTime.of(year, month, dayOfMonth, 
                                                       timeSlot.getHour(), 
                                                       timeSlot.getMinute(), 
                                                       timeSlot.getSecond());
                
                // Schedule Interview
                Interview interviewer = new Interview(localDateTime, InterviewStatus.INTERVIEW_SCHEDULED, 0);

                // Save the scheduled interview for conflict checking
                interviewList.add(interviewer);
                currentJobApplication.setInterview(interviewer);
                boolean isReplaced = jobApplicationList.replace(i, currentJobApplication);
                
                if (isReplaced) {
                    System.out.println("Interview successfully scheduled for Job Application ID: " + currentJobApplication.getId());
                } else {
                    System.out.println("Failed to schedule the interview for Job Application ID: " + currentJobApplication.getId());
                }
            }
        }
    }
    
    public void interviewRanking(ListInterface<JobApplication> jobApplicationList, JobApplication jobApplicant){
        
        int result = -1;
        
        while (true) 
        {
            try 
            {
                System.out.println("Enter the result for the interview: ");
                result = scanner.nextInt();
                if (result < 0 || result > 100) {
                    System.out.println("Invalid day. Please select a number between 0 and 100.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
                scanner.nextLine();
            }
        }
        
        interview.setInterviewMark(result);
        
    }

/*
    // Method to check if a time slot is available
    private boolean isTimeSlotAvailable(Calendar calendar, LocalTime timeSlot) {
        // Check if the given time slot already exists for the selected day
        int person = 0;
        String key = calendar.getTime().toString() + timeSlot;
        return !scheduledInterviews.containsKey(key);
    }


    public void interviewTimesReport() {
        interviewList.put(calendar.getTime().toString() + timeSlot, interview);
        System.out.println("Interview scheduled for " + calendar.getTime() + " at " + timeSlot);
        
        
    }
*/
}


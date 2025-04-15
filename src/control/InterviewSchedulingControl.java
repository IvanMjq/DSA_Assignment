/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import entity.*;
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

    public void interviewScheduling(ListInterface<Student> studentList, JobApplication jobApplicant, LocalTime timeSlot) 
    {

        System.out.println("============================");
        System.out.println("   Interview Scheduling");
        System.out.println("============================");

        for (int i = 0; i < studentList.size(); i++) 
        {
            Student currentStudent = studentList.getData(i);

            if (jobApplicant.getStudent().getId().equals(currentStudent.getId())) {
                System.out.println("Job Application found for student: " + currentStudent.getName());

                System.out.println("Please select the interview date");

                int interviewDay = -1;
                while (true) {
                    try {
                        System.out.println("Select a day for the interview (1 = Monday, 2 = Tuesday, ..., 5 = Friday): ");
                        interviewDay = scanner.nextInt();
                        if (interviewDay < 1 || interviewDay > 5) {
                            System.out.println("Invalid day. Please select a number between 1 (Monday) and 5 (Friday).");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                        scanner.nextLine();
                    }
                }

                Calendar calendar = Calendar.getInstance();
                int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                int difference = interviewDay - currentDayOfWeek;
                if (difference < 0) {
                    difference += 7;
                }

                calendar.add(Calendar.DAY_OF_YEAR, difference);
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                LocalDateTime localDateTime = LocalDateTime.of(year, month, dayOfMonth, timeSlot.getHour(), timeSlot.getMinute(), timeSlot.getSecond());

                boolean isTimeSlotAvailable = checkTimeSlotAvailability(localDateTime);
                if (!isTimeSlotAvailable) {
                    System.out.println("This time slot is already taken. Please select another time.");
                    return;
                }

                Interview interviewer = new Interview("itv" + count++, localDateTime, Interview.InterviewStatus.INTERVIEW_SCHEDULED, 0);

                interviewList.add(interviewer);
                jobApplicant.setInterview(interviewer);

                boolean isReplaced = jobApplicationList.replace(i, jobApplicant);

                if (isReplaced) {
                    System.out.println("Interview successfully scheduled for Job Application ID: " + jobApplicant.getStudent().getId());
                } else {
                    System.out.println("Failed to schedule the interview for Job Application ID: " + jobApplicant.getStudent().getId());
                }
            }
        }
    }
    
    public void interviewRanking(ListInterface<JobApplication> jobApplicationList, JobApplication jobApplicant) 
    {
        for (int i = 0; i < jobApplicationList.size(); i++) {
            JobApplication currentJobApplication = jobApplicationList.getData(i);

            if (currentJobApplication.getStudent().getId().equals(jobApplicant.getStudent().getId())) {

                Interview interview = currentJobApplication.getInterview();

                if (interview != null) {
                    
                    int result = -1;
                    while (true) {
                        try {
                            System.out.println("Enter the result for the interview (0-100): ");
                            result = scanner.nextInt();

                            if (result < 0 || result > 100) {
                                System.out.println("Invalid input. Please enter a number between 0 and 100.");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number between 0 and 100.");
                            scanner.nextLine();
                        }
                    }

                    interview.setInterviewMark(result);
                    currentJobApplication.getInterview().setInterviewMark(result);

                    boolean isReplaced = jobApplicationList.replace(i, currentJobApplication);

                    if (isReplaced) {
                        System.out.println("Interview ranking updated to: " + result);
                    } else {
                        System.out.println("Failed to update interview ranking for Job Application ID: " + jobApplicant.getStudent().getId());
                    }
                    return;
                } else {
                    System.out.println("No interview found for this job application.");
                    return;
                }
            }
        }
        System.out.println("No job application found for student with ID: " + jobApplicant.getStudent().getId());
    }
    
    // Method to check if the time slot is available
    private boolean checkTimeSlotAvailability(LocalDateTime localDateTime) 
    {
        int numberOfInterviewer = 0;

        for (Interview interview : interviewList) {
            if (interview.getScheduledDateTime().equals(localDateTime)) {
                numberOfInterviewer++;
            }
        }

        if (numberOfInterviewer >= 3) {
            return false;
        }

        return true;
    }
/*
     Method to check if a time slot is available
    private boolean isTimeSlotAvailable(Calendar calendar, LocalTime timeSlot) {
         Check if the given time slot already exists for the selected day
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


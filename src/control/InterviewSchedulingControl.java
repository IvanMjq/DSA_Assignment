/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.JobApplication;
import entity.Interview;
import java.util.Scanner;
import java.util.Calendar;
import java.util.InputMismatchException;

/**
 *
 * @author Lim Zi Qi
 */

public class InterviewSchedulingControl {
    
    private ListInterface<Interview> Interview = new DoublyLinkedList<>();
    private ListInterface<JobApplication> JobApplication = new DoublyLinkedList<>();
    static int count = 1;
    Scanner scanner = new Scanner(System.in);
    Interview interview = new Interview();
    JobApplication jobApply = new JobApplication();
    

    public void interviewScheduling(MatchingResult matchingResult){
    
        System.out.println("============================");
        System.out.println("   Interview Scheduling");
        System.out.println("============================/n");

//Get the interview day
        for (int i = 0; i < matchingResult.size(); i++) {
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
            
            //add the date to the booking date by adding diffrence
            calendar.add(Calendar.DAY_OF_YEAR, difference);

/*
// Booking time slot
            String timeSlot = null;
            while (true) {
                System.out.println("Select a time for the interview (e.g., 09:00 AM, 10:00 AM, etc.): ");
                timeSlot = scanner.next();
                if (!isTimeSlotAvailable(calendar, timeSlot)) {
                    System.out.println("Time slot " + timeSlot + " is already taken. Please choose a different time.");
                } else {
                    break;
                }
            }
*/

// Schedule Interview

            interview.setScheduledDate(calendar.getTime());
            interview.setTimeSlot(timeSlot);
            Interview.add(interview);

            // Save the scheduled interview for conflict checking
            scheduledInterviews.put(calendar.getTime().toString() + timeSlot, interview);
            System.out.println("Interview scheduled for " + calendar.getTime() + " at " + timeSlot);
        }
    }
    
    public void interviewRanking(){
        
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

    // Method to check if a time slot is available
    private boolean isTimeSlotAvailable(Calendar calendar, String timeSlot) {
        // Check if the given time slot already exists for the selected day
        String key = calendar.getTime().toString() + timeSlot;
        return !scheduledInterviews.containsKey(key);
    }

    public void interviewTimesReport() {

        
        
    }
}


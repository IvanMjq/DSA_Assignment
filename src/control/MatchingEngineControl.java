/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.MatchingUI;
import entity.JobPosting;
import entity.JobRequirementSkill;
import entity.MatchingResult;
import entity.MatchingResult.ExperienceCheck;
import entity.Student;
import entity.StudentSkill;

/**
 *
 * @author WEI ZHENG
 */
public class MatchingEngineControl {
    private MatchingUI matchingUI;
    private ListInterface<Student> studentList;
    private ListInterface<JobPosting> jobPostList;
    private ListInterface<MatchingResult> matchResults = new DoublyLinkedList<>();

    
    public MatchingEngineControl(ListInterface<Student> studentList, ListInterface<JobPosting> jobPostList){
        this.matchingUI = new MatchingUI(this);
        this.studentList = studentList;
        this.jobPostList = jobPostList;
    }
    
    
    public void matchStudentsToJobs() {
        
        for (int i = 1; i <= studentList.size() ; i++){
            Student student = studentList.getData(i);
            for(int j = 1; j <= jobPostList.size(); j++){
                JobPosting jobPost = jobPostList.getData(j);
                double totalScore = 0;
                for(int k = 1; k <= student.getSkillList().size(); k++){
                    StudentSkill studentSkill = student.getSkillList().getData(k);
                    for(int l =  1; l <= jobPost.getSkillRequired().size(); l++ ){
                        JobRequirementSkill skillRequired = jobPost.getSkillRequired().getData(l);
                        if (studentSkill.getSkill().equals(skillRequired.getSkill())) {
                            totalScore += calculateScore(studentSkill, skillRequired, totalScore);
                        }
                    }
                }
                if (totalScore > 0) {
                    ExperienceCheck experienceStatus = checkExperience(student, jobPost);
                    double distance = calculateDistance(student.getLatitude(),student.getLongitude(),jobPost.getCompany().getLatitude(), jobPost.getCompany().getLongitude());
                    MatchingResult matchingResult = new MatchingResult(student, jobPost, totalScore, experienceStatus, distance);
                    matchResults.add(matchingResult);
                }
                else{
                    System.out.println("No Job match to you");
                }
            }
            
        }
    }
    
    
    public double calculateScore(StudentSkill studentSkill, JobRequirementSkill skillRequired, double totalScore){
        return (studentSkill.getProficiencyLevel()/ 5.0)* skillRequired.getImportance();  
    }
    
    public ExperienceCheck checkExperience(Student student, JobPosting jobPost) {
       // Compare student's years of experience with the job's required experience
       int studentExperience = student.getYearsOfExperience();  // Assuming there's a method to get years of experience
       int jobExperience = jobPost.getRequiredExperience();      // Assuming there's a method to get required experience

       // Experience match status logic
       if (studentExperience < jobExperience) {
           return ExperienceCheck.Not_Experienced;  // Not suitable for the job
       } else if (studentExperience == jobExperience) {
           return ExperienceCheck.Qualified;        // Exactly matches the job's requirement
       } else {
           return ExperienceCheck.Very_Experienced; // Exceeds the job's requirement
       }
   }
    
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Radius of the Earth in kilometers
        final int R = 6371;

        // Convert degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Differences in latitudes and longitudes
        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        // Haversine formula
        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distance in kilometers
        return R * c;
    }
    
    
    
    
    public void listScoresForStudent(Student student) {
        if (matchResults.isEmpty()) {
            System.out.println("No match results found for student " + student.getName() + " (" + student.getId() + ").");
            return;
        }

        // Display the header
        System.out.println("============================================================================================================");
        System.out.println("Match Scores for Student: " + student.getName() + " (" + student.getId() + ")" );
        System.out.println("============================================================================================================");
        System.out.printf("%-20s %-50s %-10s %-20s %-15s%n", "Job Post ID", "Job Title", "Score", "Experience Status", "Distance (km)");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        // Display each match result
        for (int i = 1; i <= matchResults.size(); i++) {
                MatchingResult result = matchResults.getData(i);
                JobPosting job = result.getJobPosting(); 
                ExperienceCheck experienceStatus = result.getExperiencedCheck(); // Get experience status
                double distance = result.getDistance(); // Get the distance
                System.out.printf("%-20s %-50s %-10.2f %-20s %-15.2f%n", 
                                  job.getId(), 
                                  job.getJob().getTitle(), 
                                  result.getScore(), 
                                  experienceStatus,
                                  distance); // Print the distance
        }
    }

    public void MatchingRunner(Student student){
        int choice = 0;
        do{
//           getMatchResult().clear();
           choice = matchingUI.MatchingMenu(student);
        }while(choice != 0);
    }

    public ListInterface<MatchingResult> getMatchResults() {
        return matchResults;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.MatchingUI;
import control.MatchingResult.ExperienceCheck;
import entity.JobPosting;
import entity.JobRequiredSkill;
import entity.Student;
import entity.StudentSkill;
import java.io.Serializable;

/**
 *
 * @author WEI ZHENG
 */
public class MatchingEngineControl {
    private MatchingUI matchingUI;
    private ListInterface<Student> studentList = new DoublyLinkedList<>();
    private ListInterface<JobPosting> jobPostList = new DoublyLinkedList<>();
    private ListInterface<StudentSkill> studentSkill = new DoublyLinkedList<>();
    private ListInterface<JobRequiredSkill> jobRequiredSkill = new DoublyLinkedList<>();
    private ListInterface<MatchingResult> matchResults = new DoublyLinkedList<>();

    
    public MatchingEngineControl(ListInterface<StudentSkill> studentSkill, ListInterface<JobRequiredSkill> jobRequiredSkill, ListInterface<Student> studentList, ListInterface<JobPosting> jobPostList){
        this.matchingUI = new MatchingUI(this);
        this.studentSkill = studentSkill;
        this.jobRequiredSkill = jobRequiredSkill;
        this.studentList = studentList;
        this.jobPostList = jobPostList;
    }
    
    
    
        public void matchStudentsToJobs(String studentId) {
            for (int i = 1; i <= studentSkill.size(); i++) {
                StudentSkill stdSkill = studentSkill.getData(i);

                if (stdSkill.getStudent().getId().equals(studentId)) {

                    double totalScore = 0;

                    // Match this student's skill with required job skills
                    for (int j = 1; j <= jobRequiredSkill.size(); j++) {
                        JobRequiredSkill requiredSkill = jobRequiredSkill.getData(j); 
                        if (stdSkill.getSkill().equals(requiredSkill.getSkill())) {
                            totalScore += calculateScore(stdSkill.getProficiencyLevel(), requiredSkill.getImportance());
                        }
                        
                    }

                    if (totalScore > 0) {
                        Student student = stdSkill.getStudent();

                        
                        for (int k = 1; k <= jobPostList.size(); k++) {
                            JobPosting jobPost = jobPostList.getData(k);
                                
                                ExperienceCheck experienceStatus = checkExperience(student, jobPost);

                                
                                double distance = calculateDistance(
                                        student.getLatitude(),
                                        student.getLongitude(),
                                        jobPost.getCompany().getLatitude(),
                                        jobPost.getCompany().getLongitude()
                                );
                                MatchingResult matchingResult = new MatchingResult(student, jobPost, totalScore, experienceStatus, distance);
                                matchResults.add(matchingResult);
                            
                        }
                    } else {
                        System.out.println("No job matched for student ID: " + studentId);
                    }
                }
            }
        }
//        matchResults.clear();
//        for (int i = 1; i <= studentSkill.size() ; i++){
//            StudentSkill stdSkill = studentSkill.getData(i);
//            if(stdSkill.getStudent().getId().equals(studentId)){
//                double totalScore = 0;
//                Student student = stdSkill.getStudent();
//                for(int j = 1; j <= jobRequiredSkill.size(); j++){
//                   
//                    JobRequiredSkill requiredSkill = jobRequiredSkill.getData(j);
//                    JobPosting jobPost = requiredSkill.getJobPost();
//                    if(stdSkill.getSkill().equals(requiredSkill.getSkill())){
//                        totalScore += calculateScore(stdSkill.getProficiencyLevel(), requiredSkill.getImportance());
//                    }
//                    
//                    if(totalScore > 0){
//                        
//                        MatchingResult.ExperienceCheck experienceStatus = checkExperience(studentList.getData(i), jobPostList.getData(j));
//                        double distance = calculateDistance(studentList.getData(i).getLatitude(), studentList.getData(i).getLongitude(),
//                                                            jobPostList.getData(j).getCompany().getLatitude(), jobPostList.getData(j).getCompany().getLongitude());
//                        MatchingResult result = new MatchingResult(student, jobPost, totalScore, experienceStatus, distance);
//                        matchResults.add(result);
//                    }
//                    else{
//                        System.out.println("No Job Match with You");
//                    }
//                
//                }
//            
//            }
//            
//        }
      
    
    
    //    public void matchStudentsToJobs() {
//        
//        for (int i = 1; i <= studentList.size() ; i++){
//            Student student = studentList.getData(i);
//            for(int j = 1; j <= jobPostList.size(); j++){
//                JobPosting jobPost = jobPostList.getData(j);
//                double totalScore = 0;
//                for(int k = 1; k <= student.getSkillList().size(); k++){
//                    StudentSkill studentSkill = student.getSkillList().getData(k);
//                    for(int l =  1; l <= jobPost.getSkillRequired().size(); l++ ){
//                        JobRequiredSkill skillRequired = jobPost.getSkillRequired().getData(l);
//                        if (studentSkill.getSkill().equals(skillRequired.getSkill())) {
//                            totalScore += calculateScore(studentSkill, skillRequired, totalScore);
//                        }
//                    }
//                }
//                if (totalScore > 0) {
//                    ExperienceCheck experienceStatus = checkExperience(student, jobPost);
//                    double distance = calculateDistance(student.getLatitude(),student.getLongitude(),jobPost.getCompany().getLatitude(), jobPost.getCompany().getLongitude());
//                    MatchingResult matchingResult = new MatchingResult(student, jobPost, totalScore, experienceStatus, distance);
//                    matchResults.add(matchingResult);
//                }
//                else{
//                    System.out.println("No Job match to you");
//                }
//            }
//            
//        }
//    }
//    

    
    public double calculateScore(int proficiency, int importance){
        return (proficiency / 5.0) * importance;
    }
    
    public MatchingResult.ExperienceCheck checkExperience(Student student, JobPosting jobPost) {
       // Compare student's years of experience with the job's required experience
       int studentExperience = student.getYearsOfExperience();  
       int jobExperience = jobPost.getRequiredExperience();      

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
        if (!matchResults.isEmpty()) {
            for(int i = 1; i <= matchResults.size(); i++){
               if(matchResults.getData(i).getStudent().getId().equals(student.getId())){
                    // Display the header
                   System.out.println("============================================================================================================");
                   System.out.println("Match Scores for Student: " + student.getName() + " (" + student.getId() + ")" );
                   System.out.println("============================================================================================================");
                   System.out.printf("%-20s %-50s %-10s %-20s %-15s%n", "Job Post ID", "Job Title", "Score", "Experience Status", "Distance (km)");
                   System.out.println("------------------------------------------------------------------------------------------------------------");

                   // Display each match result

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
        }
        else{
            System.out.println("No match results found for student " + student.getName() + " (" + student.getId() + ").");
            
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

// MatchingResult Class
class MatchingResult implements Serializable {
    public enum ExperienceCheck {
        Not_Experienced,
        Qualified,
        Very_Experienced
    }

    private static int counter = 1;
    private String id;
    private Student student;
    private JobPosting jobPost;
    private double score;
    private ExperienceCheck status;
    private double distance;

    public MatchingResult(Student student, JobPosting jobPost, double score, ExperienceCheck status, double distance) {
        this.id = String.format("M%03d", counter++);
        this.student = student;
        this.jobPost = jobPost;
        this.score = score;
        this.status = status;
        this.distance = distance;
    }

    public Student getStudent() {
        return student;
    }

    public JobPosting getJobPosting() {
        return jobPost;
    }

    public double getScore() {
        return score;
    }

    public String getId() {
        return id;
    }

    public ExperienceCheck getExperiencedCheck() {
        return status;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "MatchingResult{" +
                "id='" + id + '\'' +
                ", student=" + student.getName() +
                ", job=" + jobPost.getJob() +
                ", score=" + score +
                ", status=" + status +
                ", distance=" + distance +
                '}';
    }
}



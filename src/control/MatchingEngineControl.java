/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.MatchingUI;
import control.MatchingResult.ExperienceCheck;
import dao.AllDataInitialize;
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
    private ListInterface<Student> studentList = new DoublyLinkedList<>();
    private ListInterface<JobPosting> jobPostList = new DoublyLinkedList<>();
    private ListInterface<StudentSkill> studentSkill = new DoublyLinkedList<>();
    private ListInterface<JobRequiredSkill> jobRequiredSkill = new DoublyLinkedList<>();
    private ListInterface<MatchingResult> matchResults = new DoublyLinkedList<>();
    private MatchingUI matchingUI;
    public MatchingEngineControl(){
        
    }
    public MatchingEngineControl(ListInterface<StudentSkill> studentSkill, ListInterface<JobRequiredSkill> jobRequiredSkill, ListInterface<Student> studentList, ListInterface<JobPosting> jobPostList){
        this.matchingUI = new MatchingUI(this);
        this.studentSkill = studentSkill;
        this.jobRequiredSkill = jobRequiredSkill;
        this.studentList = studentList;
        this.jobPostList = jobPostList;
       
    }
    
    
    
      public void matchStudentsToJobs(Student student) {
        matchResults.clear();

        for (int i = 1; i <= jobPostList.size(); i++) {
            JobPosting jobPost = jobPostList.getData(i);
            double totalScore = 0;

            for (int j = 1; j <= jobRequiredSkill.size(); j++) {
                JobRequiredSkill requiredSkill = jobRequiredSkill.getData(j);

                if (jobPost.getId().equals(requiredSkill.getJobPost().getId())) {
                    for (int k = 1; k <= studentSkill.size(); k++) {
                        StudentSkill stdSkill = studentSkill.getData(k);

                        if (stdSkill.getStudent().getId().equals(student.getId())) {
                            if (stdSkill.getSkill().equals(requiredSkill.getSkill())) {
                                totalScore += calculateScore(stdSkill.getProficiencyLevel(), requiredSkill.getImportance());
                            }
                        }
                    }
                }
            }

            if (totalScore > 0) {
                MatchingResult.ExperienceCheck experienceStatus = checkExperience(student, jobPost);

                switch (experienceStatus) {
                    case Very_Experienced:
                        totalScore += 20;
                        break;
                    case Qualified:
                        totalScore += 10;
                        break;
                    default:
                        totalScore -= 10;
                        break;
                }

                double distance = calculateDistance(
                    student.getLatitude(),
                    student.getLongitude(),
                    jobPost.getCompany().getLatitude(),
                    jobPost.getCompany().getLongitude()
                );

                MatchingResult matchingResult = new MatchingResult(student, jobPost, totalScore, experienceStatus, distance);
                System.out.println(matchingResult);
                matchResults.add(matchingResult);
                
            }
            
        }
         listScoresForStudent(matchResults);
    }

    public double calculateScore(int proficiency, int importance) {
        double skillAssess = (proficiency * importance);
        return (skillAssess / 25) * 80;
    }

    public static MatchingResult.ExperienceCheck checkExperience(Student student, JobPosting jobPost) {
        int studentExperience = student.getYearsOfExperience();
        int jobExperience = jobPost.getRequiredExperience();

        if (studentExperience < jobExperience) {
            return MatchingResult.ExperienceCheck.Not_Experienced;
        } else if (studentExperience == jobExperience) {
            return MatchingResult.ExperienceCheck.Qualified;
        } else {
            return MatchingResult.ExperienceCheck.Very_Experienced;
        }
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of Earth in km
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }



    
    
    
    public void listScoresForStudent(ListInterface<MatchingResult> matchResults) {
        if (!matchResults.isEmpty()) { 
 
                   System.out.println("=========================================================================================================================================");
                   System.out.println("Match Scores for Student: " + matchResults.getData(1).getStudent().getName()+ " (" + matchResults.getData(1).getStudent().getId() + ")" );
                   System.out.println("=========================================================================================================================================");
                   System.out.printf("%-20s %-50s %-10s %-20s %-15s%n", "Job Post ID", "Job Title", "Score", "Experience Status", "Distance (km)");
                   System.out.println("------------------------------------------------------------------------------------------------------------");
            for(int i = 1; i <= matchResults.size(); i++){
//               if(matchResults.getData(i).getStudent().getId().equals(matchResults.getData(i).getStudent().getStudent().getId())){
                  

         

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
//               }
           }
        }
        else{
            System.out.println("No match results found for student " + matchResults.getData(1).getStudent().getName()+ " (" + matchResults.getData(1).getStudent().getId()+ ").");
            
        }
         System.out.println("============================================================================================================");
        
    }
    
     public void SummaryMatching() {
        matchResults.clear();
        for (int i = 1; i <= studentList.size(); i++) { 
            Student student = studentList.getData(i); 

   
            for (int j = 1; j <= jobPostList.size(); j++) { 
                JobPosting jobPost = jobPostList.getData(j);
                double totalScore = 0;

                
                for (int k = 1; k <= jobRequiredSkill.size(); k++) {
                    JobRequiredSkill requiredSkill = jobRequiredSkill.getData(k);

                   
                    if (jobPost.getId().equals(requiredSkill.getJobPost().getId())) {

                   
                        for (int l = 1; l <= studentSkill.size(); l++) {
                            StudentSkill stdSkill = studentSkill.getData(l);

                            if (stdSkill.getStudent().getId().equals(student.getId())) {
                      
                                if (stdSkill.getSkill().equals(requiredSkill.getSkill())) {
                                    totalScore += calculateScore(stdSkill.getProficiencyLevel(), requiredSkill.getImportance());
                                }
                            }
                        }
                    }
                }

        
                if (totalScore > 0) {
                    ExperienceCheck experienceStatus = checkExperience(student, jobPost);

                    // Add experience level bonus points to the total score
                    switch (experienceStatus) {
                        case Very_Experienced:
                            totalScore += 20;
                            break;
                        case Qualified:
                            totalScore += 10;
                            break;
                        default:
                            totalScore -= 10;
                            break;
                    }

                    double distance = calculateDistance(
                            student.getLatitude(),
                            student.getLongitude(),
                            jobPost.getCompany().getLatitude(),
                            jobPost.getCompany().getLongitude()
                    );

                
                    MatchingResult matchingResult = new MatchingResult(student, jobPost, totalScore, experienceStatus, distance);

                    matchResults.add(matchingResult);
                }
            }
        }
        displayAllMatchingResults();
     }
           
     public void displayAllMatchingResults() {
         
        String lastStudentName = null;
        
        System.out.println("=========================================================================================================================================");
        System.out.printf("| %-5s | %-12s | %-40s | %-20s | %-8s | %-20s | %-10s |\n", 
                          "No.", "Job Post ID","Job Title", "Student Name", "Score", "Experience Level", "Distance");
        System.out.println("=========================================================================================================================================");

        int count = 1;
        for (MatchingResult result : matchResults) {

            String studentName = result.getStudent().getName();
            String jobPostId = result.getJobPosting().getId();
            String jobTitle = result.getJobPosting().getJob().getTitle();
            double score = result.getScore();
            ExperienceCheck expLevel = result.getExperiencedCheck();
            double distance = result.getDistance();
            
            String displayStudent = null;
            if (studentName.equals(lastStudentName)){
                displayStudent = "";
            }else{
                displayStudent = studentName;
            }
            

            System.out.printf("| %-5d | %-12s | %-40s | %-20s | %-8.2f | %-20s | %-10.2f |\n", 
                              count, jobPostId,jobTitle, displayStudent,  score, expLevel, distance);
            count++;
            lastStudentName = studentName;
        }

        System.out.println("=========================================================================================================================================");
    }

       

    public void MatchingRunner(Student student) {
        int choice = 0;
            
            do {
                choice = matchingUI.MatchingMenu(student);
//                choice = matchingUI.AdminReport();
                switch (choice) {
                    case 1:
                        // choice = matchingUI.Search();
                        break;
                    case 2:
                        // choice = matchingUI.Sort();
                        break;
                    default:
                       
                        break;
                }
            } while (choice != 0);
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



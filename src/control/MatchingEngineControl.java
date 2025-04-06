/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.MatchingUI;
import entity.JobPosting;
import entity.JobSkillRequirement;
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
    private ListInterface<JobPosting> jobPost;

    
    public MatchingEngineControl(ListInterface<Student> studentList, ListInterface<JobPosting> jobPost){
        this.matchingUI = new MatchingUI(this);
        this.studentList = studentList;
        this.jobPost = jobPost;
    }
    
    public void matchStudentsToJobs() {
        ListInterface<MatchingResult> matchResults = new DoublyLinkedList<>();
        
        for (int i = 1; i <= studentList.size() ; i++){
            Student student = studentList.getData(i);
            for(int j = 1; j <= jobPost.size(); j++){
                JobPosting jobPostList = jobPost.getData(j);
                double totalScore = 0;
                for(int k = 1; k <= student.getSkillList().size(); k++){
                    StudentSkill studentSkill = student.getSkillList().getData(k);
                    for(int l =  1; l <= jobPostList.getSkillRequired().size(); l++ ){
                        JobSkillRequirement skillRequired = jobPostList.getSkillRequired().getData(l);
                        if (studentSkill.getId().equals(skillRequired.getId())) {
                            totalScore += calculateScore(studentSkill, skillRequired, totalScore);
                           
                        }
                    }
                }
                if (totalScore > 0) {
                    ExperienceCheck experienceStatus = checkExperience(student, jobPostList);
                    MatchingResult matchingResult = new MatchingResult(student, jobPostList, totalScore, experienceStatus);
                    matchResults.add(matchingResult);
                    student.getMatchResult().add(matchingResult);
                }
            }
            
        }
        
    }
    
    
    public double calculateScore(StudentSkill studentSkill, JobSkillRequirement skillRequired, double totalScore){
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
    
    
    public void listScoresForStudent(Student student) {
        ListInterface<MatchingResult> matchResults = student.getMatchResult();

        if (matchResults.isEmpty()) {
            System.out.println("No match results found for student " + student.getName() + " (" + student.getId() + ").");
            return;
        }

        // Display the header
        System.out.println("============================================================================================================");
        System.out.println("Match Scores for Student: " + student.getName() + " (" + student.getId() + ")");
        System.out.println("============================================================================================================");
        System.out.printf("%-20s %-50s %-10s %-20s%n", "Job ID", "Job Title", "Score", "Experience Status");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        // Display each match result
        for (int i = 1; i <= matchResults.size(); i++) {
            MatchingResult result = matchResults.getData(i);
            JobPosting job = result.getJobPosting(); // Assuming getJobPosting() returns a JobPosting object
            ExperienceCheck experienceStatus = result.getExperiencedCheck(); // Get experience status
            System.out.printf("%-20s %-50s %-10.2f %-20s%n", 
                              job.getJob().getId(), 
                              job.getJob().getTitle(), 
                              result.getScore(), 
                              experienceStatus);
        }
    }


    
    public void MatchingRunner(Student student){
        int choice = 0;
        do{
           choice = matchingUI.MatchingMenu(student);
        }while(choice != 0);
    }
}

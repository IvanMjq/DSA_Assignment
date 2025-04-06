/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author WEI ZHENG
 */
public class MatchingResult implements Serializable{
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
//    private double weightage;
    
    public MatchingResult(Student student, JobPosting jobPost, double score, ExperienceCheck status) {
        this.id = String.format("M%03d", counter++);
        this.student = student;
        this.jobPost = jobPost;
        this.score = score;
        this.status = status;
       
//        this.reason = reason;
    }

    // Getters and setters

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
    
    public ExperienceCheck getExperiencedCheck(){
        return status;
    }
    @Override
       public String toString() {
        return "MatchingResult{" +
                "id='" + id + '\'' +
                ", student=" + student.getName() +
                ", job=" + jobPost.getJob() +
                ", score=" + score +
                '}';
    }
}

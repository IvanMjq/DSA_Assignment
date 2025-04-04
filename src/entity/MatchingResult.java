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
    
    private Student student;
    private JobPosting jobPost;
    private String id;
    private int score;
    private double weightage;
    
    public MatchingResult(Student student, JobPosting jobPost, String id, int score, double weightage) {
        this.student = student;
        this.jobPost = jobPost;
        this.score = score;
        this.weightage = weightage;
//        this.reason = reason;
    }

    // Getters and setters

    public Student getStudent() {
        return student;
    }

    public JobPosting getJobPosting() {
        return jobPost;
    }

    public int getScore() {
        return score;
    }

    public double getWeightage() {
        return weightage;
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "Student=" + student.getName() +
                ", Job=" + jobPost +
                ", Score=" + score +
                ", weightage='" + weightage + '\'' +
                '}';
    }
}

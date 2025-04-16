/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author WEI ZHENG
 */
public class MatchingResult implements Comparable<MatchingResult>{
      public enum ExperienceCheck {
        Not_Experienced,
        Experienced,
        Very_Experienced
    }

    public enum StatusDistance {
        Near,
        Moderate,
        Far,
        Very_Far
    };

    private Student student;
    private JobPosting jobPost;
    private double score;
    private ExperienceCheck status;
    private double distance;
    private StatusDistance statusDistance;

    public MatchingResult(Student student, JobPosting jobPost, double score, ExperienceCheck status, double distance, StatusDistance statusDistance) {

        this.student = student;
        this.jobPost = jobPost;
        this.score = score;
        this.status = status;
        this.distance = distance;
        this.statusDistance = statusDistance;
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


    public ExperienceCheck getExperiencedCheck() {
        return status;
    }

    public double getDistance() {
        return distance;
    }

    public StatusDistance getStatusDistance() {
        return statusDistance;
    }
    
    @Override
    public int compareTo(MatchingResult other) {
        return  Double.valueOf(this.score).compareTo(other.getScore());
    }
    
    @Override
    public String toString() {
        return "MatchingResult{"
                + ", student=" + student.getName()
                + ", jobPost=" + jobPost.getJob().getTitle()
                + ", score=" + score
                + ", status=" + status
                + ", distance=" + distance
                + '}';
    }

}

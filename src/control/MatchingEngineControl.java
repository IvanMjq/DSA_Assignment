/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

//import adt.DoublyLinkedList;
//import adt.ListInterface;
//import boundary.MatchingUI;
//import control.MatchingResult.ExperienceCheck;
//import static control.MatchingResult.ExperienceCheck.Qualified;
//import static control.MatchingResult.ExperienceCheck.Very_Experienced;
//import static control.MatchingResult.StatusDistance.Far;
//import static control.MatchingResult.StatusDistance.Moderate;
//import static control.MatchingResult.StatusDistance.Near;
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

//    private ListInterface<Student> studentList = new DoublyLinkedList<>();
//    private ListInterface<JobPosting> jobPostList = new DoublyLinkedList<>();
//    private ListInterface<MatchingResult> matchResults = new DoublyLinkedList<>();
//    private MatchingUI matchingUI;
//
//    public MatchingEngineControl() {
//
//    }
//
//    public MatchingEngineControl(ListInterface<Student> studentList, ListInterface<JobPosting> jobPostList) {
//        this.matchingUI = new MatchingUI(this);
//        this.studentList = studentList;
//        this.jobPostList = jobPostList;
//
//    }
//
//    public void matchStudentsToJobs(Student student) {
//        matchResults.clear();
//
////        for (int j = 1; j <= jobPostList.size(); j++) {
////            double totalScore = 0;
////            JobPosting jobPost = jobPostList.getData(j);
////
////            for (int k = 1; k <= student.getStudentSkillList().size(); k++) {
////                StudentSkill stdSkill = student.getStudentSkillList().getData(k);
////
////                for (int l = 1; l <= jobPost.getJobRequiredSkills().size(); l++) {
////                    JobRequiredSkill requiredSkill = jobPost.getJobRequiredSkills().getData(l);
////
////                    if (stdSkill.getSkill().getId().equals(requiredSkill.getSkill().getId())) {
////                        totalScore += calculateScore(stdSkill.getProficiencyLevel(), requiredSkill.getImportance());
////                    }
////                }
////            }
//
//            if (totalScore > 0) {
//                // Experience score
//                MatchingResult.ExperienceCheck experienceStatus = checkExperience(student, jobPost);
//                switch (experienceStatus) {
//                    case Very_Experienced:
//                        totalScore += 10;
//                        break;
//                    case Qualified:
//                        totalScore += 5;
//                        break;
//                    default:
//                        totalScore -= 10;
//                        break;
//                }
//
//                // Distance score
//                double distance = calculateDistance(
//                        student.getLatitude(),
//                        student.getLongitude(),
//                        jobPost.getCompany().getLatitude(),
//                        jobPost.getCompany().getLongitude()
//                );
//
//                MatchingResult.StatusDistance statusDistance = getStatusDistance(distance);
//                switch (statusDistance) {
//                    case Near:
//                        totalScore += 10;
//                        break;
//                    case Moderate:
//                        totalScore += 5;
//                        break;
//                    case Far:
//                        totalScore -= 5;
//                        break;
//                    default:
//                        totalScore -= 10;
//                        break;
//                }
//
//                // Add result
//                MatchingResult matchingResult = new MatchingResult(student, jobPost, totalScore, experienceStatus, distance, statusDistance);
//                matchResults.add(matchingResult);
//            }
//        }
//
//        listScoresForStudent(matchResults);
//    }
//
//    public double calculateScore(int proficiency, int importance) {
//        double skillAssess = (proficiency * importance);
//        return (skillAssess / 25) * 80;
//    }
//
//    public MatchingResult.ExperienceCheck checkExperience(Student student, JobPosting jobPost) {
//        int studentExperience = student.getYearsOfExperience();
//        int jobExperience = jobPost.getRequiredExperience();
//
//        if (studentExperience < jobExperience) {
//            return MatchingResult.ExperienceCheck.Not_Experienced;
//        } else if (studentExperience == jobExperience) {
//            return MatchingResult.ExperienceCheck.Qualified;
//        } else {
//            return MatchingResult.ExperienceCheck.Very_Experienced;
//        }
//    }
//
//    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
//
//        final int R = 6371; // Radius of Earth in km
//        double lat1Rad = Math.toRadians(lat1);
//        double lon1Rad = Math.toRadians(lon1);
//        double lat2Rad = Math.toRadians(lat2);
//        double lon2Rad = Math.toRadians(lon2);
//
//        double deltaLat = lat2Rad - lat1Rad;
//        double deltaLon = lon2Rad - lon1Rad;
//
//        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
//                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
//                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
//
//        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//        return R * c;
//
//    }
//
//    public void listScoresForStudent(ListInterface<MatchingResult> matchResults) {
//        if (!matchResults.isEmpty()) {
//
//            System.out.println("Match Scores for Student: " + matchResults.getData(1).getStudent().getName() + " (" + matchResults.getData(1).getStudent().getId() + ")");
//            System.out.println("====================================================================================================================");
//            System.out.printf("| %-12s | %-40s | %-20s | %-20s | %-8s |\n", "Job Post ID", "Job Title", "Status Of Distance", "Experience Status", "Score");
//            System.out.println("====================================================================================================================");
//            for (int i = 1; i <= matchResults.size(); i++) {
////               if(matchResults.getData(i).getStudent().getId().equals(matchResults.getData(i).getStudent().getStudent().getId())){
//
//                MatchingResult result = matchResults.getData(i);
//                JobPosting job = result.getJobPosting();
//                ExperienceCheck experienceStatus = result.getExperiencedCheck(); // Get experience status
//                MatchingResult.StatusDistance statusDistance = result.getStatusDistance();
////                double distance = result.getDistance(); 
//                System.out.printf("| %-12s | %-40s | %-20s | %-20s | %-8.2f |\n",
//                        job.getId(),
//                        job.getJob().getTitle(),
//                        statusDistance,
//                        experienceStatus,
//                        result.getScore());
////               }
//            }
//        } else {
//            System.out.println("No match results found for student " + matchResults.getData(1).getStudent().getName() + " (" + matchResults.getData(1).getStudent().getId() + ").");
//
//        }
//        System.out.println("====================================================================================================================");
//
//    }
//
//    public void SummaryMatching() {
//        matchResults.clear();
//
//        for (int i = 1; i <= studentList.size(); i++) {
//            Student student = studentList.getData(i);
//
//            for (int j = 1; j <= jobPostList.size(); j++) {
//                JobPosting jobPost = jobPostList.getData(j);
//                double totalScore = 0;
//
//                // Match student's skills with job required skills
//                for (int k = 1; k <= student.getStudentSkillList().size(); k++) {
//                    StudentSkill stdSkill = student.getStudentSkillList().getData(k);
//
//                    for (int l = 1; l <= jobPost.getJobRequiredSkills().size(); l++) {
//                        JobRequiredSkill requiredSkill = jobPost.getJobRequiredSkills().getData(l);
//
//                        if (stdSkill.getSkill().getId().equals(requiredSkill.getSkill().getId())) {
//                            totalScore += calculateScore(stdSkill.getProficiencyLevel(), requiredSkill.getImportance());
//                        }
//                    }
//                }
//
//                if (totalScore > 0) {
//                    // Experience bonus
//                    ExperienceCheck experienceStatus = checkExperience(student, jobPost);
//                    switch (experienceStatus) {
//                        case Very_Experienced:
//                            totalScore += 20;
//                            break;
//                        case Qualified:
//                            totalScore += 10;
//                            break;
//                        default:
//                            totalScore -= 10;
//                            break;
//                    }
//
//                    // Distance impact
//                    double distance = calculateDistance(
//                            student.getLatitude(),
//                            student.getLongitude(),
//                            jobPost.getCompany().getLatitude(),
//                            jobPost.getCompany().getLongitude()
//                    );
//                    MatchingResult.StatusDistance statusDistance = getStatusDistance(distance);
//                    switch (statusDistance) {
//                        case Near:
//                            totalScore += 10;
//                            break;
//                        case Moderate:
//                            totalScore += 5;
//                            break;
//                        case Far:
//                            totalScore -= 5;
//                            break;
//                        default:
//                            totalScore -= 10;
//                            break;
//                    }
//
//                    // Save the match result
//                    MatchingResult matchingResult = new MatchingResult(student, jobPost, totalScore, experienceStatus, distance, statusDistance);
//                    matchResults.add(matchingResult);
//                }
//            }
//        }
//
//        displayAllMatchingResults();
//    }
//
//    public void displayAllMatchingResults() {
//
//        String lastStudentName = null;
//
//        System.out.println("===================================================================================================================================================");
//        System.out.printf("| %-5s | %-12s | %-40s | %-20s | %-20s | %-20s | %-8s |\n",
//                "No.", "Job Post ID", "Job Title", "Student Name", "Status of Distance", "Experience Level", "Score");
//        System.out.println("===================================================================================================================================================");
//
//        int count = 1;
//        for (MatchingResult result : matchResults) {
//
//            String studentName = result.getStudent().getName();
//            String jobPostId = result.getJobPosting().getId();
//            String jobTitle = result.getJobPosting().getJob().getTitle();
//            double score = result.getScore();
//            ExperienceCheck expLevel = result.getExperiencedCheck();
//            MatchingResult.StatusDistance statusDistance = result.getStatusDistance();
//
//            String displayStudent = null;
//            if (studentName.equals(lastStudentName)) {
//                displayStudent = "";
//            } else {
//                displayStudent = studentName;
//            }
//
//            System.out.printf("| %-5d | %-12s | %-40s | %-20s | %-20s | %-20s | %-8.2f |\n",
//                    count, jobPostId, jobTitle, displayStudent, statusDistance, expLevel, score);
//            count++;
//            lastStudentName = studentName;
//        }
//
//        System.out.println("===================================================================================================================================================");
//    }
//
//    public void MatchingRunner(Student student) {
//        int choice = 0;
//
//        do {
//            choice = matchingUI.MatchingMenu(student);
////                choice = matchingUI.AdminReport();
//            switch (choice) {
//                case 1:
//                    // choice = matchingUI.Search();
//                    break;
//                case 2:
//                    // choice = matchingUI.Sort();
//                    break;
//                default:
//
//                    break;
//            }
//        } while (choice != 0);
//    }
//
//    public void AdminMatchingRunner() {
//        int choice = 0;
//
//        do {
//            choice = matchingUI.AdminReport();
////                choice = matchingUI.AdminReport();
//            switch (choice) {
//                case 1:
//                    // choice = matchingUI.Search();
//                    break;
//                case 2:
//                    // choice = matchingUI.Sort();
//                    break;
//                default:
//
//                    break;
//            }
//        } while (choice != 0);
//    }
//
//    public ListInterface<MatchingResult> getMatchResults() {
//        return matchResults;
//    }
//
//    public MatchingResult.StatusDistance getStatusDistance(double distance) {
//        if (distance <= 25) {
//            return MatchingResult.StatusDistance.Near;
//        } else if (distance > 25 && distance <= 50) {
//            return MatchingResult.StatusDistance.Moderate;
//        } else if (distance > 50 && distance <= 75) {
//            return MatchingResult.StatusDistance.Far;
//        } else {
//            return MatchingResult.StatusDistance.Very_Far;
//        }
//    }
//
//}
//
//// MatchingResult Class
//class MatchingResult implements Serializable {
//
//    public enum ExperienceCheck {
//        Not_Experienced,
//        Qualified,
//        Very_Experienced
//    }
//
//    public enum StatusDistance {
//        Near,
//        Moderate,
//        Far,
//        Very_Far
//    };
//
//    private static int counter = 1;
//    private String id;
//    private Student student;
//    private JobPosting jobPost;
//    private double score;
//    private ExperienceCheck status;
//    private double distance;
//    private StatusDistance statusDistance;
//
//    public MatchingResult(Student student, JobPosting jobPost, double score, ExperienceCheck status, double distance, StatusDistance statusDistance) {
//        this.id = String.format("M%03d", counter++);
//        this.student = student;
//        this.jobPost = jobPost;
//        this.score = score;
//        this.status = status;
//        this.distance = distance;
//        this.statusDistance = statusDistance;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public JobPosting getJobPosting() {
//        return jobPost;
//    }
//
//    public double getScore() {
//        return score;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public ExperienceCheck getExperiencedCheck() {
//        return status;
//    }
//
//    public double getDistance() {
//        return distance;
//    }
//
//    public StatusDistance getStatusDistance() {
//        return statusDistance;
//    }
//
//    @Override
//    public String toString() {
//        return "MatchingResult{"
//                + "id='" + id + '\''
//                + ", student=" + student.getName()
//                + ", job=" + jobPost.getJob()
//                + ", score=" + score
//                + ", status=" + status
//                + ", distance=" + distance
//                + '}';
//    }

}

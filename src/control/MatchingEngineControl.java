
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
import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.MatchingUI;
import entity.MatchingResult.ExperienceCheck;
import static entity.MatchingResult.ExperienceCheck.Experienced;
import static entity.MatchingResult.ExperienceCheck.Very_Experienced;
import entity.MatchingResult.StatusDistance;
import static entity.MatchingResult.StatusDistance.Far;
import static entity.MatchingResult.StatusDistance.Moderate;
import static entity.MatchingResult.StatusDistance.Near;
import dao.AllDataInitialize;
import entity.Company;
import entity.JobPosting;
import entity.JobRequiredSkill;
import entity.MatchingResult;
import entity.Student;
import entity.StudentSkill;
import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author WEI ZHENG
 */
public class MatchingEngineControl {

    private ListInterface<Student> studentList = new DoublyLinkedList<>();
    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    private ListInterface<JobPosting> jobPostList = new DoublyLinkedList<>();
    private ListInterface<MatchingResult> matchResults = new DoublyLinkedList<>();
    // Comparator to sort by score in descending order
    private final Comparator<MatchingResult> scoreComparator = (a, b) -> Double.compare(b.getScore(), a.getScore());
    private MatchingUI matchingUI;

    public MatchingEngineControl() {

    }

    public MatchingEngineControl(ListInterface<Company> companyList, ListInterface<Student> studentList) {
        this.matchingUI = new MatchingUI(this);
        this.studentList = studentList;
        this.companyList = companyList;
        for (int i = 1; i <= companyList.size(); i++) {
            Company company = companyList.getData(i);
            for (int j = 1; j <= company.getJobPostingList().size(); j++) {
                jobPostList.add(company.getJobPostingList().getData(j));
            }
        }
    }

    public void matchStudentsToJobs(Student student) {
        matchResults.clear();
        for (int i = 1; i <= companyList.size(); i++) {
            double totalScore = 0;
            Company company = companyList.getData(i);
            for (int j = 1; j <= company.getJobPostingList().size(); j++) {
                JobPosting jobPost = company.getJobPostingList().getData(j);
                for (int l = 1; l <= jobPost.getJobRequiredSkillList().size(); l++) {
                    JobRequiredSkill requiredSkill = jobPost.getJobRequiredSkillList().getData(l);
                    for (int k = 1; k <= student.getStudentSkillList().size(); k++) {
                        StudentSkill stdSkill = student.getStudentSkillList().getData(k);
                        if (stdSkill.getSkill().getId().equals(requiredSkill.getSkill().getId())) {
                            totalScore += calculateScore(stdSkill.getProficiencyLevel(), requiredSkill.getImportance());
                        }
                    }
                }

                if (totalScore > 0) {
                    ExperienceCheck experienceStatus = checkExperience(student, jobPost);
                    switch (experienceStatus) {
                        case Very_Experienced:
                            totalScore += 10;
                            break;
                        case Experienced:
                            totalScore += 5;
                            break;
                        default:
                            totalScore -= 10;
                            break;
                    }

                    double distance = calculateDistance(
                            student.getLatitude(),
                            student.getLongitude(),
                            company.getLatitude(),
                            company.getLongitude()
                    );

                    StatusDistance statusDistance = getStatusDistance(distance);
                    switch (statusDistance) {
                        case Near:
                            totalScore += 10;
                            break;
                        case Moderate:
                            totalScore += 5;
                            break;
                        case Far:
                            totalScore -= 5;
                            break;
                        default:
                            totalScore -= 10;
                            break;
                    }

                    MatchingResult matchingResult = new MatchingResult(student, jobPost, totalScore, experienceStatus, distance, statusDistance);
                    matchResults.add(matchingResult);
                }
            }
        }

    }

    public double calculateScore(int proficiency, int importance) {
        return ((double) proficiency * importance / 25) * 80;
    }

    public ExperienceCheck checkExperience(Student student, JobPosting jobPost) {
        int studentExperience = student.getYearsOfExperience();
        int jobExperience = jobPost.getRequiredExperience();

        if (studentExperience < jobExperience) {
            return ExperienceCheck.Not_Experienced;
        } else if (studentExperience == jobExperience) {
            return ExperienceCheck.Experienced;
        } else {
            return ExperienceCheck.Very_Experienced;
        }
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
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

    public MatchingResult.StatusDistance getStatusDistance(double distance) {
        if (distance <= 10) {
            return StatusDistance.Near;
        } else if (distance <= 30) {
            return StatusDistance.Moderate;
        } else {
            return StatusDistance.Far;
        }
    }

    public void listScoresForStudent(ListInterface<MatchingResult> matchResults) {
        if (!matchResults.isEmpty()) {

            System.out.println("Match Scores for Student: " + matchResults.getData(1).getStudent().getName() + " (" + matchResults.getData(1).getStudent().getId() + ")");
            System.out.println("================================================================================================================================================================================");
            System.out.printf("| %-10s | %-30s | %-8s | %-40s | %-15s | %-20s | %-20s | %-8s |\n", "CompanyId", "Company", "JobId", "Job Title", "Date Posted", "Status Of Distance", "Experience Status", "Score");
            System.out.println("================================================================================================================================================================================");
            for (int i = 1; i <= matchResults.size(); i++) {

                MatchingResult result = matchResults.getData(i);
                JobPosting jobPost = result.getJobPosting();
                ExperienceCheck experienceStatus = result.getExperiencedCheck(); // Get experience status
                MatchingResult.StatusDistance statusDistance = result.getStatusDistance();
                System.out.printf("| %-10s | %-30s | %-8s | %-40s | %-15s | %-20s | %-20s | %-8.2f |\n",
                        jobPost.getCompany().getId(),
                        jobPost.getCompany().getName(),
                        jobPost.getJob().getId(),
                        jobPost.getJob().getTitle(),
                        jobPost.getDatePosted(),
                        statusDistance,
                        experienceStatus,
                        result.getScore());

            }
        } else {
            System.out.println("No match results found for student " + matchResults.getData(1).getStudent().getName() + " (" + matchResults.getData(1).getStudent().getId() + ").");

        }
        System.out.println("================================================================================================================================================================================");

    }

    public void SummaryMatching() {
        matchResults.clear();

        for (int i = 1; i <= studentList.size(); i++) {
            Student student = studentList.getData(i);

            for (int j = 1; j <= jobPostList.size(); j++) {
                JobPosting jobPost = jobPostList.getData(j);
                double totalScore = 0;

                // Match student's skills with job required skills
                for (int k = 1; k <= student.getStudentSkillList().size(); k++) {
                    StudentSkill stdSkill = student.getStudentSkillList().getData(k);

                    for (int l = 1; l <= jobPost.getJobRequiredSkillList().size(); l++) {
                        JobRequiredSkill requiredSkill = jobPost.getJobRequiredSkillList().getData(l);

                        if (stdSkill.getSkill().getId().equals(requiredSkill.getSkill().getId())) {
                            totalScore += calculateScore(stdSkill.getProficiencyLevel(), requiredSkill.getImportance());
                        }
                    }
                }

                if (totalScore > 0) {
                    // Experience bonus
                    ExperienceCheck experienceStatus = checkExperience(student, jobPost);
                    switch (experienceStatus) {
                        case Very_Experienced:
                            totalScore += 20;
                            break;
                        case Experienced:
                            totalScore += 10;
                            break;
                        default:
                            totalScore -= 10;
                            break;
                    }

                    // Distance impact
                    double distance = calculateDistance(
                            student.getLatitude(),
                            student.getLongitude(),
                            jobPost.getCompany().getLatitude(),
                            jobPost.getCompany().getLongitude()
                    );
                    MatchingResult.StatusDistance statusDistance = getStatusDistance(distance);
                    switch (statusDistance) {
                        case Near:
                            totalScore += 10;
                            break;
                        case Moderate:
                            totalScore += 5;
                            break;
                        case Far:
                            totalScore -= 5;
                            break;
                        default:
                            totalScore -= 10;
                            break;
                    }

                    // Save the match result
                    MatchingResult matchingResult = new MatchingResult(student, jobPost, totalScore, experienceStatus, distance, statusDistance);
                    matchResults.add(matchingResult);
                }

            }
        }

    }

    public void displayAllMatchingResults() {

        String lastStudentName = null;
        int qualifiedCount = 0;
        int failCount = 0;
        System.out.println("==========================================================================================================================================================================================================================");
        System.out.printf("| %-5s | %-20s | %-10s | %-30s | %-8s | %-40s | %-20s | %-20s | %-10s | %-13s | %-8s |\n",
                "No.", "Student Name", "Company Id", "Company", "Job Id", "Job Title", "Status of Distance", "Experience Level", "Score", "Status", "Count");
        System.out.println("==========================================================================================================================================================================================================================");

        for (MatchingResult result : matchResults) {

            String studentName = result.getStudent().getName();
            String jobTitle = result.getJobPosting().getJob().getTitle();
            String company = result.getJobPosting().getCompany().getName();
            String companyId = result.getJobPosting().getCompany().getId();
            String jobId = result.getJobPosting().getJob().getId();
            double score = result.getScore();
            ExperienceCheck expLevel = result.getExperiencedCheck();
            MatchingResult.StatusDistance statusDistance = result.getStatusDistance();
            int accumulateCount = 0;
            for (int j = 1; j <= matchResults.size(); j++) {
                if (matchResults.getData(j).getStudent().getName().equals(studentName)) {
                    accumulateCount++;
                }
            }

            String status = "";

            if (score > 50) {
                status = "Qualified";
                qualifiedCount++;
            } else {
                status = "Not Qualified";
                failCount++;
            }

            String displayStudent = "";
            if (!studentName.equals(lastStudentName)) {
                displayStudent = studentName;
                System.out.printf("| %-5d | %-20s | %-10s | %-30s | %-8s | %-40s | %-20s | %-20s | %-10.2f | %-13s | %-8d |\n",
                        matchResults.indexOf(result), displayStudent, companyId, company, jobId, jobTitle, statusDistance, expLevel, score, status, accumulateCount);
            } else {
                System.out.printf("| %-5d | %-20s | %-10s | %-30s | %-8s | %-40s | %-20s | %-20s | %-10.2f | %-13s | %-8s |\n",
                        matchResults.indexOf(result), displayStudent, companyId, company, jobId, jobTitle, statusDistance, expLevel, score, status, "");
            }

            lastStudentName = studentName;
        }

        System.out.println("==========================================================================================================================================================================================================================");
        System.out.printf("| %-203s | %-8d |\n", "Total Match Results", matchResults.size());
        System.out.printf("| %-188s ( %-8.2f  %%) | %-8d |\n", "Total Qualified Match", (qualifiedCount * 100.0 / matchResults.size()), qualifiedCount);
        System.out.printf("| %-188s ( %-8.2f  %%) | %-8d |\n", "Total Fail Match", (failCount * 100.0 / matchResults.size()), failCount);

        System.out.println("==========================================================================================================================================================================================================================");
    }

    public void MatchingRunner(Student student) {
        int choice = 0;

        do {
            choice = matchingUI.MatchingMenu(student);
            matchStudentsToJobs(student);

            switch (choice) {
                case 1:
                    listScoresForStudent(matchResults);
                    break;
                case 2:
                    presentAscendingOrder();
                    break;
                case 3:
                    presentDescendingOrder();
                    break;
                default:

                    break;
            }
        } while (choice != 0);
    }

    public void AdminMatchingRunner() {
        int choice = 0;
        do {
            choice = matchingUI.AdminReport();
            SummaryMatching();
            switch (choice) {
                case 0:
                    System.out.println("Exiting the page...");
                    break;
                case 1:
                    displayAllMatchingResults();

                    break;
                case 2:
                    DistributionGraph();
                    break;
                    
                case 3:
                    String input = matchingUI.SearchUI();
                    if (input.equals("QUIT")) {
                        System.out.println("Exit Search...");
                        break;
                    }
                    searchBy(input);
                    break;
                    

                default:

                    break;
            }
        } while (choice != 0);
    }

    public ListInterface<MatchingResult> getMatchResults() {
        return matchResults;
    }

    public void DistributionGraph() {
        ListInterface<String> jobPosts = new DoublyLinkedList<>();
        ListInterface<Integer> qualifiedCounts = new DoublyLinkedList<>();

        // Count qualified students per job title
        for (int i = 1; i <= matchResults.size(); i++) {
            MatchingResult result = matchResults.getData(i);
            String jobTitle = result.getJobPosting().getJob().getTitle();
            String company = result.getJobPosting().getCompany().getName();
            String jobPost = company + " - " + jobTitle;
            double score = result.getScore();

            int foundIndex = -1;

            for (int j = 1; j <= jobPosts.size(); j++) {
                if (jobPosts.getData(j).equals(jobPost)) {
                    foundIndex = j;
                    break;
                }
            }

            if (foundIndex == -1) {
                jobPosts.add(jobPost);
                qualifiedCounts.add(score > 50 ? 1 : 0);
            } else {
                if (score > 50) {
                    int current = qualifiedCounts.getData(foundIndex);
                    qualifiedCounts.replace(foundIndex, current + 1);
                }
            }
        }

        // Find max count
        int max = 0;
        for (int i = 1; i <= qualifiedCounts.size(); i++) {
            if (qualifiedCounts.getData(i) > max) {
                max = qualifiedCounts.getData(i);
            }
        }

        System.out.println("======================================================================");
        System.out.println("Vertical Distribution of Qualified Students by Job Posting");
        System.out.println("======================================================================");

        System.out.printf("%4s\n", "^");

        // Print vertical bars using assigned characters
        for (int level = max; level >= 1; level--) {
            System.out.printf("%2d |", level);
            for (int i = 1; i <= qualifiedCounts.size(); i++) {
                if (qualifiedCounts.getData(i) >= level) {
                    System.out.print("   *   ");
                } else {
                    System.out.print("       ");
                }
            }
            System.out.println();
        }

        // X-axis
        System.out.print("   +");
        for (int i = 1; i <= jobPosts.size(); i++) {
            System.out.print("-------");
        }
        System.out.println();

        // Print character labels
        System.out.print("     ");
        for (int i = 1; i <= jobPosts.size(); i++) {
            System.out.printf("   %d   ", i);
        }
        System.out.println();

        // Print legend
        System.out.println("\nLegend:");
        for (int i = 1; i <= jobPosts.size(); i++) {
            System.out.printf("  %d = %s\n", i, jobPosts.getData(i));
        }

        System.out.println("======================================================================");
    }

    public void presentDescendingOrder() {

        if (!matchResults.isEmpty()) {
            matchResults.bubbleSort((a, b) -> Double.compare(b.getScore(), a.getScore()));

            System.out.println("Match Scores for Student: " + matchResults.getData(1).getStudent().getName() + " (" + matchResults.getData(1).getStudent().getId() + ")");
            System.out.println("================================================================================================================================================================================");
            System.out.printf("| %-10s | %-30s | %-8s | %-40s | %-15s | %-20s | %-20s | %-8s |\n", "CompanyId", "Company", "JobId", "Job Title", "Date Posted", "Status Of Distance", "Experience Status", "Score");
            System.out.println("================================================================================================================================================================================");
            for (int i = 1; i <= matchResults.size(); i++) {

                MatchingResult result = matchResults.getData(i);
                JobPosting jobPost = result.getJobPosting();
                ExperienceCheck experienceStatus = result.getExperiencedCheck(); // Get experience status
                MatchingResult.StatusDistance statusDistance = result.getStatusDistance();
                System.out.printf("| %-10s | %-30s | %-8s | %-40s | %-15s | %-20s | %-20s | %-8.2f |\n",
                        jobPost.getCompany().getId(),
                        jobPost.getCompany().getName(),
                        jobPost.getJob().getId(),
                        jobPost.getJob().getTitle(),
                        jobPost.getDatePosted(),
                        statusDistance,
                        experienceStatus,
                        result.getScore());

            }
        } else {
            System.out.println("No match results found for student " + matchResults.getData(1).getStudent().getName() + " (" + matchResults.getData(1).getStudent().getId() + ").");

        }
        System.out.println("================================================================================================================================================================================");
    }

    public void presentAscendingOrder() {

        if (!matchResults.isEmpty()) {
            matchResults.bubbleSort((a, b) -> Double.compare(a.getScore(), b.getScore()));

            System.out.println("Match Scores for Student: " + matchResults.getData(1).getStudent().getName() + " (" + matchResults.getData(1).getStudent().getId() + ")");
            System.out.println("================================================================================================================================================================================");
            System.out.printf("| %-10s | %-30s | %-8s | %-40s | %-15s | %-20s | %-20s | %-8s |\n", "CompanyId", "Company", "JobId", "Job Title", "Date Posted", "Status Of Distance", "Experience Status", "Score");
            System.out.println("================================================================================================================================================================================");
            for (int i = 1; i <= matchResults.size(); i++) {

                MatchingResult result = matchResults.getData(i);
                JobPosting jobPost = result.getJobPosting();
                ExperienceCheck experienceStatus = result.getExperiencedCheck(); // Get experience status
                MatchingResult.StatusDistance statusDistance = result.getStatusDistance();
                System.out.printf("| %-10s | %-30s | %-8s | %-40s | %-15s | %-20s | %-20s | %-8.2f |\n",
                        jobPost.getCompany().getId(),
                        jobPost.getCompany().getName(),
                        jobPost.getJob().getId(),
                        jobPost.getJob().getTitle(),
                        jobPost.getDatePosted(),
                        statusDistance,
                        experienceStatus,
                        result.getScore());

            }
        } else {
            System.out.println("No match results found for student " + matchResults.getData(1).getStudent().getName() + " (" + matchResults.getData(1).getStudent().getId() + ").");

        }
        System.out.println("================================================================================================================================================================================");
    }

    public void searchBy(String input) {
        boolean found = false;
        if (!matchResults.isEmpty()) {
            System.out.println("======================================================================================================================================================================================================================");
            System.out.printf("| %-5s | %-20s | %-10s | %-30s | %-8s | %-40s | %-20s | %-20s | %-10s | %-20s |\n",
                    "No.", "Student Name", "Company Id", "Company", "Job Id", "Job Title", "Status of Distance", "Experience Level", "Score", "Status");
            System.out.println("======================================================================================================================================================================================================================");

            for (int i = 1; i <= matchResults.size(); i++) {
                MatchingResult matchingResult = matchResults.getData(i);
                if (matchingResult.getJobPosting().getJob().getId().toLowerCase().contains(input)
                        || matchingResult.getJobPosting().getJob().getTitle().toLowerCase().contains(input)
                        || matchingResult.getStudent().getId().toLowerCase().contains(input)
                        || matchingResult.getStudent().getName().toLowerCase().toLowerCase().contains(input)
                        || matchingResult.getJobPosting().getCompany().getId().toLowerCase().contains(input)
                        || matchingResult.getJobPosting().getCompany().getName().toLowerCase().contains(input)
                        || matchingResult.getExperiencedCheck().toString().toLowerCase().contains(input)
                        || matchingResult.getStatusDistance().toString().toLowerCase().contains(input)
                        || String.valueOf(matchingResult.getScore()).toLowerCase().contains(input)
                )   {
                    
                    String studentName = matchingResult.getStudent().getName();
                    String jobTitle = matchingResult.getJobPosting().getJob().getTitle();
                    String company = matchingResult.getJobPosting().getCompany().getName();
                    String companyId = matchingResult.getJobPosting().getCompany().getId();
                    String jobId = matchingResult.getJobPosting().getJob().getId();
                    double score = matchingResult.getScore();
                    ExperienceCheck expLevel = matchingResult.getExperiencedCheck();
                    MatchingResult.StatusDistance statusDistance = matchingResult.getStatusDistance();
                    String status = "";

                    if (score > 50) {
                        status = "Qualified";
                        
                    } else {
                        status = "Not Qualified";
                        
                    }
                    System.out.printf("| %-5d | %-20s | %-10s | %-30s | %-8s | %-40s | %-20s | %-20s | %-10.2f | %-20s |\n",
                            matchResults.indexOf(matchingResult), studentName, companyId, company, jobId, jobTitle, statusDistance, expLevel, score, status);
                    found = true;
                }
               
            }
            if(!found){
                System.out.println("No matching student found: " + input);
            }
        }else{
            System.out.println("No matching results available to search.");        
        }
        System.out.println("======================================================================================================================================================================================================================");

    }
}

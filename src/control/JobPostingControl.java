/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.JobPostingManagementUI;
import dao.AllDataInitialize;
import entity.*;
import java.time.LocalDate;
import utility.JobPostingValidateFunction;
import utility.TrimToLength;

/**
 *
 * @author Ivanmjq
 */
public class JobPostingControl {

    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    private ListInterface<Job> jobList = new DoublyLinkedList<>();

    private ListInterface<Skill> skillList = new DoublyLinkedList<>();

    JobPostingManagementUI jobPostingManagementUI;
    JobControl jobControl;
    CompanyControl companyControl;

    public JobPostingControl(ListInterface<Company> companyList, ListInterface<Job> jobList, ListInterface<Skill> skillList) {
        this.companyList = companyList;
        this.jobList = jobList;
        this.skillList = skillList;

        jobPostingManagementUI = new JobPostingManagementUI(skillList);
        jobControl = new JobControl(jobList);
        companyControl = new CompanyControl(companyList);
    }

    public void startJobPostingManagement() {
        int option;

        do {
            option = jobPostingManagementUI.jobPostingManagementMenu();

            switch (option) {
                case 1:
                    addJobPosting();
                    break;
                case 2:
                    viewFunction();
                    break;
                case 3:
                    editJobPosting();
                    break;
                case 4:
                    deleteJobPosting();
                    break;
                case 5:
                    reportFunction(companyList);
                    break;
                case 0:
                    System.out.println("Returing to Main Menu ...");
                    break;
            }

        } while (option != 0);
    }

    public void addJobPosting() {
        Company company;
        Job job;
        String description;
        double mininumSalary;
        double maxinumSalary;
        int requiredExperience;
        LocalDate datePosted = LocalDate.now();

        ListInterface<JobRequiredSkill> jobRequiredSkillList = new DoublyLinkedList<>();

        String addConfirmation;

        System.out.println("\n--------------------");
        System.out.println(" Add Job Posting");
        System.out.println("--------------------");

        String exitString = "\nType 0 or X to return to the previous menu.\n";

        do {
            companyControl.viewFunction();
            System.out.println(exitString);
            String id = jobPostingManagementUI.getStringInput("Enter Company ID : ");
            id = id.toUpperCase();

            if (id.equals("0") || id.equals("X")) {
                return;
            }

            company = JobPostingValidateFunction.isValidCompanyId(id, companyList);
        } while (company == null);

        do {
            jobControl.viewFunction();
            System.out.println(exitString);
            String id = jobPostingManagementUI.getStringInput("Enter Job ID : ");
            id = id.toUpperCase();

            if (id.equals("0") || id.equals("X")) {
                return;
            }

            job = JobPostingValidateFunction.isValidJobId(id, jobList);
        } while (job == null);

        do {
            description = jobPostingManagementUI.getStringInput("Enter Job Posting Description : ");
        } while (!JobPostingValidateFunction.isValidDescription(description));

        do {
            mininumSalary = jobPostingManagementUI.getDoubleInput("Enter Minimum Salary : ");
            maxinumSalary = jobPostingManagementUI.getDoubleInput("Enter Maximum Salary : ");
        } while (!JobPostingValidateFunction.isValidSalaryRange(mininumSalary, maxinumSalary));

        do {
            requiredExperience = jobPostingManagementUI.getIntegerInput("Enter Required Experience (Years) : ");
        } while (!JobPostingValidateFunction.isValidRequiredExperience(requiredExperience));

        jobRequiredSkillList = addSkillsForNewJobPosting(jobRequiredSkillList);

        JobPosting newJobPosting = new JobPosting(company,
                job, description,
                mininumSalary,
                maxinumSalary,
                requiredExperience,
                datePosted);
        newJobPosting.setJobRequiredSkillList(jobRequiredSkillList);
        System.out.println(newJobPosting);

        do {
            addConfirmation = jobPostingManagementUI.getConfirmationPrompt("Do you want to add this Job Posting?");
        } while (!JobPostingValidateFunction.isValidConfirmation(addConfirmation));

        if (addConfirmation.equalsIgnoreCase("Y")) {
            company.getJobPostingList().add(newJobPosting);
            job.getJobPostingList().add(newJobPosting);
            System.out.println("Job Posting added successfully!");
        } else {
            System.out.println("Job Posting addition canceled.");
        }

    }

    private ListInterface<JobRequiredSkill> addSkillsForNewJobPosting(ListInterface<JobRequiredSkill> jobRequiredSkillList) {
        ListInterface<JobRequiredSkill> newJobRequiredSkillList = jobRequiredSkillList;
        String confirmationToAdd;

        do {
            int choice = jobPostingManagementUI.displaySkillMenu(); // Get skill selection
            Skill selectedSkill = skillList.getData(choice);
            System.out.println(selectedSkill);

            int importance;
            do {
                importance = jobPostingManagementUI.getIntegerInput("Enter importance for this skill (1-5) : ");
                if (importance < 1 || importance > 5) {
                    System.out.println("Invalid Importance. Must be between 1 and 5.");
                }
            } while (importance < 1 || importance > 5);

            JobRequiredSkill newJobRequiredSkill = new JobRequiredSkill(selectedSkill, importance);
            System.out.println(newJobRequiredSkill);

            newJobRequiredSkillList.add(new JobRequiredSkill(selectedSkill, importance));
            System.out.println("Job Required Skill added : " + newJobRequiredSkill.getSkill().getName() + " (Importance: " + newJobRequiredSkill.getImportance() + ")");

            do {
                confirmationToAdd = jobPostingManagementUI.getConfirmationPrompt("Do you want to add another skill?");
            } while (!JobPostingValidateFunction.isValidConfirmation(confirmationToAdd));

        } while (confirmationToAdd.equalsIgnoreCase("Y"));

        return newJobRequiredSkillList;
    }

    public void viewFunction() {
        int option;

        do {
            option = jobPostingManagementUI.getJobPostingViewOptions();

            switch (option) {
                case 1:
                    viewByMinimumSalaryRange();
                    break;
                case 2:
                    viewByMaximumSalaryRange();
                    break;
                case 3:
                    viewByRequiredExperienceRange();
                    break;
                case 4:
                    viewByDatePostedRange();
                    break;
                case 5:
                    viewAllJobPostingList();
                    break;
                case 0:
                    System.out.println("Exitting the View ...");
                    break;
            }

        } while (option != 0);

    }

    public void viewByMinimumSalaryRange() {
        if (companyList.isEmpty()) {
            System.out.println("No companies found. Cannot filter job postings.");
            return;
        }

        double startRange;
        double endRange;

        do {
            startRange = jobPostingManagementUI.getDoubleInput("Enter Start Range of Minimum Salary: ");
            endRange = jobPostingManagementUI.getDoubleInput("Enter End Range of Minimum Salary: ");
        } while (!JobPostingValidateFunction.isValidSalaryRange(startRange, endRange));

        boolean found = false;

        String line = "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+";
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.printf(" View Job Postings with Minimum Salary Between RM %.2f and RM %.2f\n", startRange, endRange);
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println(line);
        System.out.printf("| %-5s | %-30s | %-5s | %-25s | %-50s | %-12s | %-12s | %-10s | %-12s |\n",
                "C-ID", "Company Name", "J-ID", "Job Title", "Job Posting Description",
                "Min Salary", "Max Salary", "Experience", "Date Posted");
        System.out.println(line);

        for (Company company : companyList) {
            for (JobPosting posting : company.getJobPostingList()) {
                double salary = posting.getMinimumSalary();
                if (salary >= startRange && salary <= endRange) {
                    Job job = posting.getJob();

                    System.out.printf("| %-5s | %-30s | %-5s | %-25s | %-50s | %-12.2f | %-12.2f | %-10d | %-12s |\n",
                            company.getId(),
                            TrimToLength.trimToLength(company.getName(), 28),
                            job.getId(),
                            TrimToLength.trimToLength(job.getTitle(), 23),
                            TrimToLength.trimToLength(posting.getDescription(), 47),
                            posting.getMinimumSalary(),
                            posting.getMaximumSalary(),
                            posting.getRequiredExperience(),
                            posting.getDatePosted());
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.printf("|%160s|\n", "No job postings found with minimum salary between " + startRange + " and " + endRange);
        }

        System.out.println(line);
    }

    public void viewByMaximumSalaryRange() {
        if (companyList.isEmpty()) {
            System.out.println("No companies found. Cannot filter job postings.");
            return;
        }

        double startRange;
        double endRange;

        do {
            startRange = jobPostingManagementUI.getDoubleInput("Enter Start Range of Maximum Salary: ");
            endRange = jobPostingManagementUI.getDoubleInput("Enter End Range of Maximum Salary: ");
        } while (!JobPostingValidateFunction.isValidSalaryRange(startRange, endRange));

        boolean found = false;

        String line = "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+";
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.printf(" View Job Postings with Maximum Salary Between RM %.2f and RM %.2f\n", startRange, endRange);
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println(line);
        System.out.printf("| %-5s | %-30s | %-5s | %-25s | %-50s | %-12s | %-12s | %-10s | %-12s |\n",
                "C-ID", "Company Name", "J-ID", "Job Title", "Job Posting Description",
                "Min Salary", "Max Salary", "Experience", "Date Posted");
        System.out.println(line);

        for (Company company : companyList) {
            for (JobPosting posting : company.getJobPostingList()) {
                double salary = posting.getMaximumSalary();
                if (salary >= startRange && salary <= endRange) {
                    Job job = posting.getJob();

                    System.out.printf("| %-5s | %-30s | %-5s | %-25s | %-50s | %-12.2f | %-12.2f | %-10d | %-12s |\n",
                            company.getId(),
                            TrimToLength.trimToLength(company.getName(), 28),
                            job.getId(),
                            TrimToLength.trimToLength(job.getTitle(), 23),
                            TrimToLength.trimToLength(posting.getDescription(), 47),
                            posting.getMinimumSalary(),
                            posting.getMaximumSalary(),
                            posting.getRequiredExperience(),
                            posting.getDatePosted());
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.printf("|%160s|\n", "No job postings found with maximum salary between " + startRange + " and " + endRange);
        }

        System.out.println(line);
    }

    public void viewByRequiredExperienceRange() {
        if (companyList.isEmpty()) {
            System.out.println("No companies found. Cannot filter job postings.");
            return;
        }

        int minExperience;
        int maxExperience;

        do {
            minExperience = jobPostingManagementUI.getIntegerInput("Enter Minimum Years of Experience: ");
            maxExperience = jobPostingManagementUI.getIntegerInput("Enter Maximum Years of Experience: ");
        } while (!JobPostingValidateFunction.isValidRequiredExperience(minExperience)
                || !JobPostingValidateFunction.isValidRequiredExperience(maxExperience)
                || minExperience > maxExperience);

        boolean found = false;

        String line = "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+";
        System.out.println("\n-------------------------------------------------------------------------------------------");
        System.out.printf(" View Job Postings with Experience Requirement Between %d and %d Years\n", minExperience, maxExperience);
        System.out.println("-------------------------------------------------------------------------------------------");

        System.out.println(line);
        System.out.printf("| %-5s | %-30s | %-5s | %-25s | %-50s | %-12s | %-12s | %-10s | %-12s |\n",
                "C-ID", "Company Name", "J-ID", "Job Title", "Job Posting Description",
                "Min Salary", "Max Salary", "Experience", "Date Posted");
        System.out.println(line);

        for (Company company : companyList) {
            for (JobPosting posting : company.getJobPostingList()) {
                int experience = posting.getRequiredExperience();
                if (experience >= minExperience && experience <= maxExperience) {
                    Job job = posting.getJob();

                    System.out.printf("| %-5s | %-30s | %-5s | %-25s | %-50s | %-12.2f | %-12.2f | %-10d | %-12s |\n",
                            company.getId(),
                            TrimToLength.trimToLength(company.getName(), 28),
                            job.getId(),
                            TrimToLength.trimToLength(job.getTitle(), 23),
                            TrimToLength.trimToLength(posting.getDescription(), 47),
                            posting.getMinimumSalary(),
                            posting.getMaximumSalary(),
                            posting.getRequiredExperience(),
                            posting.getDatePosted());
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.printf("|%160s|\n", "No job postings found with experience requirement between " + minExperience + " and " + maxExperience + " years.");
        }

        System.out.println(line);
    }

    public void viewByDatePostedRange() {
        if (companyList.isEmpty()) {
            System.out.println("No companies found. Cannot filter job postings.");
            return;
        }

        LocalDate startDate;
        LocalDate endDate;

        do {
            startDate = jobPostingManagementUI.getDatePrompt("Enter Start Date (yyyy-MM-dd): ");
            endDate = jobPostingManagementUI.getDatePrompt("Enter End Date (yyyy-MM-dd): ");

            // Check if the start date is not after the end date
            if (startDate.isAfter(endDate)) {
                System.err.println("Start date cannot be after end date. Please enter valid dates.");
            }
        } while (startDate.isAfter(endDate));

        boolean found = false;
        String line = "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+";
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.printf(" View Job Postings with Date Posted Between %s and %s\n", startDate, endDate);
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println(line);
        System.out.printf("| %-5s | %-30s | %-5s | %-25s | %-50s | %-12s | %-12s | %-10s | %-12s |\n",
                "C-ID", "Company Name", "J-ID", "Job Title", "Job Posting Description",
                "Min Salary", "Max Salary", "Experience", "Date Posted");
        System.out.println(line);

        // Iterate over each company and its job postings
        for (Company company : companyList) {
            for (JobPosting posting : company.getJobPostingList()) {
                LocalDate postingDate = posting.getDatePosted();  // Assume this method returns a LocalDate
                // Check if posting date is within the range
                if (!postingDate.isBefore(startDate) && !postingDate.isAfter(endDate)) {
                    Job job = posting.getJob();
                    System.out.printf("| %-5s | %-30s | %-5s | %-25s | %-50s | %-12.2f | %-12.2f | %-10d | %-12s |\n",
                            company.getId(),
                            TrimToLength.trimToLength(company.getName(), 28),
                            job.getId(),
                            TrimToLength.trimToLength(job.getTitle(), 23),
                            TrimToLength.trimToLength(posting.getDescription(), 47),
                            posting.getMinimumSalary(),
                            posting.getMaximumSalary(),
                            posting.getRequiredExperience(),
                            posting.getDatePosted());
                    found = true;
                }
            }
        }

        // If no postings were found
        if (!found) {
            System.out.printf("|%160s|\n", "No job postings found within the date range.");
        }

        System.out.println(line);
    }

    public void viewAllJobPostingList() {
        String line = "+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+";
        System.out.println("\n----------------------------");
        System.out.println(" View All Job Postings List ");
        System.out.println("----------------------------");

        boolean isEmpty = true;
        for (Company company : companyList) {
            if (!company.getJobPostingList().isEmpty()) {
                isEmpty = false;
                break;
            }
        }

        if (isEmpty) {
            System.out.println("No Job Postings found.");
            return;
        }

        System.out.println(line);
        System.out.printf("| %-5s | %-30s | %-5s | %-25s | %-50s | %-12s | %-12s | %-10s | %-12s |\n",
                "C-ID", "Company Name", "J-ID", "Job Title", "Job Posting Description",
                "Min Salary", "Max Salary", "Experience", "Date Posted");
        System.out.println(line);

        for (Company company : companyList) {
            for (JobPosting posting : company.getJobPostingList()) {
                Job job = posting.getJob();

                System.out.printf("| %-5s | %-30s | %-5s | %-25s | %-50s | %-12.2f | %-12.2f | %-10d | %-12s |\n",
                        company.getId(),
                        TrimToLength.trimToLength(company.getName(), 28),
                        job.getId(),
                        TrimToLength.trimToLength(job.getTitle(), 23),
                        TrimToLength.trimToLength(posting.getDescription(), 47),
                        posting.getMinimumSalary(),
                        posting.getMaximumSalary(),
                        posting.getRequiredExperience(),
                        posting.getDatePosted());
            }
        }

        System.out.println(line);
    }

    public void editJobPosting() {
        if (companyList.isEmpty()) {
            System.out.println("No job postings available to edit.");
            return;
        }

        String exitString = "Type 0 or X to return to the Job Posting Management Menu.\n";

        JobPosting jobPostingFound;
        String confirmationToEdit = "N";

        do {
            viewAllJobPostingList();
            System.out.println(exitString);
            Company companyFound;
            Job jobFound;

            String companyId;
            do {
                companyId = jobPostingManagementUI.getStringInput("Enter Company ID : ");
                companyId = companyId.toUpperCase();
                if (companyId.equals("0") || companyId.equals("X")) {
                    return;
                }
                companyFound = JobPostingValidateFunction.isValidCompanyId(companyId, companyList);

            } while (companyFound == null);

            String jobId;
            do {
                jobId = jobPostingManagementUI.getStringInput("Enter Job ID : ").toUpperCase();
                if (jobId.equals("0") || jobId.equals("X")) {
                    return;
                }
                jobFound = JobPostingValidateFunction.isValidJobId(jobId, jobList);

            } while (jobFound == null);

            // Validate job posting from both IDs
            jobPostingFound = JobPostingValidateFunction.isValidJobPosting(companyFound, jobFound, companyList);

            if (jobPostingFound == null) {
                System.out.println("No job posting found for this Company ID and Job ID pair.");
                continue;
            }

            System.out.println("\nJob Posting Found:");
            System.out.println(jobPostingFound);

            do {
                confirmationToEdit = jobPostingManagementUI.getConfirmationPrompt("Do you want to edit this job posting?");
            } while (!JobPostingValidateFunction.isValidConfirmation(confirmationToEdit));

        } while (confirmationToEdit.equals("N"));

        int option;

        do {
            option = jobPostingManagementUI.jobPostingEditMenu();

            switch (option) {
                case 1: // Description
                    String desc;
                    do {
                        desc = jobPostingManagementUI.getStringInput("Enter Job Posting Description : ");
                    } while (!JobPostingValidateFunction.isValidDescription(desc));
                    jobPostingFound.setDescription(desc);
                    break;
                case 2: // Minimum Salary
                    double minimumSalary;
                    do {
                        System.out.println("Current Maximum Salary is " + jobPostingFound.getMaximumSalary());
                        minimumSalary = jobPostingManagementUI.getDoubleInput("Enter Minimum Salary : ");
                    } while (!JobPostingValidateFunction.isValidSalaryRange(minimumSalary, jobPostingFound.getMaximumSalary()));
                    jobPostingFound.setMinimumSalary(minimumSalary);
                    break;
                case 3: // Maximum Salary
                    double maximumSalary;
                    do {
                        System.out.println("Current Minimum Salary is " + jobPostingFound.getMinimumSalary());
                        maximumSalary = jobPostingManagementUI.getDoubleInput("Enter Maximum Salary : ");
                    } while (!JobPostingValidateFunction.isValidSalaryRange(jobPostingFound.getMinimumSalary(), maximumSalary));
                    jobPostingFound.setMaximumSalary(maximumSalary);
                    break;
                case 4: // Required Experience
                    int experience;
                    do {
                        experience = jobPostingManagementUI.getIntegerInput("Enter Required Experience (Years): ");
                    } while (!JobPostingValidateFunction.isValidRequiredExperience(experience));
                    jobPostingFound.setRequiredExperience(experience);
                    break;
                case 0:
                    System.out.println("Returning to Job Posting Management Menu..");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

            // Show updated job posting
            System.out.println("\n\nUpdated Job Posting:");
            System.out.println(jobPostingFound);

        } while (option != 0);
    }

    public void deleteJobPosting() {
        if (companyList.isEmpty()) {
            System.out.println("No job postings available to edit.");
            return;
        }

        String exitString = "Type 0 or X to return to the Job Posting Management Menu.\n";

        JobPosting jobPostingFound;
        String confirmationToEdit = "N";

        do {
            viewAllJobPostingList();
            System.out.println(exitString);
            Company companyFound;
            Job jobFound;

            String companyId;
            do {
                companyId = jobPostingManagementUI.getStringInput("Enter Company ID : ");
                companyId = companyId.toUpperCase();
                if (companyId.equals("0") || companyId.equals("X")) {
                    return;
                }
                companyFound = JobPostingValidateFunction.isValidCompanyId(companyId, companyList);

            } while (companyFound == null);

            String jobId;
            do {
                jobId = jobPostingManagementUI.getStringInput("Enter Job ID : ").toUpperCase();
                if (jobId.equals("0") || jobId.equals("X")) {
                    return;
                }
                jobFound = JobPostingValidateFunction.isValidJobId(jobId, jobList);

            } while (jobFound == null);

            // Validate job posting from both IDs
            jobPostingFound = JobPostingValidateFunction.isValidJobPosting(companyFound, jobFound, companyList);

            if (jobPostingFound == null) {
                System.out.println("No job posting found for this Company ID and Job ID pair.");
                continue;
            }

            System.out.println("\nJob Posting Found:");
            System.out.println(jobPostingFound);

            do {
                confirmationToEdit = jobPostingManagementUI.getConfirmationPrompt("Do you want to edit this job posting?");
            } while (!JobPostingValidateFunction.isValidConfirmation(confirmationToEdit));

        } while (confirmationToEdit.equals("N"));

        boolean isJobApplicationRemoved = removeJobApplicationFromStudent(jobPostingFound);
        boolean isJobApplicationRemoved2 = removeJobApplicationFromInterview(jobPostingFound);
        boolean isJobPostingFromCompanyRemoved = removeJobPostingFromCompany(jobPostingFound);
        boolean isJobPostingFromJobRemoved = removeJobPostingFromJob(jobPostingFound);

        if (isJobApplicationRemoved && isJobApplicationRemoved2 && isJobPostingFromCompanyRemoved && isJobPostingFromJobRemoved) {
            System.out.println("Job Posting successfully deleted.");
        } else {
            if (!isJobApplicationRemoved) {
                System.err.println("Failed to remove Job Application from Student.");
                System.err.flush();
            }
            if (!isJobApplicationRemoved2) {
                System.err.println("Failed to remove Job Application from Interview");
                System.err.flush();
            }
            if (!isJobPostingFromCompanyRemoved) {
                System.err.println("Failed to remove Job Posting from Company.");
                System.err.flush();
            }
            if (!isJobPostingFromJobRemoved) {
                System.err.println("Failed to remove Job Posting from Job.");
                System.err.flush();
            }
        }

    }

    public static void reportFunction(ListInterface<Company> companyList) {
        String title = "Company Job Posting Summary Report";
        int totalWidth = 174; // Adjust the total width as needed
        int titleWidth = title.length();
        int spacesBefore = (totalWidth - titleWidth) / 2;
        String line = "+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+";

        System.out.println("\n" + line);
        System.out.printf("| %" + spacesBefore + "s%s%" + (totalWidth - spacesBefore - titleWidth) + "s |\n", "", title, "");
        System.out.println(line);
        System.out.printf("| %-50s | %-60s | %-15s | %-12s | %-25s |\n", "Company", "Job", "Total", "Offered", "");
        System.out.printf("| %-50s | %-60s | %-15s | %-12s | %-25s |\n", "", "Titles", "Applications", "Unoffered", "");
        System.out.println(line);

        for (int i = 1; i <= companyList.size(); i++) {
            Company company = companyList.getData(i);
            ListInterface<JobPosting> jpList = company.getJobPostingList();

            for (int j = 1; j <= jpList.size(); j++) {
                JobPosting jp = jpList.getData(j);
                ListInterface<JobApplication> jAppList = jp.getJobApplicationList();

                int totaljApp = jAppList.size();
                int offered = 0;

                for (int k = 1; k <= totaljApp; k++) {
                    JobApplication jApp = jAppList.getData(k);
                    Interview interview = jApp.getInterview();
                    if (interview != null && interview.getInterviewStatus() == Interview.InterviewStatus.OFFERED) {
                        offered++;
                    }
                }

                int unoffered = totaljApp - offered;
                
                String offeredBar = repeatChar('#', offered);
                String unofferedBar = repeatChar('-', unoffered);

                System.out.printf("| %-50s | %-60s | %-15d | %-12s | %-25s |\n",
                        company.getName(), jp.getJob().getTitle(), totaljApp, "Offered", offeredBar);
                System.out.printf("| %-50s | %-60s | %-15s | %-12s | %-25s |\n",
                        "", "", "", "Unoffered", unofferedBar);
            }

            System.out.println(line); // space between companies
        }

    }

    private static String repeatChar(char ch, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += ch;
        }
        return result;
    }

    public static boolean removeJobApplicationFromStudent(JobPosting jobPosting) {
        ListInterface<JobApplication> jAppList = jobPosting.getJobApplicationList();
        boolean isSuccess = true;

        for (JobApplication jApp : jAppList) {
            Student student = jApp.getStudent();
            int jAppIndex = student.getJobApplicationList().indexOf(jApp);
            if (jAppIndex != -1) {
                JobApplication removedJobApplication = student.getJobApplicationList().remove(jAppIndex);
                if (removedJobApplication != null) {
                    System.out.println("Successfully removed JobApplication with ID: "
                            + removedJobApplication.getJobPosting().getJob().getId() + ", "
                            + removedJobApplication.getStudent().getId());
                } else {
                    System.err.println("Failed to remove JobApplication with ID: "
                            + jApp.getJobPosting().getJob().getId() + ", "
                            + jApp.getStudent().getId());
                    isSuccess = false;
                }
            } else {
                System.err.println("Failed to find the Job Application in its Student's Job Application List.");
            }
        }
        return isSuccess;
    }

    public static boolean removeJobApplicationFromInterview(JobPosting jobPosting) {
        ListInterface<JobApplication> jAppList = jobPosting.getJobApplicationList();
        boolean isSuccess = true;

        for (JobApplication jApp : jAppList) {
            Interview interview = jApp.getInterview();
            int jAppIndex = interview.getJobApplicationList().indexOf(jApp);
            if (jAppIndex != -1) {
                JobApplication removedJobApplication = interview.getJobApplicationList().remove(jAppIndex);
                if (removedJobApplication != null) {
                    System.out.println("Successfully removed JobApplication with ID: "
                            + removedJobApplication.getJobPosting().getJob().getId() + ", "
                            + removedJobApplication.getInterview().getId());
                } else {
                    System.err.println("Failed to remove JobApplication with ID: "
                            + jApp.getJobPosting().getJob().getId() + ", "
                            + jApp.getInterview().getId());
                    isSuccess = false;
                }
            }
        }
        return isSuccess;
    }

    public static boolean removeJobPostingFromCompany(JobPosting jobPosting) {
        Company company = jobPosting.getCompany();
        int jpIndexInCompany = company.getJobPostingList().indexOf(jobPosting);

        if (jpIndexInCompany != -1) {
            JobPosting removedJp = company.getJobPostingList().remove(jpIndexInCompany);
            if (removedJp != null) {
                System.out.println("Successfully removed Job Posting with ID : "
                        + removedJp.getCompany().getId() + ", "
                        + removedJp.getJob().getId());
                return true;
            } else {
                System.err.println("Failed to remove Job Posting with ID : "
                        + jobPosting.getCompany().getId() + ", "
                        + jobPosting.getJob().getId());
            }
        } else {
            System.err.println("Failed to find the Job Posting in its Company's Job Posting List.");
        }
        return false;
    }

    public static boolean removeJobPostingFromJob(JobPosting jobPosting) {
        Job job = jobPosting.getJob();
        int jpIndexInJob = job.getJobPostingList().indexOf(jobPosting);

        if (jpIndexInJob != -1) {
            JobPosting removedJp = job.getJobPostingList().remove(jpIndexInJob);
            if (removedJp != null) {
                System.out.println("Successfully removed Job Posting with ID: "
                        + removedJp.getCompany().getId() + ", "
                        + removedJp.getJob().getId());
                return true;
            } else {
                System.err.println("Failed to remove Job Posting with ID: "
                        + jobPosting.getCompany().getId() + ", "
                        + jobPosting.getJob().getId());
            }
        } else {
            System.err.println("Failed to find the Job Posting in its Job's Job Posting List.");
        }
        return false;
    }

    public static void main(String[] args) {
        AllDataInitialize dataInitialize = new AllDataInitialize();

        ListInterface<Company> companyList = dataInitialize.getCompanyList();
        ListInterface<Job> jobList = dataInitialize.getJobList();
        ListInterface<Skill> skillList = dataInitialize.getSkillList();

//        JobPostingControl jobPostingControl = new JobPostingControl(companyList, jobList, skillList);
//        jobPostingControl.startJobPostingManagement();
        JobPostingControl.reportFunction(companyList);
    }

}

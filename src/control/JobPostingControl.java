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

/**
 *
 * @author Ivanmjq
 */
public class JobPostingControl {

    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    private ListInterface<Job> jobList = new DoublyLinkedList<>();
    private ListInterface<Student> studentList = new DoublyLinkedList<>();
    private ListInterface<Interview> interviewList = new DoublyLinkedList<>();

    private ListInterface<Skill> skillList = new DoublyLinkedList<>();
    JobPostingManagementUI jobPostingManagementUI = new JobPostingManagementUI(skillList);
    JobControl jobControl;
    CompanyControl companyControl;

    public JobPostingControl(ListInterface<Company> companyList, ListInterface<Job> jobList, ListInterface<Student> studentList, ListInterface<Interview> interviewList, ListInterface<Skill> skillList) {
        this.companyList = companyList;
        this.jobList = jobList;
        this.studentList = studentList;
        this.interviewList = interviewList;
        this.skillList = skillList;

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
                    viewAllJobPostingList();
                    break;
                case 3:
                    editJobPosting();
                    break;
                case 4:
                    deleteJobPosting();
                    break;
                case 5:

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

        String addConfirmation;

        System.out.println("\n--------------------");
        System.out.println(" Add Job Posting");
        System.out.println("--------------------");

        String exitString = "Type 0 or X to return to the previous menu.\n";

        do {
            companyControl.viewAllCompanyList();
            System.out.println(exitString);
            String id = jobPostingManagementUI.getStringInput("Enter Company ID : ");
            id = id.toUpperCase();

            if (id.equals("0") || id.equals("X")) {
                return;
            }

            company = JobPostingValidateFunction.isValidCompanyId(id, companyList);
        } while (company == null);

        do {
            jobControl.viewAllJobList();
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

        do {
            addConfirmation = jobPostingManagementUI.getConfirmationPrompt("Do you want to add this Job Posting?");
        } while (!JobPostingValidateFunction.isValidConfirmation(addConfirmation));

        JobPosting newJobPosting = new JobPosting(company,
                job, description,
                mininumSalary,
                maxinumSalary,
                requiredExperience,
                datePosted);

        company.getJobPostingList().add(newJobPosting);
        job.getJobPostingList().add(newJobPosting);

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
                "C_ID", "Company Name", "J_ID", "Job Title", "Job Posting Description",
                "Min Salary", "Max Salary", "Experience", "Date Posted");
        System.out.println(line);

        for (Company company : companyList) {
            for (JobPosting posting : company.getJobPostingList()) {
                Job job = posting.getJob();

                System.out.printf("| %-5s | %-30s | %-5s | %-25s | %-50s | %-12.2f | %-12.2f | %-10d | %-12s |\n",
                        company.getId(),
                        jobPostingManagementUI.trimToLength(company.getName(), 28),
                        job.getId(),
                        jobPostingManagementUI.trimToLength(job.getTitle(), 23),
                        jobPostingManagementUI.trimToLength(posting.getDescription(), 47),
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
        ListInterface<Student> studentList = dataInitialize.getStudentList();
        ListInterface<Interview> interviewList = dataInitialize.getInterviewList();
        ListInterface<Skill> skillList = dataInitialize.getSkillList();

        JobPostingControl jobPostingControl = new JobPostingControl(companyList, jobList, studentList, interviewList, skillList);

        jobPostingControl.startJobPostingManagement();
    }

}

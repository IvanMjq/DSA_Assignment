/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.JobManagementUI;
import dao.AllDataInitialize;
import entity.Company;
import entity.Interview;
import entity.Job;
import entity.JobApplication;
import entity.JobPosting;
import entity.Student;
import utility.IdGeneration;
import utility.JobValidateFunction;

/**
 *
 * @author Ivanmjq
 */
public class JobControl {

    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    private ListInterface<Job> jobList = new DoublyLinkedList<>();
    private ListInterface<Student> studentList = new DoublyLinkedList<>();
    private ListInterface<Interview> interviewList = new DoublyLinkedList<>();

    JobManagementUI jobManagementUI = new JobManagementUI();

    public JobControl(ListInterface<Company> companyList, ListInterface<Job> jobList, ListInterface<Student> studentList, ListInterface<Interview> interviewList) {
        this.companyList = companyList;
        this.jobList = jobList;
        this.studentList = studentList;
        this.interviewList = interviewList;
    }

    public void startJobManagement() {
        int option;

        do {
            option = jobManagementUI.jobManagementMenu();

            switch (option) {
                case 1:
                    addJob();
                    break;
                case 2:
                    viewJobList();
                    break;
                case 3:
                    editJob();
                    break;
                case 4:
                    deleteJob();
                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("Returing to Main Menu ...");
                    break;
            }

        } while (option != 0);
    }

    public void addJob() {
        String id;
        String title;
        String type;
        String desc;

        String addConfirmation;

        id = IdGeneration.generateID(jobList, "J");

        System.out.println("\n--------------------");
        System.out.println(" Add Job ");
        System.out.println("--------------------");

        do {
            title = jobManagementUI.getStringInput("Enter Job Title : ");
        } while (!JobValidateFunction.isValidTitle(title));

        type = jobManagementUI.getJobType();

        do {
            desc = jobManagementUI.getStringInput("Enter Job Description : ");
        } while (!JobValidateFunction.isValidDescription(desc));

        System.out.println(id + "aaaaaa");

        do {
            addConfirmation = jobManagementUI.getConfirmationPrompt("Do you want to add this job?");
        } while (!JobValidateFunction.isValidConfirmation(addConfirmation));

        if (addConfirmation.equals("Y")) {

            Job newJob = new Job(id, title, type, desc);
            boolean isAdded = jobList.add(newJob);
            if (isAdded) {
                System.out.println("Company added successfully!");
            } else {
                System.err.println("Failed to add company. Please try agian.");
                System.err.flush();
            }
        } else {
            // Cancel the addition
            System.out.println("Job addition canceled.");
        }

    }

    public void viewJobList() {
        String line = "+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+";
        System.out.println("\n--------------------");
        System.out.println(" View Job List ");
        System.out.println("--------------------");

        System.out.println(line);
        System.out.printf("| %-8s | %-35s | %-25s | %-85s |\n",
                "ID", "Title", "Type", "Description");
        System.out.println(line);

        if (jobList.isEmpty()) {
            System.out.println("No companies found.");
        } else {
            for (Job j : jobList) {
                String desc = j.getDesc().length() > 75 ? j.getDesc().substring(0, 82) + "..." : j.getDesc();
                System.out.printf("| %-8s | %-35s | %-25s | %-85s |\n",
                        j.getId(),
                        jobManagementUI.trimToLength(j.getTitle(), 28),
                        jobManagementUI.trimToLength(j.getType(), 22),
                        desc);
            }
        }

        System.out.println(line);
    }

    public void editJob() {
        if (companyList.isEmpty()) {
            System.out.println("No companies available to edit.");
            return;
        }

        String id;
        Job jobFound = null;
        String confirmationToEdit;

        do {
            do {
                viewJobList();
                System.out.println("Type 0 or X to return to the previous menu.\n");
                id = jobManagementUI.getStringInput("Enter Job ID : ");
                id = id.toUpperCase();

                if (id.equals("0") || id.equals("X")) {
                    return;
                }

                jobFound = JobValidateFunction.isValidJobId(id, jobList);
            } while (jobFound == null);

            System.out.println(jobList);

            do {
                confirmationToEdit = jobManagementUI.getConfirmationPrompt("Do you want to edit this company?");
            } while (!JobValidateFunction.isValidConfirmation(confirmationToEdit));

        } while (confirmationToEdit.equals("N"));

        int option;

        do {
            option = jobManagementUI.jobEditMenu();

            switch (option) {
                case 1: // title
                    String title;
                    do {
                        title = jobManagementUI.getStringInput("Enter Job Title : ");
                    } while (!JobValidateFunction.isValidTitle(title));
                    jobFound.setTitle(title);
                    break;
                case 2: // type
                    String type = jobManagementUI.getJobType();
                    jobFound.setType(type);
                    break;
                case 3: // desc
                    String desc;
                    do {
                        desc = jobManagementUI.getStringInput("Enter Job Description : ");
                    } while (!JobValidateFunction.isValidDescription(desc));
                    jobFound.setDesc(desc);
                    break;
                case 0:
                    System.out.println("Returning to Job Management Menu..");
            }

            // Display the updated company
            System.out.println("\n\nUpdated Job : ");
            System.out.println(jobFound);

        } while (option != 0);

    }

    public void deleteJob() {
        if (companyList.isEmpty()) {
            System.out.println("No companies available to delete.");
            return;
        }

        String id;
        Job jobFound = null;
        String confirmationToEdit;

        do {
            do {
                viewJobList();
                System.out.println("Type 0 or X to return to the previous menu.\n");
                id = jobManagementUI.getStringInput("Enter Job ID : ");
                id = id.toUpperCase();

                if (id.equals("0") || id.equals("X")) {
                    return;
                }

                jobFound = JobValidateFunction.isValidJobId(id, jobList);
            } while (jobFound == null);

            System.out.println(jobList);

            do {
                confirmationToEdit = jobManagementUI.getConfirmationPrompt("Do you want to delete this job?");
            } while (!JobValidateFunction.isValidConfirmation(confirmationToEdit));

        } while (confirmationToEdit.equals("N"));

        // Remove JobApplication of the job in the Student & Interview and the JobPosting of the job in the company
        removeJobPostingsFromCompany(jobFound);
        removeJobApplicationsFromStudents(jobFound);
        removeJobApplicationsFromInterviews(jobFound);

        // Clear the JobPosting list of the company 
        jobFound.getJobPostingList().clear();

        // Remove the company
        int jobIndex = jobList.indexOf(jobFound);

        if (jobIndex != -1) {
            Job removedJob = jobList.remove(jobIndex);

            if (removedJob != null) {
                System.out.println("Successfully removed Job with ID : " + removedJob.getId());
                System.out.println("Remaining Jobs: " + companyList.size());
            } else {
                System.err.println("Error. Failed to removed Job with ID : " + jobFound.getId());
                System.err.flush();
            }
        } else {
            System.err.println("Error. Failed to get Job.");
            System.err.flush();
        }

    }

    private void removeJobPostingsFromCompany(Job job) {
        ListInterface<JobPosting> jobPostings = job.getJobPostingList();

        for (int i = jobPostings.size(); i > 0; i--) {
            JobPosting jobPosting = jobPostings.getData(i);

            for (int j = companyList.size(); j > 0; j--) {
                Company company = companyList.getData(j);
                ListInterface<JobPosting> companyJobPostings = company.getJobPostingList();

                for (int k = companyJobPostings.size(); k > 0; k--) {
                    JobPosting companyPosting = companyJobPostings.getData(k);

                    if (companyPosting.equals(jobPosting)) {
                        JobPosting removed = companyJobPostings.remove(k);
                        if (removed != null) {
                            System.out.println("Successfully removed JobPosting with ID: " + removed.getCompany().getId() + ", " + removed.getJob().getId());
                        } else {
                            System.err.println("Failed to remove JobPosting with ID: " + jobPosting.getCompany().getId() + ", " + jobPosting.getJob().getId());
                        }
                    }
                }
            }
        }
    }

    private void removeJobApplicationsFromStudents(Job job) {
        for (int i = job.getJobPostingList().size(); i > 0; i--) {
            JobPosting jJp = job.getJobPostingList().getData(i);

            for (JobApplication jJApp : jJp.getJobApplicationList()) {
                for (Student student : studentList) {
                    ListInterface<JobApplication> studentJobApplicationList = student.getJobApplicationList();

                    for (int j = studentJobApplicationList.size(); j > 0; j--) {
                        JobApplication sJApp = studentJobApplicationList.getData(j);

                        if (sJApp.equals(jJApp)) {
                            JobApplication removedJobApplication = studentJobApplicationList.remove(j);
                            if (removedJobApplication != null) {
                                System.out.println("Successfully removed JobApplication with ID : " + removedJobApplication.getJobPosting().getJob().getId() + ", " + removedJobApplication.getStudent().getId());
                            } else {
                                System.err.println("Failed to remove JobApplication with ID : " + sJApp.getJobPosting().getJob().getId() + ", " + sJApp.getStudent().getId());
                            }
                        }
                    }
                }
            }
        }
    }

    private void removeJobApplicationsFromInterviews(Job job) {
        for (int i = job.getJobPostingList().size(); i > 0; i--) {
            JobPosting jJp = job.getJobPostingList().getData(i);

            for (JobApplication jJApp : jJp.getJobApplicationList()) {
                for (Interview interview : interviewList) {
                    ListInterface<JobApplication> interviewJobApplicationList = interview.getJobApplicationList();

                    for (int j = interviewJobApplicationList.size(); j > 0; j--) {
                        JobApplication iJApp = interviewJobApplicationList.getData(j);

                        if (iJApp.equals(jJApp)) {
                            JobApplication removedJobApplication = interviewJobApplicationList.remove(j);
                            if (removedJobApplication != null) {
                                System.out.println("Successfully removed JobApplication with ID : " + removedJobApplication.getJobPosting().getJob().getId() + ", " + removedJobApplication.getInterview().getId());
                            } else {
                                System.err.println("Failed to remove JobApplication with ID : " + iJApp.getJobPosting().getJob().getId() + ", " + iJApp.getInterview().getId());
                            }
                        }
                    }
                }
            }
        }
    }

    // Just for testing purpose 
    public static void main(String[] args) {
        AllDataInitialize dataInitialize = new AllDataInitialize();

        ListInterface<Company> companyList = dataInitialize.getCompanyList();
        ListInterface<Job> jobList = dataInitialize.getJobList();
        ListInterface<Student> studentList = dataInitialize.getStudentList();
        ListInterface<Interview> interviewList = dataInitialize.getInterviewList();

        JobControl jobControl = new JobControl(companyList, jobList, studentList, interviewList);

        jobControl.startJobManagement();
    }

}

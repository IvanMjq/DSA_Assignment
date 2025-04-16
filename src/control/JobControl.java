/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.JobManagementUI;
import dao.AllDataInitialize;
import entity.Job;
import entity.JobPosting;
import utility.IdGeneration;
import utility.JobValidateFunction;
import utility.TrimToLength;

/**
 *
 * @author Ivanmjq
 */
public class JobControl {

    private ListInterface<Job> jobList = new DoublyLinkedList<>();

    JobManagementUI jobManagementUI = new JobManagementUI();

    public JobControl(ListInterface<Job> jobList) {
        this.jobList = jobList;
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
                    viewFunction();
                    break;
                case 3:
                    editJob();
                    break;
                case 4:
                    deleteJob();
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

        Job newJob = new Job(id, title, type, desc);
        System.out.println(newJob);
        
        do {
            addConfirmation = jobManagementUI.getConfirmationPrompt("Do you want to add this job?");
        } while (!JobValidateFunction.isValidConfirmation(addConfirmation));

        if (addConfirmation.equals("Y")) {

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

    public void viewFunction() {
        int option;

        do {
            option = jobManagementUI.getJobViewOptions();

            switch (option) {
                case 1:
                    viewByJobTypes();
                    break;
                case 2:
                    viewAllJobList();
                    break;
                case 0:
                    System.out.println("Exitting the View ...");
                    break;
            }

        } while (option != 0);

    }

    public void viewByJobTypes() {
        if (jobList.isEmpty()) {
            System.out.println("No Jobs found.");
            return;
        }

        String selectedJobType = jobManagementUI.getJobType();

        System.out.println("\n------------------------------------------");
        System.out.println(" Filter Jobs by" + selectedJobType);
        System.out.println("------------------------------------------");

        String line = "+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+";

        System.out.println(line);
        System.out.printf("| %-8s | %-35s | %-25s | %-85s |\n",
                "ID", "Title", "Type", "Description");
        System.out.println(line);

        boolean found = false;

        for (Job job : jobList) {
            if (job.getType().equalsIgnoreCase(selectedJobType)) {
                System.out.printf("| %-8s | %-35s | %-25s | %-85s |\n",
                        job.getId(),
                        TrimToLength.trimToLength(job.getTitle(), 28),
                        TrimToLength.trimToLength(job.getType(), 22),
                        TrimToLength.trimToLength(job.getDesc(), 82));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No jobs found for the selected job type.");
        }

        System.out.println(line);

    }

    public void viewAllJobList() {
        String line = "+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+";
        System.out.println("\n--------------------");
        System.out.println(" View Job List ");
        System.out.println("--------------------");

        System.out.println(line);
        System.out.printf("| %-8s | %-35s | %-25s | %-85s |\n",
                "ID", "Title", "Type", "Description");
        System.out.println(line);

        if (jobList.isEmpty()) {
            System.out.println("No Jobs found.");
        } else {
            for (Job j : jobList) {
                System.out.printf("| %-8s | %-35s | %-25s | %-85s |\n",
                        j.getId(),
                        TrimToLength.trimToLength(j.getTitle(), 28),
                        TrimToLength.trimToLength(j.getType(), 22),
                        TrimToLength.trimToLength(j.getDesc(), 82)
                );
            }
        }

        System.out.println(line);
    }

    public void editJob() {
        if (jobList.isEmpty()) {
            System.out.println("No Jobs available to edit.");
            return;
        }

        String id;
        Job jobFound = null;
        String confirmationToEdit;

        do {
            do {
                viewAllJobList();
                System.out.println("Type 0 or X to return to the Job Management Menu.\n");
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
        if (jobList.isEmpty()) {
            System.out.println("No companies available to delete.");
            return;
        }

        String id;
        Job jobFound = null;
        String confirmationToDelete;

        do {
            do {
                viewAllJobList();
                System.out.println("Type 0 or X to return to the Job Management Menu.\n");
                id = jobManagementUI.getStringInput("Enter Job ID : ");
                id = id.toUpperCase();

                if (id.equals("0") || id.equals("X")) {
                    return;
                }

                jobFound = JobValidateFunction.isValidJobId(id, jobList);
            } while (jobFound == null);

            System.out.println(jobFound);

            do {
                confirmationToDelete = jobManagementUI.getConfirmationPrompt("Do you want to delete this job?");
            } while (!JobValidateFunction.isValidConfirmation(confirmationToDelete));

        } while (confirmationToDelete.equals("N"));

        removeJobFromList(jobFound);

    }

    public void removeJobFromList(Job jobFound) {
        ListInterface<JobPosting> jpList = jobFound.getJobPostingList();

        for (JobPosting jp : jpList) {
            JobPostingControl.removeJobApplicationFromStudent(jp);
            JobPostingControl.removeJobApplicationFromInterview(jp);
            JobPostingControl.removeJobPostingFromJob(jp);
        }

        jobFound.getJobPostingList().clear();

        int jobIndex = jobList.indexOf(jobFound);
        Job removedJob = jobList.remove(jobIndex);
        if (removedJob != null) {
            System.out.println("Successfully removed Job with ID : "
                    + removedJob.getId()
            );
        } else {
            System.err.println("Failed to remove Job wih ID : "
                    + jobFound.getId()
            );
        }
    }

    // Just for testing purpose 
    public static void main(String[] args) {
        AllDataInitialize dataInitialize = new AllDataInitialize();

        ListInterface<Job> jobList = dataInitialize.getJobList();

        JobControl jobControl = new JobControl(jobList);

        jobControl.startJobManagement();
    }

}

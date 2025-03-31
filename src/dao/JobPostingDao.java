/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.JobPosting;
import adt.ListInterface;
import adt.DoublyLinkedList;
/**
 *
 * @author WEI ZHENG
 */
public class JobPostingDao {

    private ListInterface<JobPosting> jobPost;

    public JobPostingDao() {
        this.jobPost = new DoublyLinkedList<>();
    }


    public void addJobPosting(JobPosting jobpost) {
        jobPost.add(jobpost);
    }


    public JobPosting getJobPosting(String id) {
        for (int i = 1; i <= jobPost.getNumberOfEntries(); i++) {
            JobPosting j = jobPost.getEntry(i);
            if (j.getId().equals(id)) {
                return j;
            }
        }
        return null;
    }


    public ListInterface<JobPosting> getAllJobPostings() {
        return jobPost;
    }


    public void updateJobPosting(JobPosting job) {
        for (int i = 1; i <= jobPost.getNumberOfEntries(); i++) {
            JobPosting j = jobPost.getEntry(i);
            if (j.getId().equals(job.getId())) {
                jobPost.replace(i, job);
                return;
            }
        }
    }


    public void deleteJobPosting(String id) {
        for (int i = 1; i <= jobPost.getNumberOfEntries(); i++) {
            JobPosting j = jobPost.getEntry(i);
            if (j.getId().equals(id)) {
                jobPost.remove(i);
                return;
            }
        }
    }
}
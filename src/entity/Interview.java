/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Lim Zi Qi
 */
public class Interview implements Serializable {

    public enum InterviewStatus {
        APPLIED,
        INTERVIEW_SCHEDULED,
        INTERVIEWED,
        OFFERED,
        REJECTED,
        ACCEPTED,
        DECLINED
    }

    private String id;
    private LocalDateTime scheduledDateTime;
    private InterviewStatus interviewStatus;
    private ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
    private int interviewMark;
    
    public Interview() {
    
    }

    public Interview(String id, LocalDateTime scheduledDateTime, InterviewStatus interviewStatus, int interviewMark) {
        this.id = id;
        this.scheduledDateTime = scheduledDateTime;
        this.interviewStatus = interviewStatus;
        this.interviewMark = interviewMark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public LocalDateTime getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(LocalDateTime scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public InterviewStatus getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(InterviewStatus interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public ListInterface<JobApplication> getJobApplicationList() {
        return jobApplicationList;
    }

    public void setJobApplicationList(ListInterface<JobApplication> jobApplicationList) {
        this.jobApplicationList = jobApplicationList;
    }
    
    public int getInterviewMark() {
        return interviewMark;
    }

    public void setInterviewMark(int interviewMark) {
        this.interviewMark = interviewMark;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Interview other = (Interview) obj;
        return Objects.equals(this.id, other.id);
        // Check if the id are same
    }
    
    @Override
    public String toString() {
        return "Interview{" + "id=" + id + ", scheduledDateTime=" + scheduledDateTime + ", interviewStatus=" + interviewStatus + ", jobApplicationList=" + jobApplicationList + ", interviewMark=" + interviewMark + '}';
    }      

}

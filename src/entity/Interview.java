/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Secret
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

    private LocalDateTime scheduledDateTime;
    private InterviewStatus interviewStatus;
    private int interviewMark;
    
    public Interview() {
    
    }

    public Interview(LocalDateTime scheduledDateTime, InterviewStatus interviewStatus, int interviewMark) {
        this.scheduledDateTime = scheduledDateTime;
        this.interviewStatus = interviewStatus;
        this.interviewMark = interviewMark;
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

    public int getInterviewMark() {
        return interviewMark;
    }

    public void setInterviewMark(int interviewMark) {
        this.interviewMark = interviewMark;
    }

    @Override
    public String toString() {
        return "Interview{" + "scheduledDateTime=" + scheduledDateTime + ", interviewStatus=" + interviewStatus + ", interviewMark=" + interviewMark + '}';
    }   

}

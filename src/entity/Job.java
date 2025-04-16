/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.DoublyLinkedList;
import adt.ListInterface;
import java.io.Serializable;
import java.util.Objects;
import utility.IdGeneration;
import utility.TrimToLength;

/**
 *
 * @author ivanmjq
 */
public class Job implements Serializable, IdGeneration.Identifiable, Comparable<Job> {

    private String id;
    private String title;
    private String type;
    private String desc;

    private ListInterface<JobPosting> jobPostingList = new DoublyLinkedList<>();

    public Job(String id, String title, String type, String desc) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.desc = desc;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ListInterface<JobPosting> getJobPostingList() {
        return jobPostingList;
    }

    public void setJobPostingList(ListInterface<JobPosting> jobPostingList) {
        this.jobPostingList = jobPostingList;
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
        final Job other = (Job) obj;
        return Objects.equals(this.id, other.id);
        //check if the id are same
    }

    @Override
    public String toString() {
        String line = "+---------------------------------------------------------------+\n";
        StringBuilder sb = new StringBuilder();

        sb.append("\n").append(line);
        sb.append(String.format("| %-61s |\n", "Job Information"));
        sb.append(line);
        sb.append(String.format("| %-15s : %-43s |\n", "Job ID", TrimToLength.trimToLength(id, 43)));
        sb.append(String.format("| %-15s : %-43s |\n", "Title", TrimToLength.trimToLength(title, 43)));
        sb.append(String.format("| %-15s : %-43s |\n", "Type", TrimToLength.trimToLength(type, 43)));
        sb.append(String.format("| %-15s : %-43s |\n", "Description", TrimToLength.trimToLength(desc, 43)));
        sb.append(line);

        return sb.toString();
    }

    @Override
    public int compareTo(Job other) {
        return this.type.compareTo(other.getType());
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ivanmjq
 */
public class Job implements Serializable {
    
    private String id;
    private String title;
    private String type;
    private String desc;

    public Job(String id, String title, String type, String desc) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.desc = desc;
    }

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
        return "Job{" + "id='" + id + '\'' + ", title='" + title + '\'' +
               ", desc='" + (desc.length() > 60 ? desc.substring(0, 57) + "..." : desc) + '\'' + '}';
    }

}

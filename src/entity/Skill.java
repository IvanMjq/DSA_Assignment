/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.DoublyLinkedList;
import adt.ListInterface;
import java.io.Serializable;

/**
 *
 * @author Teh Yi Shan
 */
public class Skill implements Serializable {
    private String id;
    private String name;

    public Skill(String id, String name) {
        this.id     = id;
        this.name   = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" + "id=" + id + ", name=" + name + ", studentSkillsList=" + '}';
    }
    
}

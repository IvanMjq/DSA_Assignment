/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedList;
import adt.ListInterface;
import dao.JobRelatedDataInitialize;
import dao.StudentDetailsDao;
import entity.Skill;
import java.util.Scanner;
import entity.Student;
    

/**
 *
 * @author WEI ZHENG
 */
public class StudentUI {

    StudentDetailsDao studentDao = new StudentDetailsDao();
    private ListInterface<Student> studentList = new DoublyLinkedList<>();
    Scanner scanner = new Scanner(System.in);

 
    public void getAllStudents() {
        studentList = studentDao.getAllStudents();  // Assuming the method in StudentDetailsDao returns ListInterface<Student>
        for(Student student: studentList){
            System.out.println("studentList:\n" + student + "\n");
        }
        
    }
}

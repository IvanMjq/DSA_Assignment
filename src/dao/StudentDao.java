/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.Student;
import adt.ListInterface;
import adt.DoublyLinkedList;
/**
 *
 * @author WEI ZHENG
 */
public class StudentDao {
    
    private ListInterface<Student> students;

    public StudentDao() {
        this.students = new DoublyLinkedList<>();
    }


    public void addStudent(Student student) {
        students.add(student);
    }


    public Student getStudent(String id) {
        for (int i = 1; i <= students.getNumberOfEntries(); i++) {
            Student s = students.getEntry(i);
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }


    public ListInterface<Student> getAllStudents() {
        return students;
    }

    
    public void updateStudent(Student student) {
        for (int i = 1; i <= students.getNumberOfEntries(); i++) {
            Student s = students.getEntry(i);
            if (s.getId().equals(student.getId())) {
                students.replace(i, student);
                return;
            }
        }
    }

    
    public void deleteStudent(String id) {
        for (int i = 1; i <= students.getNumberOfEntries(); i++) {
            Student s = students.getEntry(i);
            if (s.getId().equals(id)) {
                students.remove(i);
                return;
            }
        }
    }
}
    


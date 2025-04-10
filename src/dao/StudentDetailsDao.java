/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Skill;
import entity.Student;
import java.util.Iterator;
/**
 *
 * @author WEI ZHENG
 */
public class StudentDetailsDao {
    private ListInterface<Student> studentList;
    private ListInterface<Skill> skillList = new DoublyLinkedList<>();

    
    
    public StudentDetailsDao(){
        studentList = new DoublyLinkedList<>();
//        studentList.add(new Student("S001", "Michael Jordan", 15, "123 Main Street", "michael@gmail.com", "2 President List", "Bachelor Degree in Computer Science", skillList.getData(0), skillList.getData(1)));
//        studentList.add(new Student("S002", "Sarah Lee", 20, "456 Elm Avenue", "sarah.lee@example.com", "Dean's List 2023", "Diploma in Data Science", skillList.getData(2), skillList.getData(4), skillList.getData(9)));
//        studentList.add(new Student("S003", "David Wong", 22, "789 Oak Road", "david.wong@example.com", "Hackathon Winner", "Bachelor Degree in Software Engineering", skillList.getData(0), skillList.getData(3), skillList.getData(8)));
//        studentList.add(new Student("S004", "Emily Tan", 19, "321 Pine Street", "emily.tan@example.com", "Top 10 Final Year Project", "Diploma in Computer Networking", skillList.getData(6), skillList.getData(5), skillList.getData(1)));
//        studentList.add(new Student("S005", "Jason Lim", 23, "654 Maple Boulevard", "jason.lim@example.com", "Published Research on AI", "Master Degree in Artificial Intelligence", skillList.getData(2), skillList.getData(7), skillList.getData(8)));
//        studentList.add(new Student("S006", "Alicia Tan", 21, "99 Lakeview Drive", "alicia.tan@example.com", "Certified Cloud Practitioner", "Bachelor Degree in Information Systems", skillList.getData(4), skillList.getData(5), skillList.getData(9)));
    }
    
     // Create a new student
    public boolean addStudent(Student student) {
        if(student != null){
            studentList.add(student);
            System.out.println("Successfully added");
            return true;
        }
        return false;
    }

    // Read student details by studentId
    public Student getStudentById(int studentId) {
        for (Student student : studentList) {
                if (student.getId().equals(studentId)) {
                    return student;
                }
            }
        return null; // Return null if not found
    }


    // Update student details
    public boolean updateStudent(int position, Student updatedStudent) {
        if (position >= 1 && position <= studentList.size()) {
            return studentList.replace(position, updatedStudent);
        }
        return false;
    }
    
    
    // Delete a student
    public boolean removeStudentByPosition(int givenPosition) {
        if(givenPosition >= 1 && givenPosition <= studentList.size()){
            studentList.remove(givenPosition);
            System.out.printf("Successfully removed position %d in the student list\n", givenPosition); 
            return true;
        }
        System.out.println("No such position in the student list"); 

        return false;
    }
    
    public boolean removeStudentById(int studentId) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(studentId)) {
                studentList.remove(studentList.indexOf(student)); // 1-based index
                return true;
            }
        }
        return false;    
    }
    
    
    
    public ListInterface<Student> getAllStudents() {
        return studentList;
    }
    

    // Display all students
    public void printAllStudents() {
//        if (studentList.isEmpty()) {
//            System.out.println("No students in the system.");
//        } else {
//            studentList.displayForward();
//        }
    }
}

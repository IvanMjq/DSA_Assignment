/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.JobPosting;
import entity.MatchingResult;
import entity.Skill;
import entity.Student;

/**
 *
 * @author WEI ZHENG
 */
public class MatchingEngine {
    public ListInterface<MatchingResult> matchStudentsToJobs(ListInterface<Student> studentList, ListInterface<JobPosting> jobList) {
        ListInterface<MatchingResult> matchResults = new DoublyLinkedList<>();
        
        for (int i = 1; i <= studentList.size() ; i++){
            Student student = studentList.getData(i);
            for(int j = 1; j <= jobList.size(); i++){
                JobPosting jobPost = jobList.getData(i);
                for(int k = 1; k <= student.getSkillList().size(); k++){
                    Skill skill = student.getSkillList().getData(k);
                    for(int l =  1; l <= jobPost.getSkillRequired().size(); l++ ){
//                        JobSkillRequirement
                        
                    }
                }
                calculateScore(student, jobPost);
            }
            
        }
        return matchResults;
    }
    
    public double calculateScore(Student student, JobPosting jobPost){
        double score = 0;
        return score;
    }
}

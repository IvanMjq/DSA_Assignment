/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.*;
import entity.*;
import java.time.LocalDate;

/**
 *
 * @author Teh Yi Shan
 */
public class JobRelatedDataInitialize {
    private ListInterface<Skill> skillList = new DoublyLinkedList<>();
    private ListInterface<StudentSkill> studentSkill = new DoublyLinkedList<>();
    private ListInterface<JobRequirementSkill> requiredSkill = new DoublyLinkedList<>();
    private ListInterface<Job> jobList = new DoublyLinkedList<>();
    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    private ListInterface<Student> studentList = new DoublyLinkedList<>();
    private ListInterface<JobPosting> jobPostingList = new DoublyLinkedList<>();
    private ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
    
    
    public JobRelatedDataInitialize(){
        skillList.add(new Skill("S-1", "Java Langauge"));
        skillList.add(new Skill("S-2", "C++ Langauge"));
        skillList.add(new Skill("S-3", "Java"));
        skillList.add(new Skill("S-4", "Mandarin"));
        skillList.add(new Skill("S-5", "English"));
        skillList.add(new Skill("S-6", "Bahasa Malayu"));
        skillList.add(new Skill("S-7", "C Langauge"));
        skillList.add(new Skill("S-8", "React.js"));
        skillList.add(new Skill("S-9", "Laravel"));
        skillList.add(new Skill("S-10", "Vue.js"));
        
        studentSkill.add(new StudentSkill(studentList.getData(0), skillList.getData(0), 1));
        studentSkill.add(new StudentSkill(studentList.getData(1), skillList.getData(1), 2));
        studentSkill.add(new StudentSkill(studentList.getData(2), skillList.getData(2), 3));
        studentSkill.add(new StudentSkill(studentList.getData(3), skillList.getData(3), 4));
        studentSkill.add(new StudentSkill(studentList.getData(4), skillList.getData(4), 5));
        studentSkill.add(new StudentSkill(studentList.getData(0), skillList.getData(5), 1));
        studentSkill.add(new StudentSkill(studentList.getData(1), skillList.getData(6), 2));
        studentSkill.add(new StudentSkill(studentList.getData(2), skillList.getData(7), 3));
        studentSkill.add(new StudentSkill(studentList.getData(3), skillList.getData(8), 4));
        studentSkill.add(new StudentSkill(studentList.getData(4), skillList.getData(9), 4));

        
        requiredSkill.add(new JobRequirementSkill(jobPostingList.getData(0), skillList.getData(0), 1));
        requiredSkill.add(new JobRequirementSkill(jobPostingList.getData(1), skillList.getData(1), 2));
        requiredSkill.add(new JobRequirementSkill(jobPostingList.getData(2), skillList.getData(2), 3));
        requiredSkill.add(new JobRequirementSkill(jobPostingList.getData(3), skillList.getData(3), 4));
        requiredSkill.add(new JobRequirementSkill(jobPostingList.getData(4), skillList.getData(4), 5));
        requiredSkill.add(new JobRequirementSkill(jobPostingList.getData(5), skillList.getData(5), 1));
        requiredSkill.add(new JobRequirementSkill(jobPostingList.getData(6), skillList.getData(6), 2));
        requiredSkill.add(new JobRequirementSkill(jobPostingList.getData(7), skillList.getData(7), 3));
        requiredSkill.add(new JobRequirementSkill(jobPostingList.getData(8), skillList.getData(8), 4));
        requiredSkill.add(new JobRequirementSkill(jobPostingList.getData(0), skillList.getData(9), 5));



        
        jobList.add(new Job("J-1", "Software Engineer", "Full-Time", "Responsible for designing, developing, and maintaining software applications. Collaborates with cross-functional teams to deliver scalable and efficient software solutions. Proficient in programming languages such as Java, C++, or Python. Strong problem-solving skills and knowledge of software development lifecycle are essential."));
        jobList.add(new Job("J-2", "Data Analyst", "Full-Time", "Analyze large datasets to extract actionable insights and support business decision-making. Proficient in SQL, Excel, and data visualization tools like Tableau or Power BI."));
        jobList.add(new Job("J-3", "Cybersecurity Analyst", "Full-Time", "Monitor and protect company networks and systems from cyber threats. Conduct risk assessments, manage firewalls, and ensure compliance with security protocols."));
        jobList.add(new Job("J-4", "Machine Learning Engineer", "Full-Time", "Design and implement machine learning models for automation, prediction, and data analysis. Requires knowledge of Python, TensorFlow, and data pipelines."));
        jobList.add(new Job("J-5", "Web Developer", "Full-Time", "Develop and maintain responsive websites using HTML, CSS, JavaScript, and frameworks like React.js or Vue.js. Collaborate with designers and backend teams."));
        jobList.add(new Job("J-6", "Mobile App Developer", "Full-Time", "Build and maintain mobile applications for iOS and Android platforms using technologies such as Flutter or Kotlin. Work closely with UI/UX designers and QA teams."));
        jobList.add(new Job("J-7", "Cloud Engineer", "Full-Time", "Manage and deploy applications on cloud platforms like AWS, Azure, or Google Cloud. Handle infrastructure-as-code, security, and resource optimization."));
        jobList.add(new Job("J-8", "Database Administrator", "Full-Time", "Design, maintain, and optimize databases to ensure high availability and performance. Skilled in SQL, data backup, and recovery strategies."));
        jobList.add(new Job("J-9", "AI Research Intern", "Internship", "Support the research and development of AI solutions. Assist with data preparation, training models, and evaluating performance. Python experience preferred."));
        jobList.add(new Job("J-10","Full-Stack Developer", "Full-Time", "Develop complete web applications, working on both frontend and backend. Familiarity with React, Node.js, databases, and APIs is essential."));

        studentList.add(new Student("S001", "Michael Jordan", 15, "Kepong", 0, 0 , "michael@gmail.com", "2 President List", "Bachelor Degree in Computer Science", 1, studentSkill.getData(0), skillList.getData(1)));
        studentList.add(new Student("S002", "Sarah Lee", 20, "456 Elm Avenue", 0, 0, "sarah.lee@example.com", "Dean's List 2023", "Diploma in Data Science", 2,skillList.getData(2), skillList.getData(4), skillList.getData(9)));
        studentList.add(new Student("S003", "David Wong", 22, "789 Oak Road", 0, 0, "david.wong@example.com", "Hackathon Winner", "Bachelor Degree in Software Engineering",1, skillList.getData(0), skillList.getData(3), skillList.getData(8)));
        studentList.add(new Student("S004", "Emily Tan", 19, "321 Pine Street", 0, 0, "emily.tan@example.com", "Top 10 Final Year Project", "Diploma in Computer Networking", 2,skillList.getData(6), skillList.getData(5), skillList.getData(1)));
        studentList.add(new Student("S005", "Jason Lim", 23, "654 Maple Boulevard", 0, 0, "jason.lim@example.com", "Published Research on AI", "Master Degree in Artificial Intelligence", 3,skillList.getData(2), skillList.getData(7), skillList.getData(8)));
        studentList.add(new Student("S006", "Alicia Tan", 21, "99 Lakeview Drive", 0, 0, "alicia.tan@example.com", "Certified Cloud Practitioner", "Bachelor Degree in Information Systems", 1,skillList.getData(4), skillList.getData(5), skillList.getData(9)));
        
        companyList.add(new Company("C-1", "ISJ-Technology", "03-5938420", "isj@gmail.com", "No 12A, Main Street", 0, 0, 1958));
        companyList.add(new Company("C-2","NextWave Solutions","03-6123456","contact@nextwave.com","25, Innovation Avenue, Cyberjaya", 0, 0,2003));
        companyList.add(new Company("C-3", "CloudHive Tech","03-6789123","support@cloudhive.com","Lot 7, Cloud Park, Petaling Jaya", 0, 0,2010));
        companyList.add(new Company("C-4","DataBridge Analytics","03-4455667","info@databridge.com","Kepong", 0, 0,2015));
        companyList.add(new Company("C-5","Innova Systems","03-8899001","hello@innova.com","88, Enterprise Tower, Johor Bahru", 0, 0,1995));
        companyList.add(new Company("C-6","QuantumWorks", "03-9081726","careers@quantumworks.com","Level 18, Quantum Square, Penang", 0, 0,2018));
        companyList.add(new Company("C-7","Visionary Tech Sdn Bhd","03-7832441","admin@visionarytech.com","10A, Jalan Semangat, Shah Alam", 0, 0,2007));
        companyList.add(new Company("C-8","GreenByte Solutions", "03-5566778","team@greenbyte.com","15, Eco Business Hub, Melaka", 0, 0,2001));
        companyList.add(new Company("C-9","NovaLink Digital","03-6543210","nova@novalink.com","Block C, Tech City, Seremban", 0, 0,2012));
        companyList.add(new Company("C-10","PixelForge Studio","03-7766554","studio@pixelforge.com","Suite 12, Creative Valley, Ipoh", 0, 0, 2016));
        
       
        jobPostingList.add(new JobPosting("JP-1", companyList.getData(1), jobList.getData(1),"Analyze complex datasets and present insights for business decisions.","3500.00-5000.00",1,LocalDate.of(2024, 3, 12),requiredSkill.getData(3),requiredSkill.getData(5),requiredSkill.getData(10)));
        jobPostingList.add(new JobPosting("JP-2", companyList.getData(1), jobList.getData(1),"Analyze complex datasets and present insights for business decisions.","3500.00-5000.00", 2,LocalDate.of(2024, 3, 12),requiredSkill.getData(3), requiredSkill.getData(5), requiredSkill.getData(10)));
        jobPostingList.add(new JobPosting("JP-3", companyList.getData(4), jobList.getData(4),"Develop enterprise applications with modern backend frameworks.","4000.00-6000.00", 3,LocalDate.of(2024, 5, 5),requiredSkill.getData(1), requiredSkill.getData(2)));
        jobPostingList.add(new JobPosting("JP-4", companyList.getData(3), jobList.getData(3),"Work with AI pipelines to optimize ML model deployment.","4800.00-7200.00", 2,LocalDate.of(2024, 1, 20),requiredSkill.getData(3), requiredSkill.getData(9)));
        jobPostingList.add(new JobPosting("JP-5", companyList.getData(5), jobList.getData(5),"Design and develop cross-platform mobile applications using Flutter and Kotlin.","4500.00-6000.00", 2,LocalDate.of(2024, 4, 10),requiredSkill.getData(3), requiredSkill.getData(5), requiredSkill.getData(6)));
        jobPostingList.add(new JobPosting("JP-6", companyList.getData(6), jobList.getData(2),"Implement and monitor cybersecurity protocols to safeguard company data.","5000.00-7500.00", 1,LocalDate.of(2024, 2, 22),requiredSkill.getData(1), requiredSkill.getData(4)));
        jobPostingList.add(new JobPosting("JP-7", companyList.getData(7), jobList.getData(7),"Maintain and optimize large-scale SQL databases for high performance.","4000.00-6500.00", 2,LocalDate.of(2024, 5, 1),requiredSkill.getData(6), requiredSkill.getData(2)));
        jobPostingList.add(new JobPosting("JP-8", companyList.getData(8), jobList.getData(9),"Develop full-stack web applications with seamless integration of frontend and backend.","4800.00-7000.00", 1,LocalDate.of(2024, 3, 15), requiredSkill.getData(1), requiredSkill.getData(8), requiredSkill.getData(9)));
        jobPostingList.add(new JobPosting("JP-9", companyList.getData(9), jobList.getData(8),"Assist in AI model training and evaluation for real-world research projects.", "3000.00-4000.00", 1,LocalDate.of(2024, 1, 5), requiredSkill.getData(3), requiredSkill.getData(10)));
        
        jobApplicationList.add(new JobApplication("JA-1", jobPostingList.getData(2),studentList.getData(1), LocalDate.parse("2025-04-20"),JobApplication.InterviewStatus.INTERVIEW_SCHEDULED));
        jobApplicationList.add(new JobApplication("JA-1", jobPostingList.getData(2), studentList.getData(1), LocalDate.parse("2025-04-20"), JobApplication.InterviewStatus.INTERVIEW_SCHEDULED));
        jobApplicationList.add(new JobApplication("JA-2", jobPostingList.getData(6), studentList.getData(2), LocalDate.parse("2025-04-18"), JobApplication.InterviewStatus.APPLIED));
        jobApplicationList.add(new JobApplication("JA-3", jobPostingList.getData(1), studentList.getData(4), LocalDate.parse("2025-04-15"), JobApplication.InterviewStatus.OFFERED));
        jobApplicationList.add(new JobApplication("JA-4", jobPostingList.getData(3), studentList.getData(6), LocalDate.parse("2025-04-10"), JobApplication.InterviewStatus.REJECTED));
        jobApplicationList.add(new JobApplication("JA-5", jobPostingList.getData(4), studentList.getData(5), LocalDate.parse("2025-04-25"), JobApplication.InterviewStatus.ACCEPTED));
        jobApplicationList.add(new JobApplication("JA-6", jobPostingList.getData(5), studentList.getData(3), LocalDate.parse("2025-04-12"), JobApplication.InterviewStatus.INTERVIEWED));
        jobApplicationList.add(new JobApplication("JA-7", jobPostingList.getData(8), studentList.getData(1), LocalDate.parse("2025-04-28"), JobApplication.InterviewStatus.DECLINED));
        jobApplicationList.add(new JobApplication("JA-8", jobPostingList.getData(7), studentList.getData(2), LocalDate.parse("2025-04-22"), JobApplication.InterviewStatus.APPLIED));
       
    } 
    
    public ListInterface<StudentSkill> getSkillList() {
        return studentSkill;
    }
    
    public ListInterface<JobRequirementSkill> getRequiredSkillList() {
        return requiredSkill;
    }
    
    public ListInterface<Job> getJobList() {
        return jobList;
    }
        
    public ListInterface<Company> getCompanyList() {
        return companyList;
    }
    
    public ListInterface<Student> getStudentList() {
        return studentList;
    }
    
    public ListInterface<JobApplication> getJobApplicationList() {
        return jobApplicationList;
    }
    
    public ListInterface<JobPosting> getJobPostingList() {
        return jobPostingList;
    }
    
    
}

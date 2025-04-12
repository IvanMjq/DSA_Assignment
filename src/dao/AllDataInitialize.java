/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.*;
import entity.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Teh Yi Shan
 */
public class AllDataInitialize {
    
    private ListInterface<Company> companyList = new DoublyLinkedList<>();
    private ListInterface<CompanyJob> companyJobList = new DoublyLinkedList<>();
    private ListInterface<Job> jobList = new DoublyLinkedList<>();
    private ListInterface<JobPosting> jobPostingList = new DoublyLinkedList<>();
    private ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
    private ListInterface<Student> studentList = new DoublyLinkedList<>();
    private ListInterface<Skill> skillList = new DoublyLinkedList<>();
    private ListInterface<StudentSkill> studentSkillList = new DoublyLinkedList<>();
    private ListInterface<JobRequiredSkill> jobRequiredSkillList = new DoublyLinkedList<>();
    
    public AllDataInitialize(){
        
        initializeSkillList();
        
        initializeCompanyList();
        
        initilizeJob();
        
        initializeCompanyJobList();
        
        intializeStudent();
        
        initializeJobPosting();
        
        initializeJobApplication();
        
        initializeStudentSkillList();
        
        initializeJobRequiredSkill();

//        studentList.add(new Student("S001", "Michael Jordan", 15, "Kepong", 0, 0 , "michael@gmail.com", "2 President List", "Bachelor Degree in Computer Science", 1, studentSkill.getData(0), skillList.getData(1)));
//        studentList.add(new Student("S002", "Sarah Lee", 20, "456 Elm Avenue", 0, 0, "sarah.lee@example.com", "Dean's List 2023", "Diploma in Data Science", 2,skillList.getData(2), skillList.getData(4), skillList.getData(9)));
//        studentList.add(new Student("S003", "David Wong", 22, "789 Oak Road", 0, 0, "david.wong@example.com", "Hackathon Winner", "Bachelor Degree in Software Engineering",1, skillList.getData(0), skillList.getData(3), skillList.getData(8)));
//        studentList.add(new Student("S004", "Emily Tan", 19, "321 Pine Street", 0, 0, "emily.tan@example.com", "Top 10 Final Year Project", "Diploma in Computer Networking", 2,skillList.getData(6), skillList.getData(5), skillList.getData(1)));
//        studentList.add(new Student("S005", "Jason Lim", 23, "654 Maple Boulevard", 0, 0, "jason.lim@example.com", "Published Research on AI", "Master Degree in Artificial Intelligence", 3,skillList.getData(2), skillList.getData(7), skillList.getData(8)));
//        studentList.add(new Student("S006", "Alicia Tan", 21, "99 Lakeview Drive", 0, 0, "alicia.tan@example.com", "Certified Cloud Practitioner", "Bachelor Degree in Information Systems", 1,skillList.getData(4), skillList.getData(5), skillList.getData(9)));
 
    } 
    
    private void initializeSkillList() {
        skillList.add(new Skill("SK-1", "Java Langauge"));
        skillList.add(new Skill("SK-2", "C++ Langauge"));
        skillList.add(new Skill("SK-3", "Java"));
        skillList.add(new Skill("SK-4", "Mandarin"));
        skillList.add(new Skill("SK-5", "English"));
        skillList.add(new Skill("SK-6", "Bahasa Malayu"));
        skillList.add(new Skill("SK-7", "C Langauge"));
        skillList.add(new Skill("SK-8", "React.js"));
        skillList.add(new Skill("SK-9", "Laravel"));
        skillList.add(new Skill("SK-10", "Vue.js"));
    }
    
    private void initializeCompanyList() {
        companyList.add(new Company(
                "C-1",
                "ISJ-Technology",
                "03-5938420",
                "isj@gmail.com",
                "No 12A, Main Street",
                "Pusat Bandar",
                "Selangor",
                0,
                0,
                1958,
                LocalTime.of(10, 0),
                LocalTime.of(13, 0)
        ));
        companyList.add(new Company(
                "C-2",
                "NextWave Solutions",
                "03-6123456",
                "contact@nextwave.com",
                "25, Innovation Avenue",
                "Cyberjaya",
                "Selangor",
                0,
                0,
                2003,
                LocalTime.of(10, 0),
                LocalTime.of(13, 0)
        ));
        companyList.add(new Company(
                "C-3",
                "CloudHive Tech",
                "03-6789123",
                "support@cloudhive.com",
                "Lot 7, Cloud Park",
                "Petaling Jaya",
                "Selangor",
                0,
                0,
                2010,
                LocalTime.of(10, 0),
                LocalTime.of(13, 0)
        ));
        companyList.add(new Company(
                "C-4",
                "DataBridge Analytics",
                "03-4455667",
                "info@databridge.com",
                "Jalan Kepong Baru",
                "Kepong",
                "Kuala Lumpur",
                0,
                0,
                2015,
                LocalTime.of(8, 45),
                LocalTime.of(11, 15)
        ));
        companyList.add(new Company(
                "C-5",
                "Innova Systems",
                "03-8899001",
                "hello@innova.com",
                "88, Enterprise Tower",
                "Taman Molek",
                "Johor",
                0,
                0,
                1995,
                LocalTime.of(9, 15),
                LocalTime.of(12, 15)
        ));
        companyList.add(new Company(
                "C-6",
                "QuantumWorks",
                "03-9081726",
                "careers@quantumworks.com",
                "Level 18, Quantum Square",
                "Georgetown",
                "Penang",
                0,
                0,
                2018,
                LocalTime.of(14, 0),
                LocalTime.of(17, 0)
        ));
        companyList.add(new Company(
                "C-7",
                "Visionary Tech Sdn Bhd",
                "03-7832441",
                "admin@visionarytech.com",
                "10A, Jalan Semangat",
                "Seksyen 13",
                "Selangor",
                0,
                0,
                2007,
                LocalTime.of(13, 30),
                LocalTime.of(16, 00)
        ));
        companyList.add(new Company(
                "C-8",
                "GreenByte Solutions",
                "03-5566778",
                "team@greenbyte.com",
                "15, Eco Business Hub",
                "Ayer Keroh",
                "Melaka",
                0,
                0,
                2001,
                LocalTime.of(8, 30),
                LocalTime.of(10, 30)
        ));
        companyList.add(new Company(
                "C-9",
                "NovaLink Digital",
                "03-6543210",
                "nova@novalink.com",
                "Block C, Tech City",
                "Seremban",
                "Negeri Sembilan",
                0,
                0,
                2012,
                LocalTime.of(10, 0),
                LocalTime.of(12, 0)
        ));
        companyList.add(new Company(
                "C-10",
                "PixelForge Studio",
                "03-7766554",
                "studio@pixelforge.com",
                "Suite 12, Creative Valley",
                "Ipoh",
                "Perak",
                0,
                0,
                2016,
                LocalTime.of(9, 0),
                LocalTime.of(11, 30)
        ));

    }
    
    private void initilizeJob() {
        jobList.add(new Job(
                "J-1",
                "Software Engineer",
                "Full-Time",
                "Responsible for designing, developing, and maintaining software applications. Collaborates with cross-functional teams to deliver scalable and efficient software solutions. Proficient in programming languages such as Java, C++, or Python. Strong problem-solving skills and knowledge of software development lifecycle are essential."
        ));
        jobList.add(new Job(
                "J-2", 
                "Data Analyst", 
                "Full-Time", 
                "Analyze large datasets to extract actionable insights and support business decision-making. Proficient in SQL, Excel, and data visualization tools like Tableau or Power BI."
        ));
        jobList.add(new Job(
                "J-3", 
                "Cybersecurity Analyst", 
                "Full-Time", 
                "Monitor and protect company networks and systems from cyber threats. Conduct risk assessments, manage firewalls, and ensure compliance with security protocols."
        ));
        jobList.add(new Job(
                "J-4", 
                "Machine Learning Engineer", 
                "Full-Time", 
                "Design and implement machine learning models for automation, prediction, and data analysis. Requires knowledge of Python, TensorFlow, and data pipelines."
        ));
        jobList.add(new Job(
                "J-5", 
                "Web Developer", 
                "Full-Time", 
                "Develop and maintain responsive websites using HTML, CSS, JavaScript, and frameworks like React.js or Vue.js. Collaborate with designers and backend teams."
        ));
        jobList.add(new Job(
                "J-6", 
                "Mobile App Developer", 
                "Full-Time", 
                "Build and maintain mobile applications for iOS and Android platforms using technologies such as Flutter or Kotlin. Work closely with UI/UX designers and QA teams."
        ));
        jobList.add(new Job(
                "J-7", 
                "Cloud Engineer", 
                "Full-Time", 
                "Manage and deploy applications on cloud platforms like AWS, Azure, or Google Cloud. Handle infrastructure-as-code, security, and resource optimization."
        ));
        jobList.add(new Job(
                "J-8", 
                "Database Administrator", 
                "Full-Time", 
                "Design, maintain, and optimize databases to ensure high availability and performance. Skilled in SQL, data backup, and recovery strategies."
        ));
        jobList.add(new Job(
                "J-9", 
                "AI Research Intern", 
                "Internship", 
                "Support the research and development of AI solutions. Assist with data preparation, training models, and evaluating performance. Python experience preferred."
        ));
        jobList.add(new Job(
                "J-10", 
                "Full-Stack Developer", 
                "Full-Time", 
                "Develop complete web applications, working on both frontend and backend. Familiarity with React, Node.js, databases, and APIs is essential."
        ));
    }
    
    private void intializeStudent() {
        studentList.add(new Student(
                "STU-1", 
                "Alan Chopper", 
                "abc12345", 
                22, 
                "123 Main Street", 
                3.1390, 
                101.6869, 
                "alan.chopper@example.com", 
                "Dean's List Award", 
                "Bachelor of Computer Science", 
                1));
        studentList.add(new Student(
                "STU-2", 
                "Brenda Lee", 
                "abc12345", 
                24, 
                "456 River Road", 
                3.1500, 
                101.7000, 
                "brenda.lee@example.com", 
                "Hackathon Winner", 
                "Bachelor of Software Engineering",
                2));
        studentList.add(new Student(
                "STU-3", 
                "Charles Tan", 
                "abc12345", 
                21, 
                "789 Palm Avenue", 
                3.1333, 
                101.6955, 
                "charles.tan@example.com", 
                "Top GPA", 
                "Diploma in Information Technology", 
                1));
        studentList.add(new Student(
                "STU-4", 
                "Diana Wong", 
                "abc12345", 
                23, 
                "10 Ocean Drive", 
                3.1280, 
                101.7101, 
                "diana.wong@example.com", 
                "Intern of the Year", 
                "Bachelor of Computer Science", 
                2));
        studentList.add(new Student(
                "STU-5", 
                "Ethan Lim", 
                "abc12345", 
                25, 
                "33 Sky Heights", 
                3.1456, 
                101.6789, 
                "ethan.lim@example.com", 
                "Research Assistant", 
                "Master of Data Science", 
                3));
        studentList.add(new Student(
                "STU-6", 
                "Fiona Teh", 
                "abc12345", 
                20, 
                "88 Forest Hill", 
                3.1401, 
                101.6900, 
                "fiona.teh@example.com", 
                "Coding Bootcamp Grad", 
                "Diploma in Computer Science", 
                1));
        studentList.add(new Student(
                "STU-7", 
                "George Ng", 
                "abc12345", 
                22, 
                "50 Mountain Ridge", 
                3.1204, 
                101.6799, 
                "george.ng@example.com", 
                "Volunteer Mentor", 
                "Bachelor of Software Engineering", 
                1));
        studentList.add(new Student(
                "STU-8", 
                "Hannah Yap", 
                "abc12345", 
                23, 
                "60 Lakeview Street", 
                3.1555, 
                101.7200, 
                "hannah.yap@example.com", 
                "Scholarship Recipient", 
                "Bachelor of IT", 
                2));
        studentList.add(new Student(
                "STU-9", 
                "Ivan Raj", 
                "abc12345", 
                24, 
                "12 Sunset Park", 
                3.1357, 
                101.6823, 
                "ivan.raj@example.com", 
                "Startup Founder", 
                "Bachelor of Computer Science", 
                3));
        studentList.add(new Student(
                "STU-10", 
                "Jasmine Koh", 
                "abc12345", 
                21, 
                "77 Maple Road", 
                3.1472, 
                101.6991, 
                "jasmine.koh@example.com", 
                "Exchange Program Alumni", 
                "Bachelor of AI", 
                2));
    }

    private void initializeCompanyJobList() {
        companyJobList.add(new CompanyJob(companyList.getData(0), jobList.getData(0))); // ISJ - Software Engineer
        companyJobList.add(new CompanyJob(companyList.getData(0), jobList.getData(1))); // ISJ - Data Analyst

        companyJobList.add(new CompanyJob(companyList.getData(1), jobList.getData(2))); // NextWave - Cybersecurity Analyst
        companyJobList.add(new CompanyJob(companyList.getData(1), jobList.getData(3))); // NextWave - ML Engineer

        companyJobList.add(new CompanyJob(companyList.getData(2), jobList.getData(4))); // CloudHive - Web Developer
        companyJobList.add(new CompanyJob(companyList.getData(2), jobList.getData(0))); // CloudHive - Software Engineer

        companyJobList.add(new CompanyJob(companyList.getData(3), jobList.getData(5))); // DataBridge - Mobile Dev
        companyJobList.add(new CompanyJob(companyList.getData(3), jobList.getData(6))); // DataBridge - Cloud Engineer

        companyJobList.add(new CompanyJob(companyList.getData(4), jobList.getData(7))); // Innova - DBA
        companyJobList.add(new CompanyJob(companyList.getData(4), jobList.getData(4))); // Innova - Web Developer

        companyJobList.add(new CompanyJob(companyList.getData(5), jobList.getData(8))); // QuantumWorks - AI Intern
        companyJobList.add(new CompanyJob(companyList.getData(5), jobList.getData(5))); // QuantumWorks - Mobile Dev

        companyJobList.add(new CompanyJob(companyList.getData(6), jobList.getData(9))); // Visionary - Full Stack Dev
        companyJobList.add(new CompanyJob(companyList.getData(6), jobList.getData(2))); // Visionary - Cybersecurity Analyst

        companyJobList.add(new CompanyJob(companyList.getData(7), jobList.getData(1))); // GreenByte - Data Analyst
        companyJobList.add(new CompanyJob(companyList.getData(7), jobList.getData(9))); // GreenByte - Full Stack Dev

        companyJobList.add(new CompanyJob(companyList.getData(8), jobList.getData(6))); // NovaLink - Cloud Engineer
        companyJobList.add(new CompanyJob(companyList.getData(8), jobList.getData(0))); // NovaLink - Software Engineer

        companyJobList.add(new CompanyJob(companyList.getData(9), jobList.getData(7))); // PixelForge - DBA
        companyJobList.add(new CompanyJob(companyList.getData(9), jobList.getData(3))); // PixelForge - ML Engineer
    }
    
    private void initializeJobPosting() {
        jobPostingList.add(new JobPosting(
                "JP-1", 
                companyList.getData(1), 
                jobList.getData(1),
                "Analyze complex datasets and present insights for business decisions.", 
                3500.00,
                5000.00, 
                1, 
                LocalDate.of(2024, 3, 12)
        ));
        jobPostingList.add(new JobPosting(
                "JP-2", 
                companyList.getData(1), 
                jobList.getData(1), 
                "Analyze complex datasets and present insights for business decisions.", 
                3500.00,
                5000.00, 
                2,
                LocalDate.of(2024, 3, 12)
        ));
        jobPostingList.add(new JobPosting(
                "JP-3", 
                companyList.getData(4),
                jobList.getData(4), 
                "Develop enterprise applications with modern backend frameworks.", 
                4000.00,
                6000.00, 
                3, 
                LocalDate.of(2024, 5, 5)
        ));
        jobPostingList.add(new JobPosting(
                "JP-4",
                companyList.getData(3),
                jobList.getData(3), 
                "Work with AI pipelines to optimize ML model deployment.", 
                4800.00,
                7200.00, 
                2, 
                LocalDate.of(2024, 1, 20)
        ));
        jobPostingList.add(new JobPosting(
                "JP-5",
                companyList.getData(5), 
                jobList.getData(5),
                "Design and develop cross-platform mobile applications using Flutter and Kotlin.", 
                4500.00,
                6000.00, 
                2, 
                LocalDate.of(2024, 4, 10)
        ));
        jobPostingList.add(new JobPosting(
                "JP-6", 
                companyList.getData(6),
                jobList.getData(2), 
                "Implement and monitor cybersecurity protocols to safeguard company data.", 
                5000.00,
                7500.00, 
                1, 
                LocalDate.of(2024, 2, 22)
        ));
        jobPostingList.add(new JobPosting(
                "JP-7",
                companyList.getData(7), 
                jobList.getData(7), 
                "Maintain and optimize large-scale SQL databases for high performance.", 
                4000.00,
                6500.00, 
                2, 
                LocalDate.of(2024, 5, 1)
        ));
        jobPostingList.add(new JobPosting(
                "JP-8", 
                companyList.getData(8),
                jobList.getData(9),
                "Develop full-stack web applications with seamless integration of frontend and backend.",
                4800.00,
                7000.00,
                1, 
                LocalDate.of(2024, 3, 15)
        ));
        jobPostingList.add(new JobPosting(
                "JP-9",
                companyList.getData(9),
                jobList.getData(8), 
                "Assist in AI model training and evaluation for real-world research projects.",
                3000.00,
                4000.00, 
                1, 
                LocalDate.of(2024, 1, 5)
        ));

    }
    
    private void initializeJobApplication() {
        jobApplicationList.add(new JobApplication(
                "JA-1",
                jobPostingList.getData(2), 
                studentList.getData(1)
                
        ));
        jobApplicationList.add(new JobApplication(
                "JA-1", jobPostingList.getData(2), 
                studentList.getData(1)
        ));
        jobApplicationList.add(new JobApplication(
                "JA-2", 
                jobPostingList.getData(6), 
                studentList.getData(2) 
        ));
        jobApplicationList.add(new JobApplication(
                "JA-3", 
                jobPostingList.getData(1), 
                studentList.getData(4)
        ));
        jobApplicationList.add(new JobApplication(
                "JA-4", 
                jobPostingList.getData(3), 
                studentList.getData(6)
        ));
        jobApplicationList.add(new JobApplication(
                "JA-5",
                jobPostingList.getData(4),
                studentList.getData(5)
        ));
        jobApplicationList.add(new JobApplication(
                "JA-6", jobPostingList.getData(5),
                studentList.getData(3)
        ));
        jobApplicationList.add(new JobApplication(
                "JA-7", 
                jobPostingList.getData(8), 
                studentList.getData(1)
        ));
        jobApplicationList.add(new JobApplication(
                "JA-8", 
                jobPostingList.getData(7), 
                studentList.getData(2)
        ));
    }
    
    private void initializeStudentSkillList() {
        studentSkillList.add(new StudentSkill(
                studentList.getData(1), 
                skillList.getData(1), 
                1
        ));
        studentSkillList.add(new StudentSkill(
                studentList.getData(1), 
                skillList.getData(1), 
                2
        ));
        studentSkillList.add(new StudentSkill(
                studentList.getData(2), 
                skillList.getData(2), 
                3
        ));
        studentSkillList.add(new StudentSkill(
                studentList.getData(3), 
                skillList.getData(3), 
                4
        ));
        studentSkillList.add(new StudentSkill(
                studentList.getData(4), 
                skillList.getData(4), 
                5
        ));
        studentSkillList.add(new StudentSkill(
                studentList.getData(1), 
                skillList.getData(5), 
                1
        ));
        studentSkillList.add(new StudentSkill(
                studentList.getData(1), 
                skillList.getData(6), 
                2
        ));
        studentSkillList.add(new StudentSkill(
                studentList.getData(2), 
                skillList.getData(7), 3
        ));
        studentSkillList.add(new StudentSkill(
                studentList.getData(3), 
                skillList.getData(8), 
                4
        ));
        studentSkillList.add(new StudentSkill(
                studentList.getData(4), 
                skillList.getData(9), 
                4
        ));
    }
    
    private void initializeJobRequiredSkill() {
        jobRequiredSkillList.add(new JobRequiredSkill(
                jobPostingList.getData(0), 
                skillList.getData(0), 
                1
        ));
        jobRequiredSkillList.add(new JobRequiredSkill(
                jobPostingList.getData(1), 
                skillList.getData(1), 
                2
        ));
        jobRequiredSkillList.add(new JobRequiredSkill(
                jobPostingList.getData(2), 
                skillList.getData(2), 
                3
        ));
        jobRequiredSkillList.add(new JobRequiredSkill(
                jobPostingList.getData(3), 
                skillList.getData(3), 
                4
        ));
        jobRequiredSkillList.add(new JobRequiredSkill(
                jobPostingList.getData(4), 
                skillList.getData(4), 
                5
        ));
        jobRequiredSkillList.add(new JobRequiredSkill(
                jobPostingList.getData(5), 
                skillList.getData(5), 
                1
        ));
        jobRequiredSkillList.add(new JobRequiredSkill(
                jobPostingList.getData(6), 
                skillList.getData(6), 
                2
        ));
        jobRequiredSkillList.add(new JobRequiredSkill(
                jobPostingList.getData(7), 
                skillList.getData(7), 
                3
        ));
        jobRequiredSkillList.add(new JobRequiredSkill(
                jobPostingList.getData(8), 
                skillList.getData(8), 
                4
        ));
        jobRequiredSkillList.add(new JobRequiredSkill(
                jobPostingList.getData(0), 
                skillList.getData(9), 
                5
        ));
    }
    
    // -----------------
    // Getter and Setter
    
    public ListInterface<Skill> getSkillList() {
        return skillList;
    }
    public ListInterface<StudentSkill> getStudentSkillList() {
        return studentSkillList;
    }
    
    public ListInterface<JobRequiredSkill> getJobRequiredSkillList() {
        return jobRequiredSkillList;
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
    
    // -----------------
    
    
}

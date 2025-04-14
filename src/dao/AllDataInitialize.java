/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.*;
import entity.*;
import entity.Interview.InterviewStatus;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

/**
 *
 * @author Teh Yi Shan
 */
public class AllDataInitialize {

    private final ListInterface<Skill> skillList = new DoublyLinkedList<>();
    private final ListInterface<Company> companyList = new DoublyLinkedList<>();
    private final ListInterface<Job> jobList = new DoublyLinkedList<>();
    private final ListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
    private final ListInterface<Student> studentList = new DoublyLinkedList<>();
    private final ListInterface<Interview> interviewList = new DoublyLinkedList<>();

    public AllDataInitialize() {

        initializeSkillList();

        initializeCompanyList();

        initializeJob();

        intializeStudent();

        initializeJobPosting();

        initializeJobApplication();

        initializeStudentSkillList();

        initializeJobRequiredSkill();
        
        initializeInterview();

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

    private void initializeJob() {
        jobList.add(new Job(
                "J-1",
                "Software Engineer",
                "Computer & Technology",
                "Responsible for designing, developing, and maintaining software applications. Collaborates with cross-functional teams to deliver scalable and efficient software solutions. Proficient in programming languages such as Java, C++, or Python. Strong problem-solving skills and knowledge of software development lifecycle are essential."
        ));
        jobList.add(new Job(
                "J-2",
                "Data Analyst",
                "Computer & Technology",
                "Analyze large datasets to extract actionable insights and support business decision-making. Proficient in SQL, Excel, and data visualization tools like Tableau or Power BI."
        ));
        jobList.add(new Job(
                "J-3",
                "Cybersecurity Analyst",
                "Computer & Technology",
                "Monitor and protect company networks and systems from cyber threats. Conduct risk assessments, manage firewalls, and ensure compliance with security protocols."
        ));
        jobList.add(new Job(
                "J-4",
                "Machine Learning Engineer",
                "Computer & Technology",
                "Design and implement machine learning models for automation, prediction, and data analysis. Requires knowledge of Python, TensorFlow, and data pipelines."
        ));
        jobList.add(new Job(
                "J-5",
                "Web Developer",
                "Computer & Technology",
                "Develop and maintain responsive websites using HTML, CSS, JavaScript, and frameworks like React.js or Vue.js. Collaborate with designers and backend teams."
        ));
        jobList.add(new Job(
                "J-6",
                "Mobile App Developer",
                "Computer & Technology",
                "Build and maintain mobile applications for iOS and Android platforms using technologies such as Flutter or Kotlin. Work closely with UI/UX designers and QA teams."
        ));
        jobList.add(new Job(
                "J-7",
                "Cloud Engineer",
                "Computer & Technology",
                "Manage and deploy applications on cloud platforms like AWS, Azure, or Google Cloud. Handle infrastructure-as-code, security, and resource optimization."
        ));
        jobList.add(new Job(
                "J-8",
                "Database Administrator",
                "Computer & Technology",
                "Design, maintain, and optimize databases to ensure high availability and performance. Skilled in SQL, data backup, and recovery strategies."
        ));
        jobList.add(new Job(
                "J-9",
                "AI Research Intern",
                "Computer & Technology",
                "Support the research and development of AI solutions. Assist with data preparation, training models, and evaluating performance. Python experience preferred."
        ));
        jobList.add(new Job(
                "J-10",
                "Full-Stack Developer",
                "Computer & Technology",
                "Develop complete web applications, working on both frontend and backend. Familiarity with React, Node.js, databases, and APIs is essential."
        ));
        jobList.add(new Job(
                "J-11",
                "Credit Risk Analyst",
                "Finance & Banking",
                "Evaluate credit data and financial statements to assess the risk in lending. Experience with credit scoring models and risk analysis is preferred."
        ));
        jobList.add(new Job(
                "J-12",
                "Financial Analyst",
                "Finance & Banking",
                "Analyze financial data, create financial models, and assist in strategic planning. Proficiency in Excel, financial forecasting, and risk assessment is required."
        ));
        jobList.add(new Job(
                "J-13",
                "Accountant",
                "Finance & Banking",
                "Manage financial records, prepare tax documents, and ensure regulatory compliance. Attention to detail and knowledge of accounting software are essential."
        ));
        jobList.add(new Job(
                "J-14",
                "Investment Banker",
                "Finance",
                "Help clients raise capital and provide strategic financial advice. Requires strong analytical skills, financial modeling, and knowledge of market trends."
        ));
        jobList.add(new Job(
                "J-15",
                "Budget Analyst",
                "Finance & Banking",
                "Evaluate budget proposals, monitor organizational spending, and prepare financial reports. Experience in budgeting tools and government finance is a plus."
        ));
        jobList.add(new Job(
                "J-16",
                "Medical Laboratory Technologist",
                "Healthcare",
                "Perform diagnostic tests on patient samples, analyze results, and support accurate medical diagnoses. Attention to detail and lab safety knowledge are essential."
        ));
        jobList.add(new Job(
                "J-17",
                "Secondary School Teacher",
                "Education",
                "Plan and deliver lessons for students aged 13–17 in accordance with the national curriculum. Patience, subject expertise, and classroom management are essential."
        ));
        jobList.add(new Job(
                "J-18",
                "Early Childhood Educator",
                "Education",
                "Design and implement learning activities for children aged 3–6. Strong understanding of child development and creative teaching methods is essential."
        ));
        jobList.add(new Job(
                "J-19",
                "Online Course Instructor",
                "Education",
                "Teach academic or professional subjects through online platforms. Requires excellent communication skills, subject expertise, and familiarity with e-learning tools."
        ));
        jobList.add(new Job(
                "J-20",
                "Mechanical Engineer",
                "Engineering",
                "Design, analyze, and improve mechanical systems and devices. Proficiency in CAD software and solid understanding of thermodynamics and materials required."
        ));
        jobList.add(new Job(
                "J-21",
                "Civil Engineer",
                "Engineering",
                "Plan and oversee construction projects including roads, bridges, and buildings. Requires strong project management skills and knowledge of structural analysis."
        ));

        jobList.add(new Job(
                "J-22",
                "Electrical Engineer",
                "Engineering",
                "Develop and test electrical systems and equipment. Must have experience with circuit design, signal processing, and electrical safety standards."
        ));
        jobList.add(new Job(
                "J-23",
                "Registered Nurse",
                "Healthcare",
                "Provide patient care, administer medications, and assist in treatment plans. Strong communication, empathy, and knowledge of clinical procedures are essential."
        ));
    }

    private void intializeStudent() {
        studentList.add(new Student(
                "STU-1",
                "Alan Chopper",
                "abc12345",
                22,
                "12 Jalan Ampang",
                "Kuala Lumpur",
                "Wilayah Persekutuan",
                0.0,
                0.0,
                "alan.chopper@example.com",
                "Dean's List Award",
                "Bachelor of Computer Science",
                1, 
                "Engineering", "Healthcare"
        ));

        studentList.add(new Student(
                "STU-2",
                "Brenda Lee",
                "abc12345",
                24,
                "33 Jalan Tun Razak",
                "Kuala Lumpur",
                "Wilayah Persekutuan",
                0.0,
                0.0,
                "brenda.lee@example.com",
                "Hackathon Winner",
                "Bachelor of Software Engineering",
                2, "Healthcare"));

        studentList.add(new Student(
                "STU-3",
                "Charles Tan",
                "abc12345",
                21,
                "21 Jalan Dato Onn",
                "Johor Bahru",
                "Johor",
                0.0,
                0.0,
                "charles.tan@example.com",
                "Top GPA",
                "Diploma in Information Technology",
                1, "Healthcare"));

        studentList.add(new Student(
                "STU-4",
                "Diana Wong",
                "abc12345",
                23,
                "18 Jalan Gurney",
                "Georgetown",
                "Penang",
                0.0,
                0.0,
                "diana.wong@example.com",
                "Intern of the Year",
                "Bachelor of Computer Science",
                2, "Healthcare"));

        studentList.add(new Student(
                "STU-5",
                "Ethan Lim",
                "abc12345",
                25,
                "25 Persiaran Gurney",
                "Ipoh",
                "Perak",
                0.0,
                0.0,
                "ethan.lim@example.com",
                "Research Assistant",
                "Master of Data Science",
                3, "Healthcare"));

        studentList.add(new Student(
                "STU-6",
                "Fiona Teh",
                "abc12345",
                20,
                "88 Jalan Tokong",
                "Melaka City",
                "Melaka",
                0.0,
                0.0,
                "fiona.teh@example.com",
                "Coding Bootcamp Grad",
                "Diploma in Computer Science",
                1, "Engineering"));

        studentList.add(new Student(
                "STU-7",
                "George Ng",
                "abc12345",
                22,
                "50 Jalan Song",
                "Kuching",
                "Sarawak",
                0.0,
                0.0,
                "george.ng@example.com",
                "Volunteer Mentor",
                "Bachelor of Software Engineering",
                1, "Engineering"));

        studentList.add(new Student(
                "STU-8",
                "Hannah Yap",
                "abc12345",
                23,
                "60 Jalan Sultan",
                "Seremban",
                "Negeri Sembilan",
                0.0,
                0.0,
                "hannah.yap@example.com",
                "Scholarship Recipient",
                "Bachelor of IT",
                2, "Engineering"));

        studentList.add(new Student(
                "STU-9",
                "Ivan Raj",
                "abc12345",
                24,
                "12 Jalan Lintas",
                "Kota Kinabalu",
                "Sabah",
                0.0,
                0.0,
                "ivan.raj@example.com",
                "Startup Founder",
                "Bachelor of Computer Science",
                3, "Engineering"));

        studentList.add(new Student(
                "STU-10",
                "Jasmine Koh",
                "abc12345",
                21,
                "77 Jalan Sultan Ismail",
                "Kuala Lumpur",
                "Wilayah Persekutuan",
                0.0,
                0.0,
                "jasmine.koh@example.com",
                "Exchange Program Alumni",
                "Bachelor of AI",
                2, "Engineering"));
    }

    private void initializeJobPosting() {
        JobPosting jp;

        jp = new JobPosting(
                companyList.getData(1),
                jobList.getData(1),
                "Analyze complex datasets and present insights for business decisions.",
                3500.00,
                5000.00,
                1,
                LocalDate.of(2024, 3, 12)
        );
        companyList.getData(1).getJobPostingList().add(jp);
        jobList.getData(1).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(1),
                jobList.getData(2),
                "Create and manage data visualizations using tools like Tableau and Power BI.",
                4000.00,
                6000.00,
                2,
                LocalDate.of(2024, 4, 15)
        );
        companyList.getData(1).getJobPostingList().add(jp);
        jobList.getData(2).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(1),
                jobList.getData(5),
                "Support data-driven decision-making with advanced analytics.",
                3700.00,
                5200.00,
                2,
                LocalDate.of(2024, 4, 2)
        );
        companyList.getData(1).getJobPostingList().add(jp);
        jobList.getData(5).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(2),
                jobList.getData(2),
                "Develop and maintain scalable backend services using Java and Spring Boot.",
                5000.00,
                7500.00,
                3,
                LocalDate.of(2024, 6, 1)
        );
        companyList.getData(2).getJobPostingList().add(jp);
        jobList.getData(2).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(2),
                jobList.getData(3),
                "Manage large-scale projects and lead development teams using Agile methodology.",
                5500.00,
                8000.00,
                3,
                LocalDate.of(2024, 5, 10)
        );
        companyList.getData(2).getJobPostingList().add(jp);
        jobList.getData(3).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(3),
                jobList.getData(3),
                "Work with AI pipelines to optimize ML model deployment.",
                4800.00,
                7200.00,
                2,
                LocalDate.of(2024, 1, 20)
        );
        companyList.getData(3).getJobPostingList().add(jp);
        jobList.getData(3).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(3),
                jobList.getData(4),
                "Create machine learning models for predictive analysis and forecasting.",
                4800.00,
                7500.00,
                1,
                LocalDate.of(2024, 5, 22)
        );
        companyList.getData(3).getJobPostingList().add(jp);
        jobList.getData(4).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(4),
                jobList.getData(4),
                "Develop enterprise applications with modern backend frameworks.",
                4000.00,
                6000.00,
                3,
                LocalDate.of(2024, 5, 5)
        );
        companyList.getData(4).getJobPostingList().add(jp);
        jobList.getData(4).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(4),
                jobList.getData(5),
                "Lead design and development of mobile applications for iOS and Android.",
                5000.00,
                7000.00,
                1,
                LocalDate.of(2024, 6, 18)
        );
        companyList.getData(4).getJobPostingList().add(jp);
        jobList.getData(5).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(5),
                jobList.getData(5),
                "Design and develop cross-platform mobile applications using Flutter and Kotlin.",
                4500.00,
                6000.00,
                2,
                LocalDate.of(2024, 4, 10)
        );
        companyList.getData(5).getJobPostingList().add(jp);
        jobList.getData(5).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(5),
                jobList.getData(6),
                "Develop software to prevent cyberattacks and enhance organizational security.",
                5200.00,
                7500.00,
                2,
                LocalDate.of(2024, 6, 5)
        );
        companyList.getData(5).getJobPostingList().add(jp);
        jobList.getData(6).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(6),
                jobList.getData(6),
                "Implement and monitor cybersecurity protocols to safeguard company data.",
                5000.00,
                7500.00,
                1,
                LocalDate.of(2024, 2, 22)
        );
        companyList.getData(6).getJobPostingList().add(jp);
        jobList.getData(6).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(6),
                jobList.getData(7),
                "Oversee encryption technologies to ensure safe data storage and transmission.",
                5300.00,
                7800.00,
                1,
                LocalDate.of(2024, 4, 10)
        );
        companyList.getData(6).getJobPostingList().add(jp);
        jobList.getData(7).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(7),
                jobList.getData(7),
                "Maintain and optimize large-scale SQL databases for high performance.",
                4000.00,
                6500.00,
                2,
                LocalDate.of(2024, 5, 1)
        );
        companyList.getData(7).getJobPostingList().add(jp);
        jobList.getData(7).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(7),
                jobList.getData(8),
                "Lead migration of cloud-based systems and oversee architecture optimization.",
                5800.00,
                8200.00,
                3,
                LocalDate.of(2024, 5, 30)
        );
        companyList.getData(7).getJobPostingList().add(jp);
        jobList.getData(8).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(8),
                jobList.getData(8),
                "Develop full-stack web applications with seamless integration of frontend and backend.",
                4800.00,
                7000.00,
                1,
                LocalDate.of(2024, 3, 15)
        );
        companyList.getData(8).getJobPostingList().add(jp);
        jobList.getData(8).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(8),
                jobList.getData(9),
                "Collaborate with teams to deliver full-stack web applications on time.",
                4800.00,
                7000.00,
                2,
                LocalDate.of(2024, 6, 1)
        );
        companyList.getData(8).getJobPostingList().add(jp);
        jobList.getData(9).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(9),
                jobList.getData(9),
                "Assist in AI model training and evaluation for real-world research projects.",
                3000.00,
                4000.00,
                1,
                LocalDate.of(2024, 1, 5)
        );
        companyList.getData(9).getJobPostingList().add(jp);
        jobList.getData(9).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(9),
                jobList.getData(10),
                "Conduct research and create innovative AI solutions for clients.",
                6000.00,
                8500.00,
                1,
                LocalDate.of(2024, 7, 12)
        );
        companyList.getData(9).getJobPostingList().add(jp);
        jobList.getData(10).getJobPostingList().add(jp);

        jp = new JobPosting(
                companyList.getData(10),
                jobList.getData(10),
                "Lead the development of innovative solutions in the field of AI and machine learning.",
                6000.00,
                9000.00,
                3,
                LocalDate.of(2024, 7, 1)
        );
        companyList.getData(10).getJobPostingList().add(jp);
        jobList.getData(10).getJobPostingList().add(jp);

    }

    private void initializeJobApplication() {
        studentList.getData(1).getJobApplicationList().add(new JobApplication(studentList.getData(1), companyList.getData(1).getJobPostingList().getData(1), interviewList.getData(1), LocalDateTime.of(2025, 4, 1, 13, 0)));
        studentList.getData(1).getJobApplicationList().add(new JobApplication(studentList.getData(1),  companyList.getData(3).getJobPostingList().getData(4), interviewList.getData(3), LocalDateTime.of(2025, 7, 1, 13, 0)));
//        studentList.getData(1).getJobApplicationList().add(new JobApplication(studentList.getData(1),  LocalDateTime.of(2025, 4, 1, 13, 0)));
//        studentList.getData(1).getJobApplicationList().add(new JobApplication(studentList.getData(1),  LocalDateTime.of(2025, 4, 1, 13, 0)));
//        studentList.getData(1).getJobApplicationList().add(new JobApplication(studentList.getData(1),  LocalDateTime.of(2025, 4, 1, 13, 0)));
        
//        jobApplicationList.add(new JobApplication(
//                "JA-1", 
//                studentList.getData(1),
//                LocalDateTime.of(2025, 7, 1, 13, 0)
//        ));
//        jobApplicationList.add(new JobApplication(
//                "JA-2",
//                studentList.getData(2),
//                LocalDateTime.of(2024, 7, 1, 13, 0)
//        ));
//        jobApplicationList.add(new JobApplication(
//                "JA-3",
//                studentList.getData(4),
//                LocalDateTime.of(2024, 6, 1, 13, 0)
//        ));
//        jobApplicationList.add(new JobApplication(
//                "JA-4",
//                studentList.getData(6),
//                LocalDateTime.of(2024, 7, 1, 19, 0)
//        ));
//        jobApplicationList.add(new JobApplication(
//                "JA-5",
//                studentList.getData(5),
//                LocalDateTime.of(2024, 7, 1, 13, 0)
//        ));
//        jobApplicationList.add(new JobApplication(
//                "JA-6", 
//                studentList.getData(3),
//                LocalDateTime.of(2024, 7, 1, 13, 0)
//        ));
//        jobApplicationList.add(new JobApplication(
//                "JA-7",
//                studentList.getData(1),
//                LocalDateTime.of(2024, 7, 1, 13, 0)
//        ));
//        jobApplicationList.add(new JobApplication(
//                "JA-8",
//                studentList.getData(2),
//                LocalDateTime.of(2024, 7, 1, 13, 0)
//        ));
    }

    private void initializeStudentSkillList() {
        studentList.getData(1).getStudentSkillList().add(new StudentSkill(skillList.getData(1), 3));
        studentList.getData(1).getStudentSkillList().add(new StudentSkill(skillList.getData(2), 5));
        studentList.getData(1).getStudentSkillList().add(new StudentSkill(skillList.getData(3), 2));

        studentList.getData(2).getStudentSkillList().add(new StudentSkill(skillList.getData(4), 4));
        studentList.getData(2).getStudentSkillList().add(new StudentSkill(skillList.getData(1), 2));
        studentList.getData(2).getStudentSkillList().add(new StudentSkill(skillList.getData(5), 3));

        studentList.getData(3).getStudentSkillList().add(new StudentSkill(skillList.getData(6), 5));
        studentList.getData(3).getStudentSkillList().add(new StudentSkill(skillList.getData(9), 2));

        studentList.getData(4).getStudentSkillList().add(new StudentSkill(skillList.getData(5), 4));
        studentList.getData(4).getStudentSkillList().add(new StudentSkill(skillList.getData(1), 3));
        studentList.getData(4).getStudentSkillList().add(new StudentSkill(skillList.getData(6), 2));

        studentList.getData(5).getStudentSkillList().add(new StudentSkill(skillList.getData(3), 5));
        studentList.getData(5).getStudentSkillList().add(new StudentSkill(skillList.getData(4), 2));
        studentList.getData(5).getStudentSkillList().add(new StudentSkill(skillList.getData(2), 1));

        studentList.getData(6).getStudentSkillList().add(new StudentSkill(skillList.getData(6), 4));
        studentList.getData(6).getStudentSkillList().add(new StudentSkill(skillList.getData(3), 3));
        studentList.getData(6).getStudentSkillList().add(new StudentSkill(skillList.getData(1), 2));

        studentList.getData(7).getStudentSkillList().add(new StudentSkill(skillList.getData(2), 3));
        studentList.getData(7).getStudentSkillList().add(new StudentSkill(skillList.getData(5), 4));
        studentList.getData(7).getStudentSkillList().add(new StudentSkill(skillList.getData(6), 2));

        studentList.getData(8).getStudentSkillList().add(new StudentSkill(skillList.getData(4), 1));
        studentList.getData(8).getStudentSkillList().add(new StudentSkill(skillList.getData(1), 5));
        studentList.getData(8).getStudentSkillList().add(new StudentSkill(skillList.getData(3), 2));

        studentList.getData(9).getStudentSkillList().add(new StudentSkill(skillList.getData(5), 3));
        studentList.getData(9).getStudentSkillList().add(new StudentSkill(skillList.getData(2), 1));
        studentList.getData(9).getStudentSkillList().add(new StudentSkill(skillList.getData(6), 4));

        studentList.getData(10).getStudentSkillList().add(new StudentSkill(skillList.getData(1), 2));
        studentList.getData(10).getStudentSkillList().add(new StudentSkill(skillList.getData(4), 3));
        studentList.getData(10).getStudentSkillList().add(new StudentSkill(skillList.getData(3), 5));
    }

    private void initializeJobRequiredSkill() {
        JobRequiredSkill jrs;

        jrs = new JobRequiredSkill(skillList.getData(1), 2);
        companyList.getData(1).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(5), 1);
        companyList.getData(1).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(3), 3);
        companyList.getData(1).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(2), 1);
        companyList.getData(1).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(5), 2);
        companyList.getData(1).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(4), 4);
        companyList.getData(1).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(3), 2);
        companyList.getData(4).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(9), 5);
        companyList.getData(4).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(7), 3);
        companyList.getData(4).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(1), 2);
        companyList.getData(3).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(6), 4);
        companyList.getData(3).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(8), 1);
        companyList.getData(3).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(5), 2);
        companyList.getData(5).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(10), 1);
        companyList.getData(5).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(4), 3);
        companyList.getData(5).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(2), 1);
        companyList.getData(6).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(7), 5);
        companyList.getData(6).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(9), 2);
        companyList.getData(6).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(3), 4);
        companyList.getData(7).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(6), 3);
        companyList.getData(7).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(8), 2);
        companyList.getData(8).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(10), 1);
        companyList.getData(8).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(1), 3);
        companyList.getData(8).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(4), 2);
        companyList.getData(9).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(6), 3);
        companyList.getData(9).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(7), 5);
        companyList.getData(9).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

    }
    
    public void initializeInterview(){
 /*       
        // Company 1
        companyJob = new CompanyJob(
                companyList.getData(1),
                jobList.getData(1)
        );
        companyList.getData(1).getCompanyJobList().add(companyJob);
        jobList.getData(1).getCompanyJobList().add(companyJob);

        companyJob = new CompanyJob(
                companyList.getData(1),
                jobList.getData(2)
        );
        companyList.getData(1).getCompanyJobList().add(companyJob);
        jobList.getData(2).getCompanyJobList().add(companyJob);

        // Company 2 
        companyJob = new CompanyJob(
                companyList.getData(2),
                jobList.getData(3)
        );
        companyList.getData(2).getCompanyJobList().add(companyJob);
        jobList.getData(3).getCompanyJobList().add(companyJob);

        companyJob = new CompanyJob(
                companyList.getData(2),
                jobList.getData(4)
        );
        companyList.getData(2).getCompanyJobList().add(companyJob);
        jobList.getData(4).getCompanyJobList().add(companyJob);     
*/
 
        //Interiew 1
        interviewList.add(new Interview("itv1", LocalDateTime.of(2025, 4, 1, 13, 0), InterviewStatus.INTERVIEWED, 78));
        interviewList.add(new Interview("itv2", LocalDateTime.of(2025, 4, 2, 14, 0), InterviewStatus.OFFERED, 80));
        interviewList.add(new Interview("itv3", LocalDateTime.of(2025, 4, 3, 9, 0), InterviewStatus.REJECTED, 45));
        interviewList.add(new Interview("itv4", LocalDateTime.of(2025, 4, 5, 10, 0), InterviewStatus.ACCEPTED, 92));
        interviewList.add(new Interview("itv5", LocalDateTime.of(2025, 4, 7, 15, 0), InterviewStatus.INTERVIEW_SCHEDULED, 56));
        interviewList.add(new Interview("itv6", LocalDateTime.of(2025, 4, 8, 16, 0), InterviewStatus.DECLINED, 63));
        interviewList.add(new Interview("itv7", LocalDateTime.of(2025, 4, 9, 13, 0), InterviewStatus.OFFERED, 89));
        interviewList.add(new Interview("itv8", LocalDateTime.of(2025, 4, 10, 14, 0), InterviewStatus.INTERVIEWED, 77));
        interviewList.add(new Interview("itv9", LocalDateTime.of(2025, 4, 12, 9, 0), InterviewStatus.REJECTED, 50));
        interviewList.add(new Interview("itv10", LocalDateTime.of(2025, 4, 14, 11, 0), InterviewStatus.ACCEPTED, 95));

    }

    // -----------------
    // Getter
    public ListInterface<Skill> getSkillList() {
        return skillList;
    }

    public ListInterface<Company> getCompanyList() {
        return companyList;
    }

    public ListInterface<Job> getJobList() {
        return jobList;
    }

    public ListInterface<JobApplication> getJobApplicationList() {
        return jobApplicationList;
    }

    public ListInterface<Student> getStudentList() {
        return studentList;
    }

    public ListInterface<Interview> getInterviewList() {
        return interviewList;
    }
    
    // -----------------
    // Display for testing
    public static void main(String[] args) {
        AllDataInitialize dataInitialize = new AllDataInitialize();

        for (Student a : dataInitialize.getStudentList()) {
            System.out.println(a);
        }
    }
    
}

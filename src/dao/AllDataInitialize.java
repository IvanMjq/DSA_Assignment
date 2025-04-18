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

        initializeInterview();

        intializeStudent();

        initializeJobPosting();

        initializeJobApplication();

        initializeStudentSkillList();

        initializeJobRequiredSkill();
    }

    private void initializeSkillList() {
        // Computer & Technology (1–6)
        skillList.add(new Skill("SK-1", "Java Programming"));
        skillList.add(new Skill("SK-2", "Python Scripting"));
        skillList.add(new Skill("SK-3", "React.js Development"));
        skillList.add(new Skill("SK-4", "SQL Database Management"));
        skillList.add(new Skill("SK-5", "Version Control (Git)"));
        skillList.add(new Skill("SK-6", "Cybersecurity Principles"));

        // Engineering (7–11)
        skillList.add(new Skill("SK-7", "AutoCAD Design"));
        skillList.add(new Skill("SK-8", "SolidWorks 3D Modeling"));
        skillList.add(new Skill("SK-9", "MATLAB Simulation"));
        skillList.add(new Skill("SK-10", "Thermodynamics"));
        skillList.add(new Skill("SK-11", "Circuit Design"));

        // Finance & Banking (12–16)
        skillList.add(new Skill("SK-12", "Advanced Excel"));
        skillList.add(new Skill("SK-13", "Financial Modeling"));
        skillList.add(new Skill("SK-14", "Accounting Standards"));
        skillList.add(new Skill("SK-15", "Credit & Risk Analysis"));
        skillList.add(new Skill("SK-16", "Budget Forecasting"));

        // Education (17–21)
        skillList.add(new Skill("SK-17", "Lesson Planning"));
        skillList.add(new Skill("SK-18", "Public Speaking"));
        skillList.add(new Skill("SK-19", "Curriculum Design"));
        skillList.add(new Skill("SK-20", "Google Classroom Tools"));
        skillList.add(new Skill("SK-21", "E-learning Platform Use"));

        // Healthcare (22–25)
        skillList.add(new Skill("SK-22", "Patient Care Techniques"));
        skillList.add(new Skill("SK-23", "Medical Laboratory Testing"));
        skillList.add(new Skill("SK-24", "Medical Terminology"));
        skillList.add(new Skill("SK-25", "CPR and Emergency Care"));
    }

    private void initializeCompanyList() {
        companyList.add(new Company("C-1", "TechNova Solutions", "03-1010101", "hr@technova.com", "10 Jalan Teknologi", "Cyberjaya", "Selangor", 0, 0, 2010, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        companyList.add(new Company("C-2", "CodeLab Systems", "03-2020202", "contact@codelab.com", "22 Jalan Binary", "Petaling Jaya", "Selangor", 0, 0, 2012, LocalTime.of(10, 0), LocalTime.of(18, 0)));
        companyList.add(new Company("C-3", "DataWave Tech", "03-3030303", "jobs@datawave.com", "33 Jalan AI", "Kuala Lumpur", "Wilayah Persekutuan", 0, 0, 2015, LocalTime.of(9, 30), LocalTime.of(17, 30)));
        companyList.add(new Company("C-4", "CloudScape Sdn Bhd", "03-4040404", "careers@cloudscape.com", "44 Cloud Street", "Penang", "Pulau Pinang", 0, 0, 2018, LocalTime.of(8, 30), LocalTime.of(17, 0)));
        companyList.add(new Company("C-5", "SecureNet Cyber", "03-5050505", "secure@net.com", "55 Jalan Firewall", "Shah Alam", "Selangor", 0, 0, 2020, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        companyList.add(new Company("C-6", "ByteForge", "03-6060606", "byte@forge.com", "66 Dev Lane", "Seremban", "Negeri Sembilan", 0, 0, 2011, LocalTime.of(10, 0), LocalTime.of(19, 0)));
        companyList.add(new Company("C-7", "NextGen IT", "03-7070707", "next@gen.com", "77 Jalan Next", "Melaka", "Melaka", 0, 0, 2009, LocalTime.of(8, 30), LocalTime.of(17, 30)));

        companyList.add(new Company("C-8", "MechPro Engineering", "03-8080808", "jobs@mechpro.com", "88 Engine Blvd", "Johor Bahru", "Johor", 0, 0, 2008, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        companyList.add(new Company("C-9", "ElectroWorks", "03-9090909", "careers@electroworks.com", "99 Electric Ave", "Kuantan", "Pahang", 0, 0, 2010, LocalTime.of(10, 0), LocalTime.of(18, 0)));
        companyList.add(new Company("C-10", "Structura Builders", "03-1111222", "build@structura.com", "100 Concrete Road", "Alor Setar", "Kedah", 0, 0, 2006, LocalTime.of(8, 0), LocalTime.of(17, 0)));
        companyList.add(new Company("C-11", "ChemTech Industries", "03-2222333", "hr@chemtech.com", "11A Chemical Park", "Ipoh", "Perak", 0, 0, 2013, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        companyList.add(new Company("C-12", "FlowOpt Solutions", "03-3333444", "jobs@flowopt.com", "12B Automation Drive", "Kota Bharu", "Kelantan", 0, 0, 2017, LocalTime.of(10, 0), LocalTime.of(18, 0)));

        companyList.add(new Company("C-13", "FinTrust Advisors", "03-4444555", "careers@fintrust.com", "13 Finance Street", "Kuala Lumpur", "Wilayah Persekutuan", 0, 0, 2005, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        companyList.add(new Company("C-14", "CapitalWise Bank", "03-5555666", "jobs@capitalwise.com", "14 Money Lane", "Petaling Jaya", "Selangor", 0, 0, 2000, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        companyList.add(new Company("C-15", "AuditCore", "03-6666777", "audit@core.com", "15A Jalan Audit", "Putrajaya", "Wilayah Persekutuan", 0, 0, 2002, LocalTime.of(8, 30), LocalTime.of(16, 30)));
        companyList.add(new Company("C-16", "CrediFlex Solutions", "03-7777888", "recruit@crediflex.com", "16B Loan Avenue", "Seremban", "Negeri Sembilan", 0, 0, 2009, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        companyList.add(new Company("C-17", "BudgetEase", "03-8888999", "hr@budgetease.com", "17 Budget Rd", "Kota Kinabalu", "Sabah", 0, 0, 2014, LocalTime.of(9, 0), LocalTime.of(17, 0)));

        companyList.add(new Company("C-18", "BrightFuture Academy", "03-9999000", "info@brightfuture.edu", "18A EduCity", "Johor Bahru", "Johor", 0, 0, 2011, LocalTime.of(7, 30), LocalTime.of(15, 30)));
        companyList.add(new Company("C-19", "SmartLearn Institute", "03-1212121", "admin@smartlearn.my", "19B Jalan Ilmu", "Shah Alam", "Selangor", 0, 0, 2013, LocalTime.of(8, 00), LocalTime.of(16, 00)));
        companyList.add(new Company("C-20", "UniGlobal University", "03-1313131", "faculty@uniglobal.edu", "20 Global Campus", "Kuala Lumpur", "Wilayah Persekutuan", 0, 0, 2000, LocalTime.of(9, 0), LocalTime.of(18, 0)));
        companyList.add(new Company("C-21", "E-Course Academy", "03-1414141", "support@ecourse.my", "21 Digital Lane", "Cyberjaya", "Selangor", 0, 0, 2019, LocalTime.of(10, 0), LocalTime.of(19, 0)));

        companyList.add(new Company("C-22", "MediCare Hospital", "03-1515151", "jobs@medicare.com", "22 Health Park", "Ipoh", "Perak", 0, 0, 1998, LocalTime.of(8, 0), LocalTime.of(17, 0)));
        companyList.add(new Company("C-23", "PathLab Diagnostics", "03-1616161", "lab@pathlab.my", "23 Lab Street", "Penang", "Pulau Pinang", 0, 0, 2012, LocalTime.of(8, 30), LocalTime.of(17, 30)));
        companyList.add(new Company("C-24", "CarePlus Pharmacy", "03-1717171", "care@careplus.com", "24 Meds Avenue", "Kuantan", "Pahang", 0, 0, 2016, LocalTime.of(9, 0), LocalTime.of(18, 0)));
        companyList.add(new Company("C-25", "PhysioLife Center", "03-1818181", "apply@physiolife.my", "25 Recovery Lane", "Melaka", "Melaka", 0, 0, 2018, LocalTime.of(9, 0), LocalTime.of(17, 0)));
    }

    private void initializeJob() {
        jobList.add(new Job("J-1", "Software Engineer", "Computer & Technology", "Develop and maintain software systems."));
        jobList.add(new Job("J-2", "Web Developer", "Computer & Technology", "Design and build websites and web applications."));
        jobList.add(new Job("J-3", "Database Administrator", "Computer & Technology", "Manage and secure data in databases."));
        jobList.add(new Job("J-4", "Cybersecurity Analyst", "Computer & Technology", "Protect systems from cyber threats."));
        jobList.add(new Job("J-5", "Machine Learning Engineer", "Computer & Technology", "Develop and deploy ML models."));
        jobList.add(new Job("J-6", "Cloud Architect", "Computer & Technology", "Design cloud infrastructure solutions."));
        jobList.add(new Job("J-7", "IT Support Specialist", "Computer & Technology", "Provide technical support and troubleshooting."));

        jobList.add(new Job("J-8", "Mechanical Engineer", "Engineering", "Design mechanical systems and products."));
        jobList.add(new Job("J-9", "Electrical Engineer", "Engineering", "Develop electrical components and systems."));
        jobList.add(new Job("J-10", "Civil Engineer", "Engineering", "Oversee construction projects and infrastructure."));
        jobList.add(new Job("J-11", "Chemical Engineer", "Engineering", "Work on chemical manufacturing processes."));
        jobList.add(new Job("J-12", "Industrial Engineer", "Engineering", "Improve systems and processes for efficiency."));

        jobList.add(new Job("J-13", "Financial Analyst", "Finance & Banking", "Analyze financial data and market trends."));
        jobList.add(new Job("J-14", "Investment Banker", "Finance & Banking", "Help companies raise capital."));
        jobList.add(new Job("J-15", "Auditor", "Finance & Banking", "Review financial statements for accuracy."));
        jobList.add(new Job("J-16", "Credit Risk Analyst", "Finance & Banking", "Assess loan risks and credit scores."));
        jobList.add(new Job("J-17", "Budget Analyst", "Finance & Banking", "Develop and monitor budgets."));

        jobList.add(new Job("J-18", "Primary School Teacher", "Education", "Teach young students core subjects."));
        jobList.add(new Job("J-19", "Secondary School Teacher", "Education", "Teach subject-specific classes to teens."));
        jobList.add(new Job("J-20", "University Lecturer", "Education", "Teach and research in higher education."));
        jobList.add(new Job("J-21", "Online Instructor", "Education", "Teach courses via online platforms."));

        jobList.add(new Job("J-22", "Registered Nurse", "Healthcare", "Provide medical care and patient support."));
        jobList.add(new Job("J-23", "Medical Laboratory Technologist", "Healthcare", "Perform lab tests and analysis."));
        jobList.add(new Job("J-24", "Pharmacist", "Healthcare", "Dispense medications and advise patients."));
        jobList.add(new Job("J-25", "Physiotherapist", "Healthcare", "Help patients recover physical function."));
    }

    private void intializeStudent() {
        studentList.add(new Student("STU-1", "Alan Chopper", "abc12345", 22, "12 Jalan Ampang", "Kuala Lumpur", "Wilayah Persekutuan", 0.0, 0.0, "alan.chopper@example.com", "Dean's List Award", "Bachelor of Computer Science", 1, "Computer & Technology"));
        studentList.add(new Student("STU-2", "Lavenda Lee", "abc12345", 24, "33 Jalan Tun Razak", "Kuala Lumpur", "Wilayah Persekutuan", 0.0, 0.0, "lavenda.lee@example.com", "Hackathon Winner", "Bachelor of Software Engineering", 2, "Computer & Technology", "Engineering"));
        studentList.add(new Student("STU-3", "Charles Tan", "abc12345", 21, "21 Jalan Dato Onn", "Johor Bahru", "Johor", 0.0, 0.0, "charles.tan@example.com", "Top GPA", "Diploma in Information Technology", 1, "Computer & Technology"));
        studentList.add(new Student("STU-4", "Diana Wong", "abc12345", 23, "18 Jalan Gurney", "Georgetown", "Penang", 0.0, 0.0, "diana.wong@example.com", "Intern of the Year", "Bachelor of Finance", 2, "Finance & Banking"));
        studentList.add(new Student("STU-5", "Ethan Lim", "abc12345", 25, "25 Persiaran Gurney", "Ipoh", "Perak", 0.0, 0.0, "ethan.lim@example.com", "Research Assistant", "Master of Data Science", 3, "Computer & Technology", "Finance & Banking"));
        studentList.add(new Student("STU-6", "Fiona Teh", "abc12345", 20, "88 Jalan Tokong", "Melaka City", "Melaka", 0.0, 0.0, "fiona.teh@example.com", "Coding Bootcamp Grad", "Diploma in Computer Science", 1, "Computer & Technology", "Engineering"));
        studentList.add(new Student("STU-7", "George Ng", "abc12345", 22, "50 Jalan Song", "Kuching", "Sarawak", 0.0, 0.0, "george.ng@example.com", "Volunteer Mentor", "Bachelor of Software Engineering", 1, "Computer & Technology", "Education"));
        studentList.add(new Student("STU-8", "Hannah Yap", "abc12345", 23, "60 Jalan Sultan", "Seremban", "Negeri Sembilan", 0.0, 0.0, "hannah.yap@example.com", "Scholarship Recipient", "Bachelor of IT", 2, "Computer & Technology"));
        studentList.add(new Student("STU-9", "Ivan Raj", "abc12345", 24, "12 Jalan Lintas", "Kota Kinabalu", "Sabah", 0.0, 0.0, "ivan.raj@example.com", "Startup Founder", "Bachelor of Computer Science", 3, "Computer & Technology", "Engineering"));
        studentList.add(new Student("STU-10", "Jasmine Koh", "abc12345", 21, "77 Jalan Sultan Ismail", "Kuala Lumpur", "Wilayah Persekutuan", 0.0, 0.0, "jasmine.koh@example.com", "Exchange Program Alumni", "Bachelor of AI", 2, "Computer & Technology", "Healthcare"));

        studentList.add(new Student("STU-11", "Raymond Toh", "abc12345", 23, "99 Jalan Universiti", "Petaling Jaya", "Selangor", 0.0, 0.0, "raymond.toh@example.com", "Dean’s List", "Bachelor of Mechanical Engineering", 2, "Engineering"));
        studentList.add(new Student("STU-12", "Lily Wong", "abc12345", 24, "88 Jalan Aman", "Kota Bharu", "Kelantan", 0.0, 0.0, "lily.wong@example.com", "Project Winner", "Diploma in Civil Engineering", 1, "Engineering"));
        studentList.add(new Student("STU-13", "Nicholas Yeo", "abc12345", 22, "77 Jalan Sungai", "Alor Setar", "Kedah", 0.0, 0.0, "nicholas.yeo@example.com", "Top Student", "Bachelor of Electrical Engineering", 2, "Engineering", "Computer & Technology"));
        studentList.add(new Student("STU-14", "Brenda Lee", "abc12345", 25, "66 Jalan Kewangan", "Shah Alam", "Selangor", 0.0, 0.0, "brenda.lee@example.com", "Audit Intern", "Bachelor of Accounting", 3, "Finance & Banking"));
        studentList.add(new Student("STU-15", "Aaron Chin", "abc12345", 23, "55 Jalan Sultanah", "Johor Bahru", "Johor", 0.0, 0.0, "aaron.chin@example.com", "Scholarship Recipient", "Bachelor of Business Admin", 2, "Finance & Banking"));
        studentList.add(new Student("STU-16", "Esther Goh", "abc12345", 24, "44 Jalan Mega", "Kuching", "Sarawak", 0.0, 0.0, "esther.goh@example.com", "Equity Research Intern", "Master of Finance", 2, "Finance & Banking", "Computer & Technology"));
        studentList.add(new Student("STU-17", "Isaac Tan", "abc12345", 22, "33 Jalan Damai", "Putrajaya", "Wilayah Persekutuan", 0.0, 0.0, "isaac.tan@example.com", "School Club Leader", "Bachelor of Education", 1, "Education"));
        studentList.add(new Student("STU-18", "Michelle Ong", "abc12345", 21, "22 Jalan Raja", "Taiping", "Perak", 0.0, 0.0, "michelle.ong@example.com", "Best Presenter", "Diploma in Early Childhood Education", 1, "Education", "Healthcare"));
        studentList.add(new Student("STU-19", "Timothy Low", "abc12345", 23, "11 Jalan Besar", "Butterworth", "Pulau Pinang", 0.0, 0.0, "timothy.low@example.com", "MOE Scholar", "Master of Teaching", 2, "Education"));
        studentList.add(new Student("STU-20", "Yvonne Chee", "abc12345", 24, "109 Jalan Multimedia", "Cyberjaya", "Selangor", 0.0, 0.0, "yvonne.chee@example.com", "E-learning Developer", "Bachelor of Instructional Design", 2, "Education", "Computer & Technology"));

        studentList.add(new Student("STU-21", "Felicia Ng", "abc12345", 21, "98 Jalan Medikal", "Ipoh", "Perak", 0.0, 0.0, "felicia.ng@example.com", "Top Nurse Trainee", "Diploma in Nursing", 1, "Healthcare"));
        studentList.add(new Student("STU-22", "Daniel Lim", "abc12345", 22, "87 Jalan Biotek", "George Town", "Pulau Pinang", 0.0, 0.0, "daniel.lim@example.com", "Lab Research Intern", "Bachelor of Biomedical Science", 1, "Healthcare", "Computer & Technology"));
        studentList.add(new Student("STU-23", "Kelly Chan", "abc12345", 23, "76 Jalan Farmasi", "Kuantan", "Pahang", 0.0, 0.0, "kelly.chan@example.com", "Pharma Camp Graduate", "Bachelor of Pharmacy", 2, "Healthcare"));
        studentList.add(new Student("STU-24", "Zaid Ahmad", "abc12345", 24, "65 Jalan Kesihatan", "Melaka", "Melaka", 0.0, 0.0, "zaid.ahmad@example.com", "Caregiver Intern", "Diploma in Physiotherapy", 2, "Healthcare"));
        studentList.add(new Student("STU-25", "Chloe Tan", "abc12345", 22, "54 Jalan Klinik", "Seremban", "Negeri Sembilan", 0.0, 0.0, "chloe.tan@example.com", "Research Assistant", "Bachelor of Medical Science", 2, "Healthcare", "Education"));
    }


    private void initializeInterview() {
        interviewList.add(new Interview("itv-1", LocalDateTime.of(2025, 4, 1, 13, 0), InterviewStatus.INTERVIEWED, 70));
        interviewList.add(new Interview("itv-2", LocalDateTime.of(2025, 4, 2, 14, 0), InterviewStatus.OFFERED, 92));
        interviewList.add(new Interview("itv-3", LocalDateTime.of(2025, 4, 3, 9, 0), InterviewStatus.REJECTED, 58));
        interviewList.add(new Interview("itv-4", LocalDateTime.of(2025, 4, 4, 10, 0), InterviewStatus.INTERVIEWED, 65));
        interviewList.add(new Interview("itv-5", LocalDateTime.of(2025, 4, 5, 15, 0), InterviewStatus.OFFERED, 88));
        interviewList.add(new Interview("itv-6", LocalDateTime.of(2025, 4, 6, 16, 0), InterviewStatus.REJECTED, 42));
        interviewList.add(new Interview("itv-7", LocalDateTime.of(2025, 4, 7, 13, 0), InterviewStatus.INTERVIEWED, 72));
        interviewList.add(new Interview("itv-8", LocalDateTime.of(2025, 4, 8, 14, 0), InterviewStatus.OFFERED, 90));
        interviewList.add(new Interview("itv-9", LocalDateTime.of(2025, 4, 9, 9, 0), InterviewStatus.REJECTED, 50));
        interviewList.add(new Interview("itv-10", LocalDateTime.of(2025, 4, 10, 11, 0), InterviewStatus.INTERVIEWED, 67));

        interviewList.add(new Interview("itv-11", LocalDateTime.of(2025, 4, 11, 13, 0), InterviewStatus.OFFERED, 95));
        interviewList.add(new Interview("itv-12", LocalDateTime.of(2025, 4, 12, 14, 0), InterviewStatus.REJECTED, 46));
        interviewList.add(new Interview("itv-13", LocalDateTime.of(2025, 4, 13, 9, 0), InterviewStatus.INTERVIEWED, 68));
        interviewList.add(new Interview("itv-14", LocalDateTime.of(2025, 4, 14, 10, 0), InterviewStatus.OFFERED, 86));
        interviewList.add(new Interview("itv-15", LocalDateTime.of(2025, 4, 15, 15, 0), InterviewStatus.REJECTED, 52));
        interviewList.add(new Interview("itv-16", LocalDateTime.of(2025, 4, 16, 16, 0), InterviewStatus.INTERVIEWED, 76));
        interviewList.add(new Interview("itv-17", LocalDateTime.of(2025, 4, 17, 13, 0), InterviewStatus.OFFERED, 98));
        interviewList.add(new Interview("itv-18", LocalDateTime.of(2025, 4, 18, 14, 0), InterviewStatus.REJECTED, 45));
        interviewList.add(new Interview("itv-19", LocalDateTime.of(2025, 4, 19, 9, 0), InterviewStatus.INTERVIEWED, 73));
        interviewList.add(new Interview("itv-20", LocalDateTime.of(2025, 4, 20, 11, 0), InterviewStatus.OFFERED, 89));

        interviewList.add(new Interview("itv-21", LocalDateTime.of(2025, 4, 21, 12, 30), InterviewStatus.REJECTED, 40));
        interviewList.add(new Interview("itv-22", LocalDateTime.of(2025, 4, 22, 14, 30), InterviewStatus.INTERVIEWED, 69));
        interviewList.add(new Interview("itv-23", LocalDateTime.of(2025, 4, 23, 15, 0), InterviewStatus.OFFERED, 84));
        interviewList.add(new Interview("itv-24", LocalDateTime.of(2025, 4, 24, 16, 0), InterviewStatus.REJECTED, 57));
        interviewList.add(new Interview("itv-25", LocalDateTime.of(2025, 4, 25, 10, 0), InterviewStatus.INTERVIEWED, 74));
    }


    private void initializeJobPosting() {
        JobPosting jp;

        // Posting 1
        jp = new JobPosting(companyList.getData(1), jobList.getData(1), "Develop backend systems using Java.", 4000.00, 6000.00, 2, LocalDate.of(2025, 1, 10));
        companyList.getData(1).getJobPostingList().add(jp);
        jobList.getData(1).getJobPostingList().add(jp);

        // Posting 2
        jp = new JobPosting(companyList.getData(1), jobList.getData(2), "Create and maintain responsive websites.", 3500.00, 5000.00, 1, LocalDate.of(2025, 2, 12));
        companyList.getData(1).getJobPostingList().add(jp);
        jobList.getData(2).getJobPostingList().add(jp);

        // Posting 3
        jp = new JobPosting(companyList.getData(2), jobList.getData(3), "Manage corporate database systems.", 4500.00, 6500.00, 3, LocalDate.of(2025, 3, 5));
        companyList.getData(2).getJobPostingList().add(jp);
        jobList.getData(3).getJobPostingList().add(jp);

        // Posting 4
        jp = new JobPosting(companyList.getData(2), jobList.getData(4), "Ensure company systems are secure from threats.", 4700.00, 7000.00, 2, LocalDate.of(2025, 4, 15));
        companyList.getData(2).getJobPostingList().add(jp);
        jobList.getData(4).getJobPostingList().add(jp);

        // Posting 5
        jp = new JobPosting(companyList.getData(3), jobList.getData(5), "Build and deploy machine learning models.", 5000.00, 7500.00, 3, LocalDate.of(2025, 5, 1));
        companyList.getData(3).getJobPostingList().add(jp);
        jobList.getData(5).getJobPostingList().add(jp);

        // Posting 6
        jp = new JobPosting(companyList.getData(3), jobList.getData(6), "Design and manage cloud infrastructure.", 5500.00, 8000.00, 4, LocalDate.of(2025, 6, 18));
        companyList.getData(3).getJobPostingList().add(jp);
        jobList.getData(6).getJobPostingList().add(jp);

        // Posting 7
        jp = new JobPosting(companyList.getData(4), jobList.getData(7), "Support internal IT systems and staff.", 3000.00, 4000.00, 1, LocalDate.of(2025, 7, 5));
        companyList.getData(4).getJobPostingList().add(jp);
        jobList.getData(7).getJobPostingList().add(jp);

        // Posting 8
        jp = new JobPosting(companyList.getData(4), jobList.getData(8), "Develop mechanical solutions for clients.", 4800.00, 7000.00, 3, LocalDate.of(2025, 1, 20));
        companyList.getData(4).getJobPostingList().add(jp);
        jobList.getData(8).getJobPostingList().add(jp);

        // Posting 9
        jp = new JobPosting(companyList.getData(5), jobList.getData(9), "Work on electrical circuits and testing.", 4600.00, 6800.00, 2, LocalDate.of(2025, 2, 14));
        companyList.getData(5).getJobPostingList().add(jp);
        jobList.getData(9).getJobPostingList().add(jp);

        // Posting 10
        jp = new JobPosting(companyList.getData(5), jobList.getData(10), "Oversee civil engineering projects.", 5200.00, 7200.00, 4, LocalDate.of(2025, 3, 25));
        companyList.getData(5).getJobPostingList().add(jp);
        jobList.getData(10).getJobPostingList().add(jp);

        // Posting 11
        jp = new JobPosting(companyList.getData(6), jobList.getData(11), "Assist in chemical manufacturing processes.", 5000.00, 6900.00, 2, LocalDate.of(2025, 4, 17));
        companyList.getData(6).getJobPostingList().add(jp);
        jobList.getData(11).getJobPostingList().add(jp);

        // Posting 12
        jp = new JobPosting(companyList.getData(6), jobList.getData(12), "Optimize manufacturing lines for output.", 5100.00, 7300.00, 3, LocalDate.of(2025, 5, 6));
        companyList.getData(6).getJobPostingList().add(jp);
        jobList.getData(12).getJobPostingList().add(jp);

        // Posting 13
        jp = new JobPosting(companyList.getData(7), jobList.getData(13), "Prepare and analyze financial reports.", 4200.00, 6000.00, 2, LocalDate.of(2025, 6, 10));
        companyList.getData(7).getJobPostingList().add(jp);
        jobList.getData(13).getJobPostingList().add(jp);

        // Posting 14
        jp = new JobPosting(companyList.getData(7), jobList.getData(14), "Support client investments and portfolios.", 5800.00, 8500.00, 3, LocalDate.of(2025, 7, 14));
        companyList.getData(7).getJobPostingList().add(jp);
        jobList.getData(14).getJobPostingList().add(jp);

        // Posting 15
        jp = new JobPosting(companyList.getData(8), jobList.getData(15), "Audit client financial statements.", 5000.00, 7000.00, 2, LocalDate.of(2025, 1, 8));
        companyList.getData(8).getJobPostingList().add(jp);
        jobList.getData(15).getJobPostingList().add(jp);

        // Posting 16
        jp = new JobPosting(companyList.getData(8), jobList.getData(16), "Assess and manage credit risk profiles.", 4700.00, 6800.00, 2, LocalDate.of(2025, 2, 19));
        companyList.getData(8).getJobPostingList().add(jp);
        jobList.getData(16).getJobPostingList().add(jp);

        // Posting 17
        jp = new JobPosting(companyList.getData(9), jobList.getData(17), "Manage budgets and spending forecasts.", 4500.00, 6400.00, 2, LocalDate.of(2025, 3, 21));
        companyList.getData(9).getJobPostingList().add(jp);
        jobList.getData(17).getJobPostingList().add(jp);

        // Posting 18
        jp = new JobPosting(companyList.getData(9), jobList.getData(18), "Teach primary students in core subjects.", 3200.00, 4500.00, 1, LocalDate.of(2025, 4, 2));
        companyList.getData(9).getJobPostingList().add(jp);
        jobList.getData(18).getJobPostingList().add(jp);

        // Posting 19
        jp = new JobPosting(companyList.getData(10), jobList.getData(19), "Teach secondary school science and math.", 3500.00, 5000.00, 1, LocalDate.of(2025, 5, 4));
        companyList.getData(10).getJobPostingList().add(jp);
        jobList.getData(19).getJobPostingList().add(jp);

        // Posting 20
        jp = new JobPosting(companyList.getData(10), jobList.getData(20), "Lecture undergraduate engineering students.", 6000.00, 8500.00, 4, LocalDate.of(2025, 6, 11));
        companyList.getData(10).getJobPostingList().add(jp);
        jobList.getData(20).getJobPostingList().add(jp);
        
        // Posting 21
        jp = new JobPosting(companyList.getData(11), jobList.getData(21), "Teach students through digital platforms.", 4200.00, 6000.00, 2, LocalDate.of(2025, 7, 2));
        companyList.getData(11).getJobPostingList().add(jp);
        jobList.getData(21).getJobPostingList().add(jp);

        // Posting 22
        jp = new JobPosting(companyList.getData(11), jobList.getData(22), "Provide nursing care in medical settings.", 3800.00, 5200.00, 1, LocalDate.of(2025, 1, 15));
        companyList.getData(11).getJobPostingList().add(jp);
        jobList.getData(22).getJobPostingList().add(jp);

        // Posting 23
        jp = new JobPosting(companyList.getData(12), jobList.getData(23), "Perform diagnostic lab tests and analysis.", 3900.00, 5300.00, 2, LocalDate.of(2025, 2, 8));
        companyList.getData(12).getJobPostingList().add(jp);
        jobList.getData(23).getJobPostingList().add(jp);

        // Posting 24
        jp = new JobPosting(companyList.getData(12), jobList.getData(24), "Dispense medications and counsel patients.", 4000.00, 5800.00, 2, LocalDate.of(2025, 3, 20));
        companyList.getData(12).getJobPostingList().add(jp);
        jobList.getData(24).getJobPostingList().add(jp);

        // Posting 25
        jp = new JobPosting(companyList.getData(13), jobList.getData(25), "Assist patients in physical rehabilitation.", 4100.00, 6200.00, 2, LocalDate.of(2025, 4, 12));
        companyList.getData(13).getJobPostingList().add(jp);
        jobList.getData(25).getJobPostingList().add(jp);

        // Posting 26
        jp = new JobPosting(companyList.getData(13), jobList.getData(1), "Write scalable and secure backend code.", 4700.00, 6800.00, 3, LocalDate.of(2025, 5, 6));
        companyList.getData(13).getJobPostingList().add(jp);
        jobList.getData(1).getJobPostingList().add(jp);

        // Posting 27
        jp = new JobPosting(companyList.getData(14), jobList.getData(2), "Develop front-end components using React.", 4500.00, 6300.00, 2, LocalDate.of(2025, 6, 8));
        companyList.getData(14).getJobPostingList().add(jp);
        jobList.getData(2).getJobPostingList().add(jp);

        // Posting 28
        jp = new JobPosting(companyList.getData(14), jobList.getData(3), "Maintain MySQL and PostgreSQL databases.", 5200.00, 7400.00, 3, LocalDate.of(2025, 7, 4));
        companyList.getData(14).getJobPostingList().add(jp);
        jobList.getData(3).getJobPostingList().add(jp);

        // Posting 29
        jp = new JobPosting(companyList.getData(15), jobList.getData(4), "Monitor cyber threats and conduct audits.", 5000.00, 7100.00, 2, LocalDate.of(2025, 1, 9));
        companyList.getData(15).getJobPostingList().add(jp);
        jobList.getData(4).getJobPostingList().add(jp);

        // Posting 30
        jp = new JobPosting(companyList.getData(15), jobList.getData(5), "Deploy ML models for fraud detection.", 6000.00, 8000.00, 3, LocalDate.of(2025, 2, 18));
        companyList.getData(15).getJobPostingList().add(jp);
        jobList.getData(5).getJobPostingList().add(jp);

        // Posting 31
        jp = new JobPosting(companyList.getData(16), jobList.getData(6), "Oversee AWS infrastructure and deployments.", 6200.00, 8500.00, 4, LocalDate.of(2025, 3, 13));
        companyList.getData(16).getJobPostingList().add(jp);
        jobList.getData(6).getJobPostingList().add(jp);

        // Posting 32
        jp = new JobPosting(companyList.getData(16), jobList.getData(7), "Provide IT support to local offices.", 3300.00, 4700.00, 1, LocalDate.of(2025, 4, 1));
        companyList.getData(16).getJobPostingList().add(jp);
        jobList.getData(7).getJobPostingList().add(jp);

        // Posting 33
        jp = new JobPosting(companyList.getData(17), jobList.getData(8), "Create mechanical parts in R&D department.", 4900.00, 7200.00, 3, LocalDate.of(2025, 5, 17));
        companyList.getData(17).getJobPostingList().add(jp);
        jobList.getData(8).getJobPostingList().add(jp);

        // Posting 34
        jp = new JobPosting(companyList.getData(17), jobList.getData(9), "Install and troubleshoot electrical systems.", 4600.00, 6800.00, 2, LocalDate.of(2025, 6, 12));
        companyList.getData(17).getJobPostingList().add(jp);
        jobList.getData(9).getJobPostingList().add(jp);

        // Posting 35
        jp = new JobPosting(companyList.getData(18), jobList.getData(10), "Coordinate civil engineering site projects.", 5200.00, 7800.00, 4, LocalDate.of(2025, 7, 6));
        companyList.getData(18).getJobPostingList().add(jp);
        jobList.getData(10).getJobPostingList().add(jp);

        // Posting 36
        jp = new JobPosting(companyList.getData(18), jobList.getData(11), "Assist in chemical safety process audits.", 5000.00, 6900.00, 2, LocalDate.of(2025, 1, 24));
        companyList.getData(18).getJobPostingList().add(jp);
        jobList.getData(11).getJobPostingList().add(jp);

        // Posting 37
        jp = new JobPosting(companyList.getData(19), jobList.getData(12), "Work on logistics for manufacturing lines.", 5100.00, 7300.00, 3, LocalDate.of(2025, 2, 7));
        companyList.getData(19).getJobPostingList().add(jp);
        jobList.getData(12).getJobPostingList().add(jp);

        // Posting 38
        jp = new JobPosting(companyList.getData(19), jobList.getData(13), "Assist in budget planning and variance checks.", 4400.00, 6200.00, 2, LocalDate.of(2025, 3, 11));
        companyList.getData(19).getJobPostingList().add(jp);
        jobList.getData(13).getJobPostingList().add(jp);

        // Posting 39
        jp = new JobPosting(companyList.getData(20), jobList.getData(14), "Conduct client investment assessments.", 5800.00, 8600.00, 3, LocalDate.of(2025, 4, 10));
        companyList.getData(20).getJobPostingList().add(jp);
        jobList.getData(14).getJobPostingList().add(jp);

        // Posting 40
        jp = new JobPosting(companyList.getData(20), jobList.getData(15), "Audit financial records across departments.", 5200.00, 7100.00, 3, LocalDate.of(2025, 5, 3));
        companyList.getData(20).getJobPostingList().add(jp);
        jobList.getData(15).getJobPostingList().add(jp);

        // Posting 41
        jp = new JobPosting(companyList.getData(21), jobList.getData(16), "Evaluate credit history for new applicants.", 4700.00, 6600.00, 2, LocalDate.of(2025, 6, 20));
        companyList.getData(21).getJobPostingList().add(jp);
        jobList.getData(16).getJobPostingList().add(jp);

        // Posting 42
        jp = new JobPosting(companyList.getData(21), jobList.getData(17), "Monitor department spending and limits.", 4300.00, 5900.00, 2, LocalDate.of(2025, 7, 9));
        companyList.getData(21).getJobPostingList().add(jp);
        jobList.getData(17).getJobPostingList().add(jp);

        // Posting 43
        jp = new JobPosting(companyList.getData(22), jobList.getData(18), "Teach primary students core subjects.", 3100.00, 4500.00, 1, LocalDate.of(2025, 1, 11));
        companyList.getData(22).getJobPostingList().add(jp);
        jobList.getData(18).getJobPostingList().add(jp);

        // Posting 44
        jp = new JobPosting(companyList.getData(22), jobList.getData(19), "Conduct high school science courses.", 3500.00, 4900.00, 1, LocalDate.of(2025, 2, 13));
        companyList.getData(22).getJobPostingList().add(jp);
        jobList.getData(19).getJobPostingList().add(jp);

        // Posting 45
        jp = new JobPosting(companyList.getData(23), jobList.getData(20), "Deliver university lectures on engineering.", 6100.00, 8700.00, 4, LocalDate.of(2025, 3, 30));
        companyList.getData(23).getJobPostingList().add(jp);
        jobList.getData(20).getJobPostingList().add(jp);

        // Posting 46
        jp = new JobPosting(companyList.getData(23), jobList.getData(21), "Deliver live webinars for students worldwide.", 4800.00, 6600.00, 2, LocalDate.of(2025, 4, 22));
        companyList.getData(23).getJobPostingList().add(jp);
        jobList.getData(21).getJobPostingList().add(jp);

        // Posting 47
        jp = new JobPosting(companyList.getData(24), jobList.getData(22), "Support patients in clinical settings.", 3900.00, 5100.00, 1, LocalDate.of(2025, 5, 19));
        companyList.getData(24).getJobPostingList().add(jp);
        jobList.getData(22).getJobPostingList().add(jp);

        // Posting 48
        jp = new JobPosting(companyList.getData(24), jobList.getData(23), "Run lab tests and prepare reports.", 4000.00, 5300.00, 2, LocalDate.of(2025, 6, 15));
        companyList.getData(24).getJobPostingList().add(jp);
        jobList.getData(23).getJobPostingList().add(jp);

        // Posting 49
        jp = new JobPosting(companyList.getData(25), jobList.getData(24), "Dispense prescriptions and monitor inventory.", 4200.00, 5800.00, 2, LocalDate.of(2025, 7, 1));
        companyList.getData(25).getJobPostingList().add(jp);
        jobList.getData(24).getJobPostingList().add(jp);

        // Posting 50
        jp = new JobPosting(companyList.getData(25), jobList.getData(25), "Assist patients in post-surgery rehab.", 4300.00, 6100.00, 2, LocalDate.of(2025, 7, 20));
        companyList.getData(25).getJobPostingList().add(jp);
        jobList.getData(25).getJobPostingList().add(jp);
//        JobPosting jp;
//
//        jp = new JobPosting(
//                companyList.getData(1),
//                jobList.getData(1),
//                "Design, develop, and maintain software applications. Collaborate with cross-functional teams to deliver scalable and efficient software solutions.",
//                3500.00,
//                5000.00,
//                1,
//                LocalDate.of(2024, 3, 12)
//        );
//        companyList.getData(1).getJobPostingList().add(jp);
//        jobList.getData(1).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(1),
//                jobList.getData(2),
//                "Create and manage data visualizations using tools like Tableau and Power BI. Analyze complex datasets to provide actionable insights for business decisions.",
//                4000.00,
//                6000.00,
//                2,
//                LocalDate.of(2024, 4, 15)
//        );
//        companyList.getData(1).getJobPostingList().add(jp);
//        jobList.getData(2).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(1),
//                jobList.getData(5),
//                "Support data-driven decision-making by analyzing datasets, creating reports, and presenting actionable insights to improve business performance.",
//                3700.00,
//                5200.00,
//                2,
//                LocalDate.of(2024, 4, 2)
//        );
//        companyList.getData(1).getJobPostingList().add(jp);
//        jobList.getData(5).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(2),
//                jobList.getData(2),
//                "Develop and maintain scalable backend services, ensuring high performance and reliability. Experience with Java and Spring Boot is essential.",
//                5000.00,
//                7500.00,
//                3,
//                LocalDate.of(2024, 6, 1)
//        );
//        companyList.getData(2).getJobPostingList().add(jp);
//        jobList.getData(2).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(2),
//                jobList.getData(3),
//                "Lead development teams and manage large-scale projects. Utilize Agile methodologies to ensure efficient project execution and delivery.",
//                5500.00,
//                8000.00,
//                3,
//                LocalDate.of(2024, 5, 10)
//        );
//        companyList.getData(2).getJobPostingList().add(jp);
//        jobList.getData(3).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(3),
//                jobList.getData(3),
//                "Work with AI pipelines to optimize model deployment and scalability. Collaborate with data scientists and engineers to streamline AI solutions.",
//                4800.00,
//                7200.00,
//                2,
//                LocalDate.of(2024, 1, 20)
//        );
//        companyList.getData(3).getJobPostingList().add(jp);
//        jobList.getData(3).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(3),
//                jobList.getData(4),
//                "Develop and implement machine learning models to address business problems, including predictive analysis and forecasting.",
//                4800.00,
//                7500.00,
//                1,
//                LocalDate.of(2024, 5, 22)
//        );
//        companyList.getData(3).getJobPostingList().add(jp);
//        jobList.getData(4).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(4),
//                jobList.getData(4),
//                "Design and develop enterprise applications using modern backend frameworks. Ensure applications are scalable, secure, and maintainable.",
//                4000.00,
//                6000.00,
//                3,
//                LocalDate.of(2024, 5, 5)
//        );
//        companyList.getData(4).getJobPostingList().add(jp);
//        jobList.getData(4).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(4),
//                jobList.getData(5),
//                "Lead the design and development of mobile applications for iOS and Android platforms. Collaborate with design and backend teams.",
//                5000.00,
//                7000.00,
//                1,
//                LocalDate.of(2024, 6, 18)
//        );
//        companyList.getData(4).getJobPostingList().add(jp);
//        jobList.getData(5).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(5),
//                jobList.getData(5),
//                "Design and develop cross-platform mobile applications using frameworks such as Flutter and Kotlin. Ensure high performance and user satisfaction.",
//                4500.00,
//                6000.00,
//                2,
//                LocalDate.of(2024, 4, 10)
//        );
//        companyList.getData(5).getJobPostingList().add(jp);
//        jobList.getData(5).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(5),
//                jobList.getData(6),
//                "Develop software solutions that prevent cyberattacks and enhance organizational security. Experience with network security protocols is essential.",
//                5200.00,
//                7500.00,
//                2,
//                LocalDate.of(2024, 6, 5)
//        );
//        companyList.getData(5).getJobPostingList().add(jp);
//        jobList.getData(6).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(6),
//                jobList.getData(6),
//                "Implement and monitor cybersecurity protocols to protect data and systems from potential threats. Strong knowledge of encryption and firewall systems is required.",
//                5000.00,
//                7500.00,
//                1,
//                LocalDate.of(2024, 2, 22)
//        );
//        companyList.getData(6).getJobPostingList().add(jp);
//        jobList.getData(6).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(6),
//                jobList.getData(7),
//                "Oversee the implementation of encryption technologies to ensure safe storage and transmission of data across platforms.",
//                5300.00,
//                7800.00,
//                1,
//                LocalDate.of(2024, 4, 10)
//        );
//        companyList.getData(6).getJobPostingList().add(jp);
//        jobList.getData(7).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(7),
//                jobList.getData(7),
//                "Maintain and optimize large-scale SQL databases, ensuring high performance and availability for the organization.",
//                4000.00,
//                6500.00,
//                2,
//                LocalDate.of(2024, 5, 1)
//        );
//        companyList.getData(7).getJobPostingList().add(jp);
//        jobList.getData(7).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(7),
//                jobList.getData(8),
//                "Lead the migration of cloud-based systems and oversee the architecture optimization to improve scalability and performance.",
//                5800.00,
//                8200.00,
//                3,
//                LocalDate.of(2024, 5, 30)
//        );
//        companyList.getData(7).getJobPostingList().add(jp);
//        jobList.getData(8).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(8),
//                jobList.getData(8),
//                "Design and develop full-stack web applications, ensuring seamless integration between the frontend and backend components.",
//                4800.00,
//                7000.00,
//                1,
//                LocalDate.of(2024, 3, 15)
//        );
//        companyList.getData(8).getJobPostingList().add(jp);
//        jobList.getData(8).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(8),
//                jobList.getData(9),
//                "Collaborate with teams to deliver innovative, high-quality full-stack web applications on time. Expertise in React.js and Node.js required.",
//                4800.00,
//                7000.00,
//                2,
//                LocalDate.of(2024, 6, 1)
//        );
//        companyList.getData(8).getJobPostingList().add(jp);
//        jobList.getData(9).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(9),
//                jobList.getData(9),
//                "Assist with AI model training and evaluation, contributing to real-world research projects and performance assessments.",
//                3000.00,
//                4000.00,
//                1,
//                LocalDate.of(2024, 1, 5)
//        );
//        companyList.getData(9).getJobPostingList().add(jp);
//        jobList.getData(9).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(9),
//                jobList.getData(10),
//                "Conduct research and develop innovative AI solutions. Work closely with engineers to design systems that address client-specific needs.",
//                6000.00,
//                8500.00,
//                1,
//                LocalDate.of(2024, 7, 12)
//        );
//        companyList.getData(9).getJobPostingList().add(jp);
//        jobList.getData(10).getJobPostingList().add(jp);
//
//        jp = new JobPosting(
//                companyList.getData(10),
//                jobList.getData(10),
//                "Lead the development of innovative solutions in the field of AI and machine learning.",
//                6000.00,
//                9000.00,
//                3,
//                LocalDate.of(2024, 7, 1)
//        );
//        companyList.getData(10).getJobPostingList().add(jp);
//        jobList.getData(10).getJobPostingList().add(jp);
//        
//        jp = new JobPosting(
//                companyList.getData(10),
//                jobList.getData(11),
//                "Lead the development of innovative solutions in the field of AI and machine learning.",
//                6000.00,
//                9000.00,
//                3,
//                LocalDate.of(2024, 7, 1)
//        );
//        companyList.getData(10).getJobPostingList().add(jp);
//        jobList.getData(11).getJobPostingList().add(jp);

    }

    private void initializeJobApplication() {
        
        JobApplication jApp;

        // Application 1
        jApp = new JobApplication(studentList.getData(1), companyList.getData(14).getJobPostingList().getData(1), interviewList.getData(1), LocalDate.of(2025, 5, 1));
        studentList.getData(1).getJobApplicationList().add(jApp);
        companyList.getData(14).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(1).getJobApplicationList().add(jApp);

        // Application 2
        jApp = new JobApplication(studentList.getData(1), companyList.getData(20).getJobPostingList().getData(2), interviewList.getData(2), LocalDate.of(2025, 5, 2));
        studentList.getData(1).getJobApplicationList().add(jApp);
        companyList.getData(20).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(2).getJobApplicationList().add(jApp);

        // Application 3
        jApp = new JobApplication(studentList.getData(2), companyList.getData(9).getJobPostingList().getData(1), interviewList.getData(3), LocalDate.of(2025, 5, 3));
        studentList.getData(2).getJobApplicationList().add(jApp);
        companyList.getData(9).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(3).getJobApplicationList().add(jApp);

        // Application 4
        jApp = new JobApplication(studentList.getData(2), companyList.getData(13).getJobPostingList().getData(2), interviewList.getData(4), LocalDate.of(2025, 5, 4));
        studentList.getData(2).getJobApplicationList().add(jApp);
        companyList.getData(13).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(4).getJobApplicationList().add(jApp);

        // Application 5
        jApp = new JobApplication(studentList.getData(3), companyList.getData(15).getJobPostingList().getData(1), interviewList.getData(5), LocalDate.of(2025, 5, 5));
        studentList.getData(3).getJobApplicationList().add(jApp);
        companyList.getData(15).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(5).getJobApplicationList().add(jApp);

        // Application 6
        jApp = new JobApplication(studentList.getData(3), companyList.getData(14).getJobPostingList().getData(1), interviewList.getData(1), LocalDate.of(2025, 5, 6));
        studentList.getData(3).getJobApplicationList().add(jApp);
        companyList.getData(14).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(1).getJobApplicationList().add(jApp);

        // Application 7
        jApp = new JobApplication(studentList.getData(4), companyList.getData(17).getJobPostingList().getData(2), interviewList.getData(6), LocalDate.of(2025, 5, 7));
        studentList.getData(4).getJobApplicationList().add(jApp);
        companyList.getData(17).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(6).getJobApplicationList().add(jApp);

        // Application 8
        jApp = new JobApplication(studentList.getData(4), companyList.getData(9).getJobPostingList().getData(2), interviewList.getData(3), LocalDate.of(2025, 5, 8));
        studentList.getData(4).getJobApplicationList().add(jApp);
        companyList.getData(9).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(3).getJobApplicationList().add(jApp);

        // Application 9
        jApp = new JobApplication(studentList.getData(5), companyList.getData(23).getJobPostingList().getData(2), interviewList.getData(7), LocalDate.of(2025, 5, 9));
        studentList.getData(5).getJobApplicationList().add(jApp);
        companyList.getData(23).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(7).getJobApplicationList().add(jApp);

        // Application 10
        jApp = new JobApplication(studentList.getData(5), companyList.getData(20).getJobPostingList().getData(2), interviewList.getData(2), LocalDate.of(2025, 5, 10));
        studentList.getData(5).getJobApplicationList().add(jApp);
        companyList.getData(20).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(2).getJobApplicationList().add(jApp);
        
        // Application 11
        jApp = new JobApplication(studentList.getData(6), companyList.getData(21).getJobPostingList().getData(1), interviewList.getData(8), LocalDate.of(2025, 5, 11));
        studentList.getData(6).getJobApplicationList().add(jApp);
        companyList.getData(21).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(8).getJobApplicationList().add(jApp);

        // Application 12
        jApp = new JobApplication(studentList.getData(6), companyList.getData(13).getJobPostingList().getData(2), interviewList.getData(4), LocalDate.of(2025, 5, 12));
        studentList.getData(6).getJobApplicationList().add(jApp);
        companyList.getData(13).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(4).getJobApplicationList().add(jApp);

        // Application 13
        jApp = new JobApplication(studentList.getData(7), companyList.getData(15).getJobPostingList().getData(1), interviewList.getData(5), LocalDate.of(2025, 5, 13));
        studentList.getData(7).getJobApplicationList().add(jApp);
        companyList.getData(15).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(5).getJobApplicationList().add(jApp);

        // Application 14
        jApp = new JobApplication(studentList.getData(7), companyList.getData(22).getJobPostingList().getData(1), interviewList.getData(9), LocalDate.of(2025, 5, 14));
        studentList.getData(7).getJobApplicationList().add(jApp);
        companyList.getData(22).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(9).getJobApplicationList().add(jApp);

        // Application 15
        jApp = new JobApplication(studentList.getData(8), companyList.getData(19).getJobPostingList().getData(2), interviewList.getData(10), LocalDate.of(2025, 5, 15));
        studentList.getData(8).getJobApplicationList().add(jApp);
        companyList.getData(19).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(10).getJobApplicationList().add(jApp);

        // Application 16
        jApp = new JobApplication(studentList.getData(8), companyList.getData(13).getJobPostingList().getData(2), interviewList.getData(4), LocalDate.of(2025, 5, 16));
        studentList.getData(8).getJobApplicationList().add(jApp);
        companyList.getData(13).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(4).getJobApplicationList().add(jApp);

        // Application 17
        jApp = new JobApplication(studentList.getData(9), companyList.getData(16).getJobPostingList().getData(1), interviewList.getData(11), LocalDate.of(2025, 5, 17));
        studentList.getData(9).getJobApplicationList().add(jApp);
        companyList.getData(16).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(11).getJobApplicationList().add(jApp);

        // Application 18
        jApp = new JobApplication(studentList.getData(9), companyList.getData(20).getJobPostingList().getData(2), interviewList.getData(2), LocalDate.of(2025, 5, 18));
        studentList.getData(9).getJobApplicationList().add(jApp);
        companyList.getData(20).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(2).getJobApplicationList().add(jApp);

        // Application 19
        jApp = new JobApplication(studentList.getData(10), companyList.getData(23).getJobPostingList().getData(2), interviewList.getData(7), LocalDate.of(2025, 5, 19));
        studentList.getData(10).getJobApplicationList().add(jApp);
        companyList.getData(23).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(7).getJobApplicationList().add(jApp);

        // Application 20
        jApp = new JobApplication(studentList.getData(10), companyList.getData(9).getJobPostingList().getData(2), interviewList.getData(3), LocalDate.of(2025, 5, 20));
        studentList.getData(10).getJobApplicationList().add(jApp);
        companyList.getData(9).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(3).getJobApplicationList().add(jApp);

        // Application 21
        jApp = new JobApplication(studentList.getData(11), companyList.getData(1).getJobPostingList().getData(1), interviewList.getData(12), LocalDate.of(2025, 5, 21));
        studentList.getData(11).getJobApplicationList().add(jApp);
        companyList.getData(1).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(12).getJobApplicationList().add(jApp);

        // Application 22
        jApp = new JobApplication(studentList.getData(11), companyList.getData(25).getJobPostingList().getData(2), interviewList.getData(13), LocalDate.of(2025, 5, 22));
        studentList.getData(11).getJobApplicationList().add(jApp);
        companyList.getData(25).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(13).getJobApplicationList().add(jApp);

        // Application 23
        jApp = new JobApplication(studentList.getData(12), companyList.getData(5).getJobPostingList().getData(1), interviewList.getData(14), LocalDate.of(2025, 5, 23));
        studentList.getData(12).getJobApplicationList().add(jApp);
        companyList.getData(5).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(14).getJobApplicationList().add(jApp);

        // Application 24
        jApp = new JobApplication(studentList.getData(12), companyList.getData(4).getJobPostingList().getData(2), interviewList.getData(15), LocalDate.of(2025, 5, 24));
        studentList.getData(12).getJobApplicationList().add(jApp);
        companyList.getData(4).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(15).getJobApplicationList().add(jApp);

        // Application 25
        jApp = new JobApplication(studentList.getData(13), companyList.getData(24).getJobPostingList().getData(1), interviewList.getData(16), LocalDate.of(2025, 5, 25));
        studentList.getData(13).getJobApplicationList().add(jApp);
        companyList.getData(24).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(16).getJobApplicationList().add(jApp);
        
        // Application 26
        jApp = new JobApplication(studentList.getData(14), companyList.getData(7).getJobPostingList().getData(2), interviewList.getData(17), LocalDate.of(2025, 5, 26));
        studentList.getData(14).getJobApplicationList().add(jApp);
        companyList.getData(7).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(17).getJobApplicationList().add(jApp);

        // Application 27
        jApp = new JobApplication(studentList.getData(14), companyList.getData(8).getJobPostingList().getData(1), interviewList.getData(18), LocalDate.of(2025, 5, 27));
        studentList.getData(14).getJobApplicationList().add(jApp);
        companyList.getData(8).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(18).getJobApplicationList().add(jApp);

        // Application 28
        jApp = new JobApplication(studentList.getData(15), companyList.getData(17).getJobPostingList().getData(2), interviewList.getData(6), LocalDate.of(2025, 5, 28));
        studentList.getData(15).getJobApplicationList().add(jApp);
        companyList.getData(17).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(6).getJobApplicationList().add(jApp);

        // Application 29
        jApp = new JobApplication(studentList.getData(15), companyList.getData(6).getJobPostingList().getData(1), interviewList.getData(19), LocalDate.of(2025, 5, 29));
        studentList.getData(15).getJobApplicationList().add(jApp);
        companyList.getData(6).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(19).getJobApplicationList().add(jApp);

        // Application 30
        jApp = new JobApplication(studentList.getData(16), companyList.getData(11).getJobPostingList().getData(2), interviewList.getData(20), LocalDate.of(2025, 5, 30));
        studentList.getData(16).getJobApplicationList().add(jApp);
        companyList.getData(11).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(20).getJobApplicationList().add(jApp);

        // Application 31
        jApp = new JobApplication(studentList.getData(16), companyList.getData(5).getJobPostingList().getData(1), interviewList.getData(14), LocalDate.of(2025, 5, 31));
        studentList.getData(16).getJobApplicationList().add(jApp);
        companyList.getData(5).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(14).getJobApplicationList().add(jApp);

        // Application 32
        jApp = new JobApplication(studentList.getData(17), companyList.getData(10).getJobPostingList().getData(1), interviewList.getData(21), LocalDate.of(2025, 5, 31));
        studentList.getData(17).getJobApplicationList().add(jApp);
        companyList.getData(10).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(21).getJobApplicationList().add(jApp);

        // Application 33
        jApp = new JobApplication(studentList.getData(17), companyList.getData(12).getJobPostingList().getData(1), interviewList.getData(22), LocalDate.of(2025, 5, 31));
        studentList.getData(17).getJobApplicationList().add(jApp);
        companyList.getData(12).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(22).getJobApplicationList().add(jApp);

        // Application 34
        jApp = new JobApplication(studentList.getData(18), companyList.getData(3).getJobPostingList().getData(2), interviewList.getData(23), LocalDate.of(2025, 5, 31));
        studentList.getData(18).getJobApplicationList().add(jApp);
        companyList.getData(3).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(23).getJobApplicationList().add(jApp);

        // Application 35
        jApp = new JobApplication(studentList.getData(18), companyList.getData(19).getJobPostingList().getData(1), interviewList.getData(10), LocalDate.of(2025, 5, 31));
        studentList.getData(18).getJobApplicationList().add(jApp);
        companyList.getData(19).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(10).getJobApplicationList().add(jApp);

        // Application 36
        jApp = new JobApplication(studentList.getData(19), companyList.getData(2).getJobPostingList().getData(2), interviewList.getData(24), LocalDate.of(2025, 5, 31));
        studentList.getData(19).getJobApplicationList().add(jApp);
        companyList.getData(2).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(24).getJobApplicationList().add(jApp);

        // Application 37
        jApp = new JobApplication(studentList.getData(19), companyList.getData(24).getJobPostingList().getData(2), interviewList.getData(25), LocalDate.of(2025, 5, 31));
        studentList.getData(19).getJobApplicationList().add(jApp);
        companyList.getData(24).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(25).getJobApplicationList().add(jApp);

        // Application 38
        jApp = new JobApplication(studentList.getData(20), companyList.getData(6).getJobPostingList().getData(2), interviewList.getData(19), LocalDate.of(2025, 5, 31));
        studentList.getData(20).getJobApplicationList().add(jApp);
        companyList.getData(6).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(19).getJobApplicationList().add(jApp);

        // Application 39
        jApp = new JobApplication(studentList.getData(20), companyList.getData(25).getJobPostingList().getData(1), interviewList.getData(13), LocalDate.of(2025, 5, 31));
        studentList.getData(20).getJobApplicationList().add(jApp);
        companyList.getData(25).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(13).getJobApplicationList().add(jApp);

        // Application 40
        jApp = new JobApplication(studentList.getData(21), companyList.getData(7).getJobPostingList().getData(1), interviewList.getData(17), LocalDate.of(2025, 5, 31));
        studentList.getData(21).getJobApplicationList().add(jApp);
        companyList.getData(7).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(17).getJobApplicationList().add(jApp);

        // Application 41
        jApp = new JobApplication(studentList.getData(21), companyList.getData(21).getJobPostingList().getData(2), interviewList.getData(8), LocalDate.of(2025, 5, 31));
        studentList.getData(21).getJobApplicationList().add(jApp);
        companyList.getData(21).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(8).getJobApplicationList().add(jApp);

        // Application 42
        jApp = new JobApplication(studentList.getData(22), companyList.getData(10).getJobPostingList().getData(2), interviewList.getData(21), LocalDate.of(2025, 5, 31));
        studentList.getData(22).getJobApplicationList().add(jApp);
        companyList.getData(10).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(21).getJobApplicationList().add(jApp);

        // Application 43
        jApp = new JobApplication(studentList.getData(22), companyList.getData(16).getJobPostingList().getData(2), interviewList.getData(11), LocalDate.of(2025, 5, 31));
        studentList.getData(22).getJobApplicationList().add(jApp);
        companyList.getData(16).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(11).getJobApplicationList().add(jApp);

        // Application 44
        jApp = new JobApplication(studentList.getData(23), companyList.getData(8).getJobPostingList().getData(2), interviewList.getData(18), LocalDate.of(2025, 5, 31));
        studentList.getData(23).getJobApplicationList().add(jApp);
        companyList.getData(8).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(18).getJobApplicationList().add(jApp);

        // Application 45
        jApp = new JobApplication(studentList.getData(23), companyList.getData(11).getJobPostingList().getData(1), interviewList.getData(22), LocalDate.of(2025, 5, 31));
        studentList.getData(23).getJobApplicationList().add(jApp);
        companyList.getData(11).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(22).getJobApplicationList().add(jApp);

        // Application 46
        jApp = new JobApplication(studentList.getData(24), companyList.getData(2).getJobPostingList().getData(1), interviewList.getData(24), LocalDate.of(2025, 5, 31));
        studentList.getData(24).getJobApplicationList().add(jApp);
        companyList.getData(2).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(24).getJobApplicationList().add(jApp);

        // Application 47
        jApp = new JobApplication(studentList.getData(24), companyList.getData(4).getJobPostingList().getData(1), interviewList.getData(15), LocalDate.of(2025, 5, 31));
        studentList.getData(24).getJobApplicationList().add(jApp);
        companyList.getData(4).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
        interviewList.getData(15).getJobApplicationList().add(jApp);

        // Application 48
        jApp = new JobApplication(studentList.getData(25), companyList.getData(18).getJobPostingList().getData(2), interviewList.getData(25), LocalDate.of(2025, 5, 31));
        studentList.getData(25).getJobApplicationList().add(jApp);
        companyList.getData(18).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(25).getJobApplicationList().add(jApp);

        // Application 49
        jApp = new JobApplication(studentList.getData(25), companyList.getData(12).getJobPostingList().getData(2), interviewList.getData(23), LocalDate.of(2025, 5, 31));
        studentList.getData(25).getJobApplicationList().add(jApp);
        companyList.getData(12).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(23).getJobApplicationList().add(jApp);

        // Application 50
        jApp = new JobApplication(studentList.getData(13), companyList.getData(1).getJobPostingList().getData(2), interviewList.getData(12), LocalDate.of(2025, 5, 31));
        studentList.getData(13).getJobApplicationList().add(jApp);
        companyList.getData(1).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
        interviewList.getData(12).getJobApplicationList().add(jApp);
//        JobApplication jApp;
//
//        // STU-1 → Job 1 at Company 1
//        jApp = new JobApplication(studentList.getData(1), companyList.getData(1).getJobPostingList().getData(1), interviewList.getData(1), LocalDate.of(2025, 4, 1));
//        studentList.getData(1).getJobApplicationList().add(jApp);
//        companyList.getData(1).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
//        interviewList.getData(1).getJobApplicationList().add(jApp);
//
//        // STU-1 → Job 4 at Company 3
//        jApp = new JobApplication(studentList.getData(1), companyList.getData(3).getJobPostingList().getData(2), interviewList.getData(2), LocalDate.of(2025, 7, 1));
//        studentList.getData(1).getJobApplicationList().add(jApp);
//        companyList.getData(3).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
//        interviewList.getData(2).getJobApplicationList().add(jApp);
//
//        // STU-2 → Healthcare (J-16)
//        jApp = new JobApplication(studentList.getData(2), companyList.getData(10).getJobPostingList().getData(1), interviewList.getData(3), LocalDate.of(2025, 4, 2));
//        studentList.getData(2).getJobApplicationList().add(jApp);
//        companyList.getData(10).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
//        interviewList.getData(3).getJobApplicationList().add(jApp);
//
//        // STU-3 → Job 3 at Company 2
//        jApp = new JobApplication(studentList.getData(3), companyList.getData(2).getJobPostingList().getData(2), interviewList.getData(4), LocalDate.of(2025, 6, 15));
//        studentList.getData(3).getJobApplicationList().add(jApp);
//        companyList.getData(2).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
//        interviewList.getData(4).getJobApplicationList().add(jApp);
//
//        // STU-3 → Registered Nurse (J-23)
//        jApp = new JobApplication(studentList.getData(3), companyList.getData(10).getJobPostingList().getData(2), interviewList.getData(5), LocalDate.of(2025, 6, 20));
//        studentList.getData(3).getJobApplicationList().add(jApp);
//        companyList.getData(10).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
//        interviewList.getData(5).getJobApplicationList().add(jApp);
//
//        // STU-4 → Cybersecurity Job at Company 6
//        jApp = new JobApplication(studentList.getData(4), companyList.getData(6).getJobPostingList().getData(2), interviewList.getData(6), LocalDate.of(2025, 9, 17));
//        studentList.getData(4).getJobApplicationList().add(jApp);
//        companyList.getData(6).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
//        interviewList.getData(6).getJobApplicationList().add(jApp);
//
//        // STU-5 → Healthcare: Medical Lab Tech (J-16)
//        jApp = new JobApplication(studentList.getData(5), companyList.getData(10).getJobPostingList().getData(1), interviewList.getData(7), LocalDate.of(2025, 7, 10));
//        studentList.getData(5).getJobApplicationList().add(jApp);
//        companyList.getData(10).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
//        interviewList.getData(7).getJobApplicationList().add(jApp);
//
//        // STU-6 → Cybersecurity at Company 5
//        jApp = new JobApplication(studentList.getData(6), companyList.getData(5).getJobPostingList().getData(2), interviewList.getData(8), LocalDate.of(2025, 11, 1));
//        studentList.getData(6).getJobApplicationList().add(jApp);
//        companyList.getData(5).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
//        interviewList.getData(8).getJobApplicationList().add(jApp);
//
//        // STU-7 → Full-Stack at Company 9
//        jApp = new JobApplication(studentList.getData(7), companyList.getData(9).getJobPostingList().getData(2), interviewList.getData(9), LocalDate.of(2025, 12, 1));
//        studentList.getData(7).getJobApplicationList().add(jApp);
//        companyList.getData(9).getJobPostingList().getData(2).getJobApplicationList().add(jApp);
//        interviewList.getData(9).getJobApplicationList().add(jApp);
//
//        // STU-8 → AI Intern at Company 10
//        jApp = new JobApplication(studentList.getData(8), companyList.getData(10).getJobPostingList().getData(1), interviewList.getData(10), LocalDate.of(2025, 8, 30));
//        studentList.getData(8).getJobApplicationList().add(jApp);
//        companyList.getData(10).getJobPostingList().getData(1).getJobApplicationList().add(jApp);
//        interviewList.getData(10).getJobApplicationList().add(jApp);
    }



    private void initializeStudentSkillList() {
        // STU-1
        studentList.getData(1).getStudentSkillList().add(new StudentSkill(skillList.getData(2), 3));

        // STU-2
        studentList.getData(2).getStudentSkillList().add(new StudentSkill(skillList.getData(5), 4));
        studentList.getData(2).getStudentSkillList().add(new StudentSkill(skillList.getData(9), 3));
        studentList.getData(2).getStudentSkillList().add(new StudentSkill(skillList.getData(11), 2));

        // STU-3
        studentList.getData(3).getStudentSkillList().add(new StudentSkill(skillList.getData(2), 4));

        // STU-4
        studentList.getData(4).getStudentSkillList().add(new StudentSkill(skillList.getData(16), 4));

        // STU-5
        studentList.getData(5).getStudentSkillList().add(new StudentSkill(skillList.getData(5), 3));
        studentList.getData(5).getStudentSkillList().add(new StudentSkill(skillList.getData(13), 4));
        studentList.getData(5).getStudentSkillList().add(new StudentSkill(skillList.getData(16), 2));

        // STU-6
        studentList.getData(6).getStudentSkillList().add(new StudentSkill(skillList.getData(4), 3));
        studentList.getData(6).getStudentSkillList().add(new StudentSkill(skillList.getData(8), 4));

        // STU-7
        studentList.getData(7).getStudentSkillList().add(new StudentSkill(skillList.getData(1), 5));
        studentList.getData(7).getStudentSkillList().add(new StudentSkill(skillList.getData(10), 3));
        studentList.getData(7).getStudentSkillList().add(new StudentSkill(skillList.getData(17), 2));

        // STU-8
        studentList.getData(8).getStudentSkillList().add(new StudentSkill(skillList.getData(2), 4));

        // STU-9
        studentList.getData(9).getStudentSkillList().add(new StudentSkill(skillList.getData(4), 3));
        studentList.getData(9).getStudentSkillList().add(new StudentSkill(skillList.getData(10), 3));

        // STU-10
        studentList.getData(10).getStudentSkillList().add(new StudentSkill(skillList.getData(3), 4));
        studentList.getData(10).getStudentSkillList().add(new StudentSkill(skillList.getData(23), 2));

        // STU-11
        studentList.getData(11).getStudentSkillList().add(new StudentSkill(skillList.getData(9), 4));

        // STU-12
        studentList.getData(12).getStudentSkillList().add(new StudentSkill(skillList.getData(10), 4));
        studentList.getData(12).getStudentSkillList().add(new StudentSkill(skillList.getData(7), 3));

        // STU-13
        studentList.getData(13).getStudentSkillList().add(new StudentSkill(skillList.getData(1), 4));
        studentList.getData(13).getStudentSkillList().add(new StudentSkill(skillList.getData(8), 3));
        studentList.getData(13).getStudentSkillList().add(new StudentSkill(skillList.getData(11), 2));

        // STU-14
        studentList.getData(14).getStudentSkillList().add(new StudentSkill(skillList.getData(12), 4));

        // STU-15
        studentList.getData(15).getStudentSkillList().add(new StudentSkill(skillList.getData(13), 3));
        studentList.getData(15).getStudentSkillList().add(new StudentSkill(skillList.getData(15), 2));

        // STU-16
        studentList.getData(16).getStudentSkillList().add(new StudentSkill(skillList.getData(3), 4));
        studentList.getData(16).getStudentSkillList().add(new StudentSkill(skillList.getData(12), 3));

        // STU-17
        studentList.getData(17).getStudentSkillList().add(new StudentSkill(skillList.getData(18), 4));
        studentList.getData(17).getStudentSkillList().add(new StudentSkill(skillList.getData(21), 3));

        // STU-18
        studentList.getData(18).getStudentSkillList().add(new StudentSkill(skillList.getData(17), 3));
        studentList.getData(18).getStudentSkillList().add(new StudentSkill(skillList.getData(23), 2));

        // STU-19
        studentList.getData(19).getStudentSkillList().add(new StudentSkill(skillList.getData(20), 4));

        // STU-20
        studentList.getData(20).getStudentSkillList().add(new StudentSkill(skillList.getData(3), 3));
        studentList.getData(20).getStudentSkillList().add(new StudentSkill(skillList.getData(19), 4));
        studentList.getData(20).getStudentSkillList().add(new StudentSkill(skillList.getData(21), 2));

        // STU-21
        studentList.getData(21).getStudentSkillList().add(new StudentSkill(skillList.getData(24), 4));

        // STU-22
        studentList.getData(22).getStudentSkillList().add(new StudentSkill(skillList.getData(23), 4));
        studentList.getData(22).getStudentSkillList().add(new StudentSkill(skillList.getData(5), 3));

        // STU-23
        studentList.getData(23).getStudentSkillList().add(new StudentSkill(skillList.getData(22), 4));

        // STU-24
        studentList.getData(24).getStudentSkillList().add(new StudentSkill(skillList.getData(25), 3));

        // STU-25
        studentList.getData(25).getStudentSkillList().add(new StudentSkill(skillList.getData(24), 4));
        studentList.getData(25).getStudentSkillList().add(new StudentSkill(skillList.getData(20), 3));
    }

    private void initializeJobRequiredSkill() {
        JobRequiredSkill jrs;

        // Company 1
        jrs = new JobRequiredSkill(skillList.getData(2), 3);
        companyList.getData(1).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(5), 4);
        companyList.getData(1).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(6), 2);
        companyList.getData(1).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(1), 3);
        companyList.getData(1).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);

        // Company 2
        jrs = new JobRequiredSkill(skillList.getData(4), 3);
        companyList.getData(2).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(2), 4);
        companyList.getData(2).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(5), 3);
        companyList.getData(2).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(1), 3);
        companyList.getData(2).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);

        // Company 3
        jrs = new JobRequiredSkill(skillList.getData(1), 3);
        companyList.getData(3).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(4), 3);
        companyList.getData(3).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(2), 2);
        companyList.getData(3).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(6), 4);
        companyList.getData(3).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);

        // Company 4
        jrs = new JobRequiredSkill(skillList.getData(5), 3);
        companyList.getData(4).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(4), 4);
        companyList.getData(4).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(1), 2);
        companyList.getData(4).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(3), 5);
        companyList.getData(4).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);

        // Company 5
        jrs = new JobRequiredSkill(skillList.getData(2), 3);
        companyList.getData(5).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(4), 3);
        companyList.getData(5).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(1), 4);
        companyList.getData(5).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(6), 2);
        companyList.getData(5).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);

        // Company 6
        jrs = new JobRequiredSkill(skillList.getData(9), 4);
        companyList.getData(6).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(11), 3);
        companyList.getData(6).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(10), 3);
        companyList.getData(6).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(8), 4);
        companyList.getData(6).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);

        // ... Continue this pattern for Companies 7 to 25, using their job type
        // and skill ID ranges (Engineering, Finance, Education, Healthcare)

        // Example for Company 21 (Healthcare)
        jrs = new JobRequiredSkill(skillList.getData(23), 4);
        companyList.getData(21).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(24), 2);
        companyList.getData(21).getJobPostingList().getData(1).getJobRequiredSkillList().add(jrs);

        jrs = new JobRequiredSkill(skillList.getData(22), 3);
        companyList.getData(21).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);
        jrs = new JobRequiredSkill(skillList.getData(25), 4);
        companyList.getData(21).getJobPostingList().getData(2).getJobRequiredSkillList().add(jrs);
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

    public void displaySkills() {
        System.out.printf("%-10s%-30s\n", "Skill ID", "Skill Name");

        for (int i = 1; i <= skillList.size(); i++) {
            Skill skill = skillList.getData(i);
            System.out.printf("%-10s%-30s\n", skill.getId(), skill.getName());
        }
    }
    
    public void displayCompanies() {
        System.out.printf("%-10s%-30s%-20s%-15s%-20s%-20s%-15s%-15s%-15s%-20s\n", 
                          "Company ID", "Name", "Phone", "Email", "Street Address", "Area", "State", "Latitude", "Longitude", "Founded Year");

        for (int i = 1; i <= companyList.size(); i++) {
            Company company = companyList.getData(i);
            System.out.printf("%-10s%-30s%-20s%-15s%-20s%-20s%-15s%-15.6f%-15.6f%-20d\n",
                              company.getId(),
                              company.getName(),
                              company.getPhone(),
                              company.getEmail(),
                              company.getStreetAddress(),
                              company.getArea(),
                              company.getState(),
                              company.getLatitude(),
                              company.getLongitude(),
                              company.getFoundedYear());
        }
    }
    
    public void displayJobs() 
    {
        System.out.printf("%-10s%-30s%-25s%-40s\n", "Job ID", "Job Title", "Category", "Description");

        for (int i = 1; i <= jobList.size(); i++) {
            Job job = jobList.getData(i);
            System.out.printf("%-10s%-30s%-25s%-40s\n", job.getId(), job.getTitle(), job.getType(), job.getDesc());
        }
    }
    
    public void displayStudents() {

        System.out.printf("%-10s%-25s%-25s%-15s%-20s%-20s%-10s%-15s%-25s%-20s%-20s%-20s%-20s\n", 
                          "Student ID", "Name", "Password", "Age", "Address", "Area", "State", 
                          "Latitude", "Longitude", "Email", "Achievement", "Education", 
                          "Years of Experience", "Desired Job Types");

        for (int i = 1; i <= studentList.size(); i++) {
            Student student = studentList.getData(i);

            String desiredJobTypesStr = (student.getDesiredJobTypes() != null && student.getDesiredJobTypes().length > 0) 
                ? String.join(", ", student.getDesiredJobTypes()) 
                : "None";

            System.out.printf("%-10s%-25s%-25s%-15s%-20s%-20s%-10s%-15s%-25s%-20s%-20s%-20s%-20s\n", 
                              student.getId(),
                              student.getName(),
                              student.getPassword(),
                              student.getAge(),
                              student.getStreetAddress(),
                              student.getArea(),
                              student.getState(),
                              student.getLatitude(),
                              student.getLongitude(),
                              student.getEmail(),
                              student.getAchievement(),
                              student.getEducation(),
                              student.getYearsOfExperience(),
                              desiredJobTypesStr); 
        }
    }


    public void displayJobApplications() {
        System.out.printf("%-15s%-15s%-20s%-10s\n", "Student ID", "Company ID", "Job Title", "Application Date");

        for (int i = 1; i <= jobApplicationList.size(); i++) {
            JobApplication jobApplication = jobApplicationList.getData(i);
            Student student = jobApplication.getStudent();
            Company company = jobApplication.getJobPosting().getCompany();
            Job job = jobApplication.getJobPosting().getJob();
            System.out.printf("%-15s%-15s%-20s%-10s\n",
                              student.getId(),
                              company.getId(),
                              job.getTitle(),
                              jobApplication.getAppliedDateTime());
        }
    }

    public void displayInterviews() {
        System.out.printf("%-15s%-25s%-15s%-10s\n", "Interview ID", "Interview Date", "Status", "Score");

        for (int i = 1; i <= interviewList.size(); i++) {
            Interview interview = interviewList.getData(i);

            System.out.printf("%-15s%-25s%-15s%-10d\n",
                              interview.getId(),
                              interview.getScheduledDateTime(),
                              interview.getInterviewStatus(),
                              interview.getInterviewMark());
                              
        }
    }

    public void displayAllData()
    {
        System.out.println("==== Skills ====");
        displaySkills();
        System.out.println("\n==== Companies ====");
        displayCompanies();
        System.out.println("\n==== Jobs ====");
        displayJobs();
        System.out.println("\n==== Students ====");
        displayStudents();
        System.out.println("\n==== Job Applications ====");
        displayJobApplications();
        System.out.println("\n==== Interviews ====");
        displayInterviews();
    }

        // -----------------
        // Display for testing
        public static void main(String[] args) {
            AllDataInitialize dataInitialize = new AllDataInitialize();
            
            dataInitialize.displayAllData();

            for (JobPosting a : dataInitialize.getCompanyList().getData(1).getJobPostingList()) {
                System.out.println(a);
            }
        }

    }

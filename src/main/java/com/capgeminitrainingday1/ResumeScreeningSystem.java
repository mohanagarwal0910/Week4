package com.capgeminitrainingday1;

import java.util.*;

// Abstract class representing a Job Role
abstract class JobRole {
    String candidateName;
    int experience;

    public JobRole(String candidateName, int experience) {
        this.candidateName = candidateName;
        this.experience = experience;
    }

    abstract void displayRole();
}

// Concrete Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experience) {
        super(candidateName, experience);
    }

    @Override
    void displayRole() {
        System.out.println("Software Engineer - " + candidateName + ", Experience: " + experience + " years");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experience) {
        super(candidateName, experience);
    }

    @Override
    void displayRole() {
        System.out.println("Data Scientist - " + candidateName + ", Experience: " + experience + " years");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experience) {
        super(candidateName, experience);
    }

    @Override
    void displayRole() {
        System.out.println("Product Manager - " + candidateName + ", Experience: " + experience + " years");
    }
}

// Generic Resume Processor
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        System.out.println("Processing Resume for: ");
        jobRole.displayRole();
    }
}

// Resume Screening Pipeline using Wildcards
class ResumeScreeningPipeline {
    public static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.displayRole();
        }
    }
}

// Main class to demonstrate functionality
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        // Creating instances of different job roles
        SoftwareEngineer se = new SoftwareEngineer("Alice", 5);
        DataScientist ds = new DataScientist("Bob", 3);
        ProductManager pm = new ProductManager("Charlie", 7);

        // Processing individual resumes
        Resume<SoftwareEngineer> seResume = new Resume<>(se);
        Resume<DataScientist> dsResume = new Resume<>(ds);
        Resume<ProductManager> pmResume = new Resume<>(pm);

        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();

        // Screening multiple resumes using wildcard method
        List<JobRole> resumes = Arrays.asList(se, ds, pm);
        System.out.println("\nScreening all resumes:");
        ResumeScreeningPipeline.screenResumes(resumes);
    }
}


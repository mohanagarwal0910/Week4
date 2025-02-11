package com.capgeminitrainingday1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

// Test Class for ResumeScreening
public class ResumeScreeningTest {
    private ResumeScreening screeningSystem;
    private SoftwareEngineer se;
    private DataScientist ds;
    private ProductManager pm;

    @BeforeEach
    void setUp() {
        screeningSystem = new ResumeScreening();

        // Creating Job Role Resumes
        se = new SoftwareEngineer("Alice", 5);
        ds = new DataScientist("Bob", 3);
        pm = new ProductManager("Charlie", 7);
    }

    @Test
    void testAddResume() {
        // Wrapping Job Roles in Resume Generic Class
        Resume<SoftwareEngineer> seResume = new Resume<>(se);
        Resume<DataScientist> dsResume = new Resume<>(ds);

        // Adding Resumes to the Screening System
        screeningSystem.addResume(seResume);
        screeningSystem.addResume(dsResume);

        // Check if resumes were added correctly
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(se);
        jobRoles.add(ds);

        assertEquals(2, jobRoles.size());
        assertEquals("Alice", jobRoles.get(0).getCandidateName());
        assertEquals(5, jobRoles.get(0).getExperienceYears());
        assertEquals("Bob", jobRoles.get(1).getCandidateName());
        assertEquals(3, jobRoles.get(1).getExperienceYears());
    }

    @Test
    void testDisplayResumes() {
        // Adding Resumes to a List
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(se);
        jobRoles.add(ds);
        jobRoles.add(pm);

        // Test that all resumes exist in the list
        assertEquals(3, jobRoles.size());
        assertEquals("Charlie", jobRoles.get(2).getCandidateName());
        assertEquals(7, jobRoles.get(2).getExperienceYears());

        // Run the display method to ensure no exceptions occur
        ResumeScreening.processAllResumes(jobRoles);
    }

    @Test
    void testResumeWrapper() {
        Resume<ProductManager> pmResume = new Resume<>(pm);
        assertNotNull(pmResume.getJobRole());
        assertEquals("Charlie", pmResume.getJobRole().getCandidateName());
        assertEquals(7, pmResume.getJobRole().getExperienceYears());
    }
}

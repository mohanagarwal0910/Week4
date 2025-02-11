package com.capgeminitrainingday1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class UniversityCourseManagementTest {
    private Department<ExamCourse> scienceDepartment;
    private Department<AssignmentCourse> artsDepartment;
    private Department<ResearchCourse> engineeringDepartment;

    private ExamCourse physicsExam;
    private AssignmentCourse historyAssignment;
    private ResearchCourse aiResearch;

    @BeforeEach
    void setUp() {
        scienceDepartment = new Department<>("Science Department");
        artsDepartment = new Department<>("Arts Department");
        engineeringDepartment = new Department<>("Engineering Department");

        physicsExam = new ExamCourse("Physics 101", "Dr. Smith", 70);
        historyAssignment = new AssignmentCourse("History 201", "Dr. Brown", 5);
        aiResearch = new ResearchCourse("AI Research", "Dr. Johnson", "Artificial Intelligence");
    }

    @Test
    void testCourseCreation() {
        assertEquals("Physics 101", physicsExam.getCourseName());
        assertEquals("Dr. Smith", physicsExam.getInstructor());
        assertEquals(70, physicsExam.getExamWeightage());

        assertEquals("History 201", historyAssignment.getCourseName());
        assertEquals("Dr. Brown", historyAssignment.getInstructor());
        assertEquals(5, historyAssignment.getAssignmentCount());

        assertEquals("AI Research", aiResearch.getCourseName());
        assertEquals("Dr. Johnson", aiResearch.getInstructor());
        assertEquals("Artificial Intelligence", aiResearch.getResearchArea());
    }

    @Test
    void testWildcardMethod() {
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(physicsExam);
        allCourses.add(historyAssignment);
        allCourses.add(aiResearch);

        
        // Test if the wildcard method runs without errors
        Department.displayAllCourses(allCourses);
    }
}

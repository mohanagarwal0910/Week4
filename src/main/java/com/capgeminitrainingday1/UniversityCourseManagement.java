package com.capgeminitrainingday1;
import java.util.Arrays;
import java.util.List;
// Abstract class representing different course types
abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract void evaluate();
}

// Exam-Based Course
class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " is evaluated based on exams.");
    }
}

// Assignment-Based Course
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " is evaluated based on assignments.");
    }
}

// Research-Based Course
class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " is evaluated based on research work.");
    }
}

// Generic class to manage different courses
class Course<T extends CourseType> {
    private T course;

    public Course(T course) {
        this.course = course;
    }

    public void conductEvaluation() {
        course.evaluate();
    }
}

// University class managing different courses dynamically


class University {
    public static void evaluateCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.evaluate();
        }
    }
}
public class UniversityCourseManagement {
    public static void main(String[] args) {
        ExamCourse examCourse = new ExamCourse("Mathematics");
        AssignmentCourse assignmentCourse = new AssignmentCourse("Software Engineering");
        ResearchCourse researchCourse = new ResearchCourse("Artificial Intelligence");

        Course<ExamCourse> course1 = new Course<>(examCourse);
        Course<AssignmentCourse> course2 = new Course<>(assignmentCourse);
        Course<ResearchCourse> course3 = new Course<>(researchCourse);

        // Conduct individual evaluations
        course1.conductEvaluation();
        course2.conductEvaluation();
        course3.conductEvaluation();

        // Use wildcard to evaluate all courses dynamically
        University.evaluateCourses(Arrays.asList(examCourse, assignmentCourse, researchCourse));
    }
}


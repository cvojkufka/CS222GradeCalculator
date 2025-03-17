package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGradeCalculator {

    @Test
    public void testGrade_A() {
        CourseCalculator gradeCalculator = new CourseCalculator();
        char grade = gradeCalculator.calculateGrade(7, 5, true, "Starter", "Starter", "Starter", "Starter", "Master", "Full");
        assertEquals('A', grade);
    }

    @Test
    public void testGrade_B() {
        CourseCalculator calculator = new CourseCalculator();
        char grade = calculator.calculateGrade(6, 4, true, "None", "None", "None", "None", "Proficient", "Near Full");
        assertEquals('B', grade);
    }

    @Test
    public void testGrade_C() {
        CourseCalculator calculator = new CourseCalculator();
        char grade = calculator.calculateGrade(5, 3, true, "None", "None", "None", "None", "Starter", "Minimum");
        assertEquals('C', grade);
    }
}


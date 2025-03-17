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
        char grade = calculator.calculateGrade(6, 4, true, "Starter", "Starter", "Starter", "Starter", "Proficient", "Near Full");
        assertEquals('B', grade);
    }

    @Test
    public void testGrade_C() {
        CourseCalculator calculator = new CourseCalculator();
        char grade = calculator.calculateGrade(5, 3, true, "Starter", "Starter", "Starter", "Starter", "Starter", "Minimum");
        assertEquals('C', grade);
    }

    @Test
    public void testGrade_D() {
        CourseCalculator calculator = new CourseCalculator();
        char grade = calculator.calculateGrade(4, 2, false, "Starter", "Starter", "Starter", "Starter", "Starter", "None");
        assertEquals('D', grade);
    }

    @Test
    public void testGrade_F() {
        CourseCalculator calculator = new CourseCalculator();
        char grade = calculator.calculateGrade(3, 1, false, "None", "None", "None", "None", "None", "None");
        assertEquals('F', grade);
    }
}


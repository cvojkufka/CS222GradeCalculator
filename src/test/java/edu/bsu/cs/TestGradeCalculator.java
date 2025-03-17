package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGradeCalculator {

    @Test
    public void testCalculateCourseGrade() {
        CourseCalculator gradeCalculator = new CourseCalculator();
        char result = gradeCalculator.calculateGrade('A');
        assertEquals('A', result);
    }
}

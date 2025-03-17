package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGradeCalculator {

    @Test
    public void testGrade_A() {
        CourseCalculator gradeCalculator = new CourseCalculator();
        String grade = gradeCalculator.calculateGrade(7, 5, true, "Starter", "Starter", "Starter", "Starter", "Master", "Full");
        assertEquals("Your final grade is: A", grade);
    }

    @Test
    public void testGrade_B() {
        CourseCalculator calculator = new CourseCalculator();
        String grade = calculator.calculateGrade(6, 4, true, "Starter", "Starter", "Starter", "Starter", "Proficient", "Near Full");
        assertEquals("Your final grade is: B", grade);
    }

    @Test
    public void testGrade_C() {
        CourseCalculator calculator = new CourseCalculator();
        String grade = calculator.calculateGrade(5, 3, true, "Starter", "Starter", "Starter", "Starter", "Starter", "Minimum");
        assertEquals("Your final grade is: C", grade);
    }

    @Test
    public void testGrade_D() {
        CourseCalculator calculator = new CourseCalculator();
        String grade = calculator.calculateGrade(4, 2, false, "Starter", "Starter", "Starter", "Starter", "Starter", "None");
        assertEquals("Your final grade is: D", grade);
    }

    @Test
    public void testGrade_F() {
        CourseCalculator calculator = new CourseCalculator();
        String grade = calculator.calculateGrade(3, 1, false, "None", "None", "None", "None", "None", "None");
        assertEquals("Your final grade is: F", grade);
    }

    @Test
    public void testGrade_F_or_D_SpecialCase() {
        CourseCalculator calculator = new CourseCalculator();
        String grade = calculator.calculateGrade(6, 5, true, "Starter", "Starter", "Starter", "Starter", "Starter", null);
        assertEquals("Grade: D or F (Special Case: No Final or Midterm)", grade);

        grade = calculator.calculateGrade(6, 5, true, "Starter", "Starter", "Starter", "Starter", null, "None");
        assertEquals("Grade: D or F (Special Case: No Final or Midterm)", grade);
    }
}

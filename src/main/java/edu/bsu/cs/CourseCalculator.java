package edu.bsu.cs;

public class CourseCalculator {

    public char calculateGrade(int assignmentsMet, int achievementsMet, boolean selfAssessmentMet,
                               String firstProjectLevel, String firstProjectGUILevel,
                               String finalProject1Level, String finalProject2Level,
                               String finalProject3Level, String finalExamLevel) {

        char assignmentGrade =  getAssignmentGrade(assignmentsMet);
        char achievementGrade = getAchievementGrade(achievementsMet);
        char selfAssessmentGrade = selfAssessmentMet ? 'A' : 'F';
        char finalExamGrade = getFinalExamGrade(finalExamLevel);

        char projectGrade = getProjectGrade(firstProjectLevel, firstProjectGUILevel, finalProject1Level, finalProject2Level,finalProject3Level);

        return weakestLink(assignmentGrade, achievementGrade, selfAssessmentGrade, finalExamGrade, projectGrade);
    }
}

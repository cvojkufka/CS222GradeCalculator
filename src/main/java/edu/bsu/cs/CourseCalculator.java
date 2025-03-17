package edu.bsu.cs;

public class CourseCalculator {

    public char calculateGrade(int assignmentsMet, int achievementsMet, boolean selfAssessmentMet,
                               String firstProjectLevel, String firstProjectGUILevel,
                               String finalProject1Level, String finalProject2Level,
                               String finalProject3Level, String finalExamLevel) {

        char assignmentGrade = getAssignmentGrade(assignmentsMet);
        char achievementGrade = getAchievementGrade(achievementsMet);
        char selfAssessmentGrade = selfAssessmentMet ? 'A' : 'F';
        char finalExamGrade = getFinalExamGrade(finalExamLevel);

        char projectGrade = getProjectGrade(firstProjectLevel, firstProjectGUILevel, finalProject1Level, finalProject2Level, finalProject3Level);

        return weakestLink(assignmentGrade, achievementGrade, selfAssessmentGrade, finalExamGrade, projectGrade);
    }

    private char getAssignmentGrade(int assignmentsMet) {
        if (assignmentsMet >= 7) return 'A';
        if (assignmentsMet >= 6) return 'B';
        if (assignmentsMet >= 5) return 'C';
        if (assignmentsMet >= 4) return 'D';
        return 'F';
    }

    private char getAchievementGrade(int achievementsMet) {
        if (achievementsMet >= 5) return 'A';
        if (achievementsMet >= 4) return 'B';
        if (achievementsMet >= 3) return 'C';
        if (achievementsMet >= 2) return 'D';
        return 'F';
    }

    private char getFinalExamGrade(String finalExamLevel) {
        return switch (finalExamLevel) {
            case "Full" -> 'A';
            case "Near Full" -> 'B';
            case "Minimum" -> 'C';
            default -> 'F';
        };
    }

    private char weakestLink(char... grades) {
        for (char grade : new char[]{'F', 'D', 'C', 'B', 'A'}) {
            for (char g : grades) {
                if (g == grade) return grade;
            }
        }
        return 'F';
    }
}



package edu.bsu.cs;

public class CourseCalculator {

    public String calculateGrade(int assignmentsMet, int achievementsMet, Boolean selfAssessmentMet,
                               String firstProjectLevel, String firstProjectGUILevel,
                               String finalProject1Level, String finalProject2Level,
                               String finalProject3Level, String finalExamLevel) {

        char assignmentGrade = getAssignmentGrade(assignmentsMet);
        char achievementGrade = getAchievementGrade(achievementsMet);
        //MUST take into account D grades CAN get away with no self assessment or final exam
        if (selfAssessmentMet == null || finalExamLevel == null) {
            return "Grade: D or F (Special Case: No Final or Midterm)";
        }

        char selfAssessmentGrade = selfAssessmentMet ? 'A' : 'D';
        char finalExamGrade = getFinalExamGrade(finalExamLevel);

        char projectGrade = getProjectGrade(firstProjectLevel, firstProjectGUILevel, finalProject1Level, finalProject2Level, finalProject3Level);

        char finalGrade = weakestLink(assignmentGrade, achievementGrade, selfAssessmentGrade, finalExamGrade, projectGrade);

        return "Your final grade is: " + finalGrade;
    }

    private char getAssignmentGrade(int assignmentsMet) {
        if (assignmentsMet >= 7) return 'A';
        if (assignmentsMet == 6) return 'B';
        if (assignmentsMet == 5) return 'C';
        if (assignmentsMet == 4) return 'D';
        return 'F';
    }

    private char getAchievementGrade(int achievementsMet) {
        if (achievementsMet >= 5) return 'A';
        if (achievementsMet == 4) return 'B';
        if (achievementsMet == 3) return 'C';
        if (achievementsMet == 2) return 'D';
        return 'F';
    }

    private char getFinalExamGrade(String finalExamLevel) {
        return switch (finalExamLevel) {
            case "Full" -> 'A';
            case "Near Full" -> 'B';
            case "Minimum" -> 'C';
            case "None" -> 'D';
            default -> 'F';
        };
    }

    private char getProjectGrade(String firstProjectLevel, String firstProjectGUILevel, String finalProject1Level, String finalProject2Level, String finalProject3Level) {
        boolean firstProjectMet = isAtLeastStarter(firstProjectLevel);
        boolean firstProjectGUIMet = isAtLeastStarter(firstProjectGUILevel);
        boolean finalProject1Met = isAtLeastStarter(finalProject1Level);
        boolean finalProject2Met = isAtLeastStarter(finalProject2Level);

        boolean finalProject3MeetsA = finalProject3Level.equals("Master");
        boolean finalProject3MeetsB = finalProject3Level.equals("Proficient") || finalProject3MeetsA;
        boolean finalProject3MeetsC = finalProject3Level.equals("Starter") || finalProject3MeetsB;
        boolean finalProject3MeetsD = finalProject3MeetsC;
        boolean finalProject3Completed = !finalProject3Level.equals("None");

        if (!firstProjectMet || !firstProjectGUIMet || !finalProject1Met || !finalProject2Met || !finalProject3Completed) return 'F';

        if(!finalProject3MeetsD) return 'F';
        if (!finalProject3MeetsC) return 'D';
        if (!finalProject3MeetsB) return 'C';
        if (!finalProject3MeetsA) return 'B';

        return 'A';
    }

    private boolean isAtLeastStarter(String level) {
        return level.equals("Starter") || level.equals("Proficient") || level.equals("Master");
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



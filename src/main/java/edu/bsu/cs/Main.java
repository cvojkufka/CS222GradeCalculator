package edu.bsu.cs;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            printMenu();
            String choice = scanner.nextLine();

            if(choice.equals("1")) {
                printGradeCollection(scanner);
            } else if(choice.equals("2")) {
                break;
            } else {
                System.out.println("\nInvalid choice. Please enter a 1 or 2");
            }
        }

    }

    public static void printMenu() {
        System.out.println("\n===== CS 222 Course Grade Calculator =====");
        System.out.println("1) Start Calculating Course Grade");
        System.out.println("2) Exit the program");
        System.out.print(">>");
    }

    public static void printGradeCollection(Scanner scanner) {
        CourseCalculator calculator = new CourseCalculator();
        System.out.print("Enter number of assignments meeting specifications (0-7): ");
        int assignmentsMet = scanner.nextInt();

        System.out.print("Enter number of achievements meeting specifications (0-5): ");
        int achievementsMet = scanner.nextInt();

        System.out.print("Did you meet the self-assessment requirement? (true/false): ");
        boolean selfAssessmentMet = scanner.nextBoolean();

        System.out.print("Enter level of First Project (None, Starter, Proficient, Master): ");
        String firstProjectLevel = scanner.next();

        System.out.print("Enter level of Final Project Iteration 1 (None, Starter, Proficient, Master): ");
        String finalProject1Level = scanner.next();

        System.out.print("Enter level of Final Project Iteration 2 (None, Starter, Proficient, Master): ");
        String finalProject2Level = scanner.next();

        System.out.print("Enter level of Final Project Iteration 3 (None, Starter, Proficient, Master): ");
        String finalProject3Level = scanner.next();

        System.out.print("Enter level of Final Exam (None, Minimum, Near Full, Full): ");
        String finalExamLevel = scanner.next();

        String finalGradeMessage = calculator.calculateGrade(assignmentsMet, achievementsMet, selfAssessmentMet,
                firstProjectLevel, "", finalProject1Level,
                finalProject2Level, finalProject3Level, finalExamLevel);

        System.out.println(finalGradeMessage);
    }
}

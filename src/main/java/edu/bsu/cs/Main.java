package edu.bsu.cs;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            printMenu();
            String choice = scanner.nextLine();

            if(choice.equals("1")) {
                calculateCourseGrade();
            } else if(choice.equals("2")) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a 1 or 2");
            }
        }

    }

    public static void printMenu() {
        System.out.println("===== CS 222 Course Grade Calculator =====");
        System.out.println("1) Start Calculating Course Grade");
        System.out.println("2) Exit the program");
        System.out.print(">>");
    }

    public static void calculateCourseGrade() {
        CourseCalculator gradeCalculator = new CourseCalculator();
        gradeCalculator.calculateGrade('A');
    }

}

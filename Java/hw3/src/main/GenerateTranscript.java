package main;

import util.Grade;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenerateTranscript {
    public static void takeInputFromUser() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();

        Transcript transcript = new Transcript(studentID);

        while (true) {
            System.out.print("Enter Department (if you type 'end' program will be terminated): ");
            String department = scanner.nextLine();

            if (department.equalsIgnoreCase("end")) {
                break;
            }

            int courseCode;
            while (true) {
                System.out.print("Enter Course Code (between 100 and 599): ");
                courseCode = scanner.nextInt();
                scanner.nextLine();

                if (courseCode >= 100 && courseCode <= 599) {
                    break;
                } else {
                    System.out.println("Invalid course code. Please enter a value between 100 and 599.");
                }
            }

            int courseCredit;
            while (true) {
                System.out.print("Enter Credit (3 or 4): ");
                courseCredit = scanner.nextInt();
                scanner.nextLine();

                if (courseCredit == 3 || courseCredit == 4) {
                    break;
                } else {
                    System.out.println("Invalid credit value. Please enter either 3 or 4.");
                }
            }

            System.out.print("Enter Grade: ");
            double gradeValue = scanner.nextDouble();
            scanner.nextLine();


            CourseGrade courseGrade = new CourseGrade(department, courseCode, courseCredit);
            courseGrade.setGradeTaken(gradeValue);
            transcript.addCourseTaken(courseGrade);
        }

        scanner.close();

        System.out.println(transcript);
    }

    public static void takeInputFromFile() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            int studentID = Integer.parseInt(fileScanner.nextLine().trim());
            Transcript transcript = new Transcript(studentID);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] courseInfo = line.split(" ");
                String department = courseInfo[0];
                int courseCode = Integer.parseInt(courseInfo[1]);
                int courseCredit = Integer.parseInt(courseInfo[2]);
                double gradeValue = Double.parseDouble(courseInfo[3]);

                CourseGrade courseGrade = new CourseGrade(department, courseCode, courseCredit);
                courseGrade.setGradeTaken(gradeValue);
                transcript.addCourseTaken(courseGrade);
            }

            fileScanner.close();
            System.out.println(transcript);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (NumberFormatException e) {
            System.out.println("Error reading file. Invalid format.");
        }
    }
}

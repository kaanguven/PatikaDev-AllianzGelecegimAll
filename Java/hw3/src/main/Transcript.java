package main;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private int studentID;
    private List<CourseGrade> courseGrades;
    private double GPA;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.GPA = 0.0;
        this.courseGrades = new ArrayList<>();
    }

    public void addCourseTaken(CourseGrade courseGrade) {
        if (courseGrade != null) {
            courseGrades.add(courseGrade);
            updateGPA();
        } else {
            System.out.println("Error: CourseGrade object is null.");
        }
    }

    private void updateGPA() {
        double totalPoints = 0;
        double totalCredits = 0;

        for (CourseGrade courseGrade : courseGrades) {
            totalPoints += courseGrade.getGradeTaken().getNumericValue() * courseGrade.getCourseCredit();
            totalCredits += courseGrade.getCourseCredit();
        }

        if (totalCredits > 0) {
            GPA = Math.round((totalPoints / totalCredits));
        } else {
            GPA = 0.0;
        }
    }

    @Override
    public String toString() {
        StringBuilder transcript = new StringBuilder();
        transcript.append("Student ID: ").append(studentID).append("\n");
        for (CourseGrade courseGrade : courseGrades) {
            transcript.append(courseGrade).append("\n");
        }
        transcript.append("GPA: ").append(GPA);
        return transcript.toString();
    }
}
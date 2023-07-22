package main;

import util.Grade;

public class CourseGrade {

    private String courseDepartment = "CENG";

    private int courseCode = 100;

    private int courseCredit = 4;

    private Grade gradeTaken = Grade.F;

    public CourseGrade(String courseDepartment) {
        this(courseDepartment, 100, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment, courseCode, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode, courseCredit, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        if (courseDepartment != null && courseDepartment.length() <= 4) {
            this.courseDepartment = courseDepartment;
        } else {
            this.courseDepartment = "CENG";
        }
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode >= 100 && courseCode <= 599) {
            this.courseCode = courseCode;
        } else {
            this.courseCode = 100; // Default value
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        if (courseCredit == 3 || courseCredit == 4) {
            this.courseCredit = courseCredit;
        } else {
            this.courseCredit = 4; // Default value
        }
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(double val) {
        if (val >= 0 && val <= 4.0) {
            int numValue = (int) Math.round(val);
            if (numValue == 4) {
                this.gradeTaken = Grade.A;
            } else if (numValue == 3) {
                this.gradeTaken = Grade.B;
            } else if (numValue == 2) {
                this.gradeTaken = Grade.C;
            } else if (numValue == 1) {
                this.gradeTaken = Grade.D;
            } else {
                this.gradeTaken = Grade.F;
            }
        } else {
            this.gradeTaken = Grade.F;
        }
    }

    public void setGradeTaken(Grade grade) {
        this.gradeTaken = grade;
    }

    @Override
    public String toString() {
        return "Department: " + courseDepartment + " CourseCode: " + courseCode +
                " Credit: " + courseCredit + " Grade: " + gradeTaken.getStringValue();
    }
}






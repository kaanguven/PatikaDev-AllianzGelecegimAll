import main.CourseGrade;
import main.Transcript;
import util.Grade;
import util.GradeTest;

public class Main {
    public static void main(String[] args) {

        GradeTest.values();

        CourseGrade course1 = new CourseGrade(null, 201, 5, Grade.A);
        CourseGrade course2 = new CourseGrade("COMP", 101, 3, Grade.B);
        CourseGrade course3 = new CourseGrade("ECE", 301, 4, Grade.C);
        CourseGrade course4 = new CourseGrade("ME", 401, 4, Grade.D);
        CourseGrade course5 = new CourseGrade("MATH", 600, 3, Grade.F);

        // Display CourseGrade objects using toString()
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);
        System.out.println(course4);
        System.out.println(course5);

        // Creating a Transcript for a student
        Transcript transcript = new Transcript(123456);

        // Adding CourseGrade objects to the Transcript
        transcript.addCourseTaken(course1);
        transcript.addCourseTaken(course2);
        transcript.addCourseTaken(course3);
        transcript.addCourseTaken(course4);
        transcript.addCourseTaken(course5);

        // Displaying the transcript
        System.out.println(transcript);
    }

    }

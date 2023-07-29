import main.CourseGrade;
import main.GenerateTranscript;
import main.Transcript;
import util.Grade;
import util.GradeTest;

public class Main {
    public static void main(String[] args) {

        GradeTest.values();

        CourseGrade course1 = new CourseGrade(null, 201, 5, Grade.A); // Fail test
        CourseGrade course2 = new CourseGrade("COMP", 101, 3, Grade.B);
        CourseGrade course3 = new CourseGrade("MATH", 301, 5, Grade.D);
        CourseGrade course4 = new CourseGrade("ME", 401, 4, Grade.C);
        CourseGrade course5 = new CourseGrade("FUNDENG", 600, 3, Grade.F); // Fail test

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


        GenerateTranscript transcriptTest = new GenerateTranscript();
        transcriptTest.takeInputFromUser();

        //GenerateTranscript.takeInputFromFile(); // There is a test.txt in directory to test this function.

    }

}

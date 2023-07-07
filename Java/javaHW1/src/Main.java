import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Create the HashMap to store classrooms and student names
        Map<String, List<String>> classes = new HashMap<>();

        // Create the ArrayLists for each classroom
        List<String> classroom1A = new ArrayList<>();
        List<String> classroom1B = new ArrayList<>();
        List<String> classroom1C = new ArrayList<>();
        List<String> classroom1D = new ArrayList<>();
        List<String> classroom1E = new ArrayList<>();

        // Add student names
        classroom1A.add("Ufuk Kaan Güven");
        classroom1A.add("Emre Kağızman");
        classroom1A.add("Ali Demir");
        classroom1A.add("Hasan Burak Songur");
        classroom1A.add("Kerimhan Korkmaz");

        classroom1B.add("Cem Soluk");
        classroom1B.add("Ayşe Yıldırım");
        classroom1B.add("Selim Kaptan Karan");
        classroom1B.add("Merve Sağlam");
        classroom1B.add("Berk Ali Çağan Parlak");

        classroom1C.add("Ahmet Mehmet Yılmaz");
        classroom1C.add("Murat Ali Demir");
        classroom1C.add("Emre Can Öztürk");
        classroom1C.add("Serdar Hasan Aydın");
        classroom1C.add("Ali İbrahim Arslan");

        classroom1D.add("Ayşe Yıldırım");
        classroom1D.add("Zeynep Aksoy");
        classroom1D.add("Elif Aydan Demir");
        classroom1D.add("Seda Su Nalan Arslan");
        classroom1D.add("Yaren İrem Kaplan");

        classroom1E.add("Ahmet Ali Tekinhan");
        classroom1E.add("Burak Saran  Öztürk");
        classroom1E.add("Caner Kazım Mahmut Arslan");
        classroom1E.add("Emre Baran Yılmaz");
        classroom1E.add("Yılmaz Serkan Şahin");

        // Add classrooms to the HashMap
        classes.put("1/A", classroom1A);
        classes.put("1/B", classroom1B);
        classes.put("1/C", classroom1C);
        classes.put("1/D", classroom1D);
        classes.put("1/E", classroom1E);

        // Get the keys (classroom names) from the HashMap
        Set<String> keySet = classes.keySet();

        // Iterate over the classrooms
        for (String key : keySet) {
            // Iterate over the student names in each classroom
            classes.get(key).forEach(name ->
                    {
                        String[] studentNameArray = name.split(" ");
                        // Iterate over each name Exclude the surname
                        for (int i = 0; i < studentNameArray.length - 1; i++) {
                            // Print the class name, student name, and the name that matches the condition
                            if (studentNameArray[i].endsWith("an")) {
                                System.out.println("Classroom: " + key + " - Student Name: " + name+ " --> Name that matches: "+studentNameArray[i]);
                            }
                        }
                    }
            );
        }
    }
}
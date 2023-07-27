import java.util.*;

public class Main {
    public static void main(String[] args) {



        // Create 5 Book objects
        Book book1 = new Book("Java Programming", 400, "John Doe", new Date(2022, 1, 1));
        Book book2 = new Book("Python Basics", 350, "Jane Smith", new Date(2021, 5, 15));
        Book book3 = new Book("C++ Essentials", 300, "Michael Brown", new Date(2023, 3, 10));
        Book book4 = new Book("Data Structures", 500, "Alice Johnson", new Date(2022, 8, 20));
        Book book5 = new Book("Algorithms Guide", 450, "David Lee", new Date(2021, 12, 5));

        // Create a HashSet to store books by title (A-Z order)
        Set<Book> bookSetByTitle = new HashSet<>();
        bookSetByTitle.add(book1);
        bookSetByTitle.add(book2);
        bookSetByTitle.add(book3);
        bookSetByTitle.add(book4);
        bookSetByTitle.add(book5);

        // Print books by title
        System.out.println("Books by title (A-Z order):");
        for (Book book : bookSetByTitle) {
            System.out.println(book.getTitle());
        }

        // Create a TreeSet to store books by pageCount (sorted by pageCount)
        Set<Book> bookSetByPageCount = new TreeSet<>(Comparator.comparingInt(Book::getPageCount));
        bookSetByPageCount.add(book1);
        bookSetByPageCount.add(book2);
        bookSetByPageCount.add(book3);
        bookSetByPageCount.add(book4);
        bookSetByPageCount.add(book5);

        // Print books by pageCount
        System.out.println("\nBooks by pageCount (ascending order):");
        for (Book book : bookSetByPageCount) {
            System.out.println(book.getTitle() + " - Page Count: " + book.getPageCount());
        }
    }
}
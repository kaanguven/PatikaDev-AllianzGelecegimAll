import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();

        // 10 tane Book nesnesi oluşturup listeye ekleyelim
        bookList.add(new Book("Kitap 1", 150, "Yazar 1", LocalDate.of(2021, 1, 15)));
        bookList.add(new Book("Kitap 2", 200, "Yazar 2", LocalDate.of(2020, 5, 22)));
        bookList.add(new Book("Kitap 3", 180, "Yazar 3", LocalDate.of(2019, 10, 10)));
        bookList.add(new Book("Kitap 4", 90, "Yazar 4", LocalDate.of(2018, 3, 5)));
        bookList.add(new Book("Kitap 5", 250, "Yazar 5", LocalDate.of(2022, 12, 1)));
        bookList.add(new Book("Kitap 6", 120, "Yazar 6", LocalDate.of(2017, 8, 17)));
        bookList.add(new Book("Kitap 7", 300, "Yazar 7", LocalDate.of(2023, 6, 20)));
        bookList.add(new Book("Kitap 8", 80, "Yazar 8", LocalDate.of(2016, 4, 25)));
        bookList.add(new Book("Kitap 9", 180, "Yazar 9", LocalDate.of(2020, 9, 8)));
        bookList.add(new Book("Kitap 10", 220, "Yazar 10", LocalDate.of(2015, 11, 30)));

        // Book listesinden yeni bir Map oluşturarak kitap ismi ve yazar ismini eşleştirelim
        Map<String, String> bookAuthorMap = bookList.stream()
                .collect(Collectors.toMap(Book::getBookName, Book::getAuthorName));

        System.out.println("Kitap İsimleri ve Yazarları:");
        bookAuthorMap.forEach((bookName, authorName) -> System.out.println(bookName + " - " + authorName));

        // Sayfa sayısı 100'den fazla olan kitapları filtreleyelim ve yeni bir liste olarak alalım
        List<Book> filteredBooks = bookList.stream()
                .filter(book -> book.getPageCount() > 100)
                .collect(Collectors.toList());

        System.out.println("\nSayfa Sayısı 100'den Fazla Olan Kitaplar:");
        filteredBooks.forEach(book -> System.out.println(book.getBookName()));
    }

}
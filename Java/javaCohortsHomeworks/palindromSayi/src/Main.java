import java.util.Scanner;

/*

Java ile bir sayının "Palindrom Sayı" olup olmadığını bulan bir program yapıyoruz.

Palindrom Sayı Nedir ?
Palindromik sayı, iki taraftan okunduğu zaman okunuş yönüyle aynı olan sayılardır.

Örnek: 1, 4, 8, 99, 101, 363, 4004, 9889....

 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int sayi = scanner.nextInt();

        if (isPalindrom(sayi)) {
            System.out.println(sayi + " bir palindrom sayıdır.");
        } else {
            System.out.println(sayi + " bir palindrom sayı değildir.");
        }
    }

    public static boolean isPalindrom(int sayi) {
        int tersi = 0;
        int gecici = sayi;

        while (gecici != 0) {
            int kalan = gecici % 10;
            tersi = tersi * 10 + kalan;
            gecici /= 10;
        }

        return sayi == tersi;
    }
}
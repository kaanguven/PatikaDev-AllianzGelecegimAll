import java.util.Scanner;

/*
Java döngüler ile sayının armstrong sayı olup olmadığını bulan programı yazıyoruz.

Armstrong Sayı Nedir ?
N haneli bir sayının basamaklarının n’inci üstlerinin toplamı, sayının kendisine eşitse, böyle sayılara Armstrong sayı denir.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int sayi = scanner.nextInt();

        int orjinalSayi = sayi;
        int basamakSayisi = String.valueOf(sayi).length();
        int toplam = 0;

        while (sayi > 0) {
            int basamak = sayi % 10;
            toplam += Math.pow(basamak, basamakSayisi);
            sayi /= 10;
        }

        if (toplam == orjinalSayi) {
            System.out.println(orjinalSayi + " Armstrong bir sayıdır.");
        } else {
            System.out.println(orjinalSayi + " Armstrong bir sayı değildir.");
        }
    }
}
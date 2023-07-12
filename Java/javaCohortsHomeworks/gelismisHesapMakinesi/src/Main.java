import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int secim = -1;

    while (secim != 0) {
        // Menüyü göster
        System.out.println("Hesap Makinesi");
        System.out.println("1- Toplama İşlemi");
        System.out.println("2- Çıkarma İşlemi");
        System.out.println("3- Çarpma İşlemi");
        System.out.println("4- Bölme İşlemi");
        System.out.println("5- Üslü Sayı Hesaplama");
        System.out.println("6- Faktoriyel Hesaplama");
        System.out.println("7- Mod Alma");
        System.out.println("8- Dikdörtgen Alan ve Çevre Hesabı");
        System.out.println("0- Çıkış");
        System.out.print("Bir işlem seçin: ");
        secim = scanner.nextInt();

        switch (secim) {
            case 1:
                toplamaIslemi();
                break;
            case 2:
                cikarmaIslemi();
                break;
            case 3:
                carpmaIslemi();
                break;
            case 4:
                bolmeIslemi();
                break;
            case 5:
                usluSayiHesaplama();
                break;
            case 6:
                faktoriyelHesaplama();
                break;
            case 7:
                modAlma();
                break;
            case 8:
                dikdortgenHesaplama();
                break;
            case 0:
                System.out.println("Hesap makinesi kapatılıyor...");
                break;
            default:
                System.out.println("Geçersiz bir seçim yaptınız. Tekrar deneyin.");
                break;
        }

        System.out.println(); // bir satır boşluk bırak
    }

        scanner.close();
}

    public static void toplamaIslemi() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Birinci sayıyı girin: ");
        int sayi1 = scanner.nextInt();
        System.out.print("İkinci sayıyı girin: ");
        int sayi2 = scanner.nextInt();

        int sonuc = sayi1 + sayi2;
        System.out.println("Sonuç: " + sonuc);

    }

    public static void cikarmaIslemi() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Birinci sayıyı girin: ");
        int sayi1 = scanner.nextInt();
        System.out.print("İkinci sayıyı girin: ");
        int sayi2 = scanner.nextInt();

        int sonuc = sayi1 - sayi2;
        System.out.println("Sonuç: " + sonuc);

    }

    public static void carpmaIslemi() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Birinci sayıyı girin: ");
        int sayi1 = scanner.nextInt();
        System.out.print("İkinci sayıyı girin: ");
        int sayi2 = scanner.nextInt();

        int sonuc = sayi1 * sayi2;
        System.out.println("Sonuç: " + sonuc);

    }

    public static void bolmeIslemi() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bölünen sayıyı girin: ");
        int sayi1 = scanner.nextInt();
        System.out.print("Bölen sayıyı girin: ");
        int sayi2 = scanner.nextInt();

        if (sayi2 == 0) {
            System.out.println("Bir sayıyı 0'a bölemezsiniz!");
        } else {
            double sonuc = (double) sayi1 / sayi2;
            System.out.println("Sonuç: " + sonuc);
        }

    }

    public static void usluSayiHesaplama() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Taban sayıyı girin: ");
        int taban = scanner.nextInt();
        System.out.print("Üs sayıyı girin: ");
        int us = scanner.nextInt();

        int sonuc = (int) Math.pow(taban, us);
        System.out.println("Sonuç: " + sonuc);

    }

    public static void faktoriyelHesaplama() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sayıyı girin: ");
        int sayi = scanner.nextInt();

        int faktoriyel = 1;
        for (int i = 1; i <= sayi; i++) {
            faktoriyel *= i;
        }

        System.out.println("Sonuç: " + faktoriyel);

    }

    public static void modAlma() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Birinci sayıyı girin: ");
        int sayi1 = scanner.nextInt();
        System.out.print("İkinci sayıyı girin: ");
        int sayi2 = scanner.nextInt();

        int sonuc = sayi1 % sayi2;
        System.out.println("Sonuç: " + sonuc);

    }

    public static void dikdortgenHesaplama() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dikdörtgenin uzun kenarını girin: ");
        int uzunKenar = scanner.nextInt();
        System.out.print("Dikdörtgenin kısa kenarını girin: ");
        int kisaKenar = scanner.nextInt();

        int alan = uzunKenar * kisaKenar;
        int cevre = 2 * (uzunKenar + kisaKenar);

        System.out.println("Alan: " + alan);
        System.out.println("Çevre: " + cevre);

    }
}
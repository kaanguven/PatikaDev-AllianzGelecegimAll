import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("x1 değerini girin: ");
        double x1 = scanner.nextDouble();

        System.out.print("x2 değerini girin: ");
        double x2 = scanner.nextDouble();

        System.out.println("İşlem Seçin:");
        System.out.println("1. Toplama");
        System.out.println("2. Çıkarma");
        System.out.println("3. Çarpma");
        System.out.println("4. Bölme");

        System.out.print("Seçiminizi yapın: ");
        int secim = scanner.nextInt();

        double sonuc;

        switch (secim) {
            case 1:
                sonuc = x1 + x2;
                System.out.println("Sonuç: " + sonuc);
                break;
            case 2:
                sonuc = x1 - x2;
                System.out.println("Sonuç: " + sonuc);
                break;
            case 3:
                sonuc = x1 * x2;
                System.out.println("Sonuç: " + sonuc);
                break;
            case 4:
                if (x2 != 0) {
                    sonuc = x1 / x2;
                    System.out.println("Sonuç: " + sonuc);
                } else {
                    System.out.println("Bölme işlemi için x2 değeri 0 olamaz.");
                }
                break;
            default:
                System.out.println("Geçersiz seçim.");
                break;
        }
    }
}
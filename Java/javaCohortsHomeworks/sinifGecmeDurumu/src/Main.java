import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] dersler = {"Matematik", "Fizik", "Türkçe", "Kimya", "Müzik"};
        int[] notlar = new int[5];
        int gecmeNotu = 55;
        int toplamNot = 0;
        int dersSayisi = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < dersler.length; i++) {
            System.out.print(dersler[i] + " notunu girin: ");
            int not = scanner.nextInt();

            if (not >= 0 && not <= 100) {
                notlar[i] = not;
                toplamNot += not;
                dersSayisi++;
            }
        }

        if (dersSayisi > 0) {
            double ortalama = (double) toplamNot / dersSayisi;
            System.out.println("Derslerin Ortalaması: " + ortalama);

            if (ortalama >= gecmeNotu) {
                System.out.println("Geçtiniz!");
            } else {
                System.out.println("Kaldınız.");
            }
        } else {
            System.out.println("Girilen ders notları 0 veya 100 arasında değil.");
        }
    }
}
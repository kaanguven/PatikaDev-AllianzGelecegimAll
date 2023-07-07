import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sıcaklık değerini girin: ");
        int sicaklik = scanner.nextInt();

        String etkinlik;

        if (sicaklik < 5) {
            etkinlik = "Kayak";
        } else if (sicaklik >= 5 && sicaklik <= 15) {
            etkinlik = "Sinema";
        } else if (sicaklik > 15 && sicaklik <= 25) {
            etkinlik = "Piknik";
        } else {
            etkinlik = "Yüzme";
        }

        System.out.println("Önerilen etkinlik: " + etkinlik);
    }
}
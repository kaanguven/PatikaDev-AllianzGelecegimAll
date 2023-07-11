import java.util.Scanner;

/*
Java'da döngüler kullanarak yıldızlar ile elmas yapınız.


 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elmasın yüksekliği (tek sayı): ");
        int yukseklik = scanner.nextInt();

        int bosluk = yukseklik / 2;
        int yildiz = 1;

        // Elmasın üst kısmını çizdirme
        for (int i = 0; i < yukseklik / 2 + 1; i++) {
            for (int j = 0; j < bosluk; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < yildiz; j++) {
                System.out.print("*");
            }
            System.out.println();

            bosluk--;
            yildiz += 2;
        }

        // Elmasın alt kısmını çizdirme
        bosluk = 1;
        yildiz = yukseklik - 2;

        for (int i = 0; i < yukseklik / 2; i++) {
            for (int j = 0; j < bosluk; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < yildiz; j++) {
                System.out.print("*");
            }
            System.out.println();

            bosluk++;
            yildiz -= 2;
        }
    }
}
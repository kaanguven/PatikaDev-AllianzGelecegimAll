import java.util.Scanner;


/*
N elemanlı bir kümenin elemanları ile oluşturulacak r elemanlı farklı grupların sayısı n’in r’li kombinasyonu olarak adlandırılır. N’in r’li kombinasyonu C(n,r) şeklinde gösterilir.

Java ile kombinasyon hesaplayan program yazınız.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kümenin eleman sayısını girin (n): ");
        int n = scanner.nextInt();
        System.out.print("Grup eleman sayısını girin (r): ");
        int r = scanner.nextInt();

        int kombinasyon = kombinasyonHesapla(n, r);
        System.out.println("C(" + n + ", " + r + ") = " + kombinasyon);
    }

    public static int kombinasyonHesapla(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        } else {
            return kombinasyonHesapla(n - 1, r - 1) + kombinasyonHesapla(n - 1, r);
        }
    }
}

import java.util.Scanner;

/*
Java ile girilen sayının harmonik serisini bulan program yazacağız.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int n = scanner.nextInt();

        double harmonikSerisi = 0.0;
        for (int i = 1; i <= n; i++) {
            harmonikSerisi += (1.0 / i);
        }

        System.out.println("Harmonik Seri: " + harmonikSerisi);
    }
}
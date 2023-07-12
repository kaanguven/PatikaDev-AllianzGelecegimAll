import java.util.Scanner;

/*
Java dilinde "Recursive" metot kullanarak, kullanıcıdan alınan sayının "Asal" sayı olup olmadığını bulan programı yazın.
 */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayı girin: ");
        int sayi = input.nextInt();

        if (recursiveIsPrime(sayi, sayi / 2)) {
            System.out.println(sayi + " bir asal sayıdır.");
        } else {
            System.out.println(sayi + " bir asal sayı değildir.");
        }
    }

    public static boolean recursiveIsPrime(int sayi, int bolen) {
        if (bolen == 1) {
            return true;
        } else {
            if (sayi % bolen == 0) {
                return false;
            } else {
                return recursiveIsPrime(sayi, bolen - 1);
            }
        }
    }
}
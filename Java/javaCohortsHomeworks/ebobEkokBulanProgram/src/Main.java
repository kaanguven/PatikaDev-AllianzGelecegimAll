/*
Java ile iki sayının EBOB ve EKOK değerlerini "While Döngüsü" kullanarak yazınız.
 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Birinci sayıyı giriniz: ");
        int num1 = input.nextInt();

        System.out.print("İkinci sayıyı giriniz: ");
        int num2 = input.nextInt();

        int ebob = 1;
        int ekok = (num1 * num2);

        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);

        while (min != 0) {
            int temp = min;
            min = max % min;
            max = temp;
        }

        ebob = max;
        ekok /= ebob;

        System.out.println("EBOB: " + ebob);
        System.out.println("EKOK: " + ekok);
    }
}
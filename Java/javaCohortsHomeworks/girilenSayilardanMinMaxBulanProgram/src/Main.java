import java.util.Scanner;


/*
Klavyeden girilen bir sayının mükemmel sayı olup/olmadığını bulan ve sayı mükemmel sayı ise ekrana “mükemmel sayıdır.” değilse “mükemmel sayı değildir.” ifadelerini ekrana yazan programı Java dilinde yazınız.
 */
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numberCount;

        System.out.println("Kaç tane sayi girmek istediğinizi yaziniz.");

        numberCount = input.nextInt();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;


        for (int i = 1; i <= numberCount; i++) {
            System.out.println(i + ".Sayiyi giriniz: ");
            int number = input.nextInt();

            if (number > max) {
                max = number;
            }

            if (number < min) {
                min = number;
            }
        }


        System.out.println("En büyük sayı: " + max);
        System.out.println("En küçük sayı: " + min);
    }
}

import java.util.Scanner;

/*
Java dilinde, taban ve üs değerleri kullanıcıdan alınan üs alma işlemini "Recursive" metot kullanarak yapan programı yazınız.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Taban sayıyı giriniz: ");
        int tabanSayi = input.nextInt();
        System.out.println("Almak istediğiniz üssü giriniz: ");
        int usSayi = input.nextInt();
        int answer = recursiveExponential(tabanSayi,usSayi);
        System.out.println(answer);

    }


    public static int recursiveExponential(int taban, int ust) {
        if (ust == 0) {
            return 1;
        } else {
            return taban * recursiveExponential(taban, ust - 1);
        }
    }
}
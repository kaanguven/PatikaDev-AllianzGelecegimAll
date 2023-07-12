import java.util.Scanner;

/*
Java dilinde kullanıcıdan alınan n değerine göre aşağıdaki kurala uyan döngü kullanmadan bir "Recursive" metot yazın.

Kural : Girilen sayı 0 veya negatif olduğu yere kadar girilen sayıdan 5 rakamını çıkarın. Her çıkarma işlemi sırasında
ekrana son değeri yazdırın. Sayı negatif veya 0 olduktan sonra tekrar 5 ekleyin. Yine her ekleme işleminde sayının son
değerini ekrana yazdırın.
 */
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Lütfen sayıyı giriniz: ");

        int sayi = input.nextInt();

        minusFiveTillDie(sayi);






    }

    static int minusFiveTillDie(int inputSayi){

        if (inputSayi<=0){
            System.out.println("Sayi 0 veya 0'dan küçük, "+"Sayinin son hali :"+inputSayi);
            return inputSayi;
        } else {
            System.out.println(inputSayi);
            return minusFiveTillDie(inputSayi-5);

        }


    }
}
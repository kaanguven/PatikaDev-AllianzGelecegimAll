import java.util.Scanner;

/*
Klavyeden girilen bir sayının mükemmel sayı olup/olmadığını bulan ve sayı mükemmel sayı ise ekrana “mükemmel sayıdır.” değilse “mükemmel sayı değildir.” ifadelerini ekrana yazan programı Java dilinde yazınız.
 */
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen sayiyi giriniz: ");

        int sayi = input.nextInt();

        int comparingTotal = 0;

        for (int i=1;i<sayi;i++){
            if (sayi%i==0){
                comparingTotal= comparingTotal+i;
            }
        }
        if (comparingTotal==sayi){
            System.out.println(sayi+" Mükemmel sayıdır");
        } else{
            System.out.println(sayi+" Mükemmel sayi değildir");
        }
    }
}
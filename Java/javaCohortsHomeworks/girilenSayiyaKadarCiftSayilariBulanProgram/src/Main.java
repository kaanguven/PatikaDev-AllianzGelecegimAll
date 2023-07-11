import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Sayiyi giriniz: ");
        int sayi = input.nextInt();
        List<Integer> sayilar = new ArrayList<>();
        for(int i=0;i<sayi;i++){
            if (i %4==0 && i%3==0) {
                sayilar.add(i);

            }

        }
        System.out.println(sayi+" sayisina kadar 3 ve 4 'e tam bölünen sayilar: "+sayilar);

    }
}
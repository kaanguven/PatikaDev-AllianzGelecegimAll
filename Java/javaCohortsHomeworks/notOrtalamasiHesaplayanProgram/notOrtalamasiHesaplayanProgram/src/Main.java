import java.util.*;
public class Main {
    public static void main(String[] args) {

        //defining variables
        int chemistryPoint, pyhsicsPoint, mathPoint, turkishPoint, historyPoint, musicPoint;

        //creating Scanner to get inputs

        Scanner input = new Scanner(System.in);

        // defining inputs

        System.out.println("Kimya notunu giriniz:");
        chemistryPoint = input.nextInt();

        System.out.println("Fizik notunu giriniz:");
        pyhsicsPoint = input.nextInt();

        System.out.println("Matematik notunu giriniz:");
        mathPoint = input.nextInt();

        System.out.println("Türkçe notunu giriniz:");
        turkishPoint = input.nextInt();

        System.out.println("Tarih notunu giriniz:");
        historyPoint = input.nextInt();

        System.out.println("Müzik notunu giriniz:");
        musicPoint = input.nextInt();


        int toplam = (musicPoint+historyPoint+turkishPoint+mathPoint+pyhsicsPoint+chemistryPoint);

        double avg = toplam / 6;

        System.out.println("Derslerin ortalaması: "+avg);
        System.out.println(avg < 60 ? "Kaldınız" : "Geçtiniz");

        }
    }

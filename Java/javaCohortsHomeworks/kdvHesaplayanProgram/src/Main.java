import java.util.*;
public class Main {
    public static void main(String[] args) {

        double money,kdvRatio,kdvPrice,priceWithKDV;


        Scanner input = new Scanner(System.in);

        System.out.println("Para giriniz.");
        money = input.nextDouble();



        if (money >1000) {
            kdvRatio = 0.18;
            System.out.println("KDV oranı: " + kdvRatio);
            kdvPrice = money * kdvRatio;
            priceWithKDV = money + kdvPrice;

            System.out.println("KDV Tutarı: " + kdvPrice);
            System.out.println("Toplam Tutar: " + priceWithKDV);

        }
        else if (money <= 1000){
            kdvRatio=  0.08;
            System.out.println("KDV oranı: " + kdvRatio);
            kdvPrice = money * kdvRatio;
            priceWithKDV = money + kdvPrice;

            System.out.println("KDV Tutarı: " + kdvPrice);
            System.out.println("Toplam Tutar: " + priceWithKDV);



        }

    }
}
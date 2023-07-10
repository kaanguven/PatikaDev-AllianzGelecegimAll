import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int mesafe, yas, yolculukTipi;
        double normaltutar, tutar, indirim;
        double mesafetutarı = 0.10, ogrenci = 0.10, cocuk = 0.50, yasli = 0.30, tip = 0.20;

        System.out.print("Lütfen mesafe bilgisini km cinsinden yazınız: ");
        mesafe = input.nextInt();

        System.out.print("Lütfen yaşınızı giriniz: ");
        yas = input.nextInt();

        System.out.print("Lütfen yolculuk tipini seçiniz \n1-Tek Yön \n2-Gidiş-Dönüş");
        System.out.print("\nSeçiminiz: ");
        yolculukTipi = input.nextInt();

        normaltutar = mesafe * mesafetutarı;
        if (mesafe > 0 && yas > 0 && (yolculukTipi == 1 || yolculukTipi == 2)) {
            if (yas < 12) {
                indirim = normaltutar * cocuk;
            } else if (yas >= 12 && yas <= 24) {
                indirim = normaltutar * ogrenci;
            } else if (yas >= 65) {
                indirim = normaltutar * yasli;
            } else {
                indirim = 0;
            }
            tutar = normaltutar - indirim;

            switch (yolculukTipi) {
                case 1:
                    tutar = tutar;
                    break;
                case 2:
                    indirim = tutar * tip;
                    tutar = (tutar - indirim) * 2;
                    break;
            }
            System.out.println("Toplam tutar: " + tutar);
        } else
            System.out.print("Hatalı giriş yaptınız!");

    }
}
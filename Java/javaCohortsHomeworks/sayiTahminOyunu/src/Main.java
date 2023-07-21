
import java.util.Random;
import java.util.Scanner;
public class Main {
        public static void main(String[] args){
            // Rastgele bir sayı seçme
            Random random = new Random();
            int rastgeleSayi = random.nextInt(101); // 0 ile 100 arasında bir rastgele sayı

            // Oyuna başlama mesajı
            System.out.println("0 ile 100 arasında bir sayıyı tahmin edin.");

            // Kullanıcıdan tahminleri alma
            Scanner scanner = new Scanner(System.in);
            int tahmin, adim = 0;

            do {
                adim++;
                System.out.print("Tahmininiz: ");
                tahmin = scanner.nextInt();

                if (tahmin > rastgeleSayi) {
                    System.out.println("Daha küçük bir sayı girin.");
                } else if (tahmin < rastgeleSayi) {
                    System.out.println("Daha büyük bir sayı girin.");
                } else {
                    System.out.println("Tebrikler! " + adim + ". adımda doğru sayıyı tahmin ettiniz.");
                }
            } while (tahmin != rastgeleSayi);

            // Kullanıcı oyunu bitirdiğinde çıkış mesajı
            System.out.println("Oyun bitti. Teşekkürler!");
            scanner.close();
        }
    }

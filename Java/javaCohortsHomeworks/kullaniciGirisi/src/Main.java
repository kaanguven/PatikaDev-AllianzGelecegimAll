import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String dogruKullaniciAdi = "admin";
        String dogruSifre = "sifre123";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Kullanıcı adını girin: ");
        String girilenKullaniciAdi = scanner.nextLine();

        System.out.print("Şifrenizi girin: ");
        String girilenSifre = scanner.nextLine();

        if (girilenKullaniciAdi.equals(dogruKullaniciAdi) && girilenSifre.equals(dogruSifre)) {
            System.out.println("Giriş başarılı!");
        } else {
            System.out.print("Kullanıcı adı veya şifre yanlış. Şifrenizi sıfırlamak ister misiniz? (E/H): ");
            String secim = scanner.nextLine();

            if (secim.equalsIgnoreCase("E")) {
                System.out.print("Yeni şifreyi girin: ");
                String yeniSifre = scanner.nextLine();

                if (!yeniSifre.equals(girilenSifre)) {
                    System.out.println("Şifre oluşturuldu.");
                } else {
                    System.out.println("Şifre oluşturulamadı, lütfen başka bir şifre girin.");
                }
            } else {
                System.out.println("Şifre sıfırlama işlemi iptal edildi.");
            }
        }
    }
}
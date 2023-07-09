import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Platform> platformlar = new ArrayList<>();
        List<Category> kategoriler = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean devam = true;

        while (devam) {
            if (platformlar.isEmpty()) {
                System.out.println("Listede hiç film bulunmamakta. Öncelikle film ekleyiniz.");
            }
            System.out.print("admin veya client olarak giriş yapın (0 to exit): ");
            String kullaniciTipi = scanner.nextLine();

            if (kullaniciTipi.equalsIgnoreCase("admin")) {
                System.out.print("Film adı girin: ");
                String filmAdi = scanner.nextLine();
                System.out.print("Platform adı girin: ");
                String platformAdi = scanner.nextLine();
                System.out.print("Kategori adı girin: ");
                String kategoriAdi = scanner.nextLine();
                System.out.print("Seans sayısını girin: ");
                int seansSayisi = scanner.nextInt();

                scanner.nextLine();

                Platform platform = null;
                for (Platform p : platformlar) {
                    if (p.getPlatformAdi().equalsIgnoreCase(platformAdi)) {
                        platform = p;
                        break;
                    }
                }

                if (platform == null) {
                    platform = new Platform(platformAdi);
                    platformlar.add(platform);
                }

                Category kategori = null;
                for (Category c : kategoriler) {
                    if (c.getAd().equalsIgnoreCase(kategoriAdi)) {
                        kategori = c;
                        break;
                    }
                }

                if (kategori == null) {
                    kategori = new Category(kategoriAdi);
                    kategoriler.add(kategori);
                }

                Film yeniFilm = new Film(filmAdi, platform, kategori);
                yeniFilm.setSeansSayisi(seansSayisi);

                List<String> seansSaatleri = new ArrayList<>();
                for (int i = 1; i <= seansSayisi; i++) {
                    System.out.print("Seans " + i + " saatini girin (HH:mm): ");
                    String saat = scanner.nextLine();

                    yeniFilm.addSeansSaat(saat);
                }

                platform.filmEkle(yeniFilm);
                kategori.filmEkle(yeniFilm);

                System.out.println("Film başarıyla eklendi.");
            } else if (kullaniciTipi.equalsIgnoreCase("client")) {
                System.out.println("Kategoriler:");
                for (Category kategori : kategoriler) {
                    System.out.println("- " + kategori.getAd());
                }
                System.out.print("Bir kategori seçin: ");
                String secilenKategori = scanner.nextLine();

                Category kategori = null;
                for (Category c : kategoriler) {
                    if (c.getAd().equalsIgnoreCase(secilenKategori)) {
                        kategori = c;
                        break;
                    }
                }

                if (kategori != null) {
                    int filmSayisi = kategori.filmSayisi();
                    System.out.println("Seçilen kategoride " + filmSayisi + " film bulunuyor.");

                    List<Film> filmler = kategori.getFilmler();
                    for (Film film : filmler) {
                        System.out.println("Film Adı: " + film.getFilmAdi());
                        System.out.println("Platform: " + film.getPlatform().getPlatformAdi());
                        System.out.println("Seans Sayısı: " + film.getSeansSayisi());
                        List<String> seansSaatleri = film.getSeansSaatleri();
                        for (String saat : seansSaatleri) {
                            System.out.println("Seans Saati: " + saat);
                        }
                        System.out.println("--------");
                    }
                } else {
                    System.out.println("Geçersiz kategori seçimi.");
                }
            } else if (kullaniciTipi.equals("0")) {
                devam = false;
                System.out.println("Programdan çıktınız.");
            } else {
                System.out.println("Geçersiz kullanıcı tipi.");
            }
        }
    }
}
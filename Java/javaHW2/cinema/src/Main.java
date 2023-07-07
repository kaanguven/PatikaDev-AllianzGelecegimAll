import model.*;
import java.util.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Platform> platformlar = new ArrayList<>();
        platformlar.add(new Platform("Amazon Prime"));
        platformlar.add(new Platform("Netflix"));

        Category categoryAksiyon = new Category("Aksiyon");
        Category categoryBilimKurgu = new Category("Bilim-Kurgu");

        Film film1 = new Film("Lord Of The Rings", platformlar.get(1), categoryBilimKurgu);
        Film film2 = new Film("Star Wars", platformlar.get(0), categoryAksiyon);

        platformlar.get(1).filmEkle(film1);
        platformlar.get(0).filmEkle(film2);
        categoryBilimKurgu.filmEkle(film1);
        categoryBilimKurgu.filmEkle(film2);

        Scanner scanner = new Scanner(System.in);
        boolean devam = true;

        while (devam) {
            System.out.print("admin veya client olarak giriş yapın (0 to exit): ");
            String kullaniciTipi = scanner.nextLine();

            if (kullaniciTipi.equalsIgnoreCase("admin")) {
                System.out.print("Film adı girin: ");
                String filmAdi = scanner.nextLine();
                System.out.print("Platform adı girin: ");
                String platformAdi = scanner.nextLine();
                System.out.print("Kategori adı girin: ");
                String kategoriAdi = scanner.nextLine();

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
                if (kategoriAdi.equalsIgnoreCase("Aksiyon")) {
                    kategori = categoryAksiyon;
                } else if (kategoriAdi.equalsIgnoreCase("Bilim-Kurgu")) {
                    kategori = categoryBilimKurgu;
                }

                if (kategori == null) {
                    kategori = new Category(kategoriAdi);
                    if (kategoriAdi.equalsIgnoreCase("Aksiyon")) {
                        categoryAksiyon = kategori;
                    } else if (kategoriAdi.equalsIgnoreCase("Bilim-Kurgu")) {
                        categoryBilimKurgu = kategori;
                    }
                }

                Film yeniFilm = new Film(filmAdi, platform, kategori);
                platform.filmEkle(yeniFilm);
                kategori.filmEkle(yeniFilm);

                System.out.println("Film başarıyla eklendi.");
            } else if (kullaniciTipi.equalsIgnoreCase("client")) {
                System.out.println("Kategoriler:");
                System.out.println("- Aksiyon");
                System.out.println("- Bilim-Kurgu");
                System.out.print("Bir kategori seçin: ");
                String secilenKategori = scanner.nextLine();

                Category kategori = null;
                if (secilenKategori.equalsIgnoreCase("Aksiyon")) {
                    kategori = categoryAksiyon;
                } else if (secilenKategori.equalsIgnoreCase("Bilim-Kurgu")) {
                    kategori = categoryBilimKurgu;
                }

                if (kategori != null) {
                    int filmSayisi = kategori.filmSayisi();
                    System.out.println("Seçilen kategoride " + filmSayisi + " film bulunuyor.");

                    List<Film> filmler = kategori.getFilmler();
                    for (Film film : filmler) {
                        System.out.println("Film Adı: " + film.getFilmAdi());
                        System.out.println("Platform: " + film.getPlatform().getPlatformAdi());
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
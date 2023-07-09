package model;
import java.util.*;

public class Film {
    private String filmAdi;
    private Platform platform;
    private Category kategori;
    private int seansSayisi;
    private List<String> seansSaatleri;

    public Film(String filmAdi, Platform platform, Category kategori) {
        this.filmAdi = filmAdi;
        this.platform = platform;
        this.kategori = kategori;
        this.seansSayisi = 0;
        this.seansSaatleri = new ArrayList<>();
    }

    public String getFilmAdi() {
        return filmAdi;
    }

    public Platform getPlatform() {
        return platform;
    }

    public Category getKategori() {
        return kategori;
    }

    public int getSeansSayisi() {
        return seansSayisi;
    }

    public void setSeansSayisi(int seansSayisi) {
        this.seansSayisi = seansSayisi;
    }

    public List<String> getSeansSaatleri() {
        return seansSaatleri;
    }

    public void addSeansSaat(String saat) {
        seansSaatleri.add(saat);
    }
}
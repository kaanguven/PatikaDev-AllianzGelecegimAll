package model;
import java.util.*;

public class Film {
    private String filmAdi;
    private Platform platform;
    private Category kategori;

    public Film(String filmAdi, Platform platform, Category kategori) {
        this.filmAdi = filmAdi;
        this.platform = platform;
        this.kategori = kategori;
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
}

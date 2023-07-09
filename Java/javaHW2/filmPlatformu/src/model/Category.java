package model;
import java.util.*;
public class Category {
    private String ad;
    private List<Film> filmler;

    public Category(String ad) {
        this.ad = ad;
        filmler = new ArrayList<>();
    }

    public void filmEkle(Film film) {
        filmler.add(film);
    }

    public int filmSayisi() {
        return filmler.size();
    }

    public List<Film> getFilmler() {
        return filmler;
    }
    public String getAd() {
        return ad;
    }
}
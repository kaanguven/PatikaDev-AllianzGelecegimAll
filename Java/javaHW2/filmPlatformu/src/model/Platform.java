package model;
import java.util.*;
public class Platform {
    private String platformAdi;
    private List<Film> filmler;

    public Platform(String platformAdi) {
        this.platformAdi = platformAdi;
        filmler = new ArrayList<>();
    }

    public void filmEkle(Film film) {
        filmler.add(film);
    }

    public String getPlatformAdi() {
        return platformAdi;
    }

    public List<Film> getFilmler() {
        return filmler;
    }
}
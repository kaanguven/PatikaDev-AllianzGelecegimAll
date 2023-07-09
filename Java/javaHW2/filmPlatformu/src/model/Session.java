package model;
import java.util.*;
public class Session {
    private Film film;
    private int seansSayisi;
    private List<String> seansSaatleri;

    public Session(Film film) {
        this.film = film;
        this.seansSayisi = 0;
        this.seansSaatleri = new ArrayList<>();
    }

    public void setSeansSayisi(int seansSayisi) {
        this.seansSayisi = seansSayisi;
    }

    public void setSeansSaatleri(List<String> seansSaatleri) {
        this.seansSaatleri = seansSaatleri;
    }

    public int getSeansSayisi() {
        return seansSayisi;
    }

    public List<String> getSeansSaatleri() {
        return seansSaatleri;
    }
}
package model;

import java.util.Arrays;
import java.util.List;

public class Film {

    private String filmName;
    private int year;
    private String director;
    private double imdb;
    private Category[] categoryArray;
    private String time;
    private List<String> platformList;


    public Film(String filmName, int year, String director) {
        this.filmName = filmName;
        this.year = year;
        this.director = director;
    }


    public Film() {
        this.filmName = "Lord of the rings";
        this.year = 2010;
    }


    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public List<String> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(List<String> platformList) {
        this.platformList = platformList;
    }

    public Category[] getCategoryArray() {
        return categoryArray;
    }

    public void setCategoryArray(Category[] categoryArray) {
        this.categoryArray = categoryArray;
    }



    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", imdb=" + imdb +
                ", categoryArray=" + Arrays.toString(categoryArray) +
                ", time='" + time + '\'' +
                ", platformList=" + platformList +
                '}';
    }
}

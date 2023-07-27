package model;

import java.util.List;

public class Club {

    String name;

    List<Object> clubList;

    public Club(String name) {
        this.name = name;
    }

    public List<Object> getClubList() {
        return clubList;
    }

    public void setClubList(List<Object> clubList) {
        this.clubList = clubList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Club{" +
                "name='" + name + '\'' +
                '}';
    }
}

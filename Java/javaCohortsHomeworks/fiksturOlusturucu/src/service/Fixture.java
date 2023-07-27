package service;

import model.Club;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fixture {

    public void createFixture(List<Club> clubList){
        // Check if the number of clubs is odd, if so, add a "Bay" club
        if (clubList.size() % 2 != 0) {
            Club bayClub = new Club("Bay");
            clubList.add(bayClub);
        }

        int numWeeks = clubList.size() - 1; // Number of weeks needed for the fixture

        for (int week = 1; week <= numWeeks; week++) {
            System.out.println("Week " + week + " Matches:");
            for (int i = 0; i < clubList.size() / 2; i++) {
                Club homeTeam = clubList.get(i);
                Club awayTeam = clubList.get(clubList.size() - 1 - i);
                System.out.println(homeTeam.getName() + " vs " + awayTeam.getName());
            }

            // Rotate the list of clubs for the next week's fixtures
            Collections.rotate(clubList.subList(1, clubList.size()), 1);
        }
    }




    public void addClubToFixture(Club club){
        if (club.getClubList()!=null){
            club.getClubList().add(club);
        }else{
            List<Club> clubList = new ArrayList<>();
            club.getClubList().add(club);

        }

    }
}

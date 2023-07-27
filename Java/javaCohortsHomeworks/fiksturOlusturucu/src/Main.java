import model.Club;
import service.Fixture;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Fixture fixture = new Fixture();

        Club club1 = new Club("Team A");
        Club club2 = new Club("Team B");
        Club club3 = new Club("Team C");
        Club club4 = new Club("Team D");

        List<Club> clubs = new ArrayList<>();
        clubs.add(club1);
        clubs.add(club2);
        clubs.add(club3);
        clubs.add(club4);

        fixture.createFixture(clubs);
    }

    }


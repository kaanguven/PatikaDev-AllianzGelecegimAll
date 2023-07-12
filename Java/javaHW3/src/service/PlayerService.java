package service;


import enums.CurrencyTypeEnum;
import model.Player;
import model.Team;
import model.Transfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerService {


    //yeni bir oyuncu ekliyoruz
    //başlangıcta en az bir takımı olsun
    /*
     private String name;

    private String surname;

    private int kitNumber;

    private int birthYear;

    private String position;

    private List<Transfer> transferHistory;

    private List<Team> teamList;

     */

    public Player createPlayer(String name, String surname, int kitNumber, int birthYear,
                               String position, BigDecimal value, CurrencyTypeEnum currency) {

        Player player = new Player();
        player.setName(name);
        player.setSurname(surname);
        player.setKitNumber(kitNumber);
        player.setBirthYear(birthYear);
        player.setPosition(position);
        player.setValue(value);
        player.setCurrency(currency);

        return player;
    }


    public void addTeamToPlayer(Player player, Team team) {

        if (Objects.nonNull(player.getTeamList())) {
            player.getTeamList().add(team);
        } else {
            List<Team> teamList = new ArrayList<>();
            teamList.add(team);
            player.setTeamList(teamList);
        }
    }

    public void addTransferHistoryToPlayer(Player player, Transfer transfer){
        if(player.getTransferHistory()!=null){
            player.getTransferHistory().add(transfer);
        }
        else{
            List<Transfer> transferList = new ArrayList<>();
            transferList.add(transfer);
            player.setTransferHistory(transferList);
        }
    }



}

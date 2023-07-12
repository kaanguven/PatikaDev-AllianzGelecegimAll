import enums.AwardCategoryEnum;
import enums.AwardTypeEnum;
import enums.CurrencyTypeEnum;
import model.Player;
import model.Team;
import model.Transfer;
import service.PlayerService;
import service.TeamService;
import service.TransferService;

import java.math.BigDecimal;

public class Main {

    //currency dolar,euro,tl


    public static void main(String[] args) throws Exception {

        TeamService teamService = new TeamService();
        PlayerService playerService = new PlayerService();
        TransferService transferService = new TransferService();

        Team team = teamService.createTeam("Galatasaray", "GS", "yellow-red",
                "Okan Buruk", "Dursun Özbek", "Nef Arena", new BigDecimal(400),
                CurrencyTypeEnum.EUR, "Türkiye");

        teamService.addAwardToTeam(team, "Champions Cup", 2023,
                AwardTypeEnum.CUP, AwardCategoryEnum.INTERNATIONAL);


        Team team2 = teamService.createTeam("Fenerbahçe", "FB", "yellow-blue",
                "İsmail Kartal", "Ali Koç", "Kadıköy", new BigDecimal(800),
                CurrencyTypeEnum.USD, "Türkiye");


        teamService.addAwardToTeam(team2, "Turkish Cup", 2023,
                AwardTypeEnum.CUP, AwardCategoryEnum.NATIONAL);

        teamService.addAwardToTeam(team, "League Cup", 2023,
                AwardTypeEnum.CUP, AwardCategoryEnum.NATIONAL);


        Player player = playerService.createPlayer("Cristiano", "Ronaldo",
                7, 1985, "Forvet", new BigDecimal(100), CurrencyTypeEnum.EUR);

        playerService.addTeamToPlayer(player, team);

        Transfer transfer = transferService.makeTransfer(player, team2);

        playerService.addTransferHistoryToPlayer(player, transfer);


        System.out.println("Satan takım: " + team);
        System.out.println("Alan takım: " + team2);
        System.out.println("Oyuncu: " + player);
        System.out.println("Transfer ücreti: " + transfer.getPrice()+" "+transfer.getCurrency());
    }

}
package service;


import model.Player;
import model.Team;
import model.Transfer;

import java.math.BigDecimal;

public class TransferService {


    public Transfer makeTransfer(Player player, Team toTeam){



        BigDecimal buyerTeamBudget = toTeam.getCurrency()
                .convertTo(toTeam.getBudget(),toTeam.getCurrency(),player.getCurrency());
        BigDecimal playerValue = player.getValue();
        Team sellerTeam = player.getTeamList().get(player.getTeamList().size()-1);


        if(buyerTeamBudget.compareTo(playerValue)>=0){

            System.out.println("transfer can be done");
            BigDecimal buyerTeamRemainingBudget = toTeam.getCurrency()
                            .convertTo(buyerTeamBudget.subtract(playerValue),player.getCurrency(),toTeam.getCurrency());
            toTeam.setBudget(buyerTeamRemainingBudget);
            BigDecimal sellerTeamBudget = sellerTeam.getCurrency()
                    .convertTo(sellerTeam.getBudget(),sellerTeam.getCurrency(),player.getCurrency());
            sellerTeamBudget = sellerTeamBudget.add(player.getValue());
            BigDecimal sellerTeamLastBudget = sellerTeam.getCurrency()
                    .convertTo(sellerTeamBudget,player.getCurrency(),sellerTeam.getCurrency());
            sellerTeam.setBudget(sellerTeamLastBudget);

            player.getTeamList().add(toTeam);
        }
        else{
            System.err.println("transfer can not be done because of not enough budget");
        }

        Transfer transfer = new Transfer();
        transfer.setCurrency(player.getCurrency());
        transfer.setPrice(player.getValue());
        transfer.setFromTeam(sellerTeam);
        transfer.setToTeam(toTeam);
        transfer.setYear(2023);

        return transfer;

    }


}

package service;

import model.Player;
import model.BaseCharacter;

public class PlayerService {

    public void addCharacterToPlayer(BaseCharacter character, Player player) {
        player.setCharacter(character);
    }

    public int whoStartsFirst(Player playerOne, Player playerTwo) {
        int random = (Math.random() <= 0.5) ? 1 : 2;
        if (random == 1) {
            System.out.println(playerOne.getName() + " will start the turn first.");
        } else {
            System.out.println(playerTwo.getName() + " will start the turn first.");
        }
        return random;
    }

}

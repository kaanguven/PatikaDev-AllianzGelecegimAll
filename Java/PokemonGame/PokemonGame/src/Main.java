import model.BaseCharacter;
import model.Player;
import model.Pokemon;
import model.WeatherEnum;
import service.*;

import java.util.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CharacterService characterService = new CharacterService();
        GameService gameService = new GameService();
        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        PokemonService pokemonService = new PokemonService();
        WeatherService weatherService = new WeatherService();
        Scanner scanner = new Scanner(System.in);

        Player playerOne = new Player();
        Player playerTwo = new Player();
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();
        ArrayList<BaseCharacter> characterList = loadService.loadCharacters();

        gameService.setupPlayer(playerOne, pokemonList, characterList);
        gameService.setupPlayer(playerTwo, pokemonList, characterList);

        System.out.println("Player One: " + playerOne.getName());
        System.out.println("Player Two: " + playerTwo.getName());

        System.out.println("\nGame is beginning...\n");
        int round = 0;
        while (true) {
            int startingPlayer = playerService.whoStartsFirst(playerOne, playerTwo);
            System.out.println("\nRound " + (round + 1) + " is starting!\n");


            while (!gameService.checkEndOfRound(playerOne, playerTwo)) {
                WeatherEnum weather = weatherService.getWeather();
                System.out.println("Weather condition :" + weather + "!\n");
                if (startingPlayer == 1) {
                    System.out.println(playerOne.getName() + " is attacking!\n");
                    System.out.println("Select your attack type: ");
                    System.out.println("1. Pokemon attack");
                    System.out.println("2. Character attack");
                    int attackType = scanner.nextInt();
                    gameService.checkValidInput(attackType, 1, 2);
                    if (attackType == 1) {
                        System.out.println("Please select your pokemon: ");
                        pokemonService.getPokemons(playerOne.getCharacter().getPokemonList());
                        int pokemonIndex = scanner.nextInt();
                        gameService.checkValidInput(pokemonIndex, 1,
                                playerOne.getCharacter().getPokemonList().size());
                        System.out.println(playerOne.getCharacter().getPokemonList().get(pokemonIndex - 1).getName() + " is selected!");
                        playerOne.getCharacter().getPokemonList().get(pokemonIndex - 1).setPlaying(true);
                        System.out.println("Select your attack type: ");
                        System.out.println("1. Normal attack");
                        System.out.println("2. Special attack");
                        int attackIndex = scanner.nextInt();
                        gameService.checkValidInput(attackIndex, 1, 2);
                        gameService.attack(playerOne, playerTwo, attackIndex != 1,
                                false, weather);
                        playerOne.getCharacter().getPokemonList().get(pokemonIndex - 1).setPlaying(false);
                    } else {
                        System.out.println("Select your attack type: ");
                        System.out.println("1. Normal attack");
                        System.out.println("2. Special attack");
                        int attackIndex = scanner.nextInt();
                        gameService.checkValidInput(attackIndex, 1, 2);
                        gameService.attack(playerOne, playerTwo, false,
                                attackIndex != 1, weather);
                    }
                    startingPlayer = 2;
                } else {
                    System.out.println(playerTwo.getName() + " is attacking!\n");
                    System.out.println("Select your attack type: ");
                    System.out.println("1. Pokemon attack");
                    System.out.println("2. Character attack");
                    int attackType = scanner.nextInt();
                    gameService.checkValidInput(attackType, 1, 2);
                    if (attackType == 1) {
                        System.out.println("Select your pokemon: ");
                        pokemonService.getPokemons(playerTwo.getCharacter().getPokemonList());
                        int pokemonIndex = scanner.nextInt();
                        gameService.checkValidInput(pokemonIndex, 1,
                                playerTwo.getCharacter().getPokemonList().size());
                        playerOne.getCharacter().getPokemonList().get(pokemonIndex - 1).setPlaying(true);
                        System.out.println("Select your attack type: ");
                        System.out.println("1. Normal attack");
                        System.out.println("2. Special attack");
                        int attackIndex = scanner.nextInt();
                        gameService.checkValidInput(attackIndex, 1, 2);
                        gameService.attack(playerTwo, playerOne, attackIndex != 1,
                                false, weather);
                        playerOne.getCharacter().getPokemonList().get(pokemonIndex - 1).setPlaying(false);
                    } else {
                        System.out.println("Select your attack type: ");
                        System.out.println("1. Normal attack");
                        System.out.println("2. Special attack");
                        int attackIndex = scanner.nextInt();
                        gameService.checkValidInput(attackIndex, 1, 2);
                        gameService.attack(playerTwo, playerOne, false,
                                attackIndex != 1, weather);
                    }
                    startingPlayer = 1;
                }

            }

            round++;
            Player loser = gameService.loserOfRound(playerOne, playerTwo);
            if (round >1) {
                if (gameService.checkEndOfRound(playerOne, playerTwo)) {
                    if (loser == playerOne) {
                        pokemonService.addWeakestPokemonToLoser(playerOne,playerTwo );
                        System.out.println(playerOne.getCharacter().getPokemonList());
                    } else {
                        pokemonService.addWeakestPokemonToLoser(playerTwo,playerOne);
                    }
                    if (playerOne.getOriginalPokemonList().size() == 0 || playerTwo.getOriginalPokemonList().size() == 0) {
                        // End the game if any player has no Pokémon left
                        if(playerOne.getOriginalPokemonList().size() == 0){
                            System.out.println(playerOne.getName()+" lost the game, he/she doesnt have anymore pokemon :(");
                            break;

                        }else {
                            System.out.println(playerTwo.getName()+" lost the game, he/she doesnt have anymore pokemon :(");
                            break;
                        }
                    }else {
                        gameService.reselectPokemonsForBothPlayers(playerOne, playerTwo, pokemonList);
                    }
                }

                // Determine the winner and print the result
                if (loser == playerOne) {
                    playerTwo.setWinner(true);
                    System.out.println(playerTwo.getName() + " WON !");
                } else {
                    playerOne.setWinner(true);
                    System.out.println(playerOne.getName() + " WON !");
                }



                gameService.printPokemonLists(playerOne, playerTwo);
                // Ask if the players want to play another round
                System.out.println("Do you want to play another round? (yes/no)");
                String playAgain = scanner.next();
                if (playAgain.equalsIgnoreCase("yes")) {
                    // Reset the game for another round
                    round = round +1;
                    playerOne.setWinner(false);
                    playerTwo.setWinner(false);
                    for (Pokemon pokemon : playerOne.getCharacter().getPokemonList()) {
                        pokemon.setHealth(pokemon.getMaxHealth());

                    }
                    for (Pokemon pokemon : playerTwo.getCharacter().getPokemonList()) {
                        pokemon.setHealth(pokemon.getMaxHealth());
                    }
                } else {
                    // End the game
                    System.out.println("Thank you for playing!");
                    break;
                }
            }
        }
    }
}
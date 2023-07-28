package service;

import model.Player;
import model.WeatherEnum;
import model.BaseCharacter;
import model.Pokemon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameService {
    WeatherService weatherService = new WeatherService();
    CharacterService characterService = new CharacterService();
    PokemonService pokemonService = new PokemonService();

    PlayerService playerService = new PlayerService();

    public void attack(Player attacker, Player defender, boolean isPokeSpecialPower,
                       boolean isCharSpecialPower, WeatherEnum weatherEnum) {

        int damage;

        if (isCharSpecialPower)
            damage = characterService.calculateDamage(attacker, weatherEnum, true);
        else if (isPokeSpecialPower)
            damage = pokemonService.calculateDamage(attacker, weatherEnum, true);
        else
            damage = pokemonService.calculateDamage(attacker, weatherEnum, false);
        pokemonService.takeDamage(defender, damage);
        System.out.println(attacker.getName() + " attacked " + defender.getName() + " took " +
                +damage + " damage.");
        healthCheck(defender);
    }



    public void healthCheck(Player player) {
        if (player.getCharacter().getPokemonList().get(0).getHealth() > 0) {
            System.out.println("Nobody lost, the round is still going on...");
        } else if (player.getCharacter().getPokemonList().get(0).getHealth() > 0) {
            System.out.println(player.getName() + " lost the round.");
        }
    }

    public boolean checkEndOfRound(Player playerOne, Player playerTwo) {
        ArrayList<Pokemon> playerOneList = playerOne.getCharacter().getPokemonList();
        ArrayList<Pokemon> playerTwoList = playerTwo.getCharacter().getPokemonList();
        for (Pokemon pokemon : playerOneList) {
            for (Pokemon pokemon1 : playerTwoList) {
                if (pokemon.getHealth() > 0 && pokemon1.getHealth() > 0)
                    return false;
            }
        }
        return true;
    }

    public Player loserOfRound(Player playerOne, Player playerTwo) {
        ArrayList<Pokemon> playerOneList = playerOne.getCharacter().getPokemonList();
        ArrayList<Pokemon> playerTwoList = playerTwo.getCharacter().getPokemonList();
        for (Pokemon pokemon : playerOneList) {
            if (pokemon.getHealth() > 0)
                return playerTwo;
        }
        for (Pokemon pokemon : playerTwoList) {
            if (pokemon.getHealth() > 0)
                return playerOne;
        }
        return null;
    }

    public void checkValidInput(int input, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (input < min || input > max) {
            System.out.println("Your selection is wrong ! Make sure you are selecting from list.");
            input = scanner.nextInt();
        }
    }

    public void printPokemonLists(Player playerOne, Player playerTwo) {
        System.out.println("\n--- Updated Pokemon Lists ---");
        System.out.println(playerOne.getName() + "'s Pokemon List:");
        pokemonService.getPokemons(playerOne.getOriginalPokemonList());
        System.out.println(playerTwo.getName() + "'s Pokemon List:");
        pokemonService.getPokemons(playerTwo.getOriginalPokemonList());
        System.out.println("---\n");
    }



    public void setupPlayer(Player player, ArrayList<Pokemon> pokemons, ArrayList<BaseCharacter> characters) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        player.setName(scanner.nextLine());
        System.out.println("Please select your character: ");
        characterService.showCharacters(characters);
        int characterIndex = scanner.nextInt();
        while (characterIndex < 1 || characterIndex > characters.size()) {
            System.out.println("Your selection is wrong! Make sure you are selecting from the list.");
            characterIndex = scanner.nextInt();
        }
        while (characters.get(characterIndex - 1).isSelected()) {
            System.out.println("This character is already selected. Please select another one: ");
            characterIndex = scanner.nextInt();
        }
        playerService.addCharacterToPlayer(characters.get(characterIndex - 1), player);
        characters.get(characterIndex - 1).setSelected(true);

        int randomPokemonCount =3 ; // Change this value to add more or fewer Pokemons
        Random random = new Random();
        int maxPokemonIndex = pokemons.size();
        ArrayList<Pokemon> playerPokemons = new ArrayList<>();
        for (int i = 0; i < randomPokemonCount; i++) {
            int randomPokemonIndex = random.nextInt(maxPokemonIndex);
            while (pokemons.get(randomPokemonIndex).isSelected()) {
                randomPokemonIndex = random.nextInt(maxPokemonIndex);
            }
            characterService.addPokemonToCharacter(pokemons.get(randomPokemonIndex), player.getCharacter());
            pokemons.get(randomPokemonIndex).setSelected(true);
            playerPokemons.add(pokemons.get(randomPokemonIndex)); // Store added Pokemons for player selection
        }

        // Let the player select one Pokemon to fight
        System.out.println("Select your Pokemon to fight:");
        for (int i = 0; i < playerPokemons.size(); i++) {
            System.out.println((i + 1) + ". " + playerPokemons.get(i).getName());
        }
        int selectedPokemonIndex = scanner.nextInt();
        while (selectedPokemonIndex < 1 || selectedPokemonIndex > playerPokemons.size()) {
            System.out.println("Invalid selection! Please choose a valid Pokemon.");
            selectedPokemonIndex = scanner.nextInt();
        }
        player.setOriginalPokemonList(new ArrayList<>(player.getCharacter().getPokemonList()));

        player.getCharacter().setPokemonList(new ArrayList<>()); // Clear previous Pokemon list
        characterService.addPokemonToCharacter(playerPokemons.get(selectedPokemonIndex - 1), player.getCharacter());
        playerPokemons.get(selectedPokemonIndex - 1).setSelected(true);
    }

    public void reselectPokemonsForBothPlayers(Player playerOne, Player playerTwo,
                                               ArrayList<Pokemon> pokemons) {
        System.out.println("Both players, please select your Pokémon to fight from the updated list:");

        reselectPokemons(playerOne, pokemons);
        reselectPokemons(playerTwo, pokemons);
    }

    private void reselectPokemons(Player player, ArrayList<Pokemon> pokemons) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getName() + ", please select your Pokémon to fight from the updated list:");
        pokemonService.getPokemons(player.getOriginalPokemonList());
        int selectedPokemonIndex = scanner.nextInt();
        while (selectedPokemonIndex < 1 || selectedPokemonIndex > player.getOriginalPokemonList().size()) {
            System.out.println("Invalid selection! Please choose a valid Pokémon.");
            selectedPokemonIndex = scanner.nextInt();
        }

        // Clear previous Pokémon list and add the selected Pokémon
        player.getCharacter().setPokemonList(new ArrayList<>());
        characterService.addPokemonToCharacter(player.getOriginalPokemonList().get(selectedPokemonIndex - 1), player.getCharacter());
        player.getOriginalPokemonList().get(selectedPokemonIndex - 1).setSelected(true);
    }

}
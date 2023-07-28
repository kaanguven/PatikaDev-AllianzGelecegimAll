package service;

import model.Player;
import model.WeatherEnum;
import model.BaseCharacter;
import model.Pokemon;

import java.util.ArrayList;

public class CharacterService{

    WeatherService weatherService = new WeatherService();
    PokemonService pokemonService = new PokemonService();

    public void addPokemonToCharacter(Pokemon pokemon, BaseCharacter character) {
        if (character.getPokemonList() != null) {
            character.getPokemonList().add(pokemon);
        } else {
            ArrayList<Pokemon> pokemonList = new ArrayList<>();
            pokemonList.add(pokemon);
            character.setPokemonList(pokemonList);
        }
    }


    public int calculateDamage(Player player, WeatherEnum weatherEnum, boolean isSpecialPower) {
        BaseCharacter character = player.getCharacter();
        Pokemon pokemon = character.getPokemonList().get(0);
        for (Pokemon pokemonn : character.getPokemonList()) {
            if (pokemonn.getDamage() > pokemon.getDamage()) {
                pokemon = pokemonn;
            }
        }
        if (isSpecialPower) {
            if (checkRemainingRights(player)){
                return character.getSpecialPower().getExtraDamage() + pokemon.getDamage() +
                        weatherService.checkWeatherBuffOrDebuff(weatherEnum, pokemon);
            } else
                return 0;
        }
        else
            return pokemon.getDamage() + weatherService.checkWeatherBuffOrDebuff(weatherEnum, pokemon);
    }


    public void specialPowerPenalty(Player player) {
        BaseCharacter character = player.getCharacter();
        if (character.getSpecialPower().getRemainingRights() == 0) {
            int damage = (int) (Math.random() * 5);
            System.out.println("No Rights left ! You will get" + damage + " damage.");
            pokemonService.takeDamage(player, damage);
        }
    }


    public boolean checkRemainingRights(Player player) {
        BaseCharacter character = player.getCharacter();
        int remainingRights = character.getSpecialPower().getRemainingRights();
        if (remainingRights > 0) {
            character.getSpecialPower().setRemainingRights(remainingRights - 1);
            return true;
        } else {
            specialPowerPenalty(player);
            return false;
        }
    }

    public void showCharacters(ArrayList<BaseCharacter> characters) {
        for (int i = 0; i < characters.size(); i++) {
            System.out.println(i + 1 + ". " + characters.get(i).getName());
        }
    }
}

package service;

import model.Player;
import model.WeatherEnum;
import model.Pokemon;

import java.util.ArrayList;

public class PokemonService  {
    WeatherService weatherService = new WeatherService();

    public int calculateDamage(Player player, WeatherEnum weatherEnum, boolean isSpecialPower) {
        Pokemon pokemon = player.getCharacter().getPokemonList().get(0);
        for (Pokemon poke : player.getCharacter().getPokemonList()) {
            if (poke.isPlaying()) {
                pokemon = poke;
                break;
            }
        }
        if (isSpecialPower) {
            if (checkRemainingRights(player)){
                return pokemon.getPower().getExtraDamage() + pokemon.getDamage() +
                        weatherService.checkWeatherBuffOrDebuff(weatherEnum, pokemon);
            } else
                return 0;
        }
        else
            return pokemon.getDamage() + weatherService.checkWeatherBuffOrDebuff(weatherEnum, pokemon);
    }


    public void specialPowerPenalty(Player player) {
        Pokemon pokemon = player.getCharacter().getPokemonList().get(0);
        if (pokemon.getPower().getRemainingRights() == 0) {
            int damage = (int) (Math.random() * 10);
            System.out.println("No Rights left ! You will get" + damage + " damage.");
            takeDamage(player, damage);
        }
    }


    public boolean checkRemainingRights(Player player) {
        Pokemon pokemon = player.getCharacter().getPokemonList().get(0);
        int remainingRights = pokemon.getPower().getRemainingRights();
        if (remainingRights > 0) {
            pokemon.getPower().setRemainingRights(remainingRights - 1);
            return true;
        } else {
            specialPowerPenalty(player);
            return false;
        }
    }

    public void takeDamage(Player player, int damage) {
        Pokemon pokemon = player.getCharacter().getPokemonList().get(0);
        pokemon.setHealth(pokemon.getHealth() - damage);
    }



    public void addWeakestPokemonToLoser(Player loser, Player winner) {
        ArrayList<Pokemon> loserOriginalPokemonList = loser.getOriginalPokemonList();
        ArrayList<Pokemon> winnerOriginalPokemonList = winner.getOriginalPokemonList();

        Pokemon weakestPokemon = null;
        int minDamage = Integer.MAX_VALUE;
        for (Pokemon pokemon : loserOriginalPokemonList) {
            int pokemonDamage = pokemon.getDamage();
            if (pokemonDamage < minDamage) {
                minDamage = pokemonDamage;
                weakestPokemon = pokemon;
            }
        }

        if (weakestPokemon != null) {
            loserOriginalPokemonList.remove(weakestPokemon);
            System.out.println(weakestPokemon.getName() + " has fainted and is removed from " + loser.getName() + "'s team!");
            winnerOriginalPokemonList.add(weakestPokemon);
            System.out.println("The weakest pokemon that belongs to the loser "+weakestPokemon.getName() +
                    " is transferred from " + loser.getName() + " to " + winner.getName() + "'s team!");
        }


    }




    public void getPokemons(ArrayList<Pokemon> pokemons){
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println(i + 1 +". " + pokemons.get(i).getName());
        }
    }
}

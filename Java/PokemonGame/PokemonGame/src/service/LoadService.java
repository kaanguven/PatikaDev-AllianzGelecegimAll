package service;

import model.*;


import java.util.ArrayList;

public class LoadService {

    public ArrayList<BaseCharacter> loadCharacters() {
        ArrayList<BaseCharacter> characters = new ArrayList<>();
        BaseCharacter ash = new Ash();
        BaseCharacter brock = new Brock();
        BaseCharacter james = new James();
        BaseCharacter lucas = new Lucas();

        characters.add(ash);
        characters.add(brock);
        characters.add(james);
        characters.add(lucas);

        return characters;
    }


    public ArrayList<Pokemon> loadPokemons() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        Pokemon pikachu = new Pikachu();
        Pokemon charizard = new Charizard();
        Pokemon pidgey = new Spearow();
        Pokemon bulbasaur = new Bulbasaur();
        Pokemon sandslash = new Sandslash();
        Pokemon squirtle = new Squirtle();

        pokemons.add(pikachu);
        pokemons.add(charizard);
        pokemons.add(pidgey);
        pokemons.add(bulbasaur);
        pokemons.add(sandslash);
        pokemons.add(squirtle);

        return pokemons;
    }


}
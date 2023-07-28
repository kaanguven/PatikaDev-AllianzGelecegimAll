package model;

import java.util.ArrayList;

public class Player {
    private String name;
    private BaseCharacter character;
    private boolean isWinner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseCharacter getCharacter() {
        return character;
    }

    public void setCharacter(BaseCharacter character) {
        this.character = character;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    private ArrayList<Pokemon> originalPokemonList;

    public ArrayList<Pokemon> getOriginalPokemonList() {
        return originalPokemonList;
    }

    public void setOriginalPokemonList(ArrayList<Pokemon> originalPokemonList) {
        this.originalPokemonList = originalPokemonList;
    }


}

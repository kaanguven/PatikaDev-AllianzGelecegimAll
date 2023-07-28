package model;

import java.util.ArrayList;


public class BaseCharacter {
    private String name;
    private CharPower charPower;
    private boolean isSelected = false;
    private ArrayList<Pokemon> pokemonList;


    public BaseCharacter(String name, CharPower charPower) {
        this.name = name;
        this.charPower = charPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Power getSpecialPower() {
        return charPower;
    }

    public void setSpecialPower(CharPower specialPower) {
        this.charPower = specialPower;
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return "BaseCharacter{" +
                "name='" + name + '\'' +
                ", specialPower=" + charPower +
                ", pokemonList=" + pokemonList +
                '}';
    }
}

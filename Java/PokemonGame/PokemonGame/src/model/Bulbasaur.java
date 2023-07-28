package model;

import model.ElementEnum;


public class Bulbasaur extends Pokemon{
    public Bulbasaur() {
        super("Bulbasaur", 100, 10,ElementEnum.GRASS,
                new Grass("Grass", 13, 1),100);
    }
}

package model;

import model.ElementEnum;

public class Squirtle extends Pokemon{
    public Squirtle() {
        super("Squirtle", 100, 11, ElementEnum.WATER,
                new Water("Water", 17, 1),100);
    }
}

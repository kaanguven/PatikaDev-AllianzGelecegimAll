package model;

import model.ElementEnum;

public class Charizard extends Pokemon{
    public Charizard() {
        super("Charizard", 100, 13, ElementEnum.FIRE,
                new Fire("Fire", 18, 1),100);
    }
}

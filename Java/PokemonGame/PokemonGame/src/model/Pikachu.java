package model;

import model.ElementEnum;

public class Pikachu extends Pokemon{
    public Pikachu() {
        super("Pikachu", 100, 15, ElementEnum.ELECTRICITY,
                new Electricity("Electricity", 20, 1),100);
    }
}

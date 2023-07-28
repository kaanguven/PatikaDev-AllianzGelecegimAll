package model;

import model.ElementEnum;



public class Sandslash extends Pokemon{
    public Sandslash() {
        super("Sandslash", 100, 10, ElementEnum.EARTH,
                new Earth("Earth", 10, 1),100);
    }
}

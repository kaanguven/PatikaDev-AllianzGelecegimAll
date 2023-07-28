package model;

import model.ElementEnum;


public class Pokemon {
    private String name;
    private int health;
    private int damage;
    private ElementEnum element;
    private Power power;

    private int maxHealth;
    private boolean isSelected = false;
    private boolean isPlaying = false;

    public Pokemon(String name, int health, int damage, ElementEnum element, Power power,int maxHealth) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.element = element;
        this.power = power;
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }


    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public ElementEnum getElement() {
        return element;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", element=" + element +
                ", power=" + power +
                '}';
    }
}

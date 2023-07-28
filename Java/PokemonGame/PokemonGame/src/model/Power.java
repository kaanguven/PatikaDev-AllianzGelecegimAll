package model;

public class Power {
    private String name;
    private int extraDamage;
    private int remainingRights;

    public Power(String name, int extraDamage, int remainingRights) {
        this.name = name;
        this.extraDamage = extraDamage;
        this.remainingRights = remainingRights;
    }

    public String getName() {
        return name;
    }

    public int getExtraDamage() {
        return extraDamage;
    }

    public int getRemainingRights() {
        return remainingRights;
    }

    public void setRemainingRights(int remainingRights) {
        this.remainingRights = remainingRights;
    }

    @Override
    public String toString() {
        return "Power{" +
                "name='" + name + '\'' +
                ", extraDamage=" + extraDamage +
                ", remainingRights=" + remainingRights +
                '}';
    }
}

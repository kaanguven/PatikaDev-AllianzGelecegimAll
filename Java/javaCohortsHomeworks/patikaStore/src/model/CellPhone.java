package model;

public class CellPhone extends Product {
    private String memory;
    private String screenSize;
    private int batteryPower;
    private int ram;
    private String color;

    public CellPhone(int id, double unitPrice, double discountRate, int stock, String name,
                     Brand brand, String memory, String screenSize, int batteryPower, int ram, String color) {
        super(id, unitPrice, discountRate, stock, name, brand);
        this.memory = memory;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cep Telefonu - " + super.toString() +
                String.format(" - %s GB - %s Inc - %d mAh - %d MB - %s", memory, screenSize, batteryPower, ram, color);
    }
}

package model;

public class Notebook extends Product {
    private int ram;
    private String storage;
    private String screenSize;

    public Notebook(int id, double unitPrice, double discountRate, int stock, String name,
                    Brand brand, int ram, String storage, String screenSize) {
        super(id, unitPrice, discountRate, stock, name, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "Notebook - " + super.toString() +
                String.format(" - %d GB RAM - %s SSD - %s Inc", ram, storage, screenSize);
    }
}

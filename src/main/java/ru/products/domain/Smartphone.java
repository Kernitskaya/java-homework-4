package ru.products.domain;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public boolean matches(String searchBy) {
        return super.matches(searchBy) || getManufacturer().equalsIgnoreCase(searchBy);
    }
}

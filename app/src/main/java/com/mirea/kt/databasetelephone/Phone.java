package com.mirea.kt.databasetelephone;

public class Phone {
    private String model;
    private String serialNumber;
    private int price;

    public Phone(String model, String serialNumber, int price) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getPrice() {
        return price;
    }
}

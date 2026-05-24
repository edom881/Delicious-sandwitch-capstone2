package com.pluralsight.models;

public class Chips {

    // stores chip type selected by customer
    private String type;

    // stores chips price
    private double price;

    // constructor used to create chips object
    public Chips(String type) {
        this.type = type;
        this.price = 1.50;
    }
    // returns formatted chips information
    public String getSummary() {
        return type + " chips - $" + String.format("%.2f", price);
    }

    // returns chips price
    public double getPrice() {
        return price;
    }
}


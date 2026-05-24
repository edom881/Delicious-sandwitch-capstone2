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
}


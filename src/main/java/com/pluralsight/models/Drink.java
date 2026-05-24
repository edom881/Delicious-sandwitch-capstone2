package com.pluralsight.models;

public class Drink {
    // stores drink flavor
    private String flavor;

    // stores drink size
    private String size;

    // stores drink price
    private double price;

    // constructor used to create drink object
    public Drink(String flavor, String size) {

        this.flavor = flavor;
        this.size = size;

        // sets drink price based on size
        if (size.equalsIgnoreCase("small")) {
            price = 2.00;
        }
        else if (size.equalsIgnoreCase("medium")) {
            price = 2.50;
        }
        else if (size.equalsIgnoreCase("large")) {
            price = 3.00;
        }
    }
}

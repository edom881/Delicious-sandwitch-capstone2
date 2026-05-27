package com.pluralsight.models;
public class BLT extends Sandwich {
    // creates a default BLT sandwich
    public BLT() {

        super("white", 8, true);

        addMeat("bacon", false);

        addCheese("cheddar", false);

        addTopping("lettuce");
        addTopping("tomatoes");

        addSauce("ranch");


    }



}

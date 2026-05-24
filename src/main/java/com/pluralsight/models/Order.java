package com.pluralsight.models;

import java.util.ArrayList;

public class Order {

    // stores all sandwiches in the order
    private ArrayList<Sandwich> sandwiches;

    // stores all drinks in the order
    private ArrayList<Drink> drinks;

    // stores all chips in the order
    private ArrayList<Chips> chips;

    // constructor initializes order collections
    public Order() {

        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

}



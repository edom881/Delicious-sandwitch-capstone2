package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich {
    private String bread;
    private int size;
    private boolean toasted;

    private ArrayList<String> meats;
    private ArrayList<String> cheeses;
    private ArrayList<String> toppings;
    private ArrayList<String> sauces;

    public Sandwich(String bread, int size, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
    }

    public String getSummary() {
        return size + "\" " + bread + " sandwich" +
                (toasted ? " toasted" : " not toasted");
    }

}

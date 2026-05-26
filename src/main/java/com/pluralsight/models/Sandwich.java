package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich {
    // stores bread type selected by customer
    private String bread;

    // stores sandwich size (4, 8, or 12 inches)
    private int size;

    // stores toasted option
    private boolean toasted;

    // stores premium meat toppings
    private ArrayList<String> meats;

    // stores premium cheese toppings
    private ArrayList<String> cheeses;

    // stores regular toppings
    private ArrayList<String> toppings;

    // stores sauces selected by customer
    private ArrayList<String> sauces;

    // stores total sandwich price
    private double price;

    // constructor used to create a sandwich object
    public Sandwich(String bread, int size, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;



        // initialize ArrayLists for sandwich ingredients
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();


        // sets base sandwich price based on size
        if (size == 4) {
            price = 5.50;
        }
        else if (size == 8) {
            price = 7.00;
        }
        else if (size == 12) {
            price = 8.50;
        }
    }
    // adds meat to sandwich
    public void addMeat(String meat, boolean extra ) {

        meats.add(meat);
        // regular meat pricing
        if (size == 4) {
            price += 1.00;

            // extra meat pricing
            if (extra) {
                price += 0.50;
            }
        }

        else if (size == 8) {
            price += 2.00;

            if (extra) {
                price += 1.00;
            }
        }

        else if (size == 12) {
            price += 3.00;

            if (extra) {
                price += 1.50;
            }
        }

        // adds meat price based on sandwich size
        if (size == 4) {
            price += 1.00;
        }
        else if (size == 8) {
            price += 2.00;
        }
        else if (size == 12) {
            price += 3.00;
        }
    }

    // adds cheese to sandwich
    public void addCheese(String cheese, boolean extra) {
        cheeses.add(cheese);



        // adds cheese price based on sandwich size
        if (size == 4) {
            price += 0.75;
        }
        else if (size == 8) {
            price += 1.50;
        }
        else if (size == 12) {
            price += 2.25;
        }
        // regular cheese pricing
        if (size == 4) {
            price += 0.75;

            // extra cheese pricing
            if (extra) {
                price += 0.30;
            }
        }

        else if (size == 8) {
            price += 1.50;

            if (extra) {
                price += 0.60;
            }
        }

        else if (size == 12) {
            price += 2.25;

            if (extra) {
                price += 0.90;
            }
        }
    }
    // adds regular topping to sandwich
    public void addTopping(String topping) {
        toppings.add(topping);
    }
    // adds sauce to sandwich
    public void addSauce(String sauce) {
        sauces.add(sauce);
    }
    // returns formatted sandwich information
    public String getSummary() {

        return size + "\" " + bread + " sandwich\n" +
                "Toasted: " + toasted + "\n" +
                "Meats: " + meats + "\n" +
                "Cheeses: " + cheeses + "\n" +
                "Toppings: " + toppings + "\n" +
                "Sauces: " + sauces + "\n" +
                "Price: $" + String.format("%.2f", price);

    }
    // returns sandwich total price
    public double getPrice() {
        return price;
    }

    }




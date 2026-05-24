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
    // adds sandwich to order
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    // adds drink to order
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    // adds chips to order
    public void addChips(Chips chip) {
        chips.add(chip);
    }
    // calculates full order total
    public double getTotal() {

        double total = 0;

        // adds sandwich prices
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }

        // adds drink prices
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }

        // adds chips prices
        for (Chips chip : chips) {
            total += chip.getPrice();
        }

        return total;
    }
    // returns full formatted order summary
    public String getOrderSummary() {

        String summary = "===== ORDER SUMMARY =====\n";

        // display sandwiches
        for (Sandwich sandwich : sandwiches) {
            summary += sandwich.getSummary() + "\n\n";
        }

        // display drinks
        for (Drink drink : drinks) {
            summary += drink.getSummary() + "\n";
        }

        // display chips
        for (Chips chip : chips) {
            summary += chip.getSummary() + "\n";
        }

        summary += "\nTotal Price: $" +
                String.format("%.2f", getTotal());

        return summary;
    }


}



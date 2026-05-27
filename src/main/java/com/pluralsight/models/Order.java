package com.pluralsight.models;

import java.util.ArrayList;

public class Order {

    // stores all order items
    private ArrayList<OrderItem> items;

    // constructor initializes order collections
    public Order() {

        this.items = new ArrayList<>();
    }

    // adds item to order
    public void addItem(OrderItem item) {
        items.add(item);
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



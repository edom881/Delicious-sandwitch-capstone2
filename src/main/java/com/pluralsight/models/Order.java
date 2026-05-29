package com.pluralsight.models;

import java.util.ArrayList;

// Represents a single customer order composed of multiple OrderItem entries.
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
        for (OrderItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // returns full formatted order summary
    public String getOrderSummary() {
        String summary = "";
        for (OrderItem item : items) {
            summary += item.getSummary() + "\n";
        }
        summary += "\nTotal Price: $" +
                String.format("%.2f", getTotal());
        return summary;
    }

}



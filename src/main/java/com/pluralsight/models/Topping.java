package com.pluralsight.models;

public class Topping {
    // stores topping name
    private String name;

    // stores topping category: meat, cheese, regular, sauce
    private String category;

    // stores if the topping is extra
    private boolean extra;

    // constructor creates a topping object
    public Topping(String name, String category, boolean extra) {
        this.name = name;
        this.category = category;
        this.extra = extra;
    }

    // returns topping name
    public String getName() {
        return name;
    }

    // returns topping category
    public String getCategory() {
        return category;
    }

    // returns true if topping is extra
    public boolean isExtra() {
        return extra;
    }

    // returns formatted topping details
    public String getSummary() {
        return name + " (" + category + ")" + (extra ? " extra" : "");
    }
}

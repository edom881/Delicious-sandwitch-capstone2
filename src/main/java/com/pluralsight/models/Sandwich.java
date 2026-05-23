package com.pluralsight.models;

public class Sandwich {
    private String bread;
    private int size;
    private boolean toasted;

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

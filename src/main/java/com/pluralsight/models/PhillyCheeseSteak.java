package com.pluralsight.models;

public class PhillyCheeseSteak extends Sandwich {
    // creates a default Philly Cheesesteak sandwich
    public PhillyCheeseSteak() {

        super("white", 8, true);

        addMeat("steak", false);

        addCheese("american", false);

        addTopping("peppers");
        addTopping("mushrooms");

        addSauce("mayo");
    }


}

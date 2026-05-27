package com.pluralsight.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SandwichTest {
    @Test
    public void getSandwichPrice_shouldCalculateCorrectPrice() {
        // arrange
        Sandwich sandwich = new Sandwich("white", 8, true);
        sandwich.addMeat("bacon", true);
        sandwich.addCheese("cheddar", true);
        // act
        double price = sandwich.getPrice();
        // assert
        assertEquals(12.10, price, 0.01);
    }

    }


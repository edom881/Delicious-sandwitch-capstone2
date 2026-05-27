package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {
    @Test
    public void getDrinkPrice_shouldCalculateCorrectPrice() {
        // arrange
        Drink drink = new Drink("coke", "medium");
        // act
        double price = drink.getPrice();
        // assert
        assertEquals(2.50, price, 0.01);
    }

}
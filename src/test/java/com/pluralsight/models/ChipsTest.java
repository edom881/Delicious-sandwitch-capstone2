package com.pluralsight.models;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ChipsTest {
    @Test
    public void getChipsPrice_shouldReturnCorrectPrice() {
        // arrange
        Chips chips = new Chips("bbq");
        // act
        double price = chips.getPrice();
        // assert
        assertEquals(1.50, price, 0.01);
    }

}
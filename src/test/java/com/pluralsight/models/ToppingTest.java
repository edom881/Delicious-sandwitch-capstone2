package com.pluralsight.models;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToppingTest {
    @Test
    public void topping_shouldStoreCorrectValues() {

        // arrange
        Topping topping = new Topping("jalapenos", "regular", true);

        // act
        String name = topping.getName();

        // assert
        assertEquals("jalapenos", name);
        assertTrue(topping.isExtra());
    }

}
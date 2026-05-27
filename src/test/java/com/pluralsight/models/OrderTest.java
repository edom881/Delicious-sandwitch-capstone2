package com.pluralsight.models;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class OrderTest {
    @Test
    public void getTotal_shouldCalculateCorrectOrderTotal() {
        // arrange
        Order order = new Order();
        Sandwich sandwich = new Sandwich("white", 8, true);
        sandwich.addMeat("bacon", true);
        Drink drink = new Drink("coke", "medium");
        Chips chips = new Chips("bbq");
        order.addItem(sandwich);
        order.addItem(drink);
        order.addItem(chips);
        // act
        double total = order.getTotal();
        // assert
        assertEquals(14.00, total, 0.01);
    }
    @Test
    public void getOrderSummary_shouldContainDrinkName() {
        // arrange
        Order order = new Order();
        Drink drink = new Drink("coke", "medium");
        order.addItem(drink);
        // act
        String summary = order.getOrderSummary();
        // assert
        assertTrue(summary.contains("coke"));
    }

}
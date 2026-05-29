package com.pluralsight.ui;

import com.pluralsight.models.BLT;
import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.PhillyCheeseSteak;
import com.pluralsight.models.Sandwich;
import com.pluralsight.util.InputValidator;
import com.pluralsight.util.ReceiptWriter;
import com.pluralsight.util.UIDecorator;

import java.util.Scanner;

// Console-based user interface: displays menus and builds orders.
public class UserInterface {

    // Input helper that centralizes validation and prompts.
    private final InputValidator input;

    // Construct a UI with a new Scanner and InputValidator.
    public UserInterface() {
        Scanner scanner = new Scanner(System.in);
        this.input = new InputValidator(scanner);
    }

    // Start the main application loop (home menu -> orders).
    public void start() {
        UIDecorator.printWelcomeBanner();

        boolean running = true;
        while (running) {
            int choice = showHomeScreen();
            switch (choice) {
                case 1:
                    showOrderScreen();
                    break;
                case 0:
                    UIDecorator.printGoodbye();
                    running = false;
                    break;
            }
        }
    }

    // Display the home menu and return the chosen option.
    public int showHomeScreen() {
        UIDecorator.printTitle("DELI-cious Sandwich Shop");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        return input.getInt("Enter choice: ", 0, 1);
    }

    // Run the order screen loop for creating a single Order.
    public void showOrderScreen() {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            int orderChoice = showOrderMenu();
            switch (orderChoice) {
                case 1:
                    addSandwich(order);
                    break;
                case 2:
                    addDrink(order);
                    break;
                case 3:
                    addChips(order);
                    break;
                case 4:
                    checkout(order);
                    ordering = false;
                    break;
                case 0:
                    ordering = false;
                    UIDecorator.printInfo("Order canceled. Returning home.");
                    break;
            }
        }
    }

    // Display the order menu and return the selected choice.
    private int showOrderMenu() {
        UIDecorator.printSection("Order Screen");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        return input.getInt("Enter choice: ", 0, 4);
    }

    // Add a sandwich to the given Order (custom or signature).
    private void addSandwich(Order order) {
        UIDecorator.printSection("Sandwich Menu");
        System.out.println("1) Custom Sandwich");
        System.out.println("2) BLT");
        System.out.println("3) Philly Cheesesteak");
        int sandwichChoice = input.getInt("Choose sandwich type: ", 1, 3);

        if (sandwichChoice == 2) {
            BLT blt = new BLT();
            order.addItem(blt);
            UIDecorator.printSuccess("BLT added to order.");
            return;
        }

        if (sandwichChoice == 3) {
            PhillyCheeseSteak philly = new PhillyCheeseSteak();
            order.addItem(philly);
            UIDecorator.printSuccess("Philly Cheesesteak added to order.");
            return;
        }

        Sandwich sandwich = buildCustomSandwich();
        order.addItem(sandwich);
        UIDecorator.printSuccess("Sandwich added to order.");
    }

    // Build and return a custom Sandwich by prompting the user.
    private Sandwich buildCustomSandwich() {
        UIDecorator.printSection("Build Custom Sandwich");
        String bread = input.getLine("Enter bread type (white, wheat, rye, wrap): ");
        int sandwichSize = getSandwichSize();
        boolean toasted = input.getYesNo("Would you like it toasted?");

        Sandwich sandwich = new Sandwich(bread, sandwichSize, toasted);

        UIDecorator.printInfo("Add meats one at a time. Type done when finished.");
        while (true) {
            String meat = input.getLine("Enter meat (steak, ham, salami, roast beef, chicken, bacon): ");
            if (meat.equalsIgnoreCase("done")) {
                break;
            }
            boolean extraMeat = input.getYesNo("Would you like extra meat?");
            sandwich.addMeat(meat, extraMeat);
        }

        UIDecorator.printInfo("Add cheeses one at a time. Type done when finished.");
        while (true) {
            String cheese = input.getLine("Enter cheese (american, provolone, cheddar, swiss): ");
            if (cheese.equalsIgnoreCase("done")) {
                break;
            }
            boolean extraCheese = input.getYesNo("Would you like extra cheese?");
            sandwich.addCheese(cheese, extraCheese);
        }

        UIDecorator.printInfo("Add regular toppings one at a time. Type done when finished.");
        while (true) {
            String topping = input.getLine("Enter topping (lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms): ");
            if (topping.equalsIgnoreCase("done")) {
                break;
            }
            sandwich.addTopping(topping);
        }

        UIDecorator.printInfo("Add sauces one at a time. Type done when finished.");
        while (true) {
            String sauce = input.getLine("Enter sauce (mayo, mustard, ketchup, ranch, thousand islands, vinaigrette): ");
            if (sauce.equalsIgnoreCase("done")) {
                break;
            }
            sandwich.addSauce(sauce);
        }

        return sandwich;
    }

    // Prompt for and validate sandwich size (4, 8, 12 inches).
    private int getSandwichSize() {
        int sandwichSize = 0;
        while (sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12) {
            String sizeText = input.getLine("Enter sandwich size (4, 8, 12): ");
            try {
                sandwichSize = Integer.parseInt(sizeText);
                if (sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12) {
                    UIDecorator.printError("Invalid size. Please enter 4, 8, or 12.");
                }
            } catch (NumberFormatException e) {
                UIDecorator.printError("Invalid input. Please enter a number.");
            }
        }
        return sandwichSize;
    }

    // Prompt for drink details and add to the Order.
    private void addDrink(Order order) {
        UIDecorator.printSection("Add Drink");
        String flavor = input.getLine("Enter drink flavor: ");
        String size = input.getLine("Enter drink size (small, medium, large): ");

        Drink drink = new Drink(flavor, size);
        order.addItem(drink);
        UIDecorator.printSuccess("Drink added to order.");
    }

    // Prompt for chips type and add to the Order.
    private void addChips(Order order) {
        UIDecorator.printSection("Add Chips");
        String chipType = input.getLine("Enter chip type: ");

        Chips chips = new Chips(chipType);
        order.addItem(chips);
        UIDecorator.printSuccess("Chips added to order.");
    }

    // Show order summary and handle confirm/cancel checkout.
    private void checkout(Order order) {
        UIDecorator.printSection("Checkout");
        UIDecorator.printInfo("Order Summary:");
        UIDecorator.printSeparator();
        System.out.println(order.getOrderSummary());
        UIDecorator.printSeparator();

        UIDecorator.printMenuOption(1, "Confirm");
        UIDecorator.printMenuOption(0, "Cancel");
        int checkoutChoice = input.getInt("Enter choice: ", 0, 1);

        if (checkoutChoice == 1) {
            ReceiptWriter.saveReceipt(order);
            UIDecorator.printSuccess("Order confirmed!");
        } else {
            UIDecorator.printInfo("Returning to order screen.");
        }
    }
}

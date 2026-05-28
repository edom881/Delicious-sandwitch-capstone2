package com.pluralsight;

import com.pluralsight.models.Order;
import com.pluralsight.models.Drink;
import com.pluralsight.models.BLT;
import com.pluralsight.models.PhillyCheeseSteak;

import java.util.Scanner;


import com.pluralsight.models.Chips;
import com.pluralsight.models.Sandwich;
import com.pluralsight.util.ReceiptWriter;
import com.pluralsight.util.UIDecorator;
import com.pluralsight.ui.UserInterface;

public class Application {

    static Scanner scanner = new Scanner(System.in);
    static UserInterface ui = new UserInterface();

    public static void main(String[] args) {
        UIDecorator.printWelcomeBanner();
        boolean running = true;

        while (running) {

            String choice;

            while (true) {

                choice = ui.showHomeScreen();

                if (choice.equals("1") || choice.equals("0")) {
                    break;
                }

                UIDecorator.printError("Invalid menu option. Please try again.");
            }

            switch (choice) {

                case "1":
                    showOrderScreen();
                    break;


                case "0":
                    running = false;
                    UIDecorator.printGoodbye();
                    break;

                default:
                    UIDecorator.printError("Invalid choice. Try again.");
            }
        }

    }

    public static void showOrderScreen() {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {


            String orderChoice;

            while (true) {

                orderChoice = ui.showOrderScreen();

                if (orderChoice.equals("1") ||
                        orderChoice.equals("2") ||
                        orderChoice.equals("3") ||
                        orderChoice.equals("4") ||
                        orderChoice.equals("0")) {

                    break;
                }

                UIDecorator.printError("Invalid order menu option. Please try again.");
            }
            switch (orderChoice) {

                case "1":
                    UIDecorator.printSection("Sandwich Menu");
                    System.out.println("1) Custom Sandwich");
                    System.out.println("2) BLT");
                    System.out.println("3) Philly Cheesesteak");
                    UIDecorator.prompt("Choose sandwich type: ");
                    String sandwichChoice = scanner.nextLine();
                    if (sandwichChoice.equals("2")) {

                        BLT blt = new BLT();

                        order.addItem(blt);

                        UIDecorator.printSuccess("BLT added to order.");

                        break;
                    } else if (sandwichChoice.equals("3")) {

                        PhillyCheeseSteak philly = new PhillyCheeseSteak();

                        order.addItem(philly);

                        UIDecorator.printSuccess("Philly Cheesesteak added to order.");

                        break;
                    }


                    UIDecorator.prompt("Enter bread type (white, wheat, rye, wrap): ");
                    String bread = scanner.nextLine();

                    int sandwichSize = 0;

                    while (sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12) {

                        UIDecorator.prompt("Enter sandwich size (4, 8, 12): ");

                        try {

                            sandwichSize = Integer.parseInt(scanner.nextLine());

                            if (sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12) {
                                UIDecorator.printError("Invalid size. Please enter 4, 8, or 12.");
                            }


                        } catch (NumberFormatException e) {

                            UIDecorator.printError("Invalid input. Please enter a number.");
                        }
                    }
                    UIDecorator.prompt("Would you like it toasted? (yes/no): ");
                    String toastedAnswer = scanner.nextLine();

                    boolean toasted = toastedAnswer.equalsIgnoreCase("yes");

                    Sandwich sandwich = new Sandwich(bread, sandwichSize, toasted);

                    UIDecorator.printInfo("Add meats one at a time. Type done when finished.");

                    while (true) {
                        UIDecorator.prompt("Enter meat (steak, ham, salami, roast beef, chicken, bacon): ");
                        String meat = scanner.nextLine();

                        if (meat.equalsIgnoreCase("done")) {
                            break;
                        }
                        UIDecorator.prompt("Would you like extra meat? (yes/no): ");
                        String extraMeatAnswer = scanner.nextLine();

                        boolean extraMeat = extraMeatAnswer.equalsIgnoreCase("yes");

                        sandwich.addMeat(meat, extraMeat);

                    }


                    UIDecorator.printInfo("Add cheeses one at a time. Type done when finished.");
                    while (true) {
                        UIDecorator.prompt("Enter cheese (american, provolone, cheddar, swiss): ");
                        String cheese = scanner.nextLine();

                        if (cheese.equalsIgnoreCase("done")) {
                            break;
                        }

                        UIDecorator.prompt("Would you like extra cheese? (yes/no): ");
                        String extraCheeseAnswer = scanner.nextLine();

                        boolean extraCheese = extraCheeseAnswer.equalsIgnoreCase("yes");

                        sandwich.addCheese(cheese, extraCheese);


                    }

                    UIDecorator.printInfo("Add regular toppings one at a time. Type done when finished.");
                    while (true) {
                        UIDecorator.prompt("Enter topping (lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms): ");
                        String topping = scanner.nextLine();

                        if (topping.equalsIgnoreCase("done")) {
                            break;
                        }
                        sandwich.addTopping(topping);
                    }
                    UIDecorator.printInfo("Add sauces one at a time. Type done when finished.");

                    while (true) {
                        UIDecorator.prompt("Enter sauce (mayo, mustard, ketchup, ranch, thousand islands, vinaigrette): ");
                        String sauce = scanner.nextLine();

                        if (sauce.equalsIgnoreCase("done")) {
                            break;
                        }
                        sandwich.addSauce(sauce);

                    }
                    order.addItem(sandwich);

                    UIDecorator.printSuccess("Sandwich added to order.");


                    break;
                case "2":
                    UIDecorator.printSection("Add Drink");
                    UIDecorator.prompt("Enter drink flavor: ");
                    String flavor = scanner.nextLine();

                    UIDecorator.prompt("Enter drink size (small, medium, large): ");
                    String size = scanner.nextLine();

                    Drink drink = new Drink(flavor, size);
                    order.addItem(drink);

                    UIDecorator.printSuccess("Drink added to order.");
                    break;
                case "3":
                    UIDecorator.printSection("Add Chips");
                    UIDecorator.prompt("Enter chip type: ");
                    String chipType = scanner.nextLine();

                    Chips chips = new Chips(chipType);
                    order.addItem(chips);

                    UIDecorator.printSuccess("Chips added to order.");
                    break;
                case "4":
                    UIDecorator.printSection("Checkout");
                    UIDecorator.printInfo("Order Summary:");
                    UIDecorator.printSeparator();
                    System.out.println(order.getOrderSummary());
                    UIDecorator.printSeparator();

                    UIDecorator.printMenuOption(1, "Confirm");
                    UIDecorator.printMenuOption(0, "Cancel");

                    UIDecorator.prompt("Enter choice: ");
                    String checkoutChoice = scanner.nextLine();

                    if (checkoutChoice.equals("1")) {
                        ReceiptWriter.saveReceipt(order);
                        UIDecorator.printSuccess("Order confirmed!");
                        ordering = false;
                    } else {
                        UIDecorator.printInfo("Returning to order screen.");
                    }

                    break;
                case "0":
                    ordering = false;
                    UIDecorator.printInfo("Order canceled. Returning home.");
                    break;
                default:
                    UIDecorator.printError("Invalid choice. Try again.");
            }
        }
    }

}



package com.pluralsight;

import com.pluralsight.models.Order;
import com.pluralsight.models.Drink;
import java.util.Scanner;
import com.pluralsight.models.Chips;
import com.pluralsight.models.Sandwich;
import com.pluralsight.util.ReceiptWriter;
import com.pluralsight.ui.UserInterface;

public class Application {

    static Scanner scanner = new Scanner(System.in);
    static UserInterface ui = new UserInterface();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {

            String choice = ui.showHomeScreen();

            switch (choice) {

                case "1":
                    showOrderScreen();
                    break;


                case "0":
                    running = false;
                    System.out.println("Thank you for visiting DELI-cious!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

    }

    public static void showOrderScreen() {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {


            String orderChoice =  ui.showOrderScreen();

            switch (orderChoice) {

                case "1":
                    System.out.print("Enter bread type (white, wheat, rye, wrap): ");
                    String bread = scanner.nextLine();

                    System.out.print("Enter sandwich size (4, 8, 12): ");
                    int sandwichSize = Integer.parseInt(scanner.nextLine());

                    System.out.print("Would you like it toasted? (yes/no): ");
                    String toastedAnswer = scanner.nextLine();

                    boolean toasted = toastedAnswer.equalsIgnoreCase("yes");

                    Sandwich sandwich = new Sandwich(bread, sandwichSize, toasted);

                    order.addSandwich(sandwich);

                    System.out.println("Sandwich added to order.");
                    break;
                case "2":
                    System.out.print("Enter drink flavor: ");
                    String flavor = scanner.nextLine();

                    System.out.print("Enter drink size (small, medium, large): ");
                    String size = scanner.nextLine();

                    Drink drink = new Drink(flavor, size);
                    order.addDrink(drink);

                    System.out.println("Drink added to order.");
                    break;
                case "3":
                    System.out.print("Enter chip type: ");
                    String chipType = scanner.nextLine();

                    Chips chips = new Chips(chipType);
                    order.addChips(chips);

                    System.out.println("Chips added to order.");
                    break;
                case "4":
                    System.out.println("\n===== CHECKOUT =====");
                    System.out.println(order.getOrderSummary());

                    System.out.println("\n1) Confirm");
                    System.out.println("0) Cancel");

                    System.out.print("Enter choice: ");
                    String checkoutChoice = scanner.nextLine();

                    if (checkoutChoice.equals("1")) {

                        ReceiptWriter.saveReceipt(order);

                        System.out.println("Order confirmed!");

                        ordering = false;
                    }
                    else {

                        System.out.println("Returning to order screen.");
                    }

                    break;
                case "0":
                    ordering = false;
                    System.out.println("Order canceled. Returning home.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}



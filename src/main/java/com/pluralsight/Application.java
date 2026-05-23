package com.pluralsight;

import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {

            System.out.println("\n=== DELI-cious Sandwich Shop ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("showOrderScreen();");
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

        boolean ordering = true;

        while (ordering) {
            System.out.println("\n=== Order Screen ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Enter choice: ");

            String orderChoice = scanner.nextLine();

            switch (orderChoice) {
                case "1":
                    System.out.println("Add Sandwich selected.");
                    break;
                case "2":
                    System.out.println("Add Drink selected.");
                    break;
                case "3":
                    System.out.println("Add Chips selected.");
                    break;
                case "4":
                    System.out.println("Checkout selected.");
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



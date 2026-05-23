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
                    System.out.println("Starting new order...");
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

    }



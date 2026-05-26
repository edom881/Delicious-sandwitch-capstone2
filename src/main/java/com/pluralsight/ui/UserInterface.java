package com.pluralsight.ui;

import java.util.Scanner;

public class UserInterface {
    // scanner reads user input from the console
    private Scanner scanner;

    // constructor creates scanner object
    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    // displays home screen menu
    public String showHomeScreen() {

        System.out.println("\n=== DELI-cious Sandwich Shop ===");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Enter choice: ");

        return scanner.nextLine();
    }

    // displays order screen menu
    public String showOrderScreen() {

        System.out.println("\n=== Order Screen ===");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.print("Enter choice: ");

        return scanner.nextLine();
    }


}

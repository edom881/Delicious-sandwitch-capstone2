package com.pluralsight.ui;

import com.pluralsight.util.UIDecorator;
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

        UIDecorator.printTitle("DELI-cious Sandwich Shop");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        UIDecorator.prompt("Enter choice: ");

        return scanner.nextLine();
    }

    // displays order screen menu
    public String showOrderScreen() {

        UIDecorator.printSection("Order Screen");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        UIDecorator.prompt("Enter choice: ");

        return scanner.nextLine();
    }


}

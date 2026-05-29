package com.pluralsight.util;

public class UIDecorator {

    // ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BRIGHT_GREEN = "\u001B[92m";

    private UIDecorator() { }

    public static void printWelcomeBanner() {
        System.out.println();
        System.out.println(BRIGHT_GREEN + BOLD +
                "  ╔════════════════════════════════════════╗" + RESET);
        System.out.println(BRIGHT_GREEN + BOLD +
                "  ║                                        ║" + RESET);
        System.out.println(BRIGHT_GREEN + BOLD +
                "  ║       🥪  Delicious  🥪               ║" + RESET);
        System.out.println(BRIGHT_GREEN + BOLD +
                "  ║          Sandwich Shop                 ║" + RESET);
        System.out.println(BRIGHT_GREEN + BOLD +
                "  ║                                        ║" + RESET);
        System.out.println(BRIGHT_GREEN + BOLD +
                "  ╚════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    public static void printTitle(String title) {
        printSectionHeader(title);
    }

    public static void printSection(String title) {
        printSectionHeader(title);
    }

    public static void printGoodbye() {
        System.out.println();
        System.out.println(CYAN + BOLD +
                "  ╔════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + BOLD +
                "  ║   Thank you for visiting Delicious!   ║" + RESET);
        System.out.println(CYAN + BOLD +
                "  ║         See you next time! 👋          ║" + RESET);
        System.out.println(CYAN + BOLD +
                "  ╚════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    public static void printSectionHeader(String title) {
        System.out.println();
        System.out.println(BOLD + BLUE + "   ┌─ " + title.toUpperCase() + " ─┐" + RESET);
    }

    public static void printSubMenu(String title) {
        System.out.println(MAGENTA + "\n  ► " + title + RESET);
    }

    public static void prompt(String message) {
        System.out.print(message);
    }

    public static void printMenuOption(int number, String description) {
        System.out.println(CYAN + "  [" + number + "]" + RESET + " " + description);
    }

    public static void printSuccess(String message) {
        System.out.println(GREEN + "  ✓ " + message + RESET);
    }

    public static void printError(String message) {
        System.out.println(RED + "  ✗ " + message + RESET);
    }

    public static void printInfo(String message) {
        System.out.println(YELLOW + "  ℹ " + message + RESET);
    }

    public static void printPrice(String itemDesc, double price) {
        System.out.println(String.format(CYAN + "    %s" + RESET + " " + GREEN + "$%.2f" + RESET,
                itemDesc, price));
    }

    public static void printToppingDetail(String topping) {
        System.out.println(YELLOW + "      • " + topping + RESET);
    }

    public static void printSeparator() {
        System.out.println(BLUE + "  ────────────────────────────────────────" + RESET);
    }

    public static void printTotal(double total) {
        System.out.println();
        System.out.println(BOLD + GREEN + "  TOTAL: $" + String.format("%.2f", total) + RESET);
        System.out.println();
    }

    public static void clearScreen() {
        // Works on most terminals; if not supported, just print newlines
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }
}

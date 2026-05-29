package com.pluralsight.util;

import com.pluralsight.util.UIDecorator;
import java.util.Scanner;

// Lightweight input helper that centralizes prompts and validation.
public class InputValidator {

    private final Scanner scanner;

    // Initialize validator with an existing Scanner.
    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    // Read a trimmed line after showing the prompt.
    public String getLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    // Read an integer within [min,max], reprompting on invalid input.
    public int getInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    UIDecorator.printError("Input cannot be empty.");
                    continue;
                }
                int val = Integer.parseInt(input);
                if (val < min || val > max) {
                    UIDecorator.printError("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                UIDecorator.printError("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Prompt for a yes/no answer and return true for yes.
    public boolean getYesNo(String prompt) {
        while (true) {
            String input = getLine(prompt + " (yes/no): ").toLowerCase();
            if (input.equals("yes") || input.equals("y")) return true;
            if (input.equals("no") || input.equals("n")) return false;
            UIDecorator.printError("Please enter 'yes' or 'no'.");
        }
    }
}

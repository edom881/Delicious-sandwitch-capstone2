package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Simple helper to write an Order to a timestamped receipt file.
public class ReceiptWriter {

    private static final String RECEIPT_DIR = "src/main/resources/receipts/";

    // Saves a completed order to a receipt file with a header and footer.
    public static void saveReceipt(Order order) {

        StringBuilder receipt = new StringBuilder();

        String fileName = RECEIPT_DIR + generateFileName();

        try {
            receipt.append("========================================").append(System.lineSeparator());
            receipt.append("      Delicious Sandwich Shop").append(System.lineSeparator());
            receipt.append("========================================").append(System.lineSeparator()).append(System.lineSeparator());

            receipt.append(order.getOrderSummary()).append(System.lineSeparator());;

            receipt.append("========================================").append(System.lineSeparator());
            receipt.append("Thank you for your order!").append(System.lineSeparator());

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(receipt.toString());
            writer.close();

            System.out.println("Receipt saved: " + fileName);

        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }

    // Create a timestamped filename for receipts.
    private static String generateFileName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return LocalDateTime.now().format(formatter) + ".txt";
    }

}

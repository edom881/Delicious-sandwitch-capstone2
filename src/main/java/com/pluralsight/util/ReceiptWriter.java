package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReceiptWriter {
    // saves completed order to receipt file
    public static void saveReceipt(Order order) {

        String fileName = "receipts/" + generateFileName();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            writer.write(order.getOrderSummary());

            writer.close();

            System.out.println("Receipt saved: " + fileName);

        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }

    // creates receipt filename using current date and time
    private static String generateFileName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return LocalDateTime.now().format(formatter) + ".txt";
    }


}

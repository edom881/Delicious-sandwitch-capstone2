package com.pluralsight;

import com.pluralsight.ui.UserInterface;

// Application entry point. Creates and starts the user interface.
public class Application {

    // Program entry point — construct and launch the UI.
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}



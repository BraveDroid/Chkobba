package com.bravedroid;

import com.bravedroid.presentation.ConsoleUI;
import com.bravedroid.util.Logger;

import java.io.IOException;

public class Main {
   private static boolean isDebug = true;

    public static void main(String[] args) throws IOException {
        Logger logger = new Logger(isDebug);
        final ConsoleUI consoleUI = new ConsoleUI(logger);
        consoleUI.showGame();
    }
}

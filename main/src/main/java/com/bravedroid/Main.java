package com.bravedroid;

import com.bravedroid.presentation.ConsoleUI;
import com.bravedroid.util.Logger;

public class Main {
    private static boolean isDebug = true;

    public static void main(String[] args) {
        Logger logger = new Logger(isDebug);
        final ConsoleUI consoleUI = new ConsoleUI(logger);
        consoleUI.showGame();
    }
}

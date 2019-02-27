package com.bravedroid.presentation;

import com.bravedroid.domain.Card;
import com.bravedroid.application.Game;
import com.bravedroid.application.HumanUI;
import com.bravedroid.util.Logger;

import java.io.IOException;

public class ConsoleUI implements HumanUI {
    private Logger logger;

    public ConsoleUI(Logger logger) {
        this.logger = logger;
    }

    public void showGame() {
        Game.getInstance(logger, this).start();
    }

    @Override
    public boolean acceptFirstCard(Card firstCard) {
        ReaderCmd readerCmd = new ReaderCmd();
        String input;
        try {
            input = readerCmd.readInput("would you accept this card : " + firstCard.toString() + " ?");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (input.equals("yes")) {
            return true;
        }
        if (input.equals("no")) {
            return false;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }
}

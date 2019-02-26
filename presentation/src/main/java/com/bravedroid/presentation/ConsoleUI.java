package com.bravedroid.presentation;

import com.bravedroid.domain.Card;
import com.bravedroid.domain.Game;
import com.bravedroid.domain.HumanUI;
import com.bravedroid.util.Logger;

import java.io.IOException;

public class ConsoleUI implements HumanUI {
    private Logger logger;

    public ConsoleUI(Logger logger) {
        this.logger = logger;
    }

    public void showGame() throws IOException {
        Game.getInstance(logger,this).start();
    }

    @Override
    public boolean acceptFirstCard(Card firstCard) throws IOException {
        ReaderCmd readerCmd = new ReaderCmd();
        final String input = readerCmd.readInput("would you accept this card : " + firstCard.toString() + " ?");
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

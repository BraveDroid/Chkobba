package com.bravedroid.domain;

import com.bravedroid.util.Logger;

import java.io.IOException;
import java.util.Random;

public class Game {
    private static Game instance;
    private Logger logger;

    private HumanPlayer humanPlayer;
    private BotPlayer botPlayer;
    private Player firstPlayer;
    private Player secondPlayer;

    private Game(Logger logger, HumanUI humanUI) {
        this.logger = logger;
        init(humanUI);
    }

    public static Game getInstance(Logger logger, HumanUI humanUI) {
        if (instance == null) {
            instance = new Game(logger, humanUI);
        }
        return instance;
    }

    private void init(HumanUI humanUI) {
        createHumanPlayer(humanUI);
        createBotPlayer();
        selectFirstPlayer();
    }

    private void createHumanPlayer(HumanUI humanUI) {
        humanPlayer = new HumanPlayer(humanUI);
        secondPlayer = new BotPlayer();
    }

    private void createBotPlayer() {
        botPlayer = new BotPlayer();
    }

    private void selectFirstPlayer() {
        Random rand = new Random();
        int randomInt = rand.nextInt(10);
        if (randomInt % 2 == 0) {
            firstPlayer = humanPlayer;
            secondPlayer = botPlayer;
            logger.log("first player is human ");
        } else {
            firstPlayer = botPlayer;
            secondPlayer = humanPlayer;
            logger.log("first player is bot ");

        }
    }

    public void start() throws IOException {
        Cards.getInstance().shuffle();
        askFirstPlayerToAcceptFirstCard();
    }

    private void askFirstPlayerToAcceptFirstCard() throws IOException {
        boolean isFirstCardAccepted = firstPlayer.acceptFirstCard(Cards.getFirstCard());
    }
}

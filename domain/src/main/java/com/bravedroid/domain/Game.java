package com.bravedroid.domain;

import java.util.Random;

public class Game {
    private static Game instance;
    private HumanPlayer humanPlayer;
    private BotPlayer botPlayer;

    private Player firstPlayer;
    private Player secondPlayer;

    public static Game getInstance(HumanUI humanUI) {
        if (instance == null) {
            instance = new Game(humanUI);
        }
        return instance;
    }

    private Game(HumanUI humanUI) {
        init(humanUI);
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
        int randomInt = rand.nextInt(1);
        if (randomInt == 1) {
            firstPlayer = humanPlayer;
            secondPlayer = botPlayer;
        } else {
            firstPlayer = botPlayer;
            secondPlayer = humanPlayer;
        }
    }

    public void start() {
        Cards.getInstance().shuffle();
        askFirstPlayerToAcceptFirstCard();
    }

    private void askFirstPlayerToAcceptFirstCard() {
        boolean isFirstCardAccepted = firstPlayer.acceptFirstCard(Cards.getFirstCard());
    }
}

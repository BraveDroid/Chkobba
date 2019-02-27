package com.bravedroid.application;

import com.bravedroid.application.players.BotPlayer;
import com.bravedroid.application.players.HumanPlayer;
import com.bravedroid.application.players.Player;
import com.bravedroid.domain.Card;
import com.bravedroid.domain.Cards;
import com.bravedroid.domain.HandCards;
import com.bravedroid.domain.TableCards;
import com.bravedroid.util.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.bravedroid.util.Helper.repeat;

public class Game {
    private static Game instance;
    private Logger logger;

    private HumanPlayer humanPlayer;
    private BotPlayer botPlayer;
    private Player firstPlayer;
    private Player secondPlayer;
    private TableCards tableCards;

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
        createTableCards();
        selectFirstPlayer();
    }

    private void createTableCards() {
        tableCards = new TableCards();
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

    public void start() {
        Cards.getInstance().shuffle();
        final boolean isFirstCardAccepted = askFirstPlayerToAcceptFirstCard();
        giveFirstRoundCards(isFirstCardAccepted);
        playRound();


        //giveNextRoundCards();
    }

    private void playRound() {
        repeat(() -> {
            firstPlayer.play(tableCards);
            secondPlayer.play(tableCards);
        }, 3);
    }

    private void giveFirstRoundCards(boolean isFirstCardAccepted) {
        List<Card> firstPlayerCardList = new ArrayList<>();
        List<Card> secondPlayerCardList;
        List<Card> tableCardList = new ArrayList<>();

        if (isFirstCardAccepted) {
            firstPlayerCardList.add(Cards.getInstance().getFirstCard());
            firstPlayerCardList.addAll(Cards.getInstance().getCardsRange(1, 2));
            logger.log("first player cards after accept first card " + firstPlayerCardList);

            tableCardList = Cards.getInstance().getCardsRange(3, 4);
            tableCards.takeCards(tableCardList);
            logger.log("table cards  " + tableCardList);
        } else {
            tableCardList.add(Cards.getInstance().getFirstCard());
            tableCardList.addAll(Cards.getInstance().getCardsRange(1, 3));
            tableCards.takeCards(tableCardList);
            logger.log("table cards " + tableCardList);

            firstPlayerCardList.addAll(Cards.getInstance().getCardsRange(4, 3));
            firstPlayer.takeHandCards(new HandCards(firstPlayerCardList));
            logger.log("first player cards after reject first card " + firstPlayerCardList);
        }
        secondPlayerCardList = Cards.getInstance().getCardsRange(7, 3);
        secondPlayer.takeHandCards(new HandCards(secondPlayerCardList));
        logger.log("second player cards " + secondPlayerCardList);
    }

    //private void giveNextRoundCards() {
    //    final ArrayList<Card> cardList = new ArrayList<>();
    //    int round = 0;
    //    int startIndex = 7;
    //    final int count = 3;
    //    while (round < 5) {
    //        cardList.addAll(Cards.getInstance().getCardsRange(startIndex, count));
    //        firstPlayer.takeHandCards(new HandCards(cardList));
    //        startIndex += 3;
    //        cardList.addAll(Cards.getInstance().getCardsRange(startIndex, count));
    //        secondPlayer.takeHandCards(new HandCards(cardList));
    //        round++;
    //    }
    //}

    private boolean askFirstPlayerToAcceptFirstCard() {
        return firstPlayer.acceptFirstCard(Cards.getInstance().getFirstCard());
    }
}

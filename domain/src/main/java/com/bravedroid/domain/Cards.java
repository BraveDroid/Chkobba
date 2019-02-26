package com.bravedroid.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.bravedroid.domain.Card.CardType.*;

public class Cards {
    private static Cards instance;
    private static List<Card> cardList;

    private Cards() {
        cardList = new ArrayList<>(Arrays.asList(
                Card.Factory.create(PIQUE, 1),
                Card.Factory.create(PIQUE, 2),
                Card.Factory.create(PIQUE, 3),
                Card.Factory.create(PIQUE, 4),
                Card.Factory.create(PIQUE, 5),
                Card.Factory.create(PIQUE, 6),
                Card.Factory.create(PIQUE, 7),
                Card.Factory.create(PIQUE, 8),
                Card.Factory.create(PIQUE, 9),
                Card.Factory.create(PIQUE, 10),

                Card.Factory.create(COEUR, 1),
                Card.Factory.create(COEUR, 2),
                Card.Factory.create(COEUR, 3),
                Card.Factory.create(COEUR, 4),
                Card.Factory.create(COEUR, 5),
                Card.Factory.create(COEUR, 6),
                Card.Factory.create(COEUR, 7),
                Card.Factory.create(COEUR, 8),
                Card.Factory.create(COEUR, 9),
                Card.Factory.create(COEUR, 10),

                Card.Factory.create(CARREAU, 1),
                Card.Factory.create(CARREAU, 2),
                Card.Factory.create(CARREAU, 3),
                Card.Factory.create(CARREAU, 4),
                Card.Factory.create(CARREAU, 5),
                Card.Factory.create(CARREAU, 6),
                Card.Factory.create(CARREAU, 7),
                Card.Factory.create(CARREAU, 8),
                Card.Factory.create(CARREAU, 9),
                Card.Factory.create(CARREAU, 10),

                Card.Factory.create(TREFLE, 1),
                Card.Factory.create(TREFLE, 2),
                Card.Factory.create(TREFLE, 3),
                Card.Factory.create(TREFLE, 4),
                Card.Factory.create(TREFLE, 5),
                Card.Factory.create(TREFLE, 6),
                Card.Factory.create(TREFLE, 7),
                Card.Factory.create(TREFLE, 8),
                Card.Factory.create(TREFLE, 9),
                Card.Factory.create(TREFLE, 10)
        ));

    }

    public static Cards getInstance() {
        if (instance == null) {
            instance = new Cards();
        }
        return instance;
    }

    public void shuffle() {
        Collections.shuffle(cardList);
    }

    public static Card getFirstCard() {
        return cardList.get(1);
    }

    @Override
    public String toString() {
        return "Cards{" + allCardsToString() + "}";
    }

    private String allCardsToString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cardList) {
            sb.append("_");
            sb.append(card.toString());
            sb.append("_");
        }
        return sb.toString();
    }
}

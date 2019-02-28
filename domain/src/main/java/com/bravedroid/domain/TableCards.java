package com.bravedroid.domain;

import java.util.ArrayList;
import java.util.List;

public class TableCards {
    private List<Card> cardList;

    public TableCards() {
        cardList = new ArrayList<>();
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void takeCards(List<Card> tableCardList) {
        cardList.addAll(tableCardList);
    }

    public boolean isEmpty() {
        return cardList.isEmpty();
    }
}

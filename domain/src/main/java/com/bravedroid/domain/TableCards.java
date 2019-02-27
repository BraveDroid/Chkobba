package com.bravedroid.domain;

import java.util.ArrayList;
import java.util.List;

public class TableCards {
    private List<Card> cardList;

    public TableCards() {
        this.cardList = new ArrayList<>();
    }

    public void takeCards(List<Card> tableCardList) {
        this.cardList.addAll(tableCardList);
    }
}

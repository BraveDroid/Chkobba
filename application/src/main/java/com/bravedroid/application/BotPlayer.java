package com.bravedroid.application;

import com.bravedroid.domain.Card;

public class BotPlayer implements Player {

    @Override
    public boolean acceptFirstCard(Card firstCard) {
        if (firstCard.getValue() > 5) {
            return true;
        }
        return false;
    }
}

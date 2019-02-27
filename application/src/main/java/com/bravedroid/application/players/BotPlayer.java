package com.bravedroid.application.players;

import com.bravedroid.domain.Card;
import com.bravedroid.domain.TableCards;

public class BotPlayer extends Player {

    @Override
    public boolean acceptFirstCard(Card firstCard) {
        return firstCard.getValue() > 5;
    }

    @Override
    public PlayAction play(TableCards tableCards) {

        return null;
    }

}

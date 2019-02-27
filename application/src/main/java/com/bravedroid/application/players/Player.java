package com.bravedroid.application.players;

import com.bravedroid.domain.Card;
import com.bravedroid.domain.HandCards;
import com.bravedroid.domain.TableCards;

public abstract class Player {
    private HandCards handCards;

    public HandCards getHandCards() {
        return handCards;
    }

    public abstract boolean acceptFirstCard(Card firstCard);

    public void takeHandCards(HandCards handCards) {
        this.handCards = handCards;
    }

    public abstract PlayAction play(TableCards tableCards);

}

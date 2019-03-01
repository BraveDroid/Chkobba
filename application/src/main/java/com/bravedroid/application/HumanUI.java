package com.bravedroid.application;

import com.bravedroid.application.players.PlayAction;
import com.bravedroid.domain.Card;
import com.bravedroid.domain.HandCards;
import com.bravedroid.domain.TableCards;

public interface HumanUI {
    boolean acceptFirstCard(Card firstCard);

    PlayAction play(TableCards tableCards, HandCards handCards);
}

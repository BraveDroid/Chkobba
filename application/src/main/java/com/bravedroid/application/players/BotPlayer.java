package com.bravedroid.application.players;

import com.bravedroid.domain.Card;
import com.bravedroid.domain.HandCards;
import com.bravedroid.domain.TableCards;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BotPlayer extends Player {

    @Override
    public boolean acceptFirstCard(Card firstCard) {
        return firstCard.getValue() > 5;
    }

    @Override
    public PlayAction play(TableCards tableCards) {
        if (tableCards.isEmpty()) {
            final HandCards handCards = getHandCards();
            final Card card = handCards.getHandCardList().get(0);
            return PlayAction.createThrowAction(card);
        } else {
            final HandCards handCards = getHandCards();
            final List<Card> handCardList = handCards.getHandCardList();
            final List<Card> tableCardList = tableCards.getCardList();
            for (Card handCard : handCardList) {
                for (Card tableCard : tableCardList) {
                    if (handCard.getValue() != tableCard.getValue()) {
                        final Card cardToThrow = handCards.getHandCardList().get(0);
                        return PlayAction.createThrowAction(cardToThrow);
                    }
                    if (handCard.getValue() == tableCard.getValue()) {
                        List<Card> listFromTableCards = new ArrayList<>(Collections.singletonList(tableCard));
                        return PlayAction.createEatAction(handCard, PlayAction.Action.ONE_TO_ONE_EAT, listFromTableCards);
                    }
                }
            }
        }
        throw new NotImplementedException();
    }
}

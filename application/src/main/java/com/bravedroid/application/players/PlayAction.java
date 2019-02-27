package com.bravedroid.application.players;

import com.bravedroid.domain.Card;

import java.util.List;
import java.util.Objects;

import static com.bravedroid.application.players.PlayAction.Action.THROW_CARD;

public class PlayAction {


    List<Card> listFromTableCards;
    private Card selectedCardFromHandCards;
    private Action action;

    private PlayAction(Card selectedCardFromHandCards) {
        this.selectedCardFromHandCards = selectedCardFromHandCards;
        this.action = THROW_CARD;
    }

    private PlayAction(Card selectedCardFromHandCards, Action action, List<Card> listFromTableCards) {
        this.selectedCardFromHandCards = selectedCardFromHandCards;
        this.action = action;
        this.listFromTableCards = listFromTableCards;
        if (action != THROW_CARD) {
            throw new IllegalArgumentException();
        }
    }

    public static PlayAction createEatAction(Card selectedCardFromHandCards, Action action, List<Card> listFromTableCards) {
        return new PlayAction(selectedCardFromHandCards, action, listFromTableCards);
    }

    public static PlayAction createThrowAction(Card selectedCardFromHandCards) {
        return new PlayAction(selectedCardFromHandCards);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        PlayAction that = (PlayAction) other;
        if (that.action == THROW_CARD) {
            return selectedCardFromHandCards.equals(that.selectedCardFromHandCards) &&
                    action == that.action;
        }
        return listFromTableCards.equals(that.listFromTableCards) &&
                selectedCardFromHandCards.equals(that.selectedCardFromHandCards) &&
                action == that.action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(listFromTableCards, selectedCardFromHandCards, action);
    }

    public static enum Action {
        ONE_TO_MULTIPLE_EAT, ONE_TO_ONE_EAT, THROW_CARD;
    }
}

package com.bravedroid.application.players;

import com.bravedroid.domain.Card;

import java.util.List;
import java.util.Objects;

import static com.bravedroid.application.players.PlayAction.Action.THROW_CARD;

public class PlayAction {
    private List<Card> eatenCardsList;
    private Card selectedCardFromHandCards;
    private Action action;

    private PlayAction(Card selectedCardFromHandCards) {
        this.selectedCardFromHandCards = selectedCardFromHandCards;
        this.action = THROW_CARD;
    }

    private PlayAction(Card selectedCardFromHandCards, Action action, List<Card> eatenCardsList) {
        this.selectedCardFromHandCards = selectedCardFromHandCards;
        this.action = action;
        this.eatenCardsList = eatenCardsList;

    }

    public static PlayAction createEatAction(Card selectedCardFromHandCards, Action action, List<Card> eatenCardsList) {
        if (action == THROW_CARD) {
            throw new IllegalArgumentException();
        }
        return new PlayAction(selectedCardFromHandCards, action, eatenCardsList);
    }

    public static PlayAction createThrowAction(Card selectedCardFromHandCards) {
        return new PlayAction(selectedCardFromHandCards);
    }

    public Card getSelectedCardFromHandCards() {
        return selectedCardFromHandCards;
    }

    public Action getAction() {
        return action;
    }

    public List<Card> getEatenCardsList() {
        return eatenCardsList;
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
        return eatenCardsList.equals(that.eatenCardsList) &&
                selectedCardFromHandCards.equals(that.selectedCardFromHandCards) &&
                action == that.action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eatenCardsList, selectedCardFromHandCards, action);
    }

    public enum Action {
        ONE_TO_MULTIPLE_EAT, ONE_TO_ONE_EAT, THROW_CARD
    }
}

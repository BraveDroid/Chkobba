package com.bravedroid.application.players;

import com.bravedroid.application.Game;
import com.bravedroid.application.HumanUI;
import com.bravedroid.domain.Card;
import com.bravedroid.domain.TableCards;

public class HumanPlayer extends Player {
    private HumanUI humanUI;

    public HumanPlayer(HumanUI humanUI) {
        this.humanUI = humanUI;
    }

    @Override
    public boolean acceptFirstCard(Card firstCard) {
        return humanUI.acceptFirstCard(firstCard);
    }

    @Override
    public PlayAction play(TableCards tableCards) {
        PlayAction playAction = humanUI.play(tableCards, getHandCards());
        while (!isValid(playAction)) {
            playAction = humanUI.play(tableCards, getHandCards());
        }
        return playAction;
    }

    private boolean isValid(PlayAction playAction) {
        return Game.getInstance(null, null).isValidate(playAction);
    }
}

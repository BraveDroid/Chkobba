package com.bravedroid.application.players;

import com.bravedroid.application.HumanUI;
import com.bravedroid.domain.Card;
import com.bravedroid.domain.TableCards;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        throw new NotImplementedException();
    }
}

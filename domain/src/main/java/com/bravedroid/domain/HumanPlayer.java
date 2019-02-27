package com.bravedroid.domain;

public class HumanPlayer implements Player {
    private HumanUI humanUI;

    public HumanPlayer(HumanUI humanUI) {
        this.humanUI = humanUI;
    }

    @Override
    public boolean acceptFirstCard(Card firstCard) {
        return humanUI.acceptFirstCard(firstCard);
    }
}

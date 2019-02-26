package com.bravedroid.domain;

import java.io.IOException;

public class HumanPlayer implements Player {
    private HumanUI humanUI;

    public HumanPlayer(HumanUI humanUI) {
        this.humanUI = humanUI;
    }

    @Override
    public boolean acceptFirstCard(Card firstCard) throws IOException {
        return humanUI.acceptFirstCard(firstCard);
    }
}

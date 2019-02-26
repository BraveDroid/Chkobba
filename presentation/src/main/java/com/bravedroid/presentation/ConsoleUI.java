package com.bravedroid.presentation;

import com.bravedroid.domain.Card;
import com.bravedroid.domain.Game;
import com.bravedroid.domain.HumanUI;

public class ConsoleUI implements HumanUI {
    public void showGame() {
        Game.getInstance(this).start();
    }

    @Override
    public boolean acceptFirstCard(Card firstCard) {
        print("would you accept this card : " + firstCard.toString() + " ?");
        return false;
    }

    private static void print(Object object) {
        System.out.println(object);
    }
}

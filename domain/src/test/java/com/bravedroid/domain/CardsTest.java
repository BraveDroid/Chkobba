package com.bravedroid.domain;

import org.junit.Test;

public class CardsTest {

    @Test
    public void toStringTest() {
        String firstString = Cards.getInstance().toString();
        System.out.println("original list " + firstString);
        Cards.getInstance().shuffle();
        String secondString = Cards.getInstance().toString();
        System.out.println("shuffled list: " + secondString);
    }
}

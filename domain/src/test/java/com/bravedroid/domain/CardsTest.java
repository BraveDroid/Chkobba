package com.bravedroid.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.bravedroid.domain.Card.CardType.COEUR;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CardsTest {

    @Test
    public void toStringTest() {
        String firstString = Cards.getInstance().toString();
        System.out.println("original list " + firstString);
        Cards.getInstance().shuffle();
        String secondString = Cards.getInstance().toString();
        System.out.println("shuffled list: " + secondString);
    }

    @Test
    public void getCardsRangeTest() {
        testFirstCard();
        testRange1();
        testRange2();
    }

    private void testFirstCard() {
        final List<Card> result = Cards.getInstance().getCardsRange(0, 1);
        final List<Card> expected = new ArrayList<>();
        expected.add(Cards.getInstance().getFirstCard());
        assertThat(expected, is(equalTo(result)));
    }

    private void testRange1() {
        Cards.getInstance().reset();
        final List<Card> result = Cards.getInstance().getCardsRange(1, 2);
        final List<Card> expected = new ArrayList<>();
        expected.addAll(Cards.getInstance().getCardsRange(1, 1));
        expected.addAll(Cards.getInstance().getCardsRange(2, 1));
        assertThat(expected, is(equalTo(result)));
    }

    private void testRange2() {
        final List<Card> result = Cards.getInstance().getCardsRange(10, 10);
        final List<Card> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(
                Card.Factory.create(COEUR, 1),
                Card.Factory.create(COEUR, 2),
                Card.Factory.create(COEUR, 3),
                Card.Factory.create(COEUR, 4),
                Card.Factory.create(COEUR, 5),
                Card.Factory.create(COEUR, 6),
                Card.Factory.create(COEUR, 7),
                Card.Factory.create(COEUR, 8),
                Card.Factory.create(COEUR, 9),
                Card.Factory.create(COEUR, 10)
        ));
        assertThat(expected, is(equalTo(result)));
    }
}

package com.bravedroid.application.players;

import com.bravedroid.domain.Card;
import com.bravedroid.domain.HandCards;
import com.bravedroid.domain.TableCards;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BotPlayerTest {
    private List<Card> handCardList;
    private List<Card> tableCardList;
    private BotPlayer SUT;

    @Before
    public void setUp() {
        SUT = new BotPlayer();
        handCardList = new ArrayList<>();

        tableCardList = new ArrayList<>(Arrays.asList(
                Card.Factory.create(Card.CardType.TREFLE, 7),
                Card.Factory.create(Card.CardType.TREFLE, 2),
                Card.Factory.create(Card.CardType.TREFLE, 8),
                Card.Factory.create(Card.CardType.TREFLE, 5)
        ));
    }

    @Test
    public void playTest() {
        /***********************************table_cards_is_empty*******************************/

        action_should_be_thrown_action_when_table_cards_is_empty(
                Card.Factory.create(Card.CardType.COEUR, 7),
                Card.Factory.create(Card.CardType.COEUR, 2),
                Card.Factory.create(Card.CardType.COEUR, 8)
        );

        action_should_be_thrown_action_when_table_cards_is_empty(
                Card.Factory.create(Card.CardType.COEUR, 2),
                Card.Factory.create(Card.CardType.COEUR, 8)
        );
        action_should_be_thrown_action_when_table_cards_is_empty(
                Card.Factory.create(Card.CardType.COEUR, 8)
        );

        /***********************************table_cards_is_not_empty*******************************/

        action_should_be_THROWN_when_table_cards_is_not_empty(new ArrayList<>(Arrays.asList(
                Card.Factory.create(Card.CardType.TREFLE, 4),
                Card.Factory.create(Card.CardType.TREFLE, 6),
                Card.Factory.create(Card.CardType.TREFLE, 1))
        ));

        action_should_be_THROWN_when_table_cards_is_not_empty(new ArrayList<>(Arrays.asList(
                Card.Factory.create(Card.CardType.TREFLE, 4),
                Card.Factory.create(Card.CardType.TREFLE, 1))
        ));

        action_should_be_ONE_TO_ONE_EAT_when_table_cards_is_not_empty(new ArrayList<>(Arrays.asList(
                Card.Factory.create(Card.CardType.COEUR, 7),
                Card.Factory.create(Card.CardType.COEUR, 2),
                Card.Factory.create(Card.CardType.COEUR, 8)
        )), tableCardList);

        action_should_be_ONE_TO_ONE_EAT_when_table_cards_is_not_empty(new ArrayList<>(Arrays.asList(
                Card.Factory.create(Card.CardType.COEUR, 7),
                Card.Factory.create(Card.CardType.COEUR, 2)
        )), tableCardList);

        action_should_be_ONE_TO_ONE_EAT_when_table_cards_is_not_empty(new ArrayList<>(Collections.singletonList(
                Card.Factory.create(Card.CardType.COEUR, 7)
        )), tableCardList);

    }

    private void action_should_be_thrown_action_when_table_cards_is_empty(Card... cardsArray) {
        final ArrayList<Card> cards = new ArrayList<>(Arrays.asList(cardsArray));
        SUT.takeHandCards(new HandCards(cards));
        final TableCards tableCards = new TableCards();
        final PlayAction result = SUT.play(tableCards);
        final PlayAction expected = PlayAction.createThrowAction(cards.get(0));
        assertThat(expected, is(equalTo(result)));
    }

    private void action_should_be_THROWN_when_table_cards_is_not_empty(List<Card> handCardList) {
        TableCards tableCards = new TableCards();
        tableCards.takeCards(tableCardList);
        SUT.takeHandCards(new HandCards(handCardList));
        final PlayAction result = SUT.play(tableCards);
        final PlayAction expected = PlayAction.createThrowAction(handCardList.get(0));
        assertThat(expected, is(equalTo(result)));
    }

    private void action_should_be_ONE_TO_ONE_EAT_when_table_cards_is_not_empty(List<Card> handCardList, List<Card> tableCardList) {
        TableCards tableCards = new TableCards();
        tableCards.takeCards(tableCardList);
        final Card card1 = tableCards.getCardList().get(0);

        SUT.takeHandCards(new HandCards(handCardList));

        final PlayAction result = SUT.play(tableCards);
        final PlayAction expected = PlayAction.createEatAction(handCardList.get(0),
                PlayAction.Action.ONE_TO_ONE_EAT,
                new ArrayList<>(Collections.singletonList(card1)
                ));
        assertThat(expected, is(equalTo(result)));
    }

    private void action_should_be_ONE_TO_MULTIPLE_EAT_when_table_cards_is_not_empty() {

    }
}

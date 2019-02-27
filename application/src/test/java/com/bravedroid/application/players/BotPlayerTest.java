package com.bravedroid.application.players;

import com.bravedroid.domain.Card;
import com.bravedroid.domain.HandCards;
import com.bravedroid.domain.TableCards;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BotPlayerTest {
    private BotPlayer SUT;


    @Before
    public void setUp() throws Exception {
        SUT = new BotPlayer();
    }

    @Test
    public void playTest() {
        play_action_should_be_thrown_action_when_empty_table_card();
    }

    private void play_action_should_be_thrown_action_when_empty_table_card() {
        final ArrayList<Card> cards = new ArrayList<>(Arrays.asList(
                Card.Factory.create(Card.CardType.COEUR, 7),
                Card.Factory.create(Card.CardType.COEUR, 2),
                Card.Factory.create(Card.CardType.COEUR, 8)

        ));
        SUT.takeHandCards(new HandCards(cards));
        final PlayAction result = SUT.play(new TableCards());
        final PlayAction expected = PlayAction.createThrowAction(Card.Factory.create(Card.CardType.COEUR, 7));
        assertThat(expected, is(equalTo(result)));
    }
}

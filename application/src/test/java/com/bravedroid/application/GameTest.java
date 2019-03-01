package com.bravedroid.application;

import com.bravedroid.application.players.PlayAction;
import com.bravedroid.domain.Card;
import com.bravedroid.domain.TableCards;
import com.bravedroid.util.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GameTest {
    private Game SUT;

    @Before
    public void setUp() {
        SUT = Game.getInstance(new Logger(true), null);
    }

    @Test
    public void isValidateTest() {
        should_validate_one_to_one_eat(Card.Factory.create(Card.CardType.TREFLE, 7), PlayAction.Action.ONE_TO_ONE_EAT,
                Collections.singletonList(
                        Card.Factory.create(Card.CardType.COEUR, 7)
                )
        );

        should_validate_one_to_one_eat(Card.Factory.create(Card.CardType.TREFLE, 7), PlayAction.Action.ONE_TO_MULTIPLE_EAT,
                Arrays.asList(
                        Card.Factory.create(Card.CardType.COEUR, 5),
                        Card.Factory.create(Card.CardType.COEUR, 2)
                )
        );

        should_validate_throw_Action(Card.Factory.create(Card.CardType.TREFLE, 7), Collections.emptyList(), true);

        should_validate_throw_Action(Card.Factory.create(Card.CardType.TREFLE, 7),
                Arrays.asList(
                        Card.Factory.create(Card.CardType.TREFLE, 1),
                        Card.Factory.create(Card.CardType.COEUR, 1),
                        Card.Factory.create(Card.CardType.CARREAU, 1)
                ), true
        );

        should_validate_throw_Action(Card.Factory.create(Card.CardType.TREFLE, 7),
                Arrays.asList(
                        Card.Factory.create(Card.CardType.TREFLE, 1),
                        Card.Factory.create(Card.CardType.COEUR, 5),
                        Card.Factory.create(Card.CardType.CARREAU, 1)
                ), false
        );

        should_validate_throw_Action(Card.Factory.create(Card.CardType.TREFLE, 7),
                Arrays.asList(
                        Card.Factory.create(Card.CardType.TREFLE, 3),
                        Card.Factory.create(Card.CardType.COEUR, 4),
                        Card.Factory.create(Card.CardType.CARREAU, 1)
                ), false
        );
    }

    private void should_validate_one_to_one_eat(Card handCard, PlayAction.Action action, List<Card> eatenCardList) {
        final PlayAction eatAction = PlayAction.createEatAction(handCard, action, eatenCardList);
        final boolean validate = SUT.isValidate(eatAction);
        assertTrue(validate);
    }

    private void should_validate_throw_Action(Card handCard, List<Card> tableCardList, boolean isValid) {
        final TableCards tableCards = SUT.getTableCards();
        tableCards.takeCards(tableCardList);
        final PlayAction throwAction = PlayAction.createThrowAction(handCard);
        assertThat(isValid, is(equalTo(SUT.isValidate(throwAction))));
    }
}

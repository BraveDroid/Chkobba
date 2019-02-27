package com.bravedroid.domain;

import java.util.Objects;

public class Card {
    private CardType type;
    private int value;

    private Card(CardType type, int value) {
        this.type = type;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Card otherCard = (Card) other;
        return value == otherCard.value &&
                type == otherCard.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public String toString() {
        return "Card{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }

    public static class Factory {
        public static Card create(CardType type, int value) {
            if (value <= 0 || value > 10) {
                throw new IllegalArgumentException("card value is not correct");
            }
            return new Card(type, value);
        }
    }

    public static enum CardType {
        PIQUE, COEUR, CARREAU, TREFLE;
    }
}

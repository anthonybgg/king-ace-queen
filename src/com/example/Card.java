package com.example;

/**
 * Created by zilles on 9/26/17.
 */
public class Card {
    public static final String [] NAMES = {"Queen", "King", "Ace"};
    public static final int QUEEN = 0, KING = 1, ACE = 2, NUM_CARDS = 3;

    private int value;

    /**
     * Create a card object of a given value.
     * @param value the desired value {QUEEN, KING, or ACE} for this card.
     */
    public Card(int value) {
        assert(value >= 0 && value <= ACE);
        this.value = value;
    }

    /**
     * Returns the value of the card
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the name of the card
     * @return the name of the card
     */
    @Override
    public String toString() {
        return NAMES[value];
    }

    /**
     * Determines a winner at showdown between one card and another
     * @param other The card that the current card is being compared against
     * @return true if 'this' card beats the 'other' card
     */
    public boolean beats(Card other) {
        return ((this.value == ACE) || ((this.value == KING) && (other.value == QUEEN)));
    }
}

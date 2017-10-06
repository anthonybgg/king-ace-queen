package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class TheBetterStrategyTest {
    private Card cardAce = new Card(Card.ACE);
    private Card cardQueen = new Card(Card.QUEEN);
    private Card cardKing = new Card(Card.KING);
    private PlayerStrategy playerStrategy = new TheBetterStrategy();

    @Test
    public void betAsPlayerStrategyTheBetterStrategy() throws Exception {
        assertTrue(playerStrategy.betAsPlayer1(cardAce));
        assertTrue(playerStrategy.betAsPlayer1(cardQueen));
    }

    @Test
    public void callAsPlayerStrategyTheBetterStrategy() throws Exception {
        assertFalse(playerStrategy.callAsPlayer2(cardQueen));
        assertTrue(playerStrategy.callAsPlayer2(cardKing));
    }

    @Test
    public void getName() throws Exception {
        assertEquals("TheBetterStrategy", playerStrategy.getName());
    }

}
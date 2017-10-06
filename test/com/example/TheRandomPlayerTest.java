package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class TheRandomPlayerTest {
    private Card cardAce = new Card(Card.ACE);
    private Card cardQueen = new Card(Card.QUEEN);
    private Card cardKing = new Card(Card.KING);
    private PlayerStrategy playerStrategy = new TheRandomPlayer();
    @Test
    public void betAsPlayer1() throws Exception {
        assertFalse(playerStrategy.betAsPlayer1(cardAce));
        assertFalse(playerStrategy.betAsPlayer1(cardQueen));
        assertFalse(playerStrategy.betAsPlayer1(cardKing));
    }

    @Test
    public void callAsPlayer2() throws Exception {
        assertTrue(playerStrategy.callAsPlayer2(cardQueen));
        assertTrue(playerStrategy.callAsPlayer2(cardKing));
        assertTrue(playerStrategy.callAsPlayer2(cardAce));
    }

    @Test
    public void getName() throws Exception {
        assertEquals("TheRandomPlayer", playerStrategy.getName());
    }

}
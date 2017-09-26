package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by zilles on 9/26/17.
 */
public class CardTest {
    private Card ace = new Card(Card.ACE);
    private Card king = new Card(Card.KING);
    private Card queen = new Card(Card.QUEEN);

    @Test
    public void aceBeatsKing() throws Exception {
        assertTrue(ace.beats(king));
    }

    @Test
    public void aceBeatsQueen() throws Exception {
        assertTrue(ace.beats(queen));
    }

    @Test
    public void kingBeatsQueen() throws Exception {
        assertTrue(king.beats(queen));
    }

    @Test
    public void kingDoesNotBeatAce() throws Exception {
        assertFalse(king.beats(ace));
    }

    @Test
    public void queenDoesNotBeatAce() throws Exception {
        assertFalse(queen.beats(ace));
    }

    @Test
    public void queenDoesNotBeatKing() throws Exception {
        assertFalse(queen.beats(king));
    }
}
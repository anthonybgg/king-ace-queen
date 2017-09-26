package com.example;

/**
 * Created by zilles on 9/26/17.
 */
public interface PlayerStrategy {

    /**
     * This function is called by the Game Engine to notify a player that they are
     * acting as Player 1 in this round and telling them what card they were dealt.
     * The return value indicates whether they want to make an additional bet.
     * @param card The card that this player was dealt
     * @return true if the player wants to bet, false if they don't want to bet.
     */
    public boolean betAsPlayer1(Card card);

    /**
     * This function is called by the Game Engine to notify a player that they are
     * acting as Player 2 in this round and telling them what card they were dealt.
     * The return value indicates whether they want to call or fold.
     * @param card The card that the player was dealt
     * @return true if the player wants to call, false if they want to fold.
     */
    public boolean callAsPlayer2(Card card);

    /**
     * Provides info back to a player strategy that played as Player 1 about what
     * happened during a given hand.
     * @param card1 The card dealt to Player 1
     * @param card2 The card dealt to Player 2
     * @param bet Did Player 1 bet?
     * @param call Did Player 2 call?  (only valid if Player 1 bet; ignore otherwise)
     */
    public void feedbackAsPlayer1(Card card1, Card card2, boolean bet, boolean call);

    /**
     * Provides info back to a player strategy that played as Player 1 about what
     * happened during a given hand.
     * @param card1 The card dealt to Player 1
     * @param card2 The card dealt to Player 2
     * @param bet Did Player 1 bet?
     * @param call Did Player 2 call?  (only valid if Player 1 bet; ignore otherwise)
     */
    public void feedbackAsPlayer2(Card card1, Card card2, boolean bet, boolean call);

    /**
     * Resets the player strategy.  Useful when we switch the player strategy to play
     * against a new opponent.
     */
    public void reset();

    /**
     * Returns the name of this player strategy for the purpose of printing out stats
     * @return the player's name
     */
    public String getName();
}

package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameController {
    /**
     * This function will shuffle the deck of cards and run the game.
     * @param player1 is a player called with a certain Strategy implements in the interface PlayerStrategy.
     * @param player2 is a another player called with a certain Strategy implements in the interface PlayerStrategy.
     */
    public void run(PlayerStrategy player1, PlayerStrategy player2, int pocketOfPlayer1, int pocketOfPlayer2) {
        List<Integer> pocket1 = new ArrayList<>();
        List<Integer> pocket2 = new ArrayList<>();
        Random random = new Random();
        Card card1 = new Card(random.nextInt(Card.NUM_CARDS));
        Card card2 = new Card(random.nextInt(Card.NUM_CARDS));
        if (card1 != card2) {
            for (int i = 0; i < 5000; i ++) {
                if (i % 2 == 0) {
                    feedbackForPlayers(player1, player2, card1, card2);
                    initializingPotValue(player1, player2, card1, card2, pocket1, pocket2, pocketOfPlayer1, pocketOfPlayer2);
                } else {
                    feedbackForPlayers(player2, player1, card2, card1);
                    initializingPotValue(player2, player1, card2, card1, pocket2, pocket1, pocketOfPlayer2, pocketOfPlayer1);
                }
            }
            getThePlayerWithTheMostChip(player1, player2, pocketOfPlayer1, pocketOfPlayer2);
        } else
            run(player1, player2, pocketOfPlayer1, pocketOfPlayer2);
    }

    /**
     * This function sets the pot equal to zero, initially. And after taking an action called "Ante", its value is equal
     * to two while subtracting one from both players their amount of chip.
     * @param player1 is a player called with a certain Strategy implements in the interface PlayerStrategy.
     * @param player2 is a another player called with a certain Strategy implements in the interface PlayerStrategy.
     * @param card1 is the card dealt to Player1.
     * @param card2 is the card dealt to Player2.
     */
    public void initializingPotValue(PlayerStrategy player1, PlayerStrategy player2, Card card1, Card card2,
                                     List<Integer> pocket1, List<Integer> pocket2, int pocketOfPlayer1, int pocketOfPlayer2) {
        for (int i = 0; i < 1; i++) {
            if (card1.beats(card2)) {
                if (player1.betAsPlayer1(card1) && player2.callAsPlayer2(card2)) {
                    pocket1.add(4);
                } else if (player1.betAsPlayer1(card1) && !player2.callAsPlayer2(card2)) {
                    pocket1.add(3);
                } else
                    pocket1.add(2);
            } else if (player1.betAsPlayer1(card1) && player2.callAsPlayer2(card2)) {
                pocket2.add(4);
            } else if (!player1.betAsPlayer1(card1)) {
                pocket2.add(2);
            } else
                pocket1.add(3);
        }
        for (int chip : pocket1) {
            pocketOfPlayer1 = pocketOfPlayer1 + chip;
        }
        for (int chip : pocket2) {
            pocketOfPlayer2 = pocketOfPlayer2 + chip;
        }
    }

    /**
     * This function will return the player with the most points.
     * @param player1 is a player called with a certain Strategy implements in the interface PlayerStrategy.
     * @param player2 is a another player called with a certain Strategy implements in the interface PlayerStrategy.
     * @param pocketOfPlayer1 is the amount of chip that Player 1 has.
     * @param pocketOfPlayer2 is the amount of chip that Player 2 has.
     */

    private void getThePlayerWithTheMostChip(PlayerStrategy player1, PlayerStrategy player2, int pocketOfPlayer1,
                                            int pocketOfPlayer2) {
        if (pocketOfPlayer1 > pocketOfPlayer2) {
            System.out.println(player1.getName() + " won with a score of " + pocketOfPlayer1);
        } else if (pocketOfPlayer1 < pocketOfPlayer2){
            System.out.println(player2.getName() + " won with a score of " + pocketOfPlayer2);
        } else {
            System.out.println("DRAW");
        }
    }

    /**
     * This function gives the feedback on how the game was played.
     * @param player1 is a player called with a certain Strategy implements in the interface PlayerStrategy.
     * @param player2 is a another player called with a certain Strategy implements in the interface PlayerStrategy.
     * @param card1 is the card dealt to Player1.
     * @param card2 is the card dealt to Player2.
     */
    public void feedbackForPlayers(PlayerStrategy player1, PlayerStrategy player2, Card card1, Card card2) {
        boolean bet;
        boolean call;
        if (player1.betAsPlayer1(card1) && player2.callAsPlayer2(card2)) {
            bet = true;
            call = true;
        } else if (player1.betAsPlayer1(card1) && !player2.callAsPlayer2(card2)) {
            bet = true;
            call = false;
        } else {
            bet = false;
            call = false;
        }
        player1.feedbackAsPlayer1(card1, card2, bet, call);
        player2.feedbackAsPlayer2(card1, card2, bet, call);
    }
}

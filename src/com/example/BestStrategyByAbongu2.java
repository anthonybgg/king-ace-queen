package com.example;

import java.awt.*;

public class BestStrategyByAbongu2 implements PlayerStrategy {

    @Override
    public boolean betAsPlayer1(Card card) {
        System.out.println("You are the Player 1.");
        if (card.getValue() == 2) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean callAsPlayer2(Card card) {
        if (card.getValue() == 2) {
            return true;
        } else
        return false;
    }

    @Override
    public void feedbackAsPlayer1(Card card1, Card card2, boolean bet, boolean call) {
        System.out.println("You were the Player 1");
        System.out.println("Your card was " + card1.toString() + " and your opponent's card was " + card2.toString() + ".");
        if (betAsPlayer1(card1) && callAsPlayer2(card2)) {
            bet = true;
            call = true;
            System.out.println("You bet and your opponent called.");
        } else if (bet && !call) {
            System.out.println("You bet but your opponent folded.");
        }
        if (card1.getValue() > card2.getValue()) {
            System.out.println("You've WON! :D");
        } else {
            System.out.println("You've lost. :(");
        }
    }

    @Override
    public void feedbackAsPlayer2(Card card1, Card card2, boolean bet, boolean call) {
        System.out.println("You were the Player 2");
        System.out.println("Your card was " + card2.toString() + " and your opponent's card was " + card1.toString() + ".");
        if (bet && call) {
            System.out.println("Your opponent bet and you called.");
        } else if (bet && !call) {
            System.out.println("your opponent bet, but you folded.");
        }
        if (card2.getValue() > card1.getValue()) {
            System.out.println("You've WON! :D");
        } else {
            System.out.println("You've lost. :(");
        }
    }

    @Override
    public void reset() {

    }

    @Override
    public String getName() {
        String name = "BestStrategyByAbongu2";
        return name;
    }
}

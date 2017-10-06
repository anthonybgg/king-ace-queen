package com.example;

public class TheRandomPlayer implements PlayerStrategy {
    @Override
    public boolean betAsPlayer1(Card card) { return false; }

    @Override
    public boolean callAsPlayer2(Card card) { return true; }

    @Override
    public void feedbackAsPlayer1(Card card1, Card card2, boolean bet, boolean call) {
        System.out.println("You are Player 1");
        System.out.println("Your card was " + card1.toString() + " and your opponent's card was " + card2.toString() + ".");
        if (betAsPlayer1(card1) && callAsPlayer2(card2)) {
            bet = true;
            call = true;
            System.out.println("You bet and your opponent called.");
        } else if (betAsPlayer1(card1) && !callAsPlayer2(card2)) {
            bet = true;
            call = false;
            System.out.println("You bet and your opponent folded.");
        } else {
            call = false;
            bet = false;
            System.out.println("You checked.");
        }
    }

    @Override
    public void feedbackAsPlayer2(Card card1, Card card2, boolean bet, boolean call) {
        System.out.println("You are Player 2");
        System.out.println("Your card was " + card2.toString() + " and your opponent's card was " + card1.toString() + ".");
        if (betAsPlayer1(card1) && callAsPlayer2(card2)) {
            bet = true;
            call = true;
            System.out.println("Your opponent bet and you called.");
        } else if (betAsPlayer1(card1) && !callAsPlayer2(card2)) {
            bet = true;
            call = false;
            System.out.println("Your opponent bet and you folded.");
        } else {
            call = false;
            bet = false;
            System.out.println("Your opponent checked.");
        }
    }

    @Override
    public void reset() {

    }

    @Override
    public String getName() {
        return "TheRandomPlayer";
    }
}

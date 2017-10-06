package com.example;

public class GameEngine {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        PlayerStrategy player1 = new BestStrategyByAbongu2();
        PlayerStrategy player2 = new TheRandomPlayer();
        int pocketOfPlayer1 = 0;
        int pocketOfPlayer2 = 0;
        for (int i = 0; i < 2; i++) {
            if (i % 2 == 0) {
                gameController.run(player1, player2, pocketOfPlayer1, pocketOfPlayer2);
            }
            else {
                gameController.run(player2, player1, pocketOfPlayer2, pocketOfPlayer1 );
            }
        }
    }
}

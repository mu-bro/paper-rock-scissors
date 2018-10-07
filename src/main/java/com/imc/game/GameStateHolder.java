package com.imc.game;

import com.imc.player.Player;

public class GameStateHolder {

    private final Player player1;
    private final Player player2;
    private final int totalRounds;
    private int currentRound;
    private RoundsResults results;

    public GameStateHolder(Player player1, Player player2, int totalRounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.totalRounds = totalRounds;
        this.results = new RoundsResults(player1, player2);
        this.currentRound = 0;
    }

    public void resetResults() {
        currentRound = 0;
        results.resetScores();
    }

    public void setRoundWinner(Player player) {
        results.addRoundWinner(player);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void incrementRound() {
        currentRound++;
    }

    public RoundsResults getResults() {
        return results;
    }
}

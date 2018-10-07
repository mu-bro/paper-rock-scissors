package com.imc.game;

import com.imc.player.Player;
import com.imc.ui.UserInterface;

import static com.imc.game.RoundsResults.UNNOWN_RESULT;

public class Game {

    private GameStateHolder gameState;
    private UserInterface ui;

    public Game(UserInterface ui, Player player1, Player player2, int roundsToPlay) {
        this.ui = ui;
        this.gameState = new GameStateHolder(player1, player2, roundsToPlay);
    }

    public void play() {
        startGame();
        while (gameState.getCurrentRound() < gameState.getTotalRounds()) {
            playNextRound();
        }
        showGameResults();
    }

    private void startGame() {
        gameState.resetResults();
        ui.showMessage("#############################");
        ui.showMessage("###### Game started! ########");
        ui.showMessage("#############################");
        ui.showMessage("Players: " + gameState.getPlayer1().getName() + " vs " + gameState.getPlayer2().getName());
    }

    private void playNextRound() {
        gameState.incrementRound();
        ui.showMessage("------------------------------");
        ui.showMessage("Round #" + gameState.getCurrentRound());

        Symbol player1symbol = getPlayerSymbol(gameState.getPlayer1());
        Symbol player2symbol = getPlayerSymbol(gameState.getPlayer2());

        switch (player1symbol.compareWith(player2symbol)) {
            case WINS: {
                setRoundWinner(gameState.getPlayer1());
            }
            break;
            case LOOSES: {
                setRoundWinner(gameState.getPlayer2());
            }
            break;
            case DRAW: {
                ui.showMessage("DRAW - no winners at this round.");
            }
        }
    }

    private Symbol getPlayerSymbol(Player player) {
        ui.showMessage(player.getName() + ", your turn!");
        Symbol symbol = player.showNextSymbol();
        ui.showMessage(player.getName() + " chose " + symbol);
        return symbol;
    }

    private void setRoundWinner(Player player) {
        gameState.setRoundWinner(player);
        ui.showMessage(player.getName() + " wins this round");
    }

    private void showGameResults() {
        ui.showMessage("#############################");
        ui.showMessage("###### Game is over! ########");
        ui.showMessage("#############################");

        int player1Score = gameState.getResults().getScore(gameState.getPlayer1());
        int player2Score = gameState.getResults().getScore(gameState.getPlayer2());

        if (player1Score == UNNOWN_RESULT || player2Score == UNNOWN_RESULT) {
            ui.showMessage("Error: winner not found in players list");
        }
        if (player1Score == player2Score) {
            ui.showMessage(String.format("DRAW! Players have equal score %d:%d!", player1Score, player2Score));
        } else {
            String winnerName = player1Score > player2Score ?
                    gameState.getPlayer1().getName() :
                    gameState.getPlayer2().getName();
            ui.showMessage(String.format("Player %s won with the final score %d:%d", winnerName, player1Score, player2Score));
        }
        ui.showMessage("############################");
    }

    public boolean needToRepeat() {
        ui.showMessage("Do you want to try play again?");
        ui.showMessage("Type \"Y\" to retry");
        return "Y".equals(ui.readInputData().toUpperCase());
    }

}

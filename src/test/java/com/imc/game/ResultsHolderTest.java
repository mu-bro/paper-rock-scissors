package com.imc.game;

import com.imc.player.Player;
import com.imc.player.RobotBehaviour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsHolderTest {

    @Test
    public void testShouldReturnCorrectScoreAfterRounds() {
        Player player1 = new Player(new RobotBehaviour());
        Player player2 = new Player(new RobotBehaviour());
        GameStateHolder gameState = new GameStateHolder(player1, player2, 3);

        gameState.setRoundWinner(player1);
        gameState.setRoundWinner(player2);
        gameState.setRoundWinner(player1);

        assertEquals(2, gameState.getResults().getScore(player1));
        assertEquals(1, gameState.getResults().getScore(player2));
    }

    @Test
    public void testResultsShouldBeEmptyAfterResetRounds() {
        Player player1 = new Player(new RobotBehaviour());
        Player player2 = new Player(new RobotBehaviour());
        GameStateHolder gameState = new GameStateHolder(player1, player2, 3);

        gameState.setRoundWinner(player1);
        gameState.setRoundWinner(player2);
        gameState.setRoundWinner(player1);

        gameState.resetResults();
        assertEquals(0, gameState.getResults().getScore(player1));
        assertEquals(0, gameState.getResults().getScore(player2));
    }
}

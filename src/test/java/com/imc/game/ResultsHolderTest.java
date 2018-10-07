package com.imc.game;

import com.imc.player.Player;
import com.imc.player.RobotBehaviour;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsHolderTest {

    private GameStateHolder gameState;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void init() {
        player1 = new Player(new RobotBehaviour());
        player2 = new Player(new RobotBehaviour());
        gameState = new GameStateHolder(player1, player2, 3);
    }

    @Test
    public void shouldReturnCorrectScoreAfterRounds() {
        gameState.setRoundWinner(player1);
        gameState.setRoundWinner(player2);
        gameState.setRoundWinner(player1);

        assertEquals(2, gameState.getResults().getScore(player1));
        assertEquals(1, gameState.getResults().getScore(player2));
    }

    @Test
    public void resultsShouldBeEmptyAfterResetRounds() {
        gameState.setRoundWinner(player1);
        gameState.setRoundWinner(player2);
        gameState.setRoundWinner(player1);

        gameState.resetResults();
        assertEquals(0, gameState.getResults().getScore(player1));
        assertEquals(0, gameState.getResults().getScore(player2));
    }
}

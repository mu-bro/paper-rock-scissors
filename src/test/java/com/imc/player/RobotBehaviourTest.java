package com.imc.player;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.imc.game.Symbol.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RobotBehaviourTest {

    @Test
    public void testShouldCorrectlyDefineNonEmptyRobotName() {
        Player robotPlayer = new Player(new RobotBehaviour(new Random()));
        assertFalse(robotPlayer.getName().isEmpty());
    }

    @Test
    public void testShouldRandomlyChooseDifferentSymbols() {
        assertEquals(PAPER, new RobotBehaviour(new Random(1)).makeNextChoice());
        assertEquals(ROCK, new RobotBehaviour(new Random(2)).makeNextChoice());
        assertEquals(SCISSORS, new RobotBehaviour(new Random(3)).makeNextChoice());
    }
}

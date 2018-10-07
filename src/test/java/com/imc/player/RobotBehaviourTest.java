package com.imc.player;

import com.imc.game.Symbol;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RobotBehaviourTest {

    @Test
    public void shouldCorrectlyDefineNonEmptyRobotName() {
        Player robotPlayer = new Player(new RobotBehaviour());
        assertFalse(robotPlayer.getName().isEmpty());
    }

    @Test
    public void shouldRandomlyChooseDifferentSymbols() {
        Player robotPlayer = new Player(new RobotBehaviour());
        HashSet<Symbol> differentSymbols = new HashSet<>();
        for (int i = 0;i < 1000;i++) {
            differentSymbols.add(robotPlayer.showNextSymbol());
        }
        assertEquals(3, differentSymbols.size(), "Choices random is not distributed normally");
    }
}

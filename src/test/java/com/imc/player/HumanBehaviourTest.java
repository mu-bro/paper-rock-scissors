package com.imc.player;

import com.imc.ui.Console;
import com.imc.ui.UserInterface;
import org.junit.jupiter.api.Test;

import static com.imc.game.Symbol.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HumanBehaviourTest {

    @Test
    public void testShouldCorrectlyDefineNonEmptyUserName() {
        UserInterface mockUi = mock(Console.class);
        when(mockUi.readInputData()).thenReturn("", "   ", "PlayerName", "123");

        HumanBehaviour humanBehaviour = new HumanBehaviour(mockUi);
        assertEquals("PlayerName", humanBehaviour.definePlayerName());
    }

    @Test
    public void testShouldCorrectlyParseUsersSymbolInput() {
        UserInterface mockUi = mock(Console.class);
        when(mockUi.readInputData())
                .thenReturn("PlayerName", "", "123", "P", "paPeR", "111", "rock", "scisors", "SCISSORS");

        Player humanPlayer = new Player(new HumanBehaviour(mockUi));

        assertEquals(PAPER, humanPlayer.showNextSymbol());
        assertEquals(ROCK, humanPlayer.showNextSymbol());
        assertEquals(SCISSORS, humanPlayer.showNextSymbol());
    }
}

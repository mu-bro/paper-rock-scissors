package com.imc.player;

import com.imc.ui.Console;
import com.imc.ui.UserInterface;
import org.junit.jupiter.api.Test;

import static com.imc.game.Symbol.PAPER;
import static com.imc.game.Symbol.ROCK;
import static com.imc.game.Symbol.SCISSORS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HumanBehaviourTest {

    @Test
    public void shouldCorrectlyDefineNonEmptyUserName() {
        UserInterface mockUi = mock(Console.class);
        when(mockUi.readInputData()).thenReturn("", "   ", "PlayerName", "123");

        Player humanPlayer = new Player(new HumanBehaviour(mockUi));
        assertEquals("PlayerName", humanPlayer.getName());
    }

    @Test
    public void shouldCorrectlyParseUsersSymbolInput() {
        UserInterface mockUi = mock(Console.class);
        when(mockUi.readInputData())
                .thenReturn("PlayerName", "", "123", "P", "paPeR", "111", "rock", "scisors","SCISSORS");

        Player humanPlayer = new Player(new HumanBehaviour(mockUi));

        assertEquals(PAPER, humanPlayer.showNextSymbol());
        assertEquals(ROCK, humanPlayer.showNextSymbol());
        assertEquals(SCISSORS, humanPlayer.showNextSymbol());
    }
}

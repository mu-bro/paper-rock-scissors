package com.imc.player;

import com.imc.ui.Console;
import com.imc.ui.UserInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PlayerConfiguratorTest {

    @Test
    public void shouldCreateHumanPlayer() {
        UserInterface mockUi = mock(Console.class);
        when(mockUi.readInputData()).thenReturn("", "human", "PlayerName");

        Player humanPlayer = PlayerConfigurator.createPlayer(mockUi);
        assertEquals("PlayerName", humanPlayer.getName());
        verify(mockUi, times(3)).readInputData();
    }

    @Test
    public void shouldCreateRobotPlayer() {
        UserInterface mockUi = mock(Console.class);
        when(mockUi.readInputData()).thenReturn("", "robot", "PlayerName");

        Player robotPlayer = PlayerConfigurator.createPlayer(mockUi);
        robotPlayer.showNextSymbol();
        verify(mockUi, times(2)).readInputData();
    }
}

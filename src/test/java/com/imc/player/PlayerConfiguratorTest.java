package com.imc.player;

import com.imc.ui.Console;
import com.imc.ui.UserInterface;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PlayerConfiguratorTest {

    @Test
    public void testShouldCreateHumanPlayer() {
        UserInterface mockUi = mock(Console.class);
        when(mockUi.readInputData()).thenReturn("", "human", "PlayerName");

        PlayerConfigurator.createPlayer(mockUi);
        verify(mockUi, times(3)).readInputData();
    }

    @Test
    public void testShouldCreateRobotPlayer() {
        UserInterface mockUi = mock(Console.class);
        when(mockUi.readInputData()).thenReturn("", "robot", "PlayerName");

        Player robotPlayer = PlayerConfigurator.createPlayer(mockUi);
        robotPlayer.showNextSymbol();
        verify(mockUi, times(2)).readInputData();
    }
}

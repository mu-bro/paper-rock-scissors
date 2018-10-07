package com.imc.game;

import com.imc.player.Player;
import com.imc.player.PlayerConfigurator;
import com.imc.ui.UserInterface;

public class GameConfigurator {
    public static final int MIN_ROUNDS = 1;
    public static final int MAX_ROUNDS = 10;

    private final UserInterface ui;
    private Player player1;
    private Player player2;
    private Integer totalRounds;

    private GameConfigurator(UserInterface ui) {
        this.ui = ui;
    }


    /**
     * Game builder for ui, players and amount of rounds definition.
     * @param ui UserInterface implementation for interaction with user
     * @return Created game instance based on defined parameters
     */
    public static GameConfigurator configureGameWithUI(UserInterface ui) {
        return new GameConfigurator(ui);
    }

    public GameConfigurator createFirstPlayer() {
        ui.showMessage("Player #1:");
        this.player1 = PlayerConfigurator.createPlayer(ui);
        return this;
    }

    public GameConfigurator createSecondPlayer() {
        ui.showMessage("Player #2:");
        this.player2 = PlayerConfigurator.createPlayer(ui);
        return this;
    }

    public GameConfigurator defineAmountOfRounds(int minRounds, int maxRounds) {
        Integer userInputOfRounds = 0;
        while (userInputOfRounds < minRounds || userInputOfRounds > maxRounds) {
            ui.showMessage("Enter amount rounds to play (number from " + minRounds + " to " + maxRounds + ")");
            try {
                userInputOfRounds = Integer.valueOf(ui.readInputData());
            } catch (NumberFormatException e) {
                ui.showMessage("Incorrect input data. Should be number");
            }
        }
        this.totalRounds = userInputOfRounds;
        return this;
    }

    public Game build() {
        if (player1 == null) throw new RuntimeException("Player #1 was not defined");
        if (player2 == null) throw new RuntimeException("Player #2 was not defined");
        if (totalRounds == null) throw new RuntimeException("Total rounds amount was not defined");
        return new Game(ui, player1, player2, totalRounds);
    }

}

package com.imc.player;

import com.imc.game.Symbol;
import com.imc.ui.UserInterface;

public class HumanBehaviour implements Behaviour {

    private final UserInterface ui;

    public HumanBehaviour(UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public String definePlayerName() {
        String userInputOfPlayerName;
        do {
            ui.showMessage("Please write player name:");
            userInputOfPlayerName = ui.readInputData().trim();
            if (userInputOfPlayerName.isEmpty()) {
                ui.showMessage("Name can't be empty!");
            }
        } while (userInputOfPlayerName.isEmpty());
        return userInputOfPlayerName;
    }

    @Override
    public Symbol makeNextChoice() {
        ui.showMessage("Make your choice: " + Symbol.showChoices());
        Symbol symbol = null;

        while (symbol == null) {
            String userInputOfSymbol = ui.readInputData();
            try {
                symbol = Symbol.valueOf(userInputOfSymbol.toUpperCase());
            } catch (IllegalArgumentException e) {
                ui.showMessage("Incorrect symbol. Please choose between " + Symbol.showChoices());
            }
        }
        return symbol;
    }
}

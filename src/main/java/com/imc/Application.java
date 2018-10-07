package com.imc;

import com.imc.game.Game;
import com.imc.game.GameConfigurator;
import com.imc.ui.Console;
import com.imc.ui.UserInterface;

import static com.imc.game.GameConfigurator.MAX_ROUNDS;
import static com.imc.game.GameConfigurator.MIN_ROUNDS;

public class Application {

    public static void main(String[] args) {
        try {

            UserInterface ui = new Console();

            Game game = GameConfigurator
                    .configureGameWithUI(ui)
                    .createFirstPlayer()
                    .createSecondPlayer()
                    .defineAmountOfRounds(MIN_ROUNDS, MAX_ROUNDS)
                    .build();
            do {
                game.play();
            } while (game.needToRepeat());


        } catch (Exception e) {
            System.out.println("Some unexpected error occurs during the game - " + e.getMessage());
        }
    }
}

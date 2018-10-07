package com.imc.player;

import com.imc.ui.UserInterface;

import java.util.Random;

public class PlayerConfigurator {

    private PlayerConfigurator() {}


    /**
     * Create player depending on chosen behaviour.
     * @return Player with predefined name and behaviour type
     */
    public static Player createPlayer(UserInterface ui) {
        ui.showMessage("Choose player type: HUMAN/ROBOT");
        PlayerType playerType = null;

        while (playerType == null) {
            String userInputOfPlayerType = ui.readInputData();
            try {
                playerType = PlayerType.valueOf(userInputOfPlayerType.toUpperCase());
            } catch (IllegalArgumentException e) {
                ui.showMessage("Incorrect player type. Please write HUMAN or ROBOT");
            }
        }

        switch (playerType) {
            case HUMAN:  return new Player(new HumanBehaviour(ui));
            case ROBOT:
                return new Player(new RobotBehaviour(new Random()));
            default:
                throw new RuntimeException("This behaviour type is not supported - " + playerType.toString());
        }
    }

    private enum PlayerType {
        HUMAN,ROBOT
    }
}

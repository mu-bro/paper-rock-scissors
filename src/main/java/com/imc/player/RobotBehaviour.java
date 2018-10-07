package com.imc.player;

import com.imc.game.Symbol;

import java.util.Random;

public class RobotBehaviour implements Behaviour {

    private final static String[] names = {"Robot Wall-E", "R2D2", "Terminator", "Robot Tars", "Mega Man", "Bender Bending"};
    private final Random random;

    public RobotBehaviour() {
        this.random = new Random();
    }

    public RobotBehaviour(Random random) {
        this.random = random;
    }

    @Override
    public String definePlayerName() {
        return names[random.nextInt(names.length)];
    }

    @Override
    public Symbol makeNextChoice() {
        return Symbol.values()[random.nextInt(Symbol.values().length)];
    }
}

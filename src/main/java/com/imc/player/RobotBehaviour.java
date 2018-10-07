package com.imc.player;

import com.imc.game.Symbol;

import java.util.Random;

public class RobotBehaviour implements Behaviour {
    private final static String[] names = {"Robot Wall-E", "R2D2", "Terminator", "Robot Tars", "Mega Man", "Bender Bending"};

    @Override
    public String definePlayerName() {
        return names[new Random().nextInt(names.length)];
    }

    @Override
    public Symbol makeNextChoice() {
        return Symbol.values()[new Random().nextInt(Symbol.values().length)];
    }
}

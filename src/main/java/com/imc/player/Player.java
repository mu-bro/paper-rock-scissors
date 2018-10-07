package com.imc.player;

import com.imc.game.Symbol;

public class Player {

    private final String name;
    private final Behaviour behaviour;

    public Player(Behaviour behaviour) {
        this.behaviour = behaviour;
        this.name = behaviour.definePlayerName();
    }

    public String getName() {
        return name;
    }

    public Symbol showNextSymbol() {
        return behaviour.makeNextChoice();
    }
}

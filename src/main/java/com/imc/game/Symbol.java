package com.imc.game;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Symbol implements Comparable<Symbol> {
    PAPER {
        public ComparisonResult compareWith(Symbol symbol) {
            return compareSymbolsHelper(ROCK, SCISSORS, symbol);
        }
    },
    ROCK {
        public ComparisonResult compareWith(Symbol symbol) {
            return compareSymbolsHelper(SCISSORS, PAPER, symbol);
        }
    },
    SCISSORS {
        public ComparisonResult compareWith(Symbol symbol) {
            return compareSymbolsHelper(PAPER, ROCK, symbol);
        }
    };

    private static ComparisonResult compareSymbolsHelper(Symbol winSymbol, Symbol looseSymbol, Symbol currentSymbol) {
        if (currentSymbol.equals(winSymbol)) return ComparisonResult.WINS;
        if (currentSymbol.equals(looseSymbol)) return ComparisonResult.LOOSES;
        return ComparisonResult.DRAW;
    }

    public static String showChoices() {
        return Arrays.asList(Symbol.values()).stream().map(e -> e.toString()).collect(Collectors.joining("/"));
    }

    public abstract ComparisonResult compareWith(Symbol symbol);

    public enum ComparisonResult {
        WINS, DRAW, LOOSES
    }
}

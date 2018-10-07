package com.imc.game;

import org.junit.jupiter.api.Test;

import static com.imc.game.Symbol.ComparisonResult.*;
import static com.imc.game.Symbol.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymbolTest {

    @Test
    public void testSymbolsComparison() {
        testSymbolsComparison(PAPER, ROCK, WINS);
        testSymbolsComparison(PAPER, SCISSORS, LOOSES);
        testSymbolsComparison(PAPER, PAPER, DRAW);

        testSymbolsComparison(ROCK, SCISSORS, WINS);
        testSymbolsComparison(ROCK, PAPER, LOOSES);
        testSymbolsComparison(ROCK, ROCK, DRAW);

        testSymbolsComparison(SCISSORS, PAPER, WINS);
        testSymbolsComparison(SCISSORS, ROCK, LOOSES);
        testSymbolsComparison(SCISSORS, SCISSORS, DRAW);
    }


    private void testSymbolsComparison(Symbol symbol, Symbol symbolToCompareWith, Symbol.ComparisonResult expectedResult) {
        assertEquals(expectedResult, symbol.compareWith(symbolToCompareWith));
    }

}

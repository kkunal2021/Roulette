package com.kunal.rest.domain;

import com.kunal.rest.repository.RouletteCasinoGameBetEvenOdd;

/**
 * @author kunal
 */

public class OddEvenEnumRule implements RouletteCasinoGameBetEvenOdd {

    static final double TOTAL_BET_AMOUNT = 2.0;

    enum GameEvenOdd {
        EVEN, ODD;
        static GameEvenOdd gameEvenOdd(final String game) {
            for (GameEvenOdd gameEvenOdd : values()) {
                if (gameEvenOdd.name().equals(game)) {
                    return gameEvenOdd;
                }
            }
            return null;
        }
    }

    private final GameEvenOdd type;

    OddEvenEnumRule(final GameEvenOdd type) {
        this.type = type;
    }

    @Override
    public double totalBetAmount() {
        return TOTAL_BET_AMOUNT;
    }

    @Override
    public String conversionValue() {
        return type.name();
    }

    @Override
    public boolean gamingBetResult(final RouletteCasinoGameBetEvenOdd other) {
        return this.conversionValue().equals(other.conversionValue());
    }
}

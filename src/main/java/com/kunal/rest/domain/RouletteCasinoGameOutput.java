package com.kunal.rest.domain;

import com.kunal.rest.repository.RouletteCasinoGameBetEvenOdd;

/**
 * @author kunal
 */

public class RouletteCasinoGameOutput {

    public static final double ZERO = 0.0;
    private final RouletteCasinoGameBet rouletteCasinoGameBet;
    private final RouletteCasinoGameBetEvenOdd[] rouletteCasinoGameBetEvenOdds;

    public RouletteCasinoGameOutput(final RouletteCasinoGameBet rouletteCasinoGameBet, final RouletteCasinoGameBetEvenOdd[] rouletteCasinoGameBetEvenOdds) {
        this.rouletteCasinoGameBet = rouletteCasinoGameBet;
        this.rouletteCasinoGameBetEvenOdds = rouletteCasinoGameBetEvenOdds;
    }

    RouletteCasinoGameBet rouletteCasinoGameBet() {
        return rouletteCasinoGameBet;
    }

    @Override
    public String toString() {
        if (win()) {
        } else {
        }
        return "";
    }

    boolean win() {
        for (RouletteCasinoGameBetEvenOdd rouletteCasinoGameBetEvenOdd : rouletteCasinoGameBetEvenOdds) {
            if (rouletteCasinoGameBetEvenOdd.equals(rouletteCasinoGameBet.rouletteCasinoGameBetEvenOdd())) {
                return true;
            }
        }
        return false;
    }
}

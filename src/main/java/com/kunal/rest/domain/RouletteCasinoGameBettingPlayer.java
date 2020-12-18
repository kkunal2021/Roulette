package com.kunal.rest.domain;

/**
 * @author kunal
 */

public class RouletteCasinoGameBettingPlayer {

    private final String rollingDiceEvenOrOdd;
    private double rouletteCasinoGameWin;
    private double rouletteCasinoGameNumberOfBets;

    public RouletteCasinoGameBettingPlayer(final String rollingDiceEvenOrOdd, final double rouletteCasinoGameWin,
                                           final double rouletteCasinoGameNumberOfBets) {
        this.rollingDiceEvenOrOdd = rollingDiceEvenOrOdd;
        this.rouletteCasinoGameWin = rouletteCasinoGameWin;
        this.rouletteCasinoGameNumberOfBets = rouletteCasinoGameNumberOfBets;
    }

    public RouletteCasinoGameBettingPlayer(final String rollingDiceEvenOrOdd) {
        this(rollingDiceEvenOrOdd, 0.0, 0.0);
    }

    public String rollingDiceEvenOrOdd() {
        return rollingDiceEvenOrOdd;
    }

    public double rouletteCasinoGameWin() {
        return rouletteCasinoGameWin;
    }

    public double rouletteCasinoGameNumberOfBets() {
        return rouletteCasinoGameNumberOfBets;
    }
}

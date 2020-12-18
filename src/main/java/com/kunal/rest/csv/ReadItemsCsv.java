package com.kunal.rest.csv;

/**
 * @author kunal
 */

public enum ReadItemsCsv {

    ROLLING_DICE_EVEN_OR_ODD(0),
    ROULETTE_CASINO_GAME_WIN(1),
    ROULETTE_CASINO_GAME_NUMBER_OF_BET(2);

    private final int startingPoint;

    private ReadItemsCsv(final int startingPoint) {
        this.startingPoint = startingPoint;
    }

    int startingPoint() {
        return startingPoint;
    }
}

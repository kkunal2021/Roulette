package com.kunal.rest.domain;

import com.kunal.rest.repository.RouletteCasinoGameBetEvenOdd;

public class OddEvenEnumRule implements RouletteCasinoGameBetEvenOdd {

    @Override
    public double totalBetAmount() {
        return 0;
    }

    @Override
    public String conversionValue() {
        return null;
    }

    @Override
    public boolean gamingBetResult(RouletteCasinoGameBetEvenOdd rouletteCasinoGameBetEvenOdd) {
        return false;
    }
}

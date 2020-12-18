package com.kunal.rest.domain;

import com.kunal.rest.repository.RouletteCasinoGameBetEvenOdd;

/**
 * @author kunal
 */

public class RouletteCasinoGameBet {

	private final RouletteCasinoGameBetEvenOdd rouletteCasinoGameBetEvenOdd;
	private final double bettingAmount;
	private final RouletteCasinoGameBettingPlayer rouletteCasinoGameBettingPlayer;

	public RouletteCasinoGameBet(final RouletteCasinoGameBettingPlayer rouletteCasinoGameBettingPlayer,
								 final RouletteCasinoGameBetEvenOdd rouletteCasinoGameBetEvenOdd,
								 final double bettingAmount) {
		this.rouletteCasinoGameBettingPlayer = rouletteCasinoGameBettingPlayer;
		this.rouletteCasinoGameBetEvenOdd = rouletteCasinoGameBetEvenOdd;
		this.bettingAmount = bettingAmount;
	}

	public RouletteCasinoGameBettingPlayer rouletteCasinoGameBettingPlayer() {
		return rouletteCasinoGameBettingPlayer;
	}

	public RouletteCasinoGameBetEvenOdd target() {
		return rouletteCasinoGameBetEvenOdd;
	}

	public double bettingAmount() {
		return bettingAmount;
	}
}

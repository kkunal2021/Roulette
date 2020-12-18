package com.kunal.rest.repository;

/**
 * @author kunal
 */

public interface IRouletteCasinoGameBetEvenOdd {

	double totalBetAmount();
	String conversionValue();
	boolean gamingBetResult(RouletteCasinoGameBetEvenOdd rouletteCasinoGameBetEvenOdd);
}
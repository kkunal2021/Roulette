package com.kunal.rest.repository;

import com.kunal.rest.domain.RouletteCasinoGameBettingPlayer;

import java.util.Collection;

/**
 * @author kunal
 */

public interface RouletteCasinoGameRepository {

    Collection<RouletteCasinoGameBettingPlayer> evenOrOddPlayers();
    void save(Collection<RouletteCasinoGameBettingPlayer> rouletteCasinoGameBettingPlayers);
}

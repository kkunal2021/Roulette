package com.kunal.rest.csv;

import com.kunal.rest.domain.RouletteCasinoGameBettingPlayer;
import com.kunal.rest.exceptions.UserNotFoundException;
import com.kunal.rest.repository.RouletteCasinoGameRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author kunal
 */

public class CsvRepository implements RouletteCasinoGameRepository {

    private final File inputFile;

    public CsvRepository(final File inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public Collection<RouletteCasinoGameBettingPlayer> evenOrOddPlayers() {
        return readRouletteCasinoUsers(readSourceInput(inputFile));
    }

    @Override
    public void save(Collection<RouletteCasinoGameBettingPlayer> rouletteCasinoGameBettingPlayers) {
    }

    private Collection<RouletteCasinoGameBettingPlayer> readRouletteCasinoUsers(final Collection<String> collectionOfPlayers) {
        List<RouletteCasinoGameBettingPlayer> rouletteCasinoGameBettingPlayer = new ArrayList<>();

        for (String collectionOfPlayer : collectionOfPlayers) {
            RouletteCasinoGameBettingPlayer rouletteCasinoGameBettingPlayers = rouletteCasinoGameBettingPlayer(collectionOfPlayer);
            if (rouletteCasinoGameBettingPlayers != null) {
                rouletteCasinoGameBettingPlayer.add(rouletteCasinoGameBettingPlayers);
            }
        }

        if (rouletteCasinoGameBettingPlayer.isEmpty()) {
            throw new RuntimeException("No Users Found");
        }

        return rouletteCasinoGameBettingPlayer;
    }

    private RouletteCasinoGameBettingPlayer rouletteCasinoGameBettingPlayer(String collectionOfPlayer) {
        return null;
    }

    private Collection<String> readSourceInput(final File file) {
        final List<String> rollingDice = new ArrayList<>();
        try {

            final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String rollingDices;

            while ((rollingDices = bufferedReader.readLine()) != null) {
                rollingDice.add(rollingDices);
            }
            bufferedReader.close();
        } catch (IOException ioException) {
            throw new UserNotFoundException(ioException.getMessage(), ioException.getCause());
        }

        return rollingDice;
    }
}

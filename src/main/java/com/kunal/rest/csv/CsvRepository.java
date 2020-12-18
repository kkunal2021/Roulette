package com.kunal.rest.csv;

import com.kunal.rest.domain.RouletteCasinoGameBettingPlayer;
import com.kunal.rest.exceptions.UserNotFoundException;
import com.kunal.rest.repository.RouletteCasinoGameRepository;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author kunal
 */

@Slf4j
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
        new Thread(new RouletteCasinoGameHelper(rouletteCasinoGameBettingPlayers)).start();
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

    private RouletteCasinoGameBettingPlayer rouletteCasinoGameBettingPlayer(final String bettingUser) {
        String[] stringArray = bettingUser.split(",");
        if (stringArray.length == 0) {
            return null;
        }
        if (stringArray.length == ReadItemsCsv.values().length) {
            final String rollingDiceEvenOrOdd = stringArray[ReadItemsCsv.ROLLING_DICE_EVEN_OR_ODD.startingPoint()];
            final String rouletteCasinoGameWin = stringArray[ReadItemsCsv.ROULETTE_CASINO_GAME_WIN.startingPoint()];
            final String rouletteCasinoGameNumberOfBet = stringArray[ReadItemsCsv.ROULETTE_CASINO_GAME_NUMBER_OF_BET.startingPoint()];
            return new RouletteCasinoGameBettingPlayer(rollingDiceEvenOrOdd, confirmDiceRoll(rouletteCasinoGameWin), confirmDiceRoll(rouletteCasinoGameNumberOfBet));
        } else {
            return new RouletteCasinoGameBettingPlayer(stringArray[ReadItemsCsv.ROLLING_DICE_EVEN_OR_ODD.startingPoint()]);
        }
    }

    private double confirmDiceRoll(final String input) {
        try {
            return Double.valueOf(input);
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }

    private class RouletteCasinoGameHelper implements Runnable {

        private final Collection<RouletteCasinoGameBettingPlayer> rouletteCasinoGameBettingPlayer;

        public RouletteCasinoGameHelper(final Collection<RouletteCasinoGameBettingPlayer> rouletteCasinoGameBettingPlayers) {
            this.rouletteCasinoGameBettingPlayer = rouletteCasinoGameBettingPlayers;
        }

        @Override
        public void run() {
            try {
                String delimitter = ",";
                final StringBuilder readCsvFile = new StringBuilder();
                for (RouletteCasinoGameBettingPlayer rouletteCasinoGameBettingPlayers : rouletteCasinoGameBettingPlayer) {
                    readCsvFile.append(rouletteCasinoGameBettingPlayers.rollingDiceEvenOrOdd()).append(delimitter)
                            .append(rouletteCasinoGameBettingPlayers.rouletteCasinoGameWin())
                            .append(delimitter)
                            .append(rouletteCasinoGameBettingPlayers.rouletteCasinoGameNumberOfBets())
                            .append("\n");
                }
                final BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
                writer.write(readCsvFile.toString());
                writer.close();
            } catch (IOException ioException) {
                log.error("Error In Operation {} " , ioException.getCause());
            }

        }
    }
}

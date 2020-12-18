package com.kunal.rest.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RouletteCasinoGameBetPlacing {

    private final List<RouletteCasinoGameBet> rouletteCasinoGameBets = new ArrayList<>();
    private final BlockingQueue<RouletteCasinoGameBet> rouletteCasinoGameBets1 = new LinkedBlockingQueue<>();
    private boolean accepting = false;

    RouletteCasinoGameBetPlacing() {
        BettingQueue bettingQueue = new BettingQueue(rouletteCasinoGameBets1, rouletteCasinoGameBets);
        new Thread(bettingQueue).start();
    }

    public void placedBetsInGame(boolean accepting) {
        accepting = accepting;
    }

    public Collection<RouletteCasinoGameBet> ongoingBetsInGame() {
        final ArrayList<RouletteCasinoGameBet> rouletteCasinoGameBets = new ArrayList<>();
        rouletteCasinoGameBets.addAll(this.rouletteCasinoGameBets);
        return rouletteCasinoGameBets;
    }

    private class BettingQueue implements Runnable {
        private final BlockingQueue<RouletteCasinoGameBet> rouletteCasinoGameBetBlockingQueue;
        private final List<RouletteCasinoGameBet> rouletteCasinoGameBetList;

        public BettingQueue(final BlockingQueue<RouletteCasinoGameBet> blockingQueue, final List<RouletteCasinoGameBet> rouletteCasinoGameBetList1) {
            this.rouletteCasinoGameBetBlockingQueue = blockingQueue;
            this.rouletteCasinoGameBetList = rouletteCasinoGameBetList1;
        }

        @Override
        public void run() {
            while (true) {
                if (accepting) {
                    final RouletteCasinoGameBet rouletteCasinoGameBet;
                    try {
                        rouletteCasinoGameBet = rouletteCasinoGameBetBlockingQueue.take();
                        rouletteCasinoGameBetList.add(rouletteCasinoGameBet);
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                    }
                }
            }
        }
    }
}

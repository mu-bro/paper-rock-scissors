package com.imc.game;

import com.imc.player.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundsResults {
    public static final int UNNOWN_RESULT = -1;

    private Map<Player, AtomicInteger> winsCount;

    public RoundsResults(Player... players) {
        winsCount = new HashMap<>();
        Arrays.asList(players).forEach(p -> winsCount.put(p, new AtomicInteger(0)));
    }


    /**
     * Add player to results
     *
     * @param winner player to increment score
     * @return true if winner successfully added, false - if player not found in results
     */
    public boolean addRoundWinner(Player winner) {
        if (winsCount.containsKey(winner)) {
            winsCount.get(winner).incrementAndGet();
            return true;
        }
        return false;
    }

    public int getScore(Player player) {
        if (winsCount.containsKey(player)) {
            return winsCount.get(player).get();
        } else {
            return UNNOWN_RESULT;
        }
    }

    public void resetScores() {
        winsCount.entrySet().forEach(e -> e.getValue().set(0));
    }
}

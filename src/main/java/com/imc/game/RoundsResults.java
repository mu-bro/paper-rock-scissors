package com.imc.game;

import com.imc.player.Player;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toMap;

public class RoundsResults {
    public static final int UNNOWN_RESULT = -1;

    private Map<Player, AtomicInteger> winsCount;

    public RoundsResults(Player... players) {
        winsCount = new HashMap<>();
        Arrays.asList(players).forEach(p -> winsCount.put(p, new AtomicInteger(0)));
    }

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

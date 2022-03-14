package ru.netology.domain;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Player> players = new HashMap<>();

    public void register(String playerName, Player player) {
        players.put(playerName, player);
    }

    public int round(String playerName1, String playerName2) {
        if (!players.containsKey(playerName1)) {
            throw new NotRegisteredException("Player with name " + playerName1 + " not found");
        }
        if (!players.containsKey(playerName2)) {
            throw new NotRegisteredException("Player with name " + playerName2 + " not found");
        }

        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);
        if (player1.getStrength() - player2.getStrength() > 0) {
            return 1;
        }
        if (player1.getStrength() - player2.getStrength() < 0) {
            return 2;
        }
        return 0;
    }
}

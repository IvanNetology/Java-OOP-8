package ru.netology.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private Collection<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player with name " + playerName1 + " not found");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player with name " + playerName2 + " not found");
        }

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1.getStrength() - player2.getStrength() > 0) {
            return 1;
        }
        if (player1.getStrength() - player2.getStrength() < 0) {
            return 2;
        }
        return 0;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}

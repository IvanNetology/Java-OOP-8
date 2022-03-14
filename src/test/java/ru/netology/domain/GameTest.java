package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();

    private Player player1 = new Player(1, "Alex", 100);
    private Player player2 = new Player(2, "Jon", 200);
    private Player player3 = new Player(3, "Max", 200);
    private Player player4 = new Player(4, "Sten", 400);

    @Test
    public void shouldWhereNoPlayers() {
        String playerName1 = "Alex";
        String playerName2 = "Jon";

        assertThrows(NotRegisteredException.class, () -> game.round(playerName1, playerName2));
    }

    @Test
    public void shouldWhereOnePlayers() {
        game.register("Alex", player1);

        String playerName1 = "Alex";
        String playerName2 = "Jon";

        assertThrows(NotRegisteredException.class, () -> game.round(playerName1, playerName2));
    }

    @Test
    public void shouldWhereTwoPlayers() {
        game.register("Alex", player1);
        game.register("Jon", player2);

        String playerName1 = "Alex";
        String playerName2 = "Jon";

        assertEquals(2, game.round(playerName1, playerName2));
    }

    @Test
    public void shouldWhereWinFirstPlayer() {
        game.register("Alex", player1);
        game.register("Jon", player2);
        game.register("Max", player3);

        String playerName1 = "Jon";
        String playerName2 = "Alex";

        assertEquals(1, game.round(playerName1, playerName2));
    }

    @Test
    public void shouldWhereWinSecondPlayer() {
        game.register("Alex", player1);
        game.register("Jon", player2);
        game.register("Max", player3);

        String playerName1 = "Alex";
        String playerName2 = "Jon";

        assertEquals(2, game.round(playerName1, playerName2));
    }

    @Test
    public void shouldWhereDraw() {
        game.register("Alex", player1);
        game.register("Jon", player2);
        game.register("Max", player3);
        game.register("Sten", player4);

        String playerName1 = "Jon";
        String playerName2 = "Max";

        assertEquals(0, game.round(playerName1, playerName2));
    }

    @Test
    public void shouldWhereNoMatch() {
        game.register("Alex", player1);
        game.register("Jon", player2);
        game.register("Max", player3);
        game.register("Sten", player4);

        String playerName1 = "Shon";
        String playerName2 = "Kurt";

        assertThrows(NotRegisteredException.class, () -> game.round(playerName1, playerName2));
    }

    @Test
    public void shouldWhereOneMatch() {
        game.register("Alex", player1);
        game.register("Jon", player2);
        game.register("Max", player3);
        game.register("Sten", player4);

        String playerName1 = "Jon";
        String playerName2 = "Kurt";

        assertThrows(NotRegisteredException.class, () -> game.round(playerName1, playerName2));
    }
}
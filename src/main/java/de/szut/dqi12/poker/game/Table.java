package de.szut.dqi12.poker.game;

import java.util.ArrayList;

/**
 * Created by Kevin on 10.06.2015.
 */
public class Table {
    ArrayList<Player> players;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player p) {
        this.players.add(p);
    }
}
package de.szut.onlinepoker.gui;

import de.szut.onlinepoker.model.Player;

/**
 * Created by Kevin on 19.01.2016.
 */
public interface GUI {
    void raise(Player p);
    void fold(Player p);
    void call(Player p);
    void bet(Player p);
    void check(Player p);
    void allIn(Player p);
    void tableBegin();
    void flopRound();
    void turnRound();
    void riverRound();
}
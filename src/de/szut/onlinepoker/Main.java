package de.szut.onlinepoker;

import de.szut.onlinepoker.menue.LoginWindow;

/**
 * Created by Kevin on 17.11.2015.
 */
public class Main {
    public static void main(String[] args) {
        LoginWindow.getInstance();
        LoginWindow.getInstance().getFrame().setVisible(true);
    }
}

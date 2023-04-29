package com.mycompany.millionair_game;

/**
 *
 * @author FabiF
 */
public abstract class AbstractJoker {

    private boolean used;

    public AbstractJoker() {
        used = false;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}

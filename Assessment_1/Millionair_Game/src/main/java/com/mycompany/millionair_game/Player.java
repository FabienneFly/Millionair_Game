package com.mycompany.millionair_game;

/**
 *
 * @author FabiF
 */
public class Player {

    private String player;
    private int money = 0;

    public Player(String player, int money) {
        this.player = player;
        this.money = money;
    }

    public String getName() {
        return player;
    }

    public void setName(String name) {
        this.player = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int score) {
        this.money = score;
    }
}

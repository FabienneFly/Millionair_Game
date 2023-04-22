/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionair_game;

import java.util.HashMap;

/**
 *
 * @author FabiF
 */
public class HighScore {

    private final HashMap<String, Player> players;
    int score;

    public HighScore(HashMap<String, Player> players) {
        this.players = players;
        this.score = 0;
    }

    public int getHighest() {
        score = players.values().stream().mapToInt(Player::getMoney).max().orElse(0);
        return score;
    }

}

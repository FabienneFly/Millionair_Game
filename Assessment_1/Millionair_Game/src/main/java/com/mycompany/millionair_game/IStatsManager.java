/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.millionair_game;


/**
 *
 * @author FabiF
 */
public interface IStatsManager {

    void saveStats(String playerName, int money);

    void printHighScores();
}

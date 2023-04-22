/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionair_game;

/**
 *
 * @author FabiF
 */
public class Prize extends Player {

    public Prize(String player, int money) {
        super(player, money);
    }

    public void Prize() {
        super.setMoney(super.getMoney() + 1000000);
    }
}

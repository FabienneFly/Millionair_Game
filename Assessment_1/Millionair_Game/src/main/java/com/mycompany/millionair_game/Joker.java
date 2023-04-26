/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionair_game;

/**
 *
 * @author FabiF
 */



public abstract class Joker {

    private boolean used;

    public Joker() {
        used = false;
    }

    public abstract void use(String correctAnswer, String[] answers);

    public boolean isUsed() {
        return used;
    }

    protected void setUsed(boolean used) {
        this.used = used;
    }
}

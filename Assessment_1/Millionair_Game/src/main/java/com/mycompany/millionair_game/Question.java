/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionair_game;

import java.util.List;

/**
 *
 * @author FabiF
 */
public abstract class Question {

    protected String questionText;

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public abstract void fetchQuestion(int i);

    public abstract List<String> display(int x);

}

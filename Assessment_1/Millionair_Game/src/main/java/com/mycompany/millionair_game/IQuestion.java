/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.millionair_game;

import java.util.List;

/**
 *
 * @author FabiF
 */
public interface IQuestion {

    void fetchQuestion(int questionIndex);

    List<String> printQuestion(int questionIndex);

    String getCorrectAnswer();
}

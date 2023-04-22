/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionair_game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author FabiF
 */
public class FileIO {

    public void HelpScreen() {
        try {
            FileReader fileReader = new FileReader("helpScreen.txt");
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading help screen file: " + e.getMessage());
        }
    }

    public void saveStats(String playerName, int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("playerScore.txt", true))) {
            writer.write(playerName + " - " + score + "\n");
        } catch (IOException e) {
            System.out.println("Error writing player score to file: " + e.getMessage());
        }
    }

    public void saveQuestion(int index, String question) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("questions.txt", true))) {
            writer.write((index + 1) + ". " + question + "\n");
        } catch (IOException e) {
            System.out.println("Error writing question to file: " + e.getMessage());
        }
    }

}

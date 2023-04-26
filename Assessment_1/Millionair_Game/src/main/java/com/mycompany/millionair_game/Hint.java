/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionair_game;

import java.util.Random;

/**
 *
 * @author FabiF
 */
public class Hint extends Joker {

    private boolean isUsed = false;

    @Override
    public void use(String correctAnswer, String[] answers) {
        if (isUsed()) {
            System.out.println("You have already used your 50/50 hint.");
            return;
        }

        // Find the index of the correct answer
        int correctIndex = -1;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals(correctAnswer)) {
                correctIndex = i;
                break;
            }
        }

        // Generate a list of indices to remove
        Random random = new Random();
        int indexToRemove1 = random.nextInt(answers.length);
        int indexToRemove2;
        do {
            indexToRemove2 = random.nextInt(answers.length);
        } while (indexToRemove2 == indexToRemove1 || indexToRemove2 == correctIndex);

        // Remove the incorrect answers
        for (int i = 0; i < answers.length; i++) {
            if (i != indexToRemove1 && i != indexToRemove2) {
                answers[i] = "";
            }
        }

        System.out.println("Here are your options:");
        for (int i = 0; i < answers.length; i++) {
            if (!answers[i].equals("")) {
                System.out.println((i + 1) + ". " + answers[i]);
            }
        }

        // ... (the rest of the useFiftyFifty code)
        setUsed(true);
    }
}

package com.mycompany.millionair_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hint extends AbstractJoker {

    public void useFiftyFifty(String correctAnswer, String[] answers) {
        
        //Tests if player still has a hint
        if (isUsed()) {
            System.out.println("You have already used all your hints.");
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
        // Shuffle the incorrect answers and remove one
        List<String> incorrectAnswers = new ArrayList<>();
        for (int i = 0; i < answers.length; i++) {
            if (i != correctIndex) {
                incorrectAnswers.add(answers[i]);
            }
        }
        Collections.shuffle(incorrectAnswers);
        incorrectAnswers = incorrectAnswers.subList(0, 1);
        
        // Print the hint
        System.out.println("Here are your options:");
        for (int i = 0; i < answers.length; i++) {
            if (i == correctIndex || incorrectAnswers.contains(answers[i])) {
                System.out.println((i + 1) + ". " + answers[i]);
            }
        }
        setUsed(true);
    }
}

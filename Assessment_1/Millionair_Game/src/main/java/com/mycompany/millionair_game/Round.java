/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionair_game;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FabiF
 */
public class Round {

    private final HashMap<String, Player> players;
    private final Player player;
    private MultipleChoiceQuestion multipleChoiceQuestion;
    private final FileIO saveScore = new FileIO();

    public Round(Player player) {
        this.players = new HashMap<>();
        this.player = player;
    }

    public void playQuestion() {
        multipleChoiceQuestion = new MultipleChoiceQuestion();

        for (int i = 0; i < 10; i++) {
            multipleChoiceQuestion.fetchQuestion(i);

            Scanner scanner = new Scanner(System.in);
            List<String> shuffledAnswers = multipleChoiceQuestion.printQuestion(i);
            String playerAnswerString = scanner.nextLine();

            if (playerAnswerString.toLowerCase().equals("x")) {
                break;
            }

            try {
                int playerAnswer = Integer.parseInt(playerAnswerString);

                if (shuffledAnswers.get(playerAnswer - 1).equals(multipleChoiceQuestion.getCorrectAnswer())) {
                    System.out.println("Correct! You get +100,000$");
                    player.setMoney(player.getMoney() + 100000);
                    System.out.println("");
                    if (i == 9) {
                        System.out.println("Congratulations! You answered all 10 questions correctly.");
                        saveScore.saveStats(player.getName(), player.getMoney());
                    }
                } else {
                    System.out.println("Incorrect. The correct answer is: " + multipleChoiceQuestion.getCorrectAnswer());
                    System.out.println("Thank you for playing, your score is: " + player.getMoney() + "$");
                    saveScore.saveStats(player.getName(), player.getMoney());
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.println("");
            }
        }
    }

  

}

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
    private Life life;

    public Round(Player player) {
        this.players = new HashMap<>();
        this.player = player;
    }

    public void playQuestion() {
        multipleChoiceQuestion = new MultipleChoiceQuestion();
        life = new Life();

        int questionIndex = 0;

        while (questionIndex < 10) {
            multipleChoiceQuestion.fetchQuestion(questionIndex);

            Scanner scanner = new Scanner(System.in);
            List<String> shuffledAnswers = multipleChoiceQuestion.printQuestion(questionIndex);
            String playerAnswerString = "";
            boolean questionAnsweredOrSkipped = false;

            while (!questionAnsweredOrSkipped) {
                //TODO: Make output into string and change after use (delete the joker which was already used)
                System.out.println("Press 'H' button for a hint, press 'T' to Skip the question or enter your answer!");
                playerAnswerString = scanner.nextLine().toUpperCase();

                if (playerAnswerString.equals("H")) {
                    // Use 50/50 hint
                    life.useFiftyFifty(multipleChoiceQuestion.getCorrectAnswer(), shuffledAnswers.toArray(new String[0]));
                } else if (playerAnswerString.equals("T")) {
                    // Use skip option
                    life.useSkip();
                    questionIndex++;
                    questionAnsweredOrSkipped = true;
                } else {
                    try {
                        int playerAnswer = Integer.parseInt(playerAnswerString);

                        if (shuffledAnswers.get(playerAnswer - 1).equals(multipleChoiceQuestion.getCorrectAnswer())) {
                            System.out.println("Correct! You get +100,000$");
                            System.out.println("");
                            if (questionIndex == 9) {
                                System.out.println("Congratulations! You answered all 10 questions correctly.");
                                saveScore.saveStats(player.getName(), player.getMoney());
                            }
                            questionIndex++;
                            questionAnsweredOrSkipped = true;
                        } else {
                            System.out.println("Incorrect. The correct answer is: " + multipleChoiceQuestion.getCorrectAnswer());
                            System.out.println("Thank you for playing, your score is: " + player.getMoney() + "$");
                            saveScore.saveStats(player.getName(), player.getMoney());
                            questionIndex = 10; // Exit the loop
                            questionAnsweredOrSkipped = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        System.out.println("");
                    }
                }
            }

            if (playerAnswerString.toLowerCase().equals("x")) {
                break;
            }
        }
    }

}

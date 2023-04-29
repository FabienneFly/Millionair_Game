package com.mycompany.millionair_game;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FabiF
 */
public class Round {

    private final Player player;
    private MultipleChoiceQuestion multipleChoiceQuestion;
    private final FileIO score = new FileIO();
    private Hint hint;
    private Skip skip;
    private final GameStart gameStart = new GameStart();

    public Round(Player player) {
        this.player = player;
    }

    //Start a round
    public void playQuestion() {
        multipleChoiceQuestion = new MultipleChoiceQuestion();
        hint = new Hint();
        skip = new Skip();
        int questionIndex = 0;

        while (questionIndex < 10) {
            multipleChoiceQuestion.fetchQuestion(questionIndex);

            Scanner scanner = new Scanner(System.in);
            List<String> shuffledAnswers = multipleChoiceQuestion.display(questionIndex);
            String playerAnswerString = "";
            boolean questionAnsweredOrSkipped = false;

            while (!questionAnsweredOrSkipped) {
                System.out.println(getJokerMessage());
                playerAnswerString = scanner.nextLine().toUpperCase();

                switch (playerAnswerString.toLowerCase()) {
                    case "h":
                        // Use 50/50 hint
                        hint.useFiftyFifty(multipleChoiceQuestion.getCorrectAnswer(), shuffledAnswers.toArray(new String[0]));
                        break;
                    case "t":
                        // Use skip option
                        if (skip.useSkip()) {
                            questionIndex++;
                            questionAnsweredOrSkipped = true;
                        }
                        break;
                    case "x":
                        // Use exit
                        gameStart.exitProgram();
                        break;
                    default:
                        try {
                        int playerAnswer = Integer.parseInt(playerAnswerString);

                        if (playerAnswer > 0 && playerAnswer <= shuffledAnswers.size()) {
                            if (shuffledAnswers.get(playerAnswer - 1).equals(multipleChoiceQuestion.getCorrectAnswer())) {
                                System.out.println("Correct! You get +100,000$");
                                player.setMoney(player.getMoney() + 100000);
                                System.out.println("");
                                if (questionIndex == 9) {
                                    System.out.println("Congratulations! You answered all 10 questions correctly.");
                                    score.saveStats(player.getName(), player.getMoney());
                                    score.printHighScores();

                                }
                                questionIndex++;
                                questionAnsweredOrSkipped = true;
                            } else {
                                System.out.println("Incorrect. The correct answer is: " + multipleChoiceQuestion.getCorrectAnswer() + "\n");
                                System.out.println("###############################################");
                                System.out.println("Thank you for playing, your score is: " + player.getMoney() + "$");
                                System.out.println("############################################### \n");

                                score.saveStats(player.getName(), player.getMoney());
                                score.printHighScores();
                                questionIndex = 10; // Exit the loop
                                questionAnsweredOrSkipped = true;
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number between 1 and " + shuffledAnswers.size() + ".");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        System.out.println("");
                    }
                    break;
                }
            }

            if (playerAnswerString.equalsIgnoreCase("x")) {
                break;
            }
        }
    }

    //Message whether Jokers are used or not
    public String getJokerMessage() {
        if (!hint.isUsed() && !skip.isUsed()) {
            return "Enter your answer or press 'H' for a hint. Press 'T' to skip the question.";
        } else if (!hint.isUsed()) {
            return "Enter your answer or press 'H' for a hint.";
        } else if (!skip.isUsed()) {
            return "Enter your answer or press 'T' to skip the question.";
        } else {
            return "No Joker left. Please enter your answer";
        }
    }
}

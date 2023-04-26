package com.mycompany.millionair_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Life {

    private boolean fiftyFiftyUsed;
    private boolean skipUsed;

    public Life() {
        fiftyFiftyUsed = false;
        skipUsed = false;
    }

    public void useFiftyFifty(String correctAnswer, String[] answers) {
        if (fiftyFiftyUsed)  {
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
    }

    public void useSkip() {
        if (skipUsed) {
            System.out.println("You have already used your skip option.");
            return;
        }

        skipUsed = true;
        System.out.println("Skipping the current question...");
    }

    public boolean isFiftyFiftyUsed() {
        return fiftyFiftyUsed;
    }

    public boolean isSkipUsed() {
        return skipUsed;
    }
}

//package com.mycompany.millionair_game;
//
//public class Life {
//
//    private Hint fiftyFifty;
//    private Skip skip;
//
//    public Life() {
//        fiftyFifty = new Hint();
//        skip = new Skip();
//    }
//
//    public void useFiftyFifty(String correctAnswer, String[] answers) {
//        fiftyFifty.use(correctAnswer, answers);
//    }
//
//    public void useSkip() {
//        skip.use();
//    }
//
//    public boolean isFiftyFiftyUsed() {
//        return fiftyFifty.isUsed();
//    }
//
//    public boolean isSkipUsed() {
//        return skip.isUsed();
//    }
//}

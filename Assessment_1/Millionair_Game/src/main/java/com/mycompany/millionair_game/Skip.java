package com.mycompany.millionair_game;

public class Skip extends Joker {

    public boolean useSkip() {
        if (isUsed()) {
            System.out.println("You have already used your skip option.");
            return false;
        }
        setUsed(true);
        System.out.println("Skipping the current question...");
        return true;
    }
}

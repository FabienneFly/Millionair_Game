package com.mycompany.millionair_game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author FabiF
 */
public class GameStart {

    static Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean validInput = false;
        String playerInput;

        //Welcomes Player
        System.out.println("Welcome to the Who wants to be a millionair game :) Here are the rules:\n");

        //Prints the Helpscreen
        FileIO helpScreen = new FileIO();
        helpScreen.helpScreen();

        //Handles UserInput (Name or Exit)
        do {
            try {
                System.out.print("Enter 1 to continue or x to exit: ");
                playerInput = scanner.nextLine();
                System.out.println("");

                if (playerInput.equals("1")) {
                    playerName();
                    validInput = true;

                } else if (playerInput.equalsIgnoreCase("x")) {
                    exitProgram();
                    validInput = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter 1 or x.");
            }
        } while (!validInput);

        scanner.close();
    }

    //UserName
    public void playerName() {
        System.out.print("Please enter your Name: ");
        String playerName = scanner.nextLine();
        Player currentPlayer = new Player(playerName, 0);
        System.out.println(" ");

        //New Round
        Round round = new Round(currentPlayer);
        round.playQuestion();

    }

    //Exit Program
    public void exitProgram() {
        System.out.println("Have a nice day!");
        System.exit(0);
    }

}

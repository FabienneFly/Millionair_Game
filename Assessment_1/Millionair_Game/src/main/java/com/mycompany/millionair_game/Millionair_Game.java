/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.millionair_game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author FabiF
 */
public class Millionair_Game {

    static Scanner scanner = new Scanner(System.in);
    static String playerInput;

    public static void main(String[] args) {
        System.out.println("Welcome to the Who wants to be a millionair game :) Here are the rules:");
        FileIO helpScreen = new FileIO();
        helpScreen.HelpScreen();
        boolean validInput = false;
        int index = 0;

        do {
            try {
                System.out.print("Enter 1 to continue or x to exit: ");
                String playerInput = scanner.nextLine();
                System.out.println("");

                if (playerInput.equals("1")) {
                    System.out.println("Please enter your Name: ");
                    String playerName = scanner.nextLine();
                    Player currentPlayer = new Player(playerName, 0);
      
                    Round round = new Round(currentPlayer);
                    round.playQuestion();
                    validInput = true;

                } else if (playerInput.toLowerCase().equals("x")) {
                    System.out.println("Have a nice day");
                    validInput = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter 1 or x.");
            }
        } while (!validInput);

        scanner.close();
    }

}

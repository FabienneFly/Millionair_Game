/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionair_game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Life //make a hint and skip
{
    private ArrayList<Questions> question;
    public int hint = 3;
    public int skip = 1;
    private String ha;
    private String hq;
    private String input;

    public void Life(String ha, String hq) {
        this.ha = ha;
        this.hq = hq;
    }

    public String getha() 
    {
        return this.ha;
    }

    public String gethq() 
    {
        return this.hq;
    }

    public void doHint(String hq) 
    {
        Scanner scan = new Scanner(System.in);
        if (input.equalsIgnoreCase("H")) {
            while (true) {
                if (hint > 0) {
                    System.out.println(gethq());
                    do {
                        input = scan.nextLine();

                    } while (!this.isValidAnswer(input));
                    hint--;
                }
                if (hint == 0) {
                    System.out.println("================================================\n");
                    System.out.println("You run out of hint! Please enter your answer: ");
                    System.out.println("\n================================================");
                }

            }
        }
    }

    public void doSkip(MultipleChoiceQuestion question, String hq) {
        Scanner scan = new Scanner(System.in);
        if (input.equalsIgnoreCase("T")) {
            while (true) {
                if (skip > 0) {
//                    System.out.println(question.getQuestion());
                    do {
                        input = scan.nextLine();

                    } while (!this.isValidAnswer(input));
                    skip--;
                }
                if (skip == 0) {
                    System.out.println("================================================\n");
                    System.out.println("You run out of skip! Please enter your answer: ");
                    System.out.println("\n================================================");
                }
            }
        }
    }

    private boolean isValidAnswer(String answer) {
        if (answer.equalsIgnoreCase("H")) {
            return true;
        }
        if (answer.equalsIgnoreCase("T")) {
            return true;
        } else {
            System.out.println("Invalid input! Please try again: ");
            return false;
        }
    }
}
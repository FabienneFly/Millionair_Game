/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionair_game;

/**
 *
 * @author FabiF
 */
public class Questions {

    private String question = "";
    private String[] content = new String[4];
    private int correct;

    public Questions(String question, String[] content, int correct) {
        this.question = question;
        this.content = content;
        this.correct = correct;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the content
     */
    public String[] getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String[] content) {
        this.content = content;
    }

    /**
     * @return the correct
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * @param correct the correct to set
     */
    public void setCorrect(int
            correct) {
        this.correct = correct;
    }

}

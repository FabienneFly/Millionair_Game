package com.mycompany.millionair_game;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MultipleChoiceQuestion extends Question {

    private String question;
    private String correctAnswer;
    private String[] wrongAnswers;
    private static final String API_ENDPOINT = "https://opentdb.com/api.php?amount=1&difficulty=easy&type=multiple";

    //fetches a question from https://opentdb.com/api_config.php
    @Override
    public void fetchQuestion(int questionIndex) {
        try {
            // API
            String endpoint = API_ENDPOINT;
            URL url = new URL(endpoint);

            // HTTP connection & request method
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            StringBuilder response;
            
            // Read response
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            // Parse the JSON response and extract the question
            // Chatgpt
            JSONObject jsonObj = new JSONObject(response.toString());
            JSONArray resultsArr = jsonObj.getJSONArray("results");
            JSONObject resultObj = resultsArr.getJSONObject(0);
            question = resultObj.getString("question");
            correctAnswer = resultObj.getString("correct_answer");

            //Codereview ChatGPT
            if (question == null || correctAnswer == null) {
                throw new IllegalStateException("Error: question or correctAnswer is null.");

            }
            JSONArray wrongAnswersArray = resultObj.getJSONArray("incorrect_answers");
            wrongAnswers = new String[wrongAnswersArray.length()];
            for (int j = 0; j < wrongAnswersArray.length(); j++) {
                wrongAnswers[j] = wrongAnswersArray.getString(j);
            }
            //Save the question to questions.txt
            saveQuestionToFile();

        } catch (IOException | JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    //save the Question to a File
    @Override
    public void saveQuestionToFile() {
        FileIO fileIO = new FileIO();
        fileIO.saveQuestion(question);

    }

    //Prints Question
    @Override
    public List<String> display(int questionIndex) {
        System.out.println((questionIndex + 1) + ". " + question);

        // Create a list to hold all answers (correct and incorrect)
        List<String> allAnswers = new ArrayList<>();
        allAnswers.add(correctAnswer);
        Collections.addAll(allAnswers, wrongAnswers);

        // Shuffle
        Collections.shuffle(allAnswers);

        // Print
        for (int j = 0; j < allAnswers.size(); j++) {
            System.out.println("  " + (j + 1) + ". "
                    + allAnswers.get(j));
        }
        System.out.println();
        return allAnswers;
    }

    
    public String getCorrectAnswer() {
        return correctAnswer;
    }

}

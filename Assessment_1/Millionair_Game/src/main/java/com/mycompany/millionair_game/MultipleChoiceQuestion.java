package com.mycompany.millionair_game;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MultipleChoiceQuestion {

    private String question;
    private String correctAnswer;
    private String[] wrongAnswers;

    
    public void fetchQuestion(int questionIndex) {
        try {
            // Set up the API endpoint URL
            String endpoint = "https://opentdb.com/api.php?amount=1&difficulty=easy&type=multiple";
            URL url = new URL(endpoint);

            // Create an HTTP connection and set the request method to GET
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Read the response from API
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the JSON response and extract the question
            JSONObject jsonObj = new JSONObject(response.toString());
            JSONArray resultsArr = jsonObj.getJSONArray("results");
            JSONObject resultObj = resultsArr.getJSONObject(0);
            question = resultObj.getString("question");
            correctAnswer = resultObj.getString("correct_answer");
            JSONArray wrongAnswersArray = resultObj.getJSONArray("incorrect_answers");
            wrongAnswers = new String[wrongAnswersArray.length()];
            for (int j = 0; j < wrongAnswersArray.length(); j++) {
                wrongAnswers[j] = wrongAnswersArray.getString(j);
            }
            // Save the question to a file
            FileIO fileIO = new FileIO();
            fileIO.saveQuestion(question);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<String> printQuestion(int questionIndex) {
        System.out.println((questionIndex + 1) + ". " + question);

        // Create a list to hold all answers (correct and incorrect)
        List<String> allAnswers = new ArrayList<>();
        allAnswers.add(correctAnswer);
        Collections.addAll(allAnswers, wrongAnswers);

        // Shuffle
        Collections.shuffle(allAnswers);

        // Print
        for (int j = 0; j < allAnswers.size(); j++) {
            System.out.println("  " + (j + 1) + ". " + allAnswers.get(j));
        }

        System.out.println();
        return allAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

}

package com.mycompany.millionair_game;

import java.util.List;

public abstract class AbstractQuestion {


    public AbstractQuestion() {
    }

    public abstract void fetchQuestion(int i);

    public abstract void saveQuestionToFile();

    public abstract List<String> display(int x);

}

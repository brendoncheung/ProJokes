package com.example.javajokelib;

import java.io.Serializable;

public class Jokes implements Serializable {

    private String TAG = Jokes.class.getSimpleName();

    private String jokeQuestion;
    private String jokeAnswer;

    public Jokes () {
        jokeAnswer = "default";
        jokeQuestion = "default";
    }

    public Jokes (String question, String answer){
        this.jokeQuestion = question;
        this.jokeAnswer = answer;
    }

    public void setJokeQuestion(String question) {
        jokeQuestion = question;
    }

    public String getJokeQuestion() {
        return jokeQuestion;
    }

    public void setJokeAnswer(String jokeAnswer) {
        this.jokeAnswer = jokeAnswer;
    }

    public String getJokeAnswer() {
        return jokeAnswer;
    }

    @Override
    public String toString() {
        return this.jokeQuestion + ". . . \n" + this.jokeAnswer;
    }

    public static Jokes jokeFromStringResponse(String response) {

        String[] lines = response.split("\\?");

        String jokeQuestion = lines[0];
        String jokeAnswer = lines[1];

        System.out.println(response);

        Jokes joke = new Jokes(jokeQuestion, jokeAnswer);

        return joke;


    }


}

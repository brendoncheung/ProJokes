package com.example.javajokelib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeMaster {

    private List<Jokes> mJokes;

    // Default jokes

    public JokeMaster () {

        mJokes = new ArrayList<>();

        String[] jokeQuestion = {
                "How did the programmer die in the shower?",
                "How many programmers does it take to change a light bulb?",
                "Why do programmers always mix up Halloween and Christmas?",
                "There are only ten kinds of people in this world those who know?"
        };

        String[] jokeAnswers = {
                "He read the shampoo bottle instructions: Lather. Rinse. Repeat",
                "None – It’s a hardware problem",
                "Because Oct 31 equals Dec 25.",
                "binary and those who don’t."
        };

        for(int i = 0; i < jokeQuestion.length; i++){
            Jokes joke = new Jokes();
            joke.setJokeQuestion(jokeQuestion[i]);
            joke.setJokeAnswer(jokeAnswers[i]);
            mJokes.add(joke);
        }
    }

    public Jokes getRandomJoke() {

        Random rand = new Random();
        return mJokes.get(rand.nextInt(mJokes.size()));
    }
}

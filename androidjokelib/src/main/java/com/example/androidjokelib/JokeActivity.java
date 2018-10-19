package com.example.androidjokelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.javajokelib.Jokes;

public class JokeActivity extends AppCompatActivity {

    private TextView jokeQuestion, jokeAnswer;

    public static String JOKE_INTENT = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);
        initialization();

        if (getIntent().hasExtra(JOKE_INTENT)) {
            Jokes joke = (Jokes) getIntent().getSerializableExtra(JOKE_INTENT);
            populateUI(joke);
        }

    }

    private void initialization () {
        jokeQuestion = findViewById(R.id.tv_joke_question);
        jokeAnswer = findViewById(R.id.tv_joke_answer);
    }

    private void populateUI(Jokes joke) {
        jokeQuestion.setText(joke.getJokeQuestion());
        jokeAnswer.setText(joke.getJokeAnswer());
    }

}

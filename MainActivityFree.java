package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidjokelib.JokeActivity;
import com.example.javajokelib.Jokes;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.JokeCompletionHandler;
import com.udacity.gradle.builditbigger.R;

public class MainActivityFree extends AppCompatActivity implements JokeCompletionHandler {

    private Button mJokeButton;
    private String TAG = MainActivityFree.class.getSimpleName();
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }

    @Override
    public void onJokeReturned(String response) {
        Log.d(TAG, response);
        Jokes joke = Jokes.jokeFromStringResponse(response);

        Intent intent = new Intent(this, JokeActivity.class);

        intent.putExtra(JokeActivity.JOKE_INTENT, joke);
        startActivity(intent);
    }

    public void loadJoke() {
        new EndpointsAsyncTask().execute(this);
    }

    private void initialization() {

        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mAdView.loadAd(adRequest);

        mJokeButton = findViewById(R.id.btn_joke_button);
        mJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJoke();
            }
        });
    }
}

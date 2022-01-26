package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_SCORE_1 = "Team 1 Score";
    private static final String STATE_SCORE_2 = "Team 2 Score";
    private int scoreTeam1 = 0;
    private int scoreTeam2 = 0;

    TextView scoreTextTeam1;
    TextView scoreTextTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextTeam1 = findViewById(R.id.score_1);
        scoreTextTeam2 = findViewById(R.id.score_2);

        if (savedInstanceState != null) {
            scoreTeam1 = savedInstanceState.getInt(STATE_SCORE_1);
            scoreTeam2 = savedInstanceState.getInt(STATE_SCORE_2);

            scoreTextTeam1.setText(String.valueOf(scoreTeam1));
            scoreTextTeam2.setText(String.valueOf(scoreTeam2));
        }

    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.decreaseTeam1:
                // Decrement the score and update the TextView.
                scoreTeam1--;
                scoreTextTeam1.setText(String.valueOf(scoreTeam1));
                break;
            case R.id.decreaseTeam2:
                // Decrement the score and update the TextView.
                scoreTeam2--;
                scoreTextTeam2.setText(String.valueOf(scoreTeam2));
                break;
        }
    }


    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.increaseTeam1:
                scoreTeam1++;
                scoreTextTeam1.setText(String.valueOf(scoreTeam1));
                break;
            case R.id.increaseTeam2:
                scoreTeam2++;
                scoreTextTeam2.setText(String.valueOf(scoreTeam2));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } recreate();
        }return true;
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, scoreTeam1);
        outState.putInt(STATE_SCORE_2, scoreTeam2);
        super.onSaveInstanceState(outState);
    }
}
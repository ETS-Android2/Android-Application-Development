package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int Score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //void displayForTeamA();


    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void plusThreeForTheamA(View view)
    {
        Score =Score+3;
        displayForTeamA(Score);
    }
    public void plusTowForTheamA(View view)
    {
        Score =Score+2;
        displayForTeamA(Score);
    }
    public void freeThrowForTheamA(View view)
    {
        Score =Score+1;
        displayForTeamA(Score);
    }
    public void resetForTheamA(View view)
    {
        Score =0;
        displayForTeamA(Score);
    }
    
}
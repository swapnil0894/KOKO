package com.kokonetworks.theapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public Field field;
    private TextView tvLevel;
    private TextView tvScore;

    private Button btnStart;
    private int score;
    private Mole mole;
    private final long LEVEL_DURATION_MS = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        field = findViewById(R.id.field);
        tvLevel = findViewById(R.id.tvLevel);
        btnStart = findViewById(R.id.btnStart);
        tvScore = findViewById(R.id.tvScore);

        setEventListeners();
        edngame();
    }

    private void edngame() {
        if(LEVEL_DURATION_MS > 10000)
        {


        }
    }

    void setEventListeners(){
        btnStart.setOnClickListener(view -> {
            btnStart.setVisibility(View.GONE);
            tvScore.setVisibility(View.GONE);
            field.startGame();
        });

        field.setListener(listener);


        int circleno=field.getCurrentCircle();
    }

    private final Field.Listener listener = new Field.Listener() {

        @Override
        public void onGameEnded(int score) {
            btnStart.setVisibility(View.VISIBLE);
            tvScore.setVisibility(View.VISIBLE);
            tvScore.setText(String.format(getString(R.string.your_score), score));
            field.setVisibility(View.GONE);

        }

        @Override
        public void onLevelChange(int level) {
            tvLevel.setText(String.format(getString(R.string.level), level));
        }

        @Override
        public void onScoreChange(int Score){
            field.setVisibility(View.VISIBLE);
            tvScore.setVisibility(View.VISIBLE);
            tvScore.setText(String.format(getString(R.string.your_score), score));

        }

        @Override
        public int  onCircleCliked(int score)
        {

            int circleno=field.getCurrentCircle();
            Toast.makeText(MainActivity.this, "CLiked circel no is" + circleno, Toast.LENGTH_SHORT).show();
           listener.onCircleCliked(score);
            score += mole.getCurrentLevel() * 2;
            tvScore.setText(String.format(getString(R.string.your_score), score));
            return circleno;

        }


    };


}
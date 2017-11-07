package com.miguelcr.a02_duckhunt;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView textViewName, textViewCounter, textViewTimer;
    ImageView duck;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle extras = getIntent().getExtras();
        String nickName = extras.getString("nick");

        textViewName = findViewById(R.id.textViewNick);
        textViewCounter = findViewById(R.id.textViewCounter);
        textViewTimer = findViewById(R.id.textViewTimer);

        duck = findViewById(R.id.imageViewDuck);

        textViewName.setText(nickName);

        // Hide the action bar
        getSupportActionBar().hide();

        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                textViewTimer.setText(millisUntilFinished / 1000+"s");
            }

            public void onFinish() {
                textViewTimer.setText("Game over!");
            }
        }.start();
    }

    public void duckClick(View view) {
        counter++;
        textViewCounter.setText(String.valueOf(counter));

        // Move the duck
        moveDuck();
    }

    private void moveDuck() {
        Random rand = new Random();

        // Get in execution the screen width and height
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int heightPixels = metrics.heightPixels;
        int widthPixels = metrics.widthPixels;

        int duckWidth = duck.getWidth();
        int duckHeight = duck.getHeight();

        int maxX = widthPixels-duckWidth;
        int maxY = heightPixels-duckHeight;
        int min = 0;
        int randomX = rand.nextInt((maxX - min) + 1) + min;
        int randomY = rand.nextInt((maxY - min) + 1) + min;

        // Apply the new random position to the duck imageView
        duck.setX(randomX);
        duck.setY(randomY);
    }
}

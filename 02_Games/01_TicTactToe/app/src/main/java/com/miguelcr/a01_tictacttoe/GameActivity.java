package com.miguelcr.a01_tictacttoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {
    String p1, p2;
    boolean isPlaying1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle extras = getIntent().getExtras();
        p1 = extras.getString("p1");
        p2 = extras.getString("p2");

        // Change the toolbar title
        setTitle(p1+" plays");


    }

    public void cellClicked(View view) {
        ImageView imageView = (ImageView)view;

        if(isPlaying1) {
            imageView.setImageResource(R.drawable.ic_player_1);
            setTitle(p2 + " plays");
            isPlaying1 = false;
        } else {
            imageView.setImageResource(R.drawable.ic_player_2);
            setTitle(p1 + " plays");
            isPlaying1 = true;
        }
    }
}

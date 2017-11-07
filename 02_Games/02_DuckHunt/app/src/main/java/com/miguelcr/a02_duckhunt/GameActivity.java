package com.miguelcr.a02_duckhunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    TextView textViewName, textViewCounter;
    ImageView duck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle extras = getIntent().getExtras();
        String nickName = extras.getString("nick");

        textViewName = findViewById(R.id.textViewNick);
        textViewCounter = findViewById(R.id.textViewCounter);
        duck = findViewById(R.id.imageViewDuck);

        textViewName.setText(nickName);

        // Hide the action bar
        getSupportActionBar().hide();
    }

    public void duckClick(View view) {


    }
}

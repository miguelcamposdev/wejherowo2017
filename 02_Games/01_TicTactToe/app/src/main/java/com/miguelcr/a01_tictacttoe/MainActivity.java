package com.miguelcr.a01_tictacttoe;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextPlayer1, editTextPlayer2;
    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.textViewLogo);
        editTextPlayer1 = findViewById(R.id.editTextPlayer1);
        editTextPlayer2 = findViewById(R.id.editTextPlayer2);

        Typeface typeface= Typeface.createFromAsset(
                getAssets(),"sweet.ttf");
        logo.setTypeface(typeface);
    }

    public void startGame(View view) {

        String p1Name = editTextPlayer1.getText().toString();
        String p2Name = editTextPlayer2.getText().toString();

        if(!p1Name.isEmpty() && !p2Name.isEmpty()) {
            Intent i = new Intent(this, GameActivity.class);
            i.putExtra("p1", p1Name);
            i.putExtra("p2", p2Name);
            startActivity(i);
        } else if(p1Name.isEmpty()) {
            editTextPlayer1.setError("Write player 1 name");
        } else {
            editTextPlayer2.setError("Write player 2 name");
        }
    }
}

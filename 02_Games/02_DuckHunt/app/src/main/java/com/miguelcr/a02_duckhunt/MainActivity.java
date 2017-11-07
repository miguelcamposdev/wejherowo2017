package com.miguelcr.a02_duckhunt;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewTitle;
    EditText editTextNick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewTitle = findViewById(R.id.imageViewTitle);
        editTextNick = findViewById(R.id.editTextNick);

        Picasso.with(this)
                .load(R.drawable.title)
                .into(imageViewTitle);


    }

    public void startGame(View view) {
        String nick = editTextNick.getText().toString();

        if(!nick.isEmpty()) {
            // Start the game
            Intent i = new Intent(this, GameActivity.class);

            // Set the nickname
            i.putExtra("nick",nick);
            startActivity(i);

        } else {
            Toast.makeText(this,
                            getString(R.string.message_wrong_nick),
                            Toast.LENGTH_SHORT).show();
            editTextNick.setError("Nick required");
        }
    }
}

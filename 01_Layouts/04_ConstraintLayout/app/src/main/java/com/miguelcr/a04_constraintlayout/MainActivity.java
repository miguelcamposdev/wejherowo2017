package com.miguelcr.a04_constraintlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewRonaldo;
    TextView name, award, team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewRonaldo = (ImageView)findViewById(R.id.imageViewPhoto);
        name = (TextView) findViewById(R.id.textViewName);
        award = (TextView) findViewById(R.id.textViewAwards);
        team = (TextView) findViewById(R.id.textViewTeam);

        // Change the TextView texts!
        name.setText("Ronaldo");
        team.setText("Real Madrid");
        award.setText("350");

        // Remember to write the Internet permission into the
        // Manifest file!!!!
        Picasso.with(this)
                .load("http://www.lecturas.com/medio/2017/03/29/cristiano-ronaldo-guino_625x386_324d3509.jpg")
                .into(imageViewRonaldo);
    }
}

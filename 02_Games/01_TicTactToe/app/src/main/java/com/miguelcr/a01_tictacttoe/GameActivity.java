package com.miguelcr.a01_tictacttoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    String p1, p2;
    boolean isPlaying1 = true;
    int[] cellSelected = {0,0,0,0,0,0,0,0,0};

    /*
        The cells index are...

      0  |  1  |  2
      --------------
      3  |  4  |  5
      --------------
      6  |  7  |  8

      Our ImageViews ids...

      R.id.imageView1 > 0
      R.id.imageView2 > 1
      ...
      R.id.imageView9 > 8


      By default is possible to select ALL

      0  |  0  |  0
      --------------
      0  |  0  |  0
      --------------
      0  |  0  |  0

    If player 1 select the first cell, our array changes

      1  |  0  |  0
      --------------
      0  |  0  |  0
      --------------
      0  |  0  |  0
      */

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

        // By default we think that the current
        // player is 2
        int currentPlayer = 2;
        if(isPlaying1) {
            currentPlayer = 1;
        }

        int position = 0;

        switch (imageView.getId()) {
            case R.id.imageView1:
                position = 0;
                break;
            case R.id.imageView2:
                position = 1;
                break;
            case R.id.imageView3:
                position = 2;
                break;
            case R.id.imageView4:
                position = 3;
                break;
            case R.id.imageView5:
                position = 4;
                break;
            case R.id.imageView9:
                position = 5;
                break;
            case R.id.imageView7:
                position = 6;
                break;
            case R.id.imageView8:
                position = 7;
                break;
        }

        if(cellSelected[position]==0) {
            cellSelected[position] = currentPlayer;

            if(isPlaying1) {
                imageView.setImageResource(R.drawable.ic_player_1);
                if(existSolution(1)) {
                    Toast.makeText(this, p1+" is the winner", Toast.LENGTH_SHORT).show();
                } else {
                    setTitle(p2 + " plays");
                    isPlaying1 = false;
                }
            } else {
                imageView.setImageResource(R.drawable.ic_player_2);
                if(existSolution(2)) {
                    Toast.makeText(this, p2+" is the winner", Toast.LENGTH_SHORT).show();
                } else {
                    setTitle(p1 + " plays");
                    isPlaying1 = true;
                }
            }

        } else {
            Toast.makeText(this, "Select another cell", Toast.LENGTH_SHORT).show();
        }


    }

    private boolean existSolution(int player) {
        boolean exist = false;
        // Possible solutions
        // 0,1,2
        // 3,4,5
        // 6,7,8
        // 0,4,8 >>>> the example
        // ...

        if(cellSelected[0]==cellSelected[4]
                && cellSelected[4]==cellSelected[8]
                && cellSelected[8]==player) {
            exist = true;
        } else if() {
        }

        return exist;

    }
}

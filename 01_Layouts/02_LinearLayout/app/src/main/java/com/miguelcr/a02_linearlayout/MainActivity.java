package com.miguelcr.a02_linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // To load the IU file
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.buttonLogin);
        btn.setText("It's all for today");

    }
}

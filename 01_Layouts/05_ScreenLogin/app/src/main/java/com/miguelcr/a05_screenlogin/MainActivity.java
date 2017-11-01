package com.miguelcr.a05_screenlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
    }

    public void doLogin(View view) {
        String e = email.getText().toString();
        String p = password.getText().toString();

        if(e.equals("admin@admin.com") && p.equals("1234")) {
            Intent i = new Intent(this,
                    PrivateActivity.class);

            i.putExtra("userEmail",e);
            i.putExtra("userAge",20);

            startActivity(i);
        } else {
            Toast.makeText(
                    this,
                    "Try to hack another app!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}

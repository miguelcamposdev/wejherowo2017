package com.miguelcr.mecaround;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPass = findViewById(R.id.editTextPassword);

        // Hide the toolbar
        getSupportActionBar().hide();
    }

    public void doLogin(View view) {
        String email = editTextEmail.getText().toString();
        String pass = editTextPass.getText().toString();

        if(!email.isEmpty() && !pass.isEmpty()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://miguelcamposrivera.com/mecaround/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            MecaroundServerInterface service = retrofit.create(MecaroundServerInterface.class);


            Call<LoginResponse> serverResponse = service.serverLogin(email, pass);


            serverResponse.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.code() == 200) {
                        Intent i = new Intent(MainActivity.this, UserPrivateActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(MainActivity.this, "Email and/or password are not ok", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });

        }
    }
}

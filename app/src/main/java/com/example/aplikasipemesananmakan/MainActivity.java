package com.example.aplikasipemesananmakan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //untuk mendeklarasikan
    Button bSignin;
    TextView bSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //untuk memanggil layout signin dan signup
        bSignin = findViewById(R.id.bSignin);
        bSignup = findViewById(R.id.bSignup);
        //untuk membuat fungsi bsignin
        bSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), com.example.aplikasipemesananmakan.SignIn.class);
                startActivity(i);
            }
        });
        //untuk membuat fungsi bsignup
        bSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), com.example.aplikasipemesananmakan.SignUp.class);
                startActivity(i);
            }
        });
    }
}
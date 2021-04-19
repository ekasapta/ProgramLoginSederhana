package com.example.proglogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    TextView textToleransi;
    Button btnLogin;

    int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        textToleransi = (TextView) findViewById(R.id.textToleransi);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(etUsername.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    public void validate(String username, String password) {
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            Intent second = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(second);
        } else {
            counter--;
            textToleransi.setText("Jumlah Toleransi Kesalahan: " + String.valueOf(counter));

            if(counter == 0) {
                btnLogin.setEnabled(false);
            }
        }
    }
}
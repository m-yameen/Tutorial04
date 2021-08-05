package com.example.tutorial04;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText user,pass;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        btn    = findViewById(R.id.login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ValUsername = user.getText().toString();
                String ValPassword = pass.getText().toString();
                Log.i("Login Screen","In Onclick");

                if (!Patterns.EMAIL_ADDRESS.matcher(ValUsername).matches()){
                    Toast.makeText(LoginActivity.this,"Email address format is not valid", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (ValUsername.equals("admin@gmail.com") && ValPassword.equals("123456")) {
                    Log.i("Login Screen", "in onClick if");

                    Intent intent = new Intent(LoginActivity.this,WelcomeActivity.class);
                    intent.putExtra("userdata",ValUsername);
                    startActivity(intent);
                    finish();

                    Toast.makeText(LoginActivity.this,"Login Successfully", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(LoginActivity.this,"Username or Password is wrong.", Toast.LENGTH_SHORT).show();
                    Log.i("Login Screen","In Onclick");
                }
            }
        });
    }
}
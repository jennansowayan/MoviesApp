package com.demo.MovieProject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText Username;
    EditText Password;
    Button LoginBtn;
    TextView Register;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        Username = (EditText)findViewById(R.id.usrnm);
        Password = (EditText)findViewById(R.id.pwd);
        LoginBtn = (Button)findViewById(R.id.loginbtn);
        Register = (TextView)findViewById(R.id.register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Username.getText().toString().trim();
                String pwd = Password.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if(res == true)
                {
                    Intent NextActivitySt = new Intent(LoginActivity.this,TypesActivity.class);
                    startActivity(NextActivitySt);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
package com.demo.MovieProject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText Name;
    EditText Username;
    EditText Password;
    EditText Phone;
    EditText Email;
    Button RegisterBtn;
    TextView Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        Username = (EditText)findViewById(R.id.username);
        Password = (EditText)findViewById(R.id.password);
        Phone = (EditText)findViewById(R.id.phone);
        Name = (EditText)findViewById(R.id.name);
        Email = (EditText)findViewById(R.id.email);
        RegisterBtn = (Button)findViewById(R.id.registerbtn);
        Login = (TextView)findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString().trim();
                String phone = Phone.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String username = Username.getText().toString().trim();
                String pwd = Password.getText().toString().trim();

                if(!name.isEmpty() && !phone.isEmpty() && !email.isEmpty() && !username.isEmpty() && !pwd.isEmpty()){
                    long val = db.addUser(username,pwd);
                    if(val > 0){
                        Toast.makeText(RegisterActivity.this,"New customer added successfully",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Registration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(RegisterActivity.this,"Missing Required Data",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
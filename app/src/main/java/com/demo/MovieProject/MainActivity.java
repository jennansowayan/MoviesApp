package com.demo.MovieProject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = (Button) findViewById(R.id.lgnbtn);
        Button signup = (Button) findViewById(R.id.signupbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                goToLogInActivity();}});
      signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                goToSignupActivity();}});
    }

    private void  goToLogInActivity(){
        Intent intent = new Intent (MainActivity.this, LoginActivity.class);
        startActivity(intent);}
    private void  goToSignupActivity(){
        Intent intent = new Intent (MainActivity.this, RegisterActivity.class);
        startActivity(intent);}}

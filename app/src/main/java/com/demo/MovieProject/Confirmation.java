package com.demo.MovieProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class Confirmation extends AppCompatActivity {
 Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        home = (Button) findViewById(R.id.backhomebtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gohome = new Intent(Confirmation.this, MainActivity.class);
                startActivity(gohome);
            }
        });
    }
}
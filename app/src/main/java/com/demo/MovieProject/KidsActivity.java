package com.demo.MovieProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.os.Bundle;

public class KidsActivity extends AppCompatActivity {
    EditText txtQty;
    Button butSubmit;
    String numSeats;
    int total = 0;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);
        spin = findViewById(R.id.seatType);
        ImageView imgHome = (ImageView) findViewById(R.id.home);
        ImageView imgLogout = (ImageView) findViewById(R.id.logout);
        String[] seats = { "First Class - 100 SR", "Second Class - 75 SR", "Third Class - 50 SR" };
        txtQty = (EditText) findViewById(R.id.txtQty);
        butSubmit = (Button) findViewById(R.id.ordercnf);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, seats);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(ad);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackHome = new Intent(KidsActivity.this,MainActivity.class);
                startActivity(BackHome);}});

        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Logout = new Intent(KidsActivity.this,LoginActivity.class);
                startActivity(Logout);}});
        butSubmit.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             /// read num of Seats
                                             if (txtQty.getText().toString().equals("")) {
                                                 openDialog();
                                             }
                                             else {
                                                 numSeats = txtQty.getText().toString().trim();
                                                 ///// read type of Seat
                                                 int seatID = spin.getSelectedItemPosition();
                                                 if(seatID==0) total = 100 * Integer.parseInt(numSeats);
                                                 if(seatID==1) total = 75 * Integer.parseInt(numSeats);
                                                 if(seatID==2) total = 50 * Integer.parseInt(numSeats);
                                                 String sttotal = String.valueOf(total);
                                                 Intent i = new Intent(KidsActivity.this, PaymentActivity.class);
                                                 i.putExtra("TOTAL_PRICE", sttotal);
                                                 startActivity(i);
                                             }
                                         }
                                     }
        );

    }
    public void openDialog(){
        DialogueClass dc = new DialogueClass();
        dc.show(getSupportFragmentManager(), "dialogue");
    }
}
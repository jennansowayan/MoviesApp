package com.demo.MovieProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {
    TextView txtTotal;
    RadioGroup radioGroup;
    ImageView imgHome, imgLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        imgHome = (ImageView) findViewById(R.id.home);
        imgLogout = (ImageView) findViewById(R.id.logout);
        txtTotal = (TextView) findViewById(R.id.txtTotal);
        String total = getIntent().getStringExtra("TOTAL_PRICE");
        txtTotal.setText(total);
        final RadioButton paypal = (RadioButton) findViewById(R.id.radiopaypal);
        final RadioButton visa = (RadioButton) findViewById(R.id.radiovisa);
        radioGroup = findViewById(R.id.radioType);
        final Button btn = (Button) findViewById(R.id.ordercnf);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackHome = new Intent(PaymentActivity.this,MainActivity.class);
                startActivity(BackHome);}});

        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Logout = new Intent(PaymentActivity.this,LoginActivity.class);
                startActivity(Logout);}});
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       if(radioGroup.getCheckedRadioButtonId()==-1){
                                             openDialog();}
                                       else{
                                           Intent confirm = new Intent(PaymentActivity.this, Confirmation.class);
                                           startActivity(confirm);
                                       }

                                   }
                               }

        );

    }
        public void openDialog() {
            NewDialogueClass exampleDialog = new NewDialogueClass();
            exampleDialog.show(getSupportFragmentManager(), "dialogue");
        }
    }

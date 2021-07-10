package com.demo.MovieProject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TypesActivity extends AppCompatActivity {
    ImageView imgComedy, imgKids, imgAction, imgTragedy, imgSocial, imgRomantic;
    ImageView imgHome, imgLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);
        imgHome = (ImageView) findViewById(R.id.home);
        imgLogout = (ImageView) findViewById(R.id.logout);
        imgComedy = (ImageView) findViewById(R.id.comedy);
        imgKids = (ImageView) findViewById(R.id.kids);
        imgAction = (ImageView) findViewById(R.id.action);
        imgTragedy = (ImageView) findViewById(R.id.tragedy);
        imgSocial = (ImageView) findViewById(R.id.social);
        imgRomantic = (ImageView) findViewById(R.id.romantic);

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackHome = new Intent(TypesActivity.this,MainActivity.class);
                startActivity(BackHome);}});

        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Logout = new Intent(TypesActivity.this,LoginActivity.class);
                startActivity(Logout);}});

        imgComedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoComedy = new Intent(TypesActivity.this,ComedyActivity.class);
                startActivity(GoComedy);}});
        imgAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoAction = new Intent(TypesActivity.this,ActionActivity.class);
                startActivity(GoAction);}});
        imgKids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoKids = new Intent(TypesActivity.this,KidsActivity.class);
                startActivity(GoKids);}});
        imgRomantic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoRomantic = new Intent(TypesActivity.this,RomanticActivity.class);
                startActivity(GoRomantic);}});
        imgTragedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoTragedy = new Intent(TypesActivity.this,TragedyActivity.class);
                startActivity(GoTragedy);}});
        imgSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoSocial = new Intent(TypesActivity.this,SocialActivity.class);
                startActivity(GoSocial);}});

    }
}

package com.example.traveltoabazashta.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.traveltoabazashta.R;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
    }

    public void start(View view) {
        Intent intent = new Intent(Profile.this, SelectTest.class);
        startActivity(intent);
    }
}

package com.example.traveltoabazashta.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.traveltoabazashta.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myProfile(View view) {
        Intent intent = new Intent(MainActivity.this, LoginToAccount.class);
        startActivity(intent);
    }

    public void aboutUs(View view) {
        Intent intent = new Intent(MainActivity.this, AboutUs.class);
        startActivity(intent);
    }

    public void links(View view) {
        Intent intent = new Intent(MainActivity.this, Links.class);
        startActivity(intent);
    }
}

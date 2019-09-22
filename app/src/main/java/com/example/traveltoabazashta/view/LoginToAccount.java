package com.example.traveltoabazashta.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.traveltoabazashta.R;

public class LoginToAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_account);
    }

    public void addUser(View view) {
        Intent intent = new Intent(LoginToAccount.this, AddUser.class);
        startActivity(intent);
    }

    public void input(View view) {
        Intent intent = new Intent(LoginToAccount.this, Profile.class);
        startActivity(intent);
    }
}

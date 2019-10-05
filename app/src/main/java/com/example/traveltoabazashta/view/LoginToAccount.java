package com.example.traveltoabazashta.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveltoabazashta.R;
import com.example.traveltoabazashta.model.Value;
import com.example.traveltoabazashta.present.Presenter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoginToAccount extends AppCompatActivity {

    private EditText inputLogin;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_account);

        inputLogin = (EditText) findViewById(R.id.input_login);
        presenter = new Presenter(getApplicationContext());
    }

    public void addUser(View view) {
        Intent intent = new Intent(LoginToAccount.this, AddUser.class);
        startActivity(intent);
    }

    public void input(View view) {
        String nameLogin = inputLogin.getText().toString();
        ArrayList<String> logins = presenter.getUserLogins();
        if (logins.indexOf(nameLogin) > -1) {
            Value.idUser = logins.indexOf(nameLogin);
            Value.userName = nameLogin;
            Intent intent = new Intent(LoginToAccount.this, Profile.class);
            intent.putExtra("userName", nameLogin);
            startActivity(intent);
        } else {
            inputLogin.setText("");
            Toast.makeText(getApplicationContext(), "Неправильный логин", Toast.LENGTH_LONG).show();
        }
    }
}

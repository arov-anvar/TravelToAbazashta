package com.example.traveltoabazashta.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveltoabazashta.R;
import com.example.traveltoabazashta.present.Presenter;

import java.util.ArrayList;

public class AddUser extends AppCompatActivity {

    private Presenter presenter;
    private EditText inputLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        init();


    }

    public void init() {
        inputLogin = (EditText) findViewById(R.id.input_login);
        presenter = new Presenter(getApplicationContext());
    }

    public void registration(View view) {
        String newUserName = inputLogin.getText().toString();
        ArrayList<String> lastNames = presenter.getUserLogins();
        if (lastNames.indexOf(newUserName) < 0) {
            presenter.addNewUser(newUserName);
            Toast.makeText(getApplicationContext(), "Пользователь добавлен", Toast.LENGTH_LONG).show();
            //отображения подтверждения создания нового пользователя
        } else {
            Toast.makeText(getApplicationContext(), "Пользователь уже существует", Toast.LENGTH_LONG).show();
            // отображение что пользователь с таким именем уже есть
        }

    }
}

package com.example.traveltoabazashta.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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


    }

    public void init() {
        inputLogin = (EditText) findViewById(R.id.input_login);
    }

    public void registration(View view) {
        String newUserName = inputLogin.getText().toString();
        ArrayList<String> lastNames = presenter.getUserLogins();
        if (lastNames.indexOf(newUserName) != -1) {
            presenter.addNewUser(newUserName);
            // добавить отображения подтверждения создания нового пользователя
        } else {
            // отображение что пользователь с таким именем уже есть
        }

    }
}

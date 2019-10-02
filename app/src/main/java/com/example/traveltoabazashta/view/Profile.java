package com.example.traveltoabazashta.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.traveltoabazashta.R;
import com.example.traveltoabazashta.present.Presenter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    private TextView textLanguage;
    private TextView textHistory;
    private TextView textCulture;
    private TextView textName;
    private String userName;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        init();
    }

    private void init() {
        textCulture = (TextView) findViewById(R.id.culture);
        textHistory = (TextView) findViewById(R.id.history);
        textLanguage = (TextView) findViewById(R.id.language);
        textName = (TextView) findViewById(R.id.name);
        userName = getIntent().getStringExtra("userName");
        presenter = new Presenter(getApplicationContext());

        ArrayList<Integer> records = presenter.getRecords(userName);
        textCulture.setText(records.get(0).toString());
        textHistory.setText(records.get(1).toString());
        textLanguage.setText(records.get(2).toString());
        textName.setText(userName);
    }

    public void start(View view) {
        Intent intent = new Intent(Profile.this, SelectTest.class);
        startActivity(intent);
    }
}

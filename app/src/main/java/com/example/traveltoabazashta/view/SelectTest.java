package com.example.traveltoabazashta.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.traveltoabazashta.R;

public class SelectTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_test);
    }

    public void startTest(View view) {
        Intent intent = new Intent(SelectTest.this, Testing.class);

        switch (view.getId()) {
            case R.id.history:
                intent.putExtra("typeTest", 1);
                break;
            case R.id.language:
                intent.putExtra("typeTest", 2);
                break;
            case R.id.culture:
                intent.putExtra("typeTest", 3);
                break;
        }

        startActivity(intent);
    }
}

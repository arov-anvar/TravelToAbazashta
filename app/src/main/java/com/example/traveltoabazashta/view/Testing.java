package com.example.traveltoabazashta.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.traveltoabazashta.R;
import com.example.traveltoabazashta.model.DataQuestion;
import com.example.traveltoabazashta.present.Presenter;

import java.util.ArrayList;

public class Testing extends AppCompatActivity {

    private final int COUNT_ANSWER = 25;

    private Button answer1, answer2, answer3, answer4, next, info;
    private TextView question;
    private Presenter presenter;
    private ArrayList<DataQuestion> dataQuestions;
    private int typeTest;
    private int indexQuestion = 0, countRightAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        init();

    }

    public void init() {
        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);
        next = (Button) findViewById(R.id.next);
        info = (Button) findViewById(R.id.info);
        question = (TextView) findViewById(R.id.question);

        typeTest = getIntent().getIntExtra("typeTest", 0);
        presenter = new Presenter(getApplicationContext());
        dataQuestions = presenter.getQuestion(typeTest);

        answer1.setText(dataQuestions.get(indexQuestion).getAnswer1());
        answer2.setText(dataQuestions.get(indexQuestion).getAnswer2());
        answer3.setText(dataQuestions.get(indexQuestion).getAnswer3());
        answer4.setText(dataQuestions.get(indexQuestion).getAnswer4());
        question.setText(dataQuestions.get(indexQuestion).getQuestion());
    }

    public void checkClick(View view) {
        switch (view.getId()) {
            case R.id.answer1: checkAnswer(answer1, 1); break;
            case R.id.answer2: checkAnswer(answer2, 2); break;
            case R.id.answer3: checkAnswer(answer3, 3); break;
            case R.id.answer4: checkAnswer(answer4, 4); break;
            case R.id.next: changeAnswer(); break;
            case R.id.info: watchInfo(); break;
        }
    }


    private void watchInfo() {
        answer1.setVisibility(View.INVISIBLE);
        answer2.setVisibility(View.INVISIBLE);
        answer3.setVisibility(View.INVISIBLE);
        answer4.setVisibility(View.INVISIBLE);
        question.setText(dataQuestions.get(indexQuestion).getInfo());
    }

    private void checkAnswer(Button btn, int answer) {
        if (dataQuestions.get(indexQuestion).getRightAnswer() == answer) {
            btn.setBackgroundResource(R.drawable.btn_win);
            ++countRightAnswer;
        } else {
            btn.setBackgroundResource(R.drawable.btn_lose);
        }
        next.setVisibility(View.VISIBLE);
        info.setVisibility(View.VISIBLE);
    }

    private void printNewAnswer() {
        ++indexQuestion;
        answer1.setVisibility(View.VISIBLE);
        answer2.setVisibility(View.VISIBLE);
        answer3.setVisibility(View.VISIBLE);
        answer4.setVisibility(View.VISIBLE);
        answer1.setText(dataQuestions.get(indexQuestion).getAnswer1());
        answer2.setText(dataQuestions.get(indexQuestion).getAnswer2());
        answer3.setText(dataQuestions.get(indexQuestion).getAnswer3());
        answer4.setText(dataQuestions.get(indexQuestion).getAnswer4());
        question.setText(dataQuestions.get(indexQuestion).getQuestion());
        answer1.setBackgroundResource(R.color.main_text_1);
        answer2.setBackgroundResource(R.color.main_text_1);
        answer3.setBackgroundResource(R.color.main_text_1);
        answer4.setBackgroundResource(R.color.main_text_1);
        next.setVisibility(View.INVISIBLE);
        info.setVisibility(View.INVISIBLE);
    }

    private void changeAnswer() {
        if (COUNT_ANSWER == indexQuestion + 1) {
            Intent intent = new Intent(Testing.this, Result.class);
            intent.putExtra("rightAnswer", countRightAnswer);
            startActivity(intent);
            finish();
        } else {
            printNewAnswer();
        }
    }
}

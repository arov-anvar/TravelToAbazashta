package com.example.traveltoabazashta.view;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.traveltoabazashta.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {

    private PieChart mPieChart;

    private static final float TRANSPARENT_CIRCLE_RADIUS = 65f;
    private static final int ANIMATION_VALUE = 2000;
    private static final int BUNDLE_KEY_ZERO_INDEX = 0;
    private static final Integer BUNDLE_KEY_SECOND_INDEX = 2;
    private static final String RESULT = "Результаты";
    private static final String RIGHT = "Правильно";
    private static final String NO_RIGHT = "Не правильно";
    private static final String EMPTY_STRING = "";

    private final int COUNT_RIGHT = 25;

    private int rightAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        rightAnswer = getIntent().getIntExtra("rightAnswer", 0);
        showPieChart();

    }

    public void showPieChart() {
        mPieChart = (PieChart) findViewById(R.id.piechart);
        mPieChart.setUsePercentValues(true);
        mPieChart.setDrawHoleEnabled(true);
        mPieChart.setTransparentCircleRadius(TRANSPARENT_CIRCLE_RADIUS);
        mPieChart.setHoleRadius(TRANSPARENT_CIRCLE_RADIUS);
        mPieChart.setDescription(new Description());
        mPieChart.animateXY(ANIMATION_VALUE, ANIMATION_VALUE);

        List<PieEntry> yvalues = new ArrayList<>();
        yvalues.add(new PieEntry(rightAnswer, BUNDLE_KEY_ZERO_INDEX));
        yvalues.add(new PieEntry(COUNT_RIGHT, BUNDLE_KEY_SECOND_INDEX));
        PieDataSet dataSet = new PieDataSet(yvalues, EMPTY_STRING);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add(RIGHT);
        xVals.add(NO_RIGHT);
        PieData data = new PieData(dataSet);

        data.setValueFormatter(new PercentFormatter());
        mPieChart.setData(data);

    }
}

package com.example.traveltoabazashta.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Model {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    private Context mContext;
    private Cursor myCursor;

    public Model(Context context) {
        mContext = context;
        dbHelper = new DatabaseHelper(mContext);
    }

    public ArrayList<DataQuestion> getQuestion(String tableName, int index) {
        ArrayList<DataQuestion> data = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        myCursor = database.rawQuery("SELECT * FROM " + tableName, null);
        myCursor.moveToFirst();
        for (int i = 0; i < myCursor.getCount(); i++) {
            if (myCursor.getInt(7) == index) {
                data.add(new DataQuestion(  myCursor.getString(1),
                                            myCursor.getString(2),
                                            myCursor.getString(3),
                                            myCursor.getString(4),
                                            myCursor.getString(5),
                                            myCursor.getInt(6)));
            }
            myCursor.moveToNext();
        }
        database.close();
        myCursor.close();
        return data;
    }

    public void setRecord(int result) {

    }

}

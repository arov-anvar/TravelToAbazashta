package com.example.traveltoabazashta.model;

import android.content.ContentValues;
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

    public String getTestName(int indexTest) {
        switch (indexTest) {
            case 1:
                return "culture";
            case 2:
                return "history";
            case 3:
                return "language";
        }

        return null;
    }

    public ArrayList<DataQuestion> getQuestion(int indexTest) {
        ArrayList<DataQuestion> data = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        myCursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_QUESTION, null);
        myCursor.moveToFirst();
        for (int i = 0; i < myCursor.getCount(); i++) {
            if (myCursor.getInt(7) == indexTest) {
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

    public void setRecord(int result, int userId, int indexTest) {
        int record;
        database = dbHelper.getReadableDatabase();
        myCursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_USERS, null);
        myCursor.moveToPosition(userId);
        record = myCursor.getInt(indexTest + 1);
        database.close();
        myCursor.close();
        if (result > record) {
            ContentValues cv = new ContentValues();
            cv.put(getTestName(indexTest), result);
            database = dbHelper.getWritableDatabase();
            database.update("users", cv, "_id="+userId, null);
            database.close();
            myCursor.close();
        }
    }

}

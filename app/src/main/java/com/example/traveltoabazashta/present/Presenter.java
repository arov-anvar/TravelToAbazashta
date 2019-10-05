package com.example.traveltoabazashta.present;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.traveltoabazashta.model.DataQuestion;
import com.example.traveltoabazashta.model.DatabaseHelper;
import com.example.traveltoabazashta.model.Value;

import java.util.ArrayList;

public class Presenter {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    private Context mContext;
    private Cursor myCursor;


    public Presenter(Context context) {
        mContext = context;
        dbHelper = new DatabaseHelper(mContext);
    }

    private String getTestName(int indexTest) {
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
                        myCursor.getInt(6),
                        myCursor.getString(7)));
            }
            myCursor.moveToNext();
        }
        database.close();
        myCursor.close();
        return data;
    }

    public void setRecord(int result, String userName, int indexTest) {
        int record;
        database = dbHelper.getReadableDatabase();
        myCursor = database.rawQuery("select * from " + DatabaseHelper.TABLE_USERS, null);
        myCursor.moveToPosition(Value.idUser);
        record = myCursor.getInt(indexTest + 1);
        database.close();
        myCursor.close();
        if (result > record) {
            ContentValues cv = new ContentValues();
            cv.put(getTestName(indexTest), result);
            database = dbHelper.getReadableDatabase();
//            int updCount = database.update(DatabaseHelper.TABLE_USERS, cv, "_id = ?", new String[] { Value.idUser.toString() });
//            int a = database.update(DatabaseHelper.TABLE_USERS, cv, DatabaseHelper.COLUMN_ID + "=" + Value.idUser, null);
            int a = database.update(DatabaseHelper.TABLE_USERS, cv, "_id="+(Value.idUser + 1), null);
            database.close();
        }
    }

    public ArrayList<String> getUserLogins() {
        ArrayList<String> loginUsers = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        myCursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_USERS, null);
        myCursor.moveToFirst();
        for (int i = 0; i < myCursor.getCount(); ++i) {
            loginUsers.add(myCursor.getString(1));
            myCursor.moveToNext();
        }
        database.close();
        myCursor.close();
        return loginUsers;
    }

    public void addNewUser(String name) {
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_USER_NAME, name);
        database.insert(DatabaseHelper.TABLE_USERS, null, cv);
        database.close();
    }

    public ArrayList<Integer> getRecords(String userName) {
        ArrayList<Integer> arr = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        myCursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_USERS, null);
        myCursor.moveToPosition(Value.idUser);
        arr.add(myCursor.getInt(2));
        arr.add(myCursor.getInt(3));
        arr.add(myCursor.getInt(4));
        database.close();
        myCursor.close();
        return arr;
    }
}

package com.example.mysqlapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDataBaseAdapter {
    //database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "Login.db";
    //Variable to hold the database instance
    private static SQLiteDatabase db;
    //Database open/upgrade helper
    private DataBaseHelper dbHelper;


    // constructor
    public LoginDataBaseAdapter(Context context) {
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Method to open the database
    public LoginDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    // Method to close databse
    public void close()
    {
        db.close();
    }
    //method returns an instance of the database
    public SQLiteDatabase getDataBaseInstance()
    {
        return db;
    }

    //method to get the password of username
    public String getSingleEntry(String un)
    {
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("User", null, "UserName=?",
                new String[]{un}, null, null, null);
        if(cursor.getCount() < 1) // username not exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String getPassword = cursor.getString(cursor.getColumnIndex("userPassword"));
        cursor.close();
        return getPassword;
    }

    public void insertEntry(String un, String pw)
    {
        ContentValues newValues = new ContentValues();
        //Assign vale for each row.
        newValues.put("userName", un);
        newValues.put("userPassword", pw);

        // insert the row into your table
        db.insert ("User", null, newValues);
    }

}
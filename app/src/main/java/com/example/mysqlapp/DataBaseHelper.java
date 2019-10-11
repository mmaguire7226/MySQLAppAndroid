package com.example.mysqlapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table sql query
        String CREATE_USER_TABLE =
                "create table User (userID integer primary key autoincrement, userName text, " +
                        "userPassword text);";
        try {
            db.execSQL(CREATE_USER_TABLE);
        }
        catch (Exception er) {
            Log.e("Error : ", "exception");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop the table if exist
        db.execSQL("Drop table if exists " + "User");
        //create a new one
        onCreate(db);
    }
}

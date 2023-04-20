package com.example.myapplication.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Sqlite extends SQLiteOpenHelper {
    public Sqlite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + "user_table" +
                " (" + "ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "account" + " TEXT, " +
                "password" + " TEXT)";
        db.execSQL(createTable);

        // 插入数据
        ContentValues values1 = new ContentValues();
        values1.put("account", "1091052567");
        values1.put("password", "123");
        db.insert("user_table", null, values1);

        ContentValues values2 = new ContentValues();
        values2.put("account", "2483745934");
        values2.put("password", "456");
        db.insert("user_table", null, values2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 可以在此处添加升级表结构的代码
    }
}

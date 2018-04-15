package com.example.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * SQLiteOpenHelper类用于对于数据库的操作
 * Created by 461152465 on 2018/4/15.
 * 和SQLite数据库相关的类
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_TABLE = "create table Book ("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text)";

    public static final String CREATE_CATEGORY = "create table Category("
            + "id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code integer)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        //Context上下文
        //name：数据库名
        //CursorFactory数据库游标
        //version数据库版本
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE); //执行建表语句
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext, "Create succeed!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }


}

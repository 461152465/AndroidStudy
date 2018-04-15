package com.example.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
    注意SQLite数据库和MySQL数据库之间区别和联系
    首先创建数据库
    然后向数据库中添加表
    可以添加新的表（升级数据库）
    向表中添加数据
*/

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        //创建数据库
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dbHelper.getWritableDatabase(); //创建数据库
            }
        });
        //向数据库中一个表中添加shuju
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                  //SQLiteOpenHelper用于创建数据库，其中getWritableDatabase()方法返回一个SQLiteDatabase对象
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //添加第一条数据
                values.put("author","Jack");
                values.put("price",20.0);
                values.put("pages",30);
                values.put("name","Me");
                db.insert("Book", null, values);
                //添加第二条数据
                values.put("author","Rose");
                values.put("price",50.0);
                values.put("pages",100);
                values.put("name","You");
                db.insert("Book", null, values);
            }
        });
        //更新数据库中的数据
        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               SQLiteDatabase db = dbHelper.getWritableDatabase();
               ContentValues values = new ContentValues();
               values.put("price",10.99);
               db.update("Book", values, "name = ?",new String[]{"Me"} );
           }
        });
        //删除表中的一些数据
        Button deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               SQLiteDatabase db = dbHelper.getWritableDatabase();
               db.delete("Book","pages > ?",new String[] {"50"});
           }
        });
        Button queryButton = (Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               SQLiteDatabase db = dbHelper.getWritableDatabase();
               //查询Book表中的所有数据
               Cursor cursor = db.query("Book", null, null, null, null, null, null);
               if(cursor.moveToFirst()){
                   do {
                       //getColumnIndex获取数据位置索引，再用对应的方法打印出来
                       String name = cursor.getString(cursor.getColumnIndex("name"));
                       String author = cursor.getString(cursor.getColumnIndex("author"));
                       double price = cursor.getDouble(cursor.getColumnIndex("price"));
                       int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                       Log.d("MainActivity", "book name is" + name);
                       Log.d("MainActivity", "book price is " + price);
                       Log.d("MainActivity", "book pages is " + pages);
                       Log.d("MainActivity", "book author is " + author);
                       Log.d("MainActivity", "zhangjinsb");
                   } while(cursor.moveToNext());
               }
               cursor.close();
           }
        });
    }
}





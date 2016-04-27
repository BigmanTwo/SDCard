package com.example.asus.sdcard.sqlipte;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asus on 2016/4/24.
 */
public class MySqlOpen extends SQLiteOpenHelper {
    //第一个参数值的是引用的对象
    //第二个参数是数据库名
    //第三个参数一般为null
    //第四个参数为数据库自己的版本号
    public MySqlOpen(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
//创建数据库中的表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists goods(id int primary key ," +
                "image int,name vachar(20),price int)");
    }
//更新数据库中的版本
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

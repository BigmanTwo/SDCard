package com.example.asus.sdcard.sqlipte;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asus.sdcard.bean.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2016/4/24.
 */
public class MyGoodSql {
    private SQLiteDatabase db;

    public MyGoodSql(SQLiteDatabase db) {
        this.db = db;
    }
    public void addData(Goods goods){
        db.execSQL("insert into goods(image,name,price)values(?,?,?)",
                new Object[]{goods.getImage(),goods.getName(),goods.getPrice()});
    }
    public void updata(Goods goods){
        //空格也很重要
        db.execSQL("update goods set price="+goods.getPrice()+" where name='"+goods.getName()+"'");
    }
    public  void delete(Goods goods){
        //注意引号，数据的类型
        db.execSQL("delete from goods where name='"+goods.getName()+"'");
    }
    public List<Goods> quary(){
        List<Goods> list=new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from goods",null);
        while(cursor.moveToNext()){
            int image=cursor.getInt(cursor.getColumnIndex("image"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            int price=cursor.getInt(cursor.getColumnIndex("price"));
            Goods goods=new Goods(image,name,price);
            list.add(goods);
        }
        return list;
    }
    public void close(List<Goods> list){
        db.execSQL("delete from goods where id between 0 and '"+list.size()+"'");

    }
}

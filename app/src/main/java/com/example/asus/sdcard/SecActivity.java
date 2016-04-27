package com.example.asus.sdcard;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.asus.sdcard.adpter.Myadpter;
import com.example.asus.sdcard.bean.Goods;
import com.example.asus.sdcard.sqlipte.MyGoodSql;
import com.example.asus.sdcard.sqlipte.MySqlOpen;

import java.util.ArrayList;
import java.util.List;

public class SecActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton1,mButton2,mButton3,mButton4,mButton5;
    private ListView mListView;
    private List<Goods> mList;
    private MyGoodSql myGoodSql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        //创建SQLiteOpenHelper的实例
        MySqlOpen open=new MySqlOpen(this,"Goods",null,1);
        //通过getWritableDatabase方法获得数据库的操作权限
        //Writer既可以读也可以写，reader只能读
        SQLiteDatabase database=open.getWritableDatabase();
         myGoodSql=new MyGoodSql(database);
        mButton1=(Button)findViewById(R.id.add_data);
        mButton2=(Button)findViewById(R.id.del_data);
        mButton3=(Button)findViewById(R.id.upd_data);
        mButton4=(Button)findViewById(R.id.sel_data);
        mButton5=(Button)findViewById(R.id.drop_table);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mListView=(ListView)findViewById(R.id.list_item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_data:
                add();
                break;
            case R.id.del_data:
                delete();
                break;
            case R.id.upd_data:
                updata();
                break;
            case R.id.sel_data:
                query();
                break;
            case R.id.drop_table:
                close();
                finish();
                break;

        }
    }
    private void add(){
        Goods goods1=new Goods(R.mipmap.caocao,"曹操1",250);
        Goods goods2=new Goods(R.mipmap.caocao,"曹操2",250);
        Goods goods3=new Goods(R.mipmap.sidal,"曹操3",250);
        Goods goods4=new Goods(R.mipmap.caocao,"曹操4",250);
        Goods goods5=new Goods(R.mipmap.ph1,"曹操5",250);
        Goods goods6=new Goods(R.mipmap.caocao,"曹操6",250);
        Goods goods7=new Goods(R.mipmap.zhangfei,"曹操7",250);
        Goods goods8=new Goods(R.mipmap.mei,"美女",250);
        Goods goods9=new Goods(R.mipmap.caocao,"曹操8",250);
        myGoodSql.addData(goods1);
        myGoodSql.addData(goods2);
        myGoodSql.addData(goods3);
        myGoodSql.addData(goods4);
        myGoodSql.addData(goods5);
        myGoodSql.addData(goods6);
        myGoodSql.addData(goods7);
        myGoodSql.addData(goods8);
        myGoodSql.addData(goods9);
        mList=new ArrayList<>();
        mList=myGoodSql.quary();
        Myadpter myadpter=new Myadpter(mList,this);
        mListView.setAdapter(myadpter);
    }
    private void query(){
        mList=new ArrayList<>();
        mList=myGoodSql.quary();
        Myadpter myadpter=new Myadpter(mList,this);
        mListView.setAdapter(myadpter);
    }
    private void updata(){
        Goods goods=new Goods(R.mipmap.guanyu,"曹操5",230);
        myGoodSql.updata(goods);
        mList=new ArrayList<>();
        mList=myGoodSql.quary();
        Myadpter myadpter=new Myadpter(mList,this);
        mListView.setAdapter(myadpter);
    }
    private void delete(){
        Goods goods=new Goods("曹操3");
        myGoodSql.delete(goods);
        mList=new ArrayList<>();
        mList=myGoodSql.quary();
        Myadpter myadpter=new Myadpter(mList,this);
        mListView.setAdapter(myadpter);
    }
    private void close(){

        myGoodSql.close(mList);
    }
}

package com.example.asus.sdcard;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton1,mButton2,mButton3;
    private EditText editText1,editText2;
    static final String FILENAME="SSR.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=(EditText)findViewById(R.id.text1);
        editText2=(EditText)findViewById(R.id.text2);
        mButton1=(Button)findViewById(R.id.read_button);
        mButton2=(Button)findViewById(R.id.write_button);
        mButton3=(Button)findViewById(R.id.secactivity);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.write_button:
                String str= Environment.getExternalStorageState();
                if(Environment.MEDIA_MOUNTED.equals(str)){
                    File file=new File(Environment.getExternalStorageDirectory(),FILENAME);
                    try {
                        OutputStream outputStream=new FileOutputStream(file);
                        byte[] b=editText1.getText().toString().getBytes();
                        outputStream.write(b);
                        outputStream.flush();
                        outputStream.close();
                        Toast.makeText(this,"写入成功",Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }
                break;
            case R.id.read_button:
                File file=new File( Environment.getExternalStorageDirectory(),FILENAME);
                try {
                    InputStream inputStream=new FileInputStream(file);
                    byte[] b=new byte[inputStream.available()];
                    inputStream.read(b);
                    String sr=new String(b);
                    editText2.setText(sr);
                    inputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.secactivity:
                Intent intent=new Intent(MainActivity.this,SecActivity.class);
                startActivity(intent);
                break;
        }
    }
}

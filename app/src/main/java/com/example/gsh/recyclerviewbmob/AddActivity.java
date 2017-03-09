package com.example.gsh.recyclerviewbmob;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by gsh on 2017/3/6.
 */

public class AddActivity extends AppCompatActivity {
    private EditText ed_name;
    private EditText ed_age;
    private Button btn_add2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ed_name= (EditText) findViewById(R.id.ed_name);
        ed_age= (EditText) findViewById(R.id.ed_age);
        btn_add2= (Button) findViewById(R.id.btn_add2);

        btn_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age= Integer.parseInt(ed_age.getText().toString().trim());
                String name =ed_name.getText().toString().trim();
                initData(name,age);
                finish();
            }
        });


    }

    private void initData(String name,int age) {
        Person p=new Person();
        p.setName(name);
        p.setAge(age);
        p.setAddress("天安门");
        p.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e==null){
                    Toast.makeText(getApplicationContext(),"jiale",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"meijiale",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

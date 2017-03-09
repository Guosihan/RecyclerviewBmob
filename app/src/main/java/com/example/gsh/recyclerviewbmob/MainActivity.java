package com.example.gsh.recyclerviewbmob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Person> mArrayList;
    private RecyclerView mRecycleView;
    private MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView=(RecyclerView) findViewById(R.id.recyclerview);
        //StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));;



        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
                initquery();
            }
        });
        findViewById(R.id.btn_query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initquery();

            }
        });

        initdelect();
        initupdata();
        Bmob.initialize(this,"78401053e1640ec9ea828aa14005d352");

    }
    private void initinsert(){


    }
    private void initdelect(){

    }
    private  void initquery(){
        mArrayList = new ArrayList<>();
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();

        bmobQuery.setLimit(50);
        bmobQuery.findObjects(new FindListener<Person>() {
            @Override
            public void done(List<Person> list, BmobException e) {
                if (e==null){
                    for (Person p : list) {
                        mArrayList.add(p);
                    }
                    mAdapter = new MyAdapter(mArrayList);
                    mRecycleView.setAdapter(mAdapter);
                }else{
                    Toast.makeText(MainActivity.this,"cuole",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void initupdata(){

    }
}

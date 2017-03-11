package com.example.gsh.recyclerviewbmob;

import cn.bmob.v3.BmobUser;

/**
 * Created by gsh on 2017/3/11.
 */

public class User extends BmobUser {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

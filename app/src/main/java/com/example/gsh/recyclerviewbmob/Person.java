package com.example.gsh.recyclerviewbmob;

import cn.bmob.v3.BmobBatch;
import cn.bmob.v3.BmobObject;

/**
 * Created by gsh on 2017/3/6.
 */

public class Person extends BmobObject{
    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

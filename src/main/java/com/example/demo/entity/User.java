package com.example.demo.entity;

public class User {
    private int userid;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserid() {

        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(int userid,String name,int age) {
        this.userid = userid;
        this.name = name;
        this.age = age;
    }
    public User(){};
}

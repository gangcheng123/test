package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private Userservice userservice;
    @RequestMapping("/{userid}")
    public User user(@PathVariable("userid") int userid ){
        //User user=new User(0,"tom",12);
       // user.setId(id);

        return userservice.getUserbyid(userid);
    }
    @RequestMapping("/insertU")
    public void insertUser (@RequestBody String jsonUser ){
        User user =JSONObject.parseObject(jsonUser,User.class);
        userservice.insertUser(user);
    }
}

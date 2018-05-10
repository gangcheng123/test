package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Userservice {

    @Autowired
    private UserDao userDao;


    public User getUserbyid(int userid ){
       return userDao.getUserbyid(userid);
    }
    @Transactional
    public void insertUser(User user ){
       userDao.insertUser(user);
    }
}

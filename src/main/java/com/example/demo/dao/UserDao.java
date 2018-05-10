package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    @Select("select userid,name,age from user_tt where userid=#{userid}")
    public User getUserbyid(int userid);

    @Insert("insert into user_tt(userid,name,age) value (#{userid},#{name},#{age})")
    public void insertUser(User user);
}

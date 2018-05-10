package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)

@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void  init(){
        mockMvc=MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void isSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/4").contentType(MediaType.APPLICATION_JSON_UTF8)
//                .param("id","3")
        .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());

    }
    @Test
    public void insertUsetTest () throws Exception {
        User user =new User(5,"dddd",26);
        String jsonRequest= JSONObject.toJSONString(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/insertU").contentType(MediaType.APPLICATION_JSON)
        .content(jsonRequest)).andDo(MockMvcResultHandlers.print());
    }

}

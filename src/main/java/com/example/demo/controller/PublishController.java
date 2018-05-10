package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;
import javax.management.Query;

@RestController
@RequestMapping("/publish")
public class PublishController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue  queue;
    @Autowired
    private Topic topic;

    @RequestMapping("/queue")
    public  String queue(){
        for (int i = 0; i < 10; i++) {
            jmsMessagingTemplate.convertAndSend(queue,"queue"+i);
        }
        return "queuef发送成功";
    }

    @JmsListener(destination = "out.queue")
    public void consumerMsg(String msg){
        System.out.println(msg);
    }

    @RequestMapping("/topic")
    public String topic(){

        for (int i = 0; i < 10 ; i++){
            jmsMessagingTemplate.convertAndSend(topic, "topic"+i);
        }

        return "topic 发送成功";
    }


}

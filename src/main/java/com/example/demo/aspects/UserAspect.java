package com.example.demo.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {
    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    public void init(){}

    @Before(value="init()")
    public  void before(){
        System.out.println("执行之前");
    }
    @AfterReturning(value = "init()")
    public void after(){
        System.out.println("执行之后");
    }

}

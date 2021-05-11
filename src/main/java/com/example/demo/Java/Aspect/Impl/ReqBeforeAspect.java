package com.example.demo.Java.Aspect.Impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author zh
 * @date 2021-03-10 11:01
 **/
@Aspect
@Component
public class ReqBeforeAspect {

    @Before("@annotation(com.example.demo.Java.Aspect.annotation.ReqBefore)")
    public void before(JoinPoint joinPoint) {
        System.out.println("ReqBefore doAround start ...");
        System.out.println("ReqBefore doAround end ...");
    }
}

package com.example.demo.javaSomething.aspect.Impl;

import org.aspectj.lang.JoinPoint;
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

    @Before("@annotation(com.example.demo.javaSomething.aspect.annotation.ReqBefore)")
    public void before(JoinPoint joinPoint) {
        System.out.println("ReqBefore doAround start ...");
        System.out.println("ReqBefore doAround end ...");
    }
}

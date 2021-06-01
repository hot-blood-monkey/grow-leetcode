package com.example.demo.javaSomething.aspect.Impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zh
 * @date 2021-03-10 11:01
 **/
@Aspect
@Component
public class FacadeAspect {

    @Around("@annotation(com.example.demo.javaSomething.aspect.annotation.Facade)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("FacadeAspect doAround start ...");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("FacadeAspect doAround end ...");
        return result;
    }
}

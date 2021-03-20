package com.example.demo.Java.Proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zh
 * @date 2021-03-20 14:36
 **/

public class CglibHandler implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CglibHandler add........");
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("CglibHandler end........");
        return res;
    }
}

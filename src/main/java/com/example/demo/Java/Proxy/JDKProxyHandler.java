package com.example.demo.Java.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zh
 * @date 2021-02-22 00:40
 **/

public class JDKProxyHandler implements InvocationHandler {

    private Object target;

    public JDKProxyHandler (Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start");
        Object o = method.invoke(target, args);
        System.out.println("end");

        return o;
    }
}

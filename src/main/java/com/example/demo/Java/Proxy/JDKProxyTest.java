package com.example.demo.Java.Proxy;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Proxy;

/**
 * @author zh
 * @date 2021-02-22 00:44
 **/

public class JDKProxyTest {

    public static void main(String[] args) {
        UseeerManagerImpl userM1 = new UseeerManagerImpl();
        JDKProxyHandler jdkProxyHandler = new JDKProxyHandler(userM1);
        UserManager useeerManager = (UserManager) Proxy.newProxyInstance(UseeerManagerImpl.class.getClassLoader(),
                UseeerManagerImpl.class.getInterfaces(), jdkProxyHandler);
        useeerManager.addUser("zh", "134");

        int[] table = new int[] {1,3,5,7,9};
        int count = 0;
        for(int[] t = table;;) {
            System.out.println(JSON.toJSONString(t));
            count++;
            if (count > 10) {
                break;
            }
        }

        int f;

        if ( (f = count - 1) >= 10) {
            System.out.println(f);
        }



    }
}

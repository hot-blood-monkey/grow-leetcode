package com.example.demo.javaSomething.proxy;

import com.alibaba.fastjson.JSON;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author zh
 * @date 2021-02-22 00:44
 **/

public class JavaProxyTest {

    public static void main(String[] args) {
        testCglib();



    }

    public static void testJDK() {
        UserManagerImpl userM1 = new UserManagerImpl();
        JDKProxyHandler jdkProxyHandler = new JDKProxyHandler(userM1);
        UserManager userManager = (UserManager) Proxy.newProxyInstance(UserManagerImpl.class.getClassLoader(),
                UserManagerImpl.class.getInterfaces(), jdkProxyHandler);
        userManager.addUser("zh", "134");

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


    public static void testCglib() {
        UserManagerImpl userM1 = new UserManagerImpl();
        CglibHandler cglibHandler = new CglibHandler();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userM1.getClass());
        enhancer.setCallback(cglibHandler);
        UserManagerImpl proxyInstance = (UserManagerImpl) enhancer.create();
        proxyInstance.addUser("zh", "zh");
    }
}

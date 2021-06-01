package com.example.demo.dubboDemo.service;

import com.alibaba.fastjson.JSON;
import com.example.demo.dubboDemo.api.UserFacade;
import com.example.demo.dubboDemo.facade.UserFacadeImpl;
import org.apache.dubbo.common.bytecode.Wrapper;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zh
 * @date 2021-03-20 19:55
 **/
public class WrapperTest {

    public static void main(String[] args) {
        testWrapperFlow();
//        mockSelfDefinitionWrapper();
    }


    public static void testWrapperFlow() {
        UserFacadeImpl userFacade = new UserFacadeImpl();
        Wrapper wrapper = Wrapper.getWrapper(UserFacadeImpl.class);

        System.out.println("-------------------------------------------");
        System.out.println("wrapper.getDeclaredMethodNames() : " + JSON.toJSONString(wrapper.getDeclaredMethodNames()));
        System.out.println("wrapper.getPropertyNames() : " + JSON.toJSONString(wrapper.getPropertyNames()));
        System.out.println("wrapper json : " + JSON.toJSONString(wrapper));
        System.out.println("-------------------------------------------");

        try {
            Object res = wrapper.invokeMethod(userFacade, "getUserName", new Class[]{Long.class}, new Object[]{1L});
            System.out.println(res);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void mockSelfDefinitionWrapper() {
        UserFacadeImpl userFacade = new UserFacadeImpl();
        WrapperUserFacadeImpl wrapper = new WrapperUserFacadeImpl<UserFacade>();

        System.out.println("-------------------------------------------");
        System.out.println("wrapper.getDeclaredMethodNames() : " + JSON.toJSONString(wrapper.getDeclaredMethodNames()));
        System.out.println("wrapper.getPropertyNames() : " + JSON.toJSONString(wrapper.getPropertyNames()));
        System.out.println("wrapper json : " + JSON.toJSONString(wrapper));
        System.out.println("-------------------------------------------");

        try {
            Object res = wrapper.invokeMethod(userFacade, "getUserName", new Class[]{Long.class}, new Object[]{1L});
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.example.demo.DubboDemo.service;

import com.alibaba.fastjson.JSON;
import com.example.demo.DubboDemo.api.UserFacade;
import com.example.demo.DubboDemo.facade.UserFacadeImpl;
import org.apache.dubbo.common.bytecode.Wrapper;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zh
 * @date 2021-03-20 19:55
 **/
public class WrapperTest {

    public static void main(String[] args) {
        UserFacadeImpl userFacade = new UserFacadeImpl();
        Wrapper wrapper = Wrapper.getWrapper(UserFacade.class);
        System.out.println("wrapper.getDeclaredMethodNames():" + JSON.toJSONString(wrapper.getDeclaredMethodNames()));
        System.out.println("wrapper.getMethodNames()" + JSON.toJSONString(wrapper.getMethodNames()));
        System.out.println("wrapper.getPropertyNames()" + JSON.toJSONString(wrapper.getPropertyNames()));

        try {
            Object res = wrapper.invokeMethod(userFacade, "getUserName", new Class[]{Long.class}, new Object[]{1L});
            System.out.println(res);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

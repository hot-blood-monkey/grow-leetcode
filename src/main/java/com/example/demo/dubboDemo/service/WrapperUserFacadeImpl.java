package com.example.demo.dubboDemo.service;

import org.apache.dubbo.common.bytecode.NoSuchPropertyException;
import org.apache.dubbo.common.bytecode.Wrapper;

public class WrapperUserFacadeImpl<T> extends Wrapper {

    private T proxy;

    @Override
    public String[] getPropertyNames() {
        return new String[0];
    }

    @Override
    public Class<?> getPropertyType(String pn) {
        return null;
    }

    @Override
    public boolean hasProperty(String name) {
        return false;
    }

    @Override
    public Object getPropertyValue(Object instance, String pn) throws NoSuchPropertyException, IllegalArgumentException {
        return null;
    }

    @Override
    public void setPropertyValue(Object instance, String pn, Object pv) throws NoSuchPropertyException, IllegalArgumentException {

    }

    @Override
    public String[] getMethodNames() {
        return new String[0];
    }

    @Override
    public String[] getDeclaredMethodNames() {
        return new String[0];
    }


    @Override
    public Object invokeMethod(Object instance, String mn, Class<?>[] types, Object[] args)  {
        try {
            proxy = (T) instance;
            return proxy.getClass().getMethod(mn, types).invoke(proxy, args);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}

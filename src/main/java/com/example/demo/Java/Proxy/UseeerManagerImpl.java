package com.example.demo.Java.Proxy;

/**
 * @author zh
 * @date 2021-02-22 00:45
 **/

public class UseeerManagerImpl implements UserManager {
    @Override
    public void addUser(String username, String password) {
        System.out.println("add username:" + username + " password:" + password);
    }

    @Override
    public void delUser(String username) {
        System.out.println("delete username:" + username);


    }
}

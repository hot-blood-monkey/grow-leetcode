package com.example.demo.Java.Proxy;

import com.example.demo.Java.Aspect.annotation.Facade;
import com.example.demo.Java.Aspect.annotation.ReqBefore;
import org.springframework.stereotype.Service;

/**
 * @author zh
 * @date 2021-02-22 00:45
 **/
@Service
public class UserManagerImpl implements UserManager {

    @ReqBefore
    @Override
    public void addUser(String username, String password) {
        System.out.println("add username:" + username + " password:" + password);
    }

    @Facade
    @Override
    public void delUser(String username) {
        System.out.println("delete username:" + username);


    }
}

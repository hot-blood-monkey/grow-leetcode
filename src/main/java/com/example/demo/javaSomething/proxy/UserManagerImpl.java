package com.example.demo.javaSomething.proxy;

import com.example.demo.javaSomething.aspect.annotation.Facade;
import com.example.demo.javaSomething.aspect.annotation.ReqBefore;
import com.example.demo.javaSomething.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void change(User user) throws Exception {
        user.setName("kong");
        if (user.getAge() == 1) {
            throw new Exception("fjmdf");
        }

    }
}

package com.example.demo.javaSomething.proxy;

import com.example.demo.javaSomething.model.User;

/**
 * @author zh
 * @date 2021-02-22 00:38
 **/

public interface UserManager {
    void addUser(String username, String password);
    void delUser(String username) throws Exception;

    void change(User user) throws Exception;
}

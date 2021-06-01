package com.example.demo.javaSomething;

import com.alibaba.fastjson.JSON;
import com.example.demo.javaSomething.proxy.UserManagerImpl;
import com.example.demo.javaSomething.model.User;
import org.springframework.stereotype.Component;

@Component
public class TransitionDemo {

    public void init() {
        UserManagerImpl userManager = new UserManagerImpl();
        User user = new User();
        user.setName("A");
        user.setAge(1);
        try {
            userManager.change(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSON(user));
    }
}

package com.example.demo.Java;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zh
 * @date 2021-03-05 17:29
 **/
@Component
public class UserTest {

    @PostConstruct
    public void init() {
        try {
            User user = (User) Class.forName("com.example.demo.Java.User").newInstance();
            System.out.println(user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

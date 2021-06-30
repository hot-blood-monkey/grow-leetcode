package com.example.demo.admin.service;

import com.alibaba.fastjson.JSON;
import com.example.demo.javaSomething.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    public static final ThreadLocal<List<User>> threadLocal = new ThreadLocal();

    @Override
    public void showUserInfoByRandom() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setAge(i);
            user.setName(String.valueOf(i));
            user.setTel("sjjffjjfffjkdfjdklsjfklsdjfklsdjkfjsdklfjsdkljffdjf");
            user.setProvince("hunan Province");

            mockUserCop(user);

            userList.add(user);
        }
        threadLocal.set(userList);


    }

    private void mockUserCop(User user) {
        if (user.getAge() < 50) {
            user.setAge(user.getAge() * 3);
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (user.getName().length() < 10) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append(user.getName());
            }
            user.setName(sb.toString());
        }
    }
}

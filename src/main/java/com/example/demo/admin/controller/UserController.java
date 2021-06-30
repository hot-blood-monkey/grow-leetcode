package com.example.demo.admin.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.admin.service.UserService;
import com.example.demo.javaSomething.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/showUserInfoByRandom")
    public void showUserInfoByRandom() {
        userService.showUserInfoByRandom();
    }

}

package com.example.demo.Java;

import com.example.demo.Java.Proxy.UserManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author zh
 * @date 2021-02-23 01:06
 **/
@Component
public class OomTest {

    @Resource
    private OoMComponent ooMComponent;

    @Resource
    private UserManager userManager;

    @PostConstruct
    public void init() {
        System.out.println("ooMComponent.outMemoryThread() - start");
        userManager.addUser("su", "su");
        System.out.println("ooMComponent.outMemoryThread() - end");
    }

}

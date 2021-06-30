package com.example.demo.dubboDemo.consumer;

import com.example.demo.dubboDemo.api.UserFacade;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zh
 * @date 2021-03-21 00:06
 **/
@Component
public class UserConsumer {

//    @Reference(check = false, version = "1.0.0", timeout = 2000, init = true)
    private UserFacade us;

//    @PostConstruct
//    public void init() {
//        new Thread(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            String name = us.getUserName(23L);
//            System.out.println(name);
//        }).start();
//
//    }
}

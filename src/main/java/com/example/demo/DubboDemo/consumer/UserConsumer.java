package com.example.demo.DubboDemo.consumer;

import com.example.demo.DubboDemo.api.UserFacade;
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
//    private UserFacade userFacade;
//
//    @PostConstruct
//    public void init() {
//        String name = userFacade.getUserName(23L);
//        System.out.println(name);
//    }
}

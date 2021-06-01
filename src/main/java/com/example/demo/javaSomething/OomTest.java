package com.example.demo.javaSomething;

import com.example.demo.javaSomething.aspect.annotation.ReqBefore;
import com.example.demo.javaSomething.proxy.UserManager;
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
//        ooMComponent.outMemoryThread();
        System.out.println("ooMComponent.outMemoryThread() - end");
    }

    @ReqBefore
    public void aop() {
    }

}

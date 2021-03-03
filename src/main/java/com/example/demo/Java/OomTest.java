package com.example.demo.Java;

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

    @PostConstruct
    public void init() {
        System.out.println("ooMComponent.outMemoryThread() - start");
        ooMComponent.outMemoryThread();
        System.out.println("ooMComponent.outMemoryThread() - end");
    }

}

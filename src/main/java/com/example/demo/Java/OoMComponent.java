package com.example.demo.Java;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zh
 * @date 2021-02-23 00:52
 **/
@Component
public class OoMComponent {

    @Resource
    private OomTest oomTest;


    public void outMerry() {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i<999999999; i ++) {
            res.add(new int[99999999]);
        }
        System.out.println(res.size());
    }

    public void outMemoryThread() {
        ExecutorService executor = new ThreadPoolExecutor(
                100,
                200,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque());
        for(int i = 0; i<999999999; i++) {
            executor.execute(this::outMerry);
        }
    }



}

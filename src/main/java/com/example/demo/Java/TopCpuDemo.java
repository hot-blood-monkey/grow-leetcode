package com.example.demo.Java;

import org.apache.dubbo.common.utils.NamedThreadFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.concurrent.*;

@Component
public class TopCpuDemo {
    public static final ThreadFactory threadFactory = new NamedThreadFactory("Thread-TopCpuDemo-");

    public static final ExecutorService executor = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue(10), threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());


    @PostConstruct
    public void init() {
        executor.submit(() -> topCpuFun());
        executor.submit(() -> topCpuFun());
    }

    private void topCpuFun() {
        while (true) {

        }
    }
}

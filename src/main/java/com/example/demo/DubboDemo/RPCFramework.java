package com.example.demo.DubboDemo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zh
 * @date 2021-03-15 17:28
 **/

public class RPCFramework {

    public static ExecutorService threadExecutor = new ThreadPoolExecutor(10, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static void export (Object service, int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket socket = server.accept();
            threadExecutor.submit(() -> {
                try {
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    Class serviceClass = service.getClass();
                    Method[] methods = serviceClass.getMethods();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }

    }

    public void say(String msg) {
        System.out.println(msg);
    }


    public static void main(String[] args) {
        ServiceLoader<RPCFramework> serviceLoader = ServiceLoader.load(RPCFramework.class);
        for (RPCFramework framework : serviceLoader) {
            framework.say("frame");
        }
    }
}

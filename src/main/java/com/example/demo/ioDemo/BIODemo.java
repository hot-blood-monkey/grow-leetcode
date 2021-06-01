package com.example.demo.ioDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class BIODemo {
    public static final ExecutorService executorService = new ThreadPoolExecutor(8, 16, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
    public void bioProcessor() {
        try {
            ServerSocket serverSocket = new ServerSocket(8090);
            while (true) {
                Socket client = serverSocket.accept();
                if (client == null) {
                    System.out.println("client connect is null");
                    continue;
                } else {
                    executorService.submit(() -> forkThreadDoing(client));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void forkThreadDoing(Socket client) {
        try (InputStream in = client.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        BIODemo q = new BIODemo();
        q.bioProcessor();

    }
}

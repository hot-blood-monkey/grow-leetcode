package com.example.demo.Java;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @author zh
 * @date 2021-03-14 14:06
 **/

public class PriorityQueueTest {


    public static void main(String[] args) {
        Random random = new Random();
        Queue<Integer> queue = new PriorityQueue<>(5);
        for (int i=0; i<100;i++) {
            if (queue.size() == 5) {
                queue.remove();
            }

            int v = i;
            queue.add(v);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}

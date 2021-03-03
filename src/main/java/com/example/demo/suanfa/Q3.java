package com.example.demo.suanfa;

import org.assertj.core.util.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zh
 * @date 2021-03-01 10:46
 **/

public class Q3 {

    public static class Node {
        private String val;
        private Node left;
        private Node right;


    }

    public static void func(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        int len = 1;
        int nextLen = 0;

        while (!queue.isEmpty()) {

            for(int i=0; i<len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                    nextLen ++;
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                    nextLen ++;
                }
            }

            len = nextLen;
            nextLen = 0;
        }

    }


    public static void main(String[] args) {
        Node head = new Node();
        head.val = "a";

        Node l1 = new Node();
        l1.val = "b";

        Node r1 = new Node();
        r1.val = "c";

        Node r2 = new Node();
        r2.val = "d";

        Node l3 = new Node();
        l3.val = "e";



        head.left = l1;
        head.right = r1;

        r1.right = r2;
        r2.left = l3;

        func(head);


    }
}

package com.example.demo.leetCode.Q25;

import com.alibaba.fastjson.JSON;
import com.example.demo.leetCode.ListNode;


public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode();
        ListNode pre = preHead;
        ListNode start = head;
        ListNode end = null;
        int i = 0;
        while (head != null) {
            i ++;
            if (i == k) {
                end = head;
                head = head.next;
                end.next = null;

                ListNode changStart = reverse(start);

                // pre next point
                pre.next = changStart;
                // pre point cur segment end;
                pre = start;
                // start point end.next;
                start = head;
                i = 0;
            } else {
                head = head.next;
            }

        }


        pre.next = start;
        return preHead.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;


        Q25 q = new Q25();
        ListNode res = q.reverseKGroup(a1, 2);
        System.out.println(JSON.toJSON(res));

    }
}

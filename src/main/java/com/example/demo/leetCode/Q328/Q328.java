package com.example.demo.leetCode.Q328;

import com.alibaba.fastjson.JSON;
import com.example.demo.leetCode.ListNode;

public class Q328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slowH = head;
        ListNode fastH = head.next;
        ListNode fastHeadBackup = fastH;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slowH.next = fast.next;
            fastH.next = fast.next.next;
            slowH = slowH.next;
            fastH = fastH.next;
            fast = fastH;
        }

        slowH.next = fastHeadBackup;
        return head;
    }


    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        Q328 q = new Q328();
        ListNode res = q.oddEvenList(a1);
        System.out.println(JSON.toJSON(res));
    }

}

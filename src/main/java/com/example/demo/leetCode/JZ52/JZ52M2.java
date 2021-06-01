package com.example.demo.leetCode.JZ52;

import com.alibaba.fastjson.JSON;
import com.example.demo.leetCode.ListNode;

public class JZ52M2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b ) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
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

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);
        ListNode b4 = new ListNode(8);
        ListNode b5 = new ListNode(4);
        ListNode b6 = new ListNode(5);
        b1.next = b2;
        b2.next = b3;
        b3.next = a3;
//        b4.next = b5;
//        b5.next = b6;

        JZ52M2 jz52 = new JZ52M2();
        ListNode res = jz52.getIntersectionNode(a1, b1);
        System.out.println(JSON.toJSON(res));
    }
}

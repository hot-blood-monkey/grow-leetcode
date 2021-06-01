package com.example.demo.leetCode.Q61;

import com.example.demo.leetCode.ListNode;

/**
 * @author zh
 * @date 2021-02-18 23:48
 **/

public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode fast = preHead;
        ListNode slow = preHead;
        int total = 0;
        while (fast.next != null) {
            fast = fast.next;
            total ++;
        }

        fast = preHead;
        int count = k % total;
        while (fast.next != null) {
            fast = fast.next;
            count ++;
            if (count > k) {
                slow = slow.next;
            }
        }

        fast.next = head;
        preHead.next = slow.next;
        slow.next = null;
        return preHead.next;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        head.next = n1;
        n1.next = n2;
        Object o = new Q61().rotateRight(head, 1);
        System.out.println(o);
    }
}

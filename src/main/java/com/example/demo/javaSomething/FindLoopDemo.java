package com.example.demo.javaSomething;

import com.example.demo.leetCode.ListNode;

public class FindLoopDemo {
    public static boolean hasLoop(ListNode head) {
        if (head == null) {
            return false;
        }

        if (head.next == null) {
            return false;
        }


        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null) {
            if (slow == fast) {
                return true;
            }

            if (fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;


    }
}

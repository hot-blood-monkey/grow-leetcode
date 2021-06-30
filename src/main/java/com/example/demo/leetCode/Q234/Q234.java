package com.example.demo.leetCode.Q234;

import com.example.demo.leetCode.ListNode;

public class Q234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        if (head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            temp.next = pre;
            pre = temp;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null && pre != null) {
            if (pre.val == slow.val) {
                pre = pre.next;
                slow = slow.next;
                continue;
            }
            return false;
        }

        return true;

    }


    public static void main(String[] args) {

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);
        ListNode b4 = new ListNode(1);
        ListNode b5 = new ListNode(0);
        ListNode b6 = new ListNode(5);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;

        Q234 q = new Q234();
        q.isPalindrome(b1);
    }

}

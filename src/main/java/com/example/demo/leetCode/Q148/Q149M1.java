package com.example.demo.leetCode.Q148;

import com.alibaba.fastjson.JSON;
import com.example.demo.leetCode.ListNode;

public class Q149M1 {
    public ListNode sortList(ListNode head) {
        // 1.
        if (head.next == null) {
            return head;
        }

        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode fast = preHead;
        ListNode slow = preHead;
        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(fast);

        // 2。 合并
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode preHead = new ListNode();
        preHead.next = left;
        ListNode preLeft = preHead;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                preLeft = left;
                left = left.next;
            } else {
                preLeft.next = right;
                preLeft = right;
                ListNode temp = right.next;
                right.next = left;
                right = temp;
            }
        }

        if (left == null) {
            preLeft.next = right;
        }

        return preHead.next;
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
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;

        Q149M1 q = new Q149M1();
        ListNode res = q.sortList(a1);
        System.out.println(JSON.toJSON(res));
    }
}

package com.example.demo.javaSomething;

import com.alibaba.fastjson.JSON;
import lombok.Data;

public class MergeSection {

    @Data
    public static class ListSectionNode {
        private Integer left;
        private Integer right;
        private ListSectionNode next;

        public ListSectionNode () {

        }

        public ListSectionNode (Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }
    }


    public static ListSectionNode merge(ListSectionNode n1, ListSectionNode n2) {
        ListSectionNode head = null;
        ListSectionNode preHead = null;
        ListSectionNode res = null;

        while (n1 != null && n2 != null) {
            if (res == null) {
                //
                boolean canMerge = mergeNode(n1, n2);
                if (canMerge) {
                    res = new ListSectionNode(n2.left, n2.right);
                    n1 = n1.next;
                    n2 = n2.next;
                } else if (n1.left < n2.left) {
                    res = new ListSectionNode(n1.left, n1.right);
                    n1 = n1.next;
                } else {
                    res = new ListSectionNode(n2.left, n2.right);
                    n2 = n2.next;
                }

                head = head == null ? res : head;
                if (preHead != null) {
                    preHead.next = res;
                }

            } else {
                boolean b1 = mergeNode(n1, res);
                n1 = b1 ? n1.next : n1;
                boolean b2 = mergeNode(n2, res);
                n2 = b2 ? n2.next : n2;
                // 与 res 没办法和

                if (!b1 && !b2) {
                    preHead = res;
                    res = res.next;
                }
            }

        }

        System.out.println(JSON.toJSON(head));

        return head;

    }

    private static boolean mergeNode(ListSectionNode node, ListSectionNode res) {
        if (node.right < res.left || node.left > res.right) {
            return false;
        }

        res.left = Math.min(node.left, res.left);
        res.right = Math.max(node.right, res.right);
        return true;
    }


    public static void main(String[] args) {
        ListSectionNode n1 = new ListSectionNode(1, 3);
        ListSectionNode n1N1 = new ListSectionNode(4, 5);
        ListSectionNode n1N2 = new ListSectionNode(8, 13);
        n1.next = n1N1;
        n1N1.next = n1N2;
//

        ListSectionNode n2 = new ListSectionNode(0, 5);
        ListSectionNode n2N1 = new ListSectionNode(6, 7);
        ListSectionNode n2N2 = new ListSectionNode(10, 15);
        ListSectionNode n2N3 = new ListSectionNode(30, 40);
        n2.next = n2N1;
        n2N1.next = n2N2;
        n2N2.next = n2N3;

        merge(n1,n2);


    }
}

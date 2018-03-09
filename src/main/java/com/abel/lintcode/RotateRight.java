package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/9/15 17:01.
 * 给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数
 *
 * 给出链表1->2->3->4->5->null和k=2
 *
 * 返回4->5->1->2->3->null*
 */
public class RotateRight {
    /*
         * @param head: the List
         * @param k: rotate to the right k places
         * @return: the list after rotation
         */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        if (head == null || k == 0 || k == len || k % len == 0) {
            return head;
        }

        p = head;
        int index = 1;


        while (index != (len - k % len)) {
            index++;
            p = p.next;
        }

        ListNode q = p.next;
        p.next = null;

        ListNode t = q;
        while (t.next != null) {
            t = t.next;
        }
        t.next = head;

        return q;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

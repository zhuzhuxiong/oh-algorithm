package com.leetcode.classic150;

import com.structure.linked.ListNode;

/**
 * 环形链表
 * @author zz
 */
public class No56Code141 {

    public boolean hasCycle(ListNode head) {
        ListNode h1 = head, h2 = head;
        while (h1 != null && h1.next != null && h2 != null) {
            h1 = h1.next.next;
            h2 = h2.next;
            if (h1 == h2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

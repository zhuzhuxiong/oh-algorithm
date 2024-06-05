package com.leetcode.classic150;

import com.structure.linked.ListNode;

/**
 * @author zz
 */
public class No62Code19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        /** ** */
        dummy.next = head;
        ListNode p = dummy;
        ListNode fast = dummy;
        /** ** */
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}

package com.labula.linked;

import com.structure.linked.ListNode;

/**
 * 环形
 * @author zz
 */
public class No6Code141 {

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

    public static boolean practice(ListNode head) {
        return false;
    }
}

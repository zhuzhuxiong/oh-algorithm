package com.labula.linked;

import com.structure.linked.ListNode;

/**
 * @author zz
 */
public class Code19No4 {

    /**
     * 1.虚拟节点
     * 2.p2.next = p2.next.next;
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p1 = dummy;
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }
        ListNode p2 = dummy;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }

    /**
     * 寻找倒数第 n 个节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode findNthFormEnd(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


    public static void main(String[] args) {

    }

    public static ListNode practice(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p1 = dummy,p2 = dummy;
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }

}

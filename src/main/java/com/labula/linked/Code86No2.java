package com.labula.linked;

import com.structure.linked.ListNode;

/**
 * @author zz
 */
public class Code86No2 {

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;

        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            }else {
                p1.next = p;
                p1 = p1.next;
            }

            //断开新链表与原链表的方法 避免成环
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        //链接两个链表
        p1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {

    }

    public ListNode practice(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            }else {
                p1.next = p;
                p1 = p1.next;
            }

            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}

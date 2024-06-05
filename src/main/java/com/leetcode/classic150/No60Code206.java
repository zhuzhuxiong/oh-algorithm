package com.leetcode.classic150;

import com.structure.linked.ListNode;

/**
 * 翻转链表
 * @author zz
 */
public class No60Code206 {

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {

    }

    public ListNode practice(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode last = practice(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }




}

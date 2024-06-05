package com.leetcode.classic150;

import com.structure.linked.ListNode;

/**
 * 两数相加
 * @author zz
 */
public class No57No2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while (h1 != null || h2 != null || carry > 0) {

            int sum = carry;
            if (h1 != null) {
                sum += h1.val;
                h1 = h1.next;
            }
            if (h2 != null) {
                sum += h2.val;
                h2 = h2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            p.next = new ListNode(sum);
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }

    public ListNode practice(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1, p2 = l2;
        int carry = 0;
        while (p1 != null || p2 != null || carry > 0) {
            int sum = carry;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            sum = sum / 10;
            carry = sum % 10;
            p.next = new ListNode(sum);
            p = p.next;
        }
        return dummy.next;
    }
}

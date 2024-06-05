package com.leetcode.classic150;

import com.structure.linked.ListNode;

/**
 * 合并两个有序链表
 * @author zz
 */
public class No58Code21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            }else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}

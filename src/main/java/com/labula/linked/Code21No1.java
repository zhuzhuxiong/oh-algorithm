package com.labula.linked;

import com.structure.linked.LinkedList;
import com.structure.linked.ListNode;
import com.util.PrintUtil;

/**
 * 链表双指针
 * @author zz
 */
public class Code21No1 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = list1, p2 = list2;
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
        if (p1 != null){
            p.next = p1;
        }
        if (p2 != null){
            p.next = p2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_4 = new ListNode(4);
        LinkedList.insert(l1, l1_2);
        LinkedList.insert(l1_2, l1_4);
        PrintUtil.printLinked(l1);

        ListNode l2 = new ListNode(1);
        ListNode l2_3 = new ListNode(3);
        ListNode l2_4 = new ListNode(4);
        LinkedList.insert(l2, l2_3);
        LinkedList.insert(l2_3, l2_4);
        PrintUtil.printLinked(l2);

        ListNode listNode = practice(l1, l2);
        PrintUtil.printLinked(listNode);
    }

    public static ListNode practice(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = list1, p2 = list2;

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
}

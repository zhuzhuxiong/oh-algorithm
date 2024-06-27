package com.labula.linked.reverse;

import com.structure.linked.ListNode;
import com.util.PrintUtil;

/**
 *
 * @author zz
 */
public class No1Code206 {

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, next = head;
        while (cur != null) {
            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        No1Code206 code206 = new No1Code206();
        PrintUtil.printLinked(code206.reverseList(node1));
        PrintUtil.printLinked(code206.practice(node5));
        PrintUtil.printLinked(code206.reverse(node1));


    }

    public ListNode practice(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = practice(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

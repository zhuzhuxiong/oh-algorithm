package com.labula.linked.reverse;

import com.structure.linked.ListNode;
import com.util.PrintUtil;

/**
 * @author zz
 */
public class No3Code92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
           return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null;
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
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

        No3Code92 code206 = new No3Code92();
        PrintUtil.printLinked(code206.reverseBetween(node1 , 2,4));
    }
}

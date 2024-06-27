package com.labula.linked.reverse;

import com.structure.linked.ListNode;
import com.util.PrintUtil;

/**
 * k个一组翻转
 * @author zz
 */
public class No4Code25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a, b;
        a = b = head;
        //k个以内不翻转
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        //翻转a-b
        ListNode newHead = reverse(a, b);
        //递归后续
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, next = a;
        while (cur != b) {
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

        No4Code25 code25 = new No4Code25();
        PrintUtil.printLinked(code25.practice(node1, 3));
        PrintUtil.printLinked(code25.reverseKGroup(node1, 3));
    }

    public ListNode practice(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a , b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = re(a, b);
        a.next = practice(b, k);
        return newHead;
    }

    private ListNode re(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

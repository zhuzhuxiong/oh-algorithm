package com.labula.linked;

import com.structure.linked.ListNode;

/**
 * 返回链表中点
 * @author zz
 */
public class FindMidNode {

    /**
     *  偶数个节点时，返回靠后的一个
     */
    public static ListNode findMidNode(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2;
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
//        node4.next = node5;

        System.out.println(findMidNode(node1).val);
    }
}

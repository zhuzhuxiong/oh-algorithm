package com.labula.linked;

import com.structure.linked.ListNode;

import java.util.PriorityQueue;

/**
 * @author
 */
public class Code23No3 {

    /**
     * 1.利用优先级队列找最小值，即起点
     * 2.虚拟起点
     * 3.p = p.next 向后
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,(a, b) -> (a.val - b.val));

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            p.next = min;
            if (min.next != null) {
                queue.add(min.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }

    public ListNode practice(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,(a,b) -> (a.val - b.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}

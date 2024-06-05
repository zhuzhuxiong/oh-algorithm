package com.leetcode.classic150;

import com.structure.linked.ListNode;

/**
 * 翻转链表 贰
 * @author zz
 */
public class No60Code92 {

    /**
     * 前奏：反正链表前N个节点
     * @param head
     * @param n
     * @return
     */
    /** h后继节点 */
    ListNode successor;
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head, left - 1, right - 1);
        return head;
    }

    public static void main(String[] args) {

    }

//    ListNode reverse(ListNode head, int n) {
//
//    }



}

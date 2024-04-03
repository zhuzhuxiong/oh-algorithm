package com.labula.linked;

import com.structure.linked.ListNode;
import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Header1_1Impl;

/**
 * @author zz
 */
public class Code160No7 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            }else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            }else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    public static void main(String[] args) {

    }

    public static ListNode practice(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null){
                p1 = headB;
            }else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            }else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}

package com.structure.linked;

/**
 * 双向链表节点
 * @author zz
 */
public class DeListNode {

    public int val;
    public DeListNode prev;
    public DeListNode next;

    public DeListNode(int val){
        this.val = val;
        prev = next = null;
    }
}

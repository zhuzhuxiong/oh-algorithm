package com.leetcode.classic150;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据结构复制 公式：
 * 一个哈希表 + 两次遍历。
 *
 * 第一次遍历专门克隆节点，借助哈希表把原始节点和克隆节点的映射存储起来；
 * 第二次专门组装节点，照着原数据结构的样子，把克隆节点的指针组装起来。
 * @author zz
 */
public class No59Code138 {

    public Node copyRandomList(Node head) {
        // <old, new>
        HashMap<Node, Node> map = new HashMap<>();
        for (Node p = head; p != null ; p = p.next) {
            if (!map.containsKey(p)) {
                map.put(p, new Node(p.val));
            }
        }

        for (Node p = head; p != null ; p = p.next) {
            if (p.next != null) {
                map.get(p).next = map.get(p.next);
            }
            if (p.random != null) {
                map.get(p).random = map.get(p.random);
            }
        }
        return map.get(head);
    }

    public static void main(String[] args) {

    }

    public Node practice(Node head) {
        Map<Node, Node> map = new HashMap<>();
        for (Node p = head; p != null ; p = p.next) {
            if (!map.containsKey(p)) {
                map.put(p, new Node(p.val));
            }
        }

        for (Node p = head; p != null ; p = p.next) {
            if (p.next != null) {
                map.get(p).next = map.get(p.next);
            }
            if (p.random != null) {
                map.get(p).random = map.get(p.random);
            }
        }
        return map.get(head);
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

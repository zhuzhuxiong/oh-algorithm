package com.labula.linked.lru;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author zz
 */
public class No1Code146_1 {

    class Node{
        public int key;
        public int val;
        public Node next;
        public Node pre;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList{
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void  addLast(Node node) {
            //维护新节点的前后指针，新节点-前节点的后指针，新节点-后节点的前指针
            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;
            size++;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return size;
        }
    }

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;

    public No1Code146_1(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecent(key);
        return map.get(key).val;
    }

    private void makeRecent(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (capacity == cache.size) {
            removeOld();
        }
        addRecently(key,value);
    }

    private void removeOld() {
        Node node = cache.removeFirst();
        map.remove(node.key);
    }

    private void addRecently(int key, int value) {
        Node node = new Node(key, value);
        cache.addLast(node);
        map.put(key, node);
    }

    private void deleteKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
    }
}

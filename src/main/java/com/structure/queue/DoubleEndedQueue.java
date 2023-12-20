package com.structure.queue;

import com.structure.linked.DeListNode;
import com.util.PrintUtil;

import java.util.LinkedList;

/**
 * 双向队列
 *
 * @author zz
 */
public class DoubleEndedQueue {

    private DeListNode front, rear;
    private int size;

    public DoubleEndedQueue() {
        rear = front = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void pushFirst(int num) {
        push(num, true);
    }

    public void pushLast(int num) {
        push(num, false);
    }

    private void push(int num, boolean isFront) {
        DeListNode node = new DeListNode(num);
        if (isEmpty()) {
            front = rear = node;
        } else if (isFront) {
            front.prev = node;
            node.next = front;
            front = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
        size++;
    }

    public int popFirst() {
        return pop(true);
    }

    public int popLast() {
        return pop(false);
    }

    private int pop(boolean isFront) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int val;
        if (isFront) {
            val = front.val;
            DeListNode fNext = front.next;
            if (null != fNext) {
                fNext.prev = null;
                front.next = null;
            }
            front = fNext;
        } else {
            val = rear.val;
            DeListNode rPrev = rear.prev;
            if (null != rPrev) {
                rear.prev = null;
                rPrev.next = null;
            }
            rear = rPrev;
        }
        size--;
        return val;
    }


    public static void main(String[] args) {
        LinkedList<Integer> dequeue = new LinkedList<>();

        dequeue.offerLast(3);
        dequeue.offerFirst(2);
        dequeue.offerLast(4);
        dequeue.offerFirst(1);

        System.out.println(dequeue);

        System.out.println(dequeue.peekFirst());
        System.out.println(dequeue.peekLast());

        System.out.println(dequeue.pollFirst());
        System.out.println(dequeue.pollLast());

        System.out.println(dequeue.size());
        System.out.println(dequeue.isEmpty());

        DoubleEndedQueue queue = new DoubleEndedQueue();
        queue.pushFirst(1);
        queue.pushFirst(2);
        queue.pushLast(3);
        queue.pushLast(4);
        PrintUtil.printDeLinked(queue.front);

        System.out.println(queue.popFirst());
        System.out.println(queue.popLast());
        PrintUtil.printDeLinked(queue.front);

    }
}

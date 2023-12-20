package com.structure.stack;

import com.structure.linked.ListNode;
import com.util.PrintUtil;

import java.util.Stack;

/**
 * 链表实现栈
 *
 * @author zz
 */
public class StackLink {

    /**
     * 栈的基本元素
     */
    private ListNode stackPeek;
    private int size = 0;

    /**
     * 栈的长度
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int num) {
        ListNode node = new ListNode(num);
        node.next = stackPeek;
        stackPeek = node;
        size++;
    }

    public int pop() {
        int peek = peek();
        stackPeek = stackPeek.next;
        size--;
        return peek;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return stackPeek.val;
    }

    public static void main(String[] args) {
        /** 栈基本操作 */
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        Integer peek = stack.peek();

        int size = stack.size();

        boolean empty = stack.isEmpty();

        Integer pop = stack.pop();

        /** */
        StackLink link = new StackLink();
        link.push(1);
        link.push(2);
        link.push(3);
        PrintUtil.printLinked(link.stackPeek);
        System.out.println("peek result====" + link.peek());
        System.out.println("pop result====" + link.pop());
        PrintUtil.printLinked(link.stackPeek);
    }


}

package com.util;

import com.structure.linked.DeListNode;
import com.structure.linked.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
public class PrintUtil {

    /**
     * 打印矩阵
     * @param matrix
     * @param <T>
     */
    public static <T> void printMatrix(List<List<T>> matrix) {
        System.out.println("[");
        for (List<T> row : matrix) {
            System.out.println("  " + row + ",");
        }
        System.out.println("]");
    }

    /**
     * 打印链表
     * @param header
     */
    public static void printLinked(ListNode header) {
        ArrayList<String> list = new ArrayList<>();
        while (header != null) {
            list.add(String.valueOf(header.val));
            header = header.next;
        }
        System.out.println(String.join("->",list));
    }

    /**
     * 打印双向队列
     * @param node
     */
    public static void printDeLinked(DeListNode node){
        ArrayList<Integer> list = new ArrayList<>();
        while (null != node) {
            list.add(node.val);
            node = node.next;
        }
        System.out.println(list);
    }


}

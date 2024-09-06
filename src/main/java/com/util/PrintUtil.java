package com.util;

import com.structure.linked.DeListNode;
import com.structure.linked.ListNode;
import com.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static <T> void printMatrix1(T[][] matrix) {
        System.out.println("[");
        for (T[] row : matrix) {
            System.out.println("  " + Arrays.toString(row) + ",");
        }
        System.out.println("]");
    }

    public static void printMatrix1(int[][] matrix) {
        System.out.println("[");
        for (int[] row : matrix) {
            System.out.println("  " + Arrays.toString(row) + ",");
        }
        System.out.println("]");
    }

    public static void printMatrix(char[][] matrix) {
        System.out.println("[");
        for (char[] row : matrix) {
            System.out.println("  " + Arrays.toString(row) + ",");
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

    public static void printTree(TreeNode root) {
        printTree(root, null, false);
    }

    public static void printTree(TreeNode root, Trunk prev, boolean isLeft) {
        if (root == null) {
            return;
        }
        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.right, trunk, true);

        if (prev == null) {
            trunk.str = "———";
        } else if (isLeft) {
            trunk.str = "/———";
            prev_str = "   |";
        } else {
            trunk.str = "\\———";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        System.out.println(" " + root.val);

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.left, trunk, false);
    }

    public static void showTrunks(Trunk p) {
        if (p == null) {
            return;
        }

        showTrunks(p.prev);
        System.out.print(p.str);
    }

}

class Trunk {
    Trunk prev;
    String str;

    Trunk(Trunk prev, String str) {
        this.prev = prev;
        this.str = str;
    }
};
